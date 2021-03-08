package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.base.d implements NoNetworkView.a {
    private NoNetworkView gCe;
    private AlphaAnimation gED;
    private AlphaAnimation gEE;
    private com.baidu.tieba.enterForum.data.c iIO;
    private String iLA;
    private boolean iLB;
    private com.baidu.adp.framework.listener.a iLC;
    private CustomMessageListener iLD;
    private EnterForumTabFragment iLl;
    private LinearLayout iLm;
    private ForumHeaderView iLn;
    private NewPagerSlidingTabBaseStrip iLo;
    private PullLeftViewPager iLp;
    private EnterForumTabPagerAdapter iLq;
    private List<EnterForumTabPagerAdapter.a> iLr;
    private com.baidu.tieba.enterForum.data.c iLs;
    private ImageView iLt;
    private View iLu;
    private View iLv;
    private NavigationBar iLw;
    private View iLx;
    private com.baidu.tieba.enterForum.view.b iLy;
    private int iLz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.iLB = false;
        this.iLC = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cvt();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cvt();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.iLD = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bRW();
                    } else {
                        c.this.bRX();
                    }
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                c.this.c(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z;
                c.this.xE(i);
                if (c.this.iLr != null && c.this.iLr.size() > i) {
                    if (c.this.iLy != null) {
                        c.this.iLy.cxT();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iLr.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cwq();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.csH().pB(false);
                            boolean cwq = ((EnterForumTabFeedFragment) aVar.fragment).cwq();
                            TiebaStatic.log(new ar("c13366").aq("obj_locate", 3).dR("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cwq;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bRW();
                        } else {
                            c.this.bRX();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ar("c13366").aq("obj_locate", 1));
                        }
                        if (i == 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                        }
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        this.iLl = enterForumTabFragment;
        this.iLl.registerListener(this.iLC);
        this.iLl.registerListener(this.iLD);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.iLz = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gCe.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iLp = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.iLl.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iLr = new ArrayList();
        this.iLr.add(aVar);
        this.iLq = new EnterForumTabPagerAdapter(this.iLl.getActivity().getSupportFragmentManager(), this.iLr);
        this.iLp.setAdapter(this.iLq);
        this.iLp.setOffscreenPageLimit(this.iLr.size());
    }

    public void auX() {
    }

    private void al(Bundle bundle) {
        this.iLm = (LinearLayout) LayoutInflater.from(this.iLl.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.iLn = (ForumHeaderView) this.iLm.findViewById(R.id.recommend_forum_header_serch_view);
        this.iLn.setFrom(0);
        this.iLn.onChangeSkinType();
        this.iLo = (NewPagerSlidingTabBaseStrip) this.iLm.findViewById(R.id.tab_layout);
        this.iLo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iLo.setRectPaintColor(R.color.CAM_X0302);
        this.iLo.a(l.getDimens(this.iLl.getContext(), R.dimen.tbds46), l.getDimens(this.iLl.getContext(), R.dimen.tbds46), l.getDimens(this.iLl.getContext(), R.dimen.tbds10), l.getDimens(this.iLl.getContext(), R.dimen.tbds46), true);
        this.iLo.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.iLo.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iLo.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iLo.setIndicatorMarginBottom(l.getDimens(this.iLl.getContext(), R.dimen.tbds0));
        this.iLo.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.iLo.setTabPadding(l.getDimens(this.iLl.getContext(), R.dimen.tbds36), 0, l.getDimens(this.iLl.getContext(), R.dimen.tbds36), 0);
        this.iLo.setViewPager(this.iLp);
        this.iLo.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iLv = this.iLm.findViewById(R.id.enter_forum_tab_left_grandient);
        this.iLu = this.iLm.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iLw = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iLw.setNavHeight(this.mNavHeight);
        this.iLw.hideBottomLine();
        this.iLx = this.mRootView.findViewById(R.id.divider_shadow);
        xF(0);
        this.iLt = (ImageView) this.iLm.findViewById(R.id.navigationBarGoSignall);
        this.iLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.iLl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.iLo != null) {
            this.iLw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.iLm, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.iLm.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.iLo.setPadding(this.iLo.getPaddingLeft(), this.iLo.getPaddingTop(), this.iLo.getPaddingRight(), this.iLo.getPaddingBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.iLo != null && aVar != null) {
            this.iLo.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xD(int i) {
        if (i < 0 || i > this.iLr.size()) {
            return false;
        }
        this.iLp.setCurrentItem(i, true);
        return true;
    }

    public void Jt(String str) {
        this.iLA = str;
    }

    public int Ju(String str) {
        if (StringUtils.isNull(str) || this.iLr == null || this.iLr.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iLr.size(); i2++) {
            if (str.equals(this.iLr.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.iLl.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cwz() {
        return this.iLB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xE(this.iLp.getCurrentItem());
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(getPageContext(), i);
        }
        if (this.iLr != null && this.iLr.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iLr.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iLr.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.iLx, R.drawable.personalize_tab_shadow);
        this.iLo.onChangeSkinType();
        this.iLn.onChangeSkinType();
        ap.a(this.iLv, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.iLu, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cwA() {
        xE(this.iLp.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, float f, int i2) {
        if (this.iLw != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xE(i);
                } else if (this.iIO != null && this.iIO.iJq && this.iIO.iJs > 0) {
                    if (this.iLy != null && this.iLy.getRefreshView() != null && this.iLy.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iLw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iLw.setBackgroundColor(0);
                    ap.a(this.iLw.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xE(i);
            } else if (this.iIO != null && this.iIO.iJq && this.iIO.iJs > 0) {
                if (this.iLy != null && this.iLy.getRefreshView() != null && this.iLy.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.iLw.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iLw.setBackgroundColor(0);
                ap.a(this.iLw.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(int i) {
        int i2;
        if (this.iLt != null) {
            if (i == 0) {
                if (this.iIO != null && this.iIO.iJq && this.iIO.iJs > 0) {
                    if (this.iLy != null && this.iLy.getRefreshView() != null && this.iLy.getRefreshView().isViewAttached()) {
                        SvgManager.bsU().a(this.iLt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.iIO.iJt > 0 && this.iIO.iJs > this.iIO.iJt / 2) {
                        SvgManager.bsU().a(this.iLt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bsU().a(this.iLt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bsU().a(this.iLt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bsU().a(this.iLt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iLw != null) {
            this.iLw.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.iIO != null && this.iIO.iJq && this.iIO.iJs > 0) {
                    if (this.iLy != null && this.iLy.getRefreshView() != null && this.iLy.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iLw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.iIO.iJt > 0) {
                            int i3 = (this.iIO.iJs * 255) / this.iIO.iJt;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iLw.setBackgroundColor(0);
                        ap.a(this.iLw.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.iLw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.iLw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.iIO != null && this.iIO.iJq && this.iIO.iJs > 0) {
                if (this.iIO.iJt > 0 && this.iIO.iJs > this.iIO.iJt / 2) {
                    if (this.iLy != null && this.iLy.getRefreshView() != null && this.iLy.getRefreshView().isViewAttached()) {
                        this.iLo.setWhiteStyle(false);
                    } else {
                        this.iLo.setWhiteStyle(true);
                    }
                } else {
                    this.iLo.setWhiteStyle(false);
                }
            } else {
                this.iLo.setWhiteStyle(false);
            }
        } else {
            this.iLo.setWhiteStyle(false);
        }
        if (i == 0) {
            this.iLn.setAdState(this.iIO);
        } else {
            this.iLn.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.iLl.isPrimary() && this.iIO != null && this.iIO.iJq && i == 0) {
            if (this.iIO.iJs > this.iIO.iJt / 2) {
                if (this.iLs != null && this.iLs.iJs <= this.iIO.iJt / 2) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iLs != null && this.iLs.iJs >= this.iIO.iJt / 2) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cwB() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iLp.getCurrentItem() == 0 && this.iLl.isPrimary()) {
            if (this.iLy != null && this.iLy.getRefreshView() != null && this.iLy.getRefreshView().isViewAttached()) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.iIO != null && this.iIO.iJq) {
                if (this.iIO.iJs > this.iIO.iJt / 2 || this.iIO.iJs == 0) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iLr != null && this.iLr.size() > 0 && this.iLp != null) {
            EnterForumTabPagerAdapter.a aVar = this.iLr.get(this.iLp.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajW() {
        if (this.iLl != null && this.iLr != null && this.iLp != null && this.iLq != null) {
            FragmentManager supportFragmentManager = this.iLl.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iLr.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iLp.getId(), this.iLq.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gCe != null) {
            this.gCe.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iLq != null) {
            this.iLq.setPrimary(z);
        }
        if (this.iLr != null && this.iLr.size() > 0 && this.iLp != null) {
            EnterForumTabPagerAdapter.a aVar = this.iLr.get(this.iLp.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iLr != null && this.iLr.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iLr.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iLr.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xE(this.iLp.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRW() {
        if (this.iLm != null && this.iLm.getPaddingTop() < 0) {
            cwC();
        } else if (this.iLx != null) {
            this.iLx.clearAnimation();
            if (this.iLx.getVisibility() != 0) {
                this.iLx.setVisibility(0);
                if (this.gED == null) {
                    this.gED = new AlphaAnimation(0.0f, 1.0f);
                    this.gED.setFillAfter(true);
                    this.gED.setDuration(300L);
                }
                this.iLx.startAnimation(this.gED);
            }
        }
    }

    public void bRX() {
        if (this.iLx != null && this.iLx.getVisibility() != 8) {
            if (this.gEE == null) {
                this.gEE = new AlphaAnimation(1.0f, 0.0f);
                this.gEE.setFillAfter(true);
                this.gEE.setDuration(300L);
                this.gEE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.iLx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.iLx.startAnimation(this.gEE);
        }
    }

    private void cwC() {
        if (this.iLx != null && this.iLx.getVisibility() != 8) {
            this.iLx.clearAnimation();
            this.iLx.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.iLy = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iLs = this.iIO;
        this.iIO = cVar;
        this.iLn.setAdState(cVar);
        xE(this.iLp.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.iLn.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cwD() {
        return this.iLm;
    }

    public String getCurrentPageKey() {
        if (this.iLq != null) {
            return this.iLq.getCurrentPageKey();
        }
        return null;
    }

    private void xF(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iLx.getLayoutParams();
        layoutParams.topMargin = this.iLz + i;
        this.iLx.setLayoutParams(layoutParams);
    }

    public int cwE() {
        return this.iLp.getCurrentItem();
    }

    public void xG(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.iLr, i) != null && (this.iLr.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iLr.get(i).fragment).qb(true);
        }
    }

    public String xH(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.iLr, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
