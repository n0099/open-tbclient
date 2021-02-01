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
    private NoNetworkView gAh;
    private AlphaAnimation gCG;
    private AlphaAnimation gCH;
    private com.baidu.tieba.enterForum.data.c iGR;
    private View iJA;
    private com.baidu.tieba.enterForum.view.b iJB;
    private int iJC;
    private String iJD;
    private boolean iJE;
    private com.baidu.adp.framework.listener.a iJF;
    private CustomMessageListener iJG;
    private EnterForumTabFragment iJo;
    private LinearLayout iJp;
    private ForumHeaderView iJq;
    private NewPagerSlidingTabBaseStrip iJr;
    private PullLeftViewPager iJs;
    private EnterForumTabPagerAdapter iJt;
    private List<EnterForumTabPagerAdapter.a> iJu;
    private com.baidu.tieba.enterForum.data.c iJv;
    private ImageView iJw;
    private View iJx;
    private View iJy;
    private NavigationBar iJz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.iJE = false;
        this.iJF = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cvg();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cvg();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.iJG = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bRJ();
                    } else {
                        c.this.bRK();
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
                c.this.xD(i);
                if (c.this.iJu != null && c.this.iJu.size() > i) {
                    if (c.this.iJB != null) {
                        c.this.iJB.cxG();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iJu.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cwd();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.csu().pB(false);
                            boolean cwd = ((EnterForumTabFeedFragment) aVar.fragment).cwd();
                            TiebaStatic.log(new ar("c13366").ap("obj_locate", 3).dR("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cwd;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bRJ();
                        } else {
                            c.this.bRK();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ar("c13366").ap("obj_locate", 1));
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
        this.iJo = enterForumTabFragment;
        this.iJo.registerListener(this.iJF);
        this.iJo.registerListener(this.iJG);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.iJC = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gAh.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iJs = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.iJo.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iJu = new ArrayList();
        this.iJu.add(aVar);
        this.iJt = new EnterForumTabPagerAdapter(this.iJo.getActivity().getSupportFragmentManager(), this.iJu);
        this.iJs.setAdapter(this.iJt);
        this.iJs.setOffscreenPageLimit(this.iJu.size());
    }

    public void auU() {
    }

    private void al(Bundle bundle) {
        this.iJp = (LinearLayout) LayoutInflater.from(this.iJo.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.iJq = (ForumHeaderView) this.iJp.findViewById(R.id.recommend_forum_header_serch_view);
        this.iJq.setFrom(0);
        this.iJq.onChangeSkinType();
        this.iJr = (NewPagerSlidingTabBaseStrip) this.iJp.findViewById(R.id.tab_layout);
        this.iJr.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iJr.setRectPaintColor(R.color.CAM_X0302);
        this.iJr.a(l.getDimens(this.iJo.getContext(), R.dimen.tbds46), l.getDimens(this.iJo.getContext(), R.dimen.tbds46), l.getDimens(this.iJo.getContext(), R.dimen.tbds10), l.getDimens(this.iJo.getContext(), R.dimen.tbds46), true);
        this.iJr.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.iJr.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iJr.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iJr.setIndicatorMarginBottom(l.getDimens(this.iJo.getContext(), R.dimen.tbds0));
        this.iJr.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.iJr.setTabPadding(l.getDimens(this.iJo.getContext(), R.dimen.tbds36), 0, l.getDimens(this.iJo.getContext(), R.dimen.tbds36), 0);
        this.iJr.setViewPager(this.iJs);
        this.iJr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iJy = this.iJp.findViewById(R.id.enter_forum_tab_left_grandient);
        this.iJx = this.iJp.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iJz = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iJz.setNavHeight(this.mNavHeight);
        this.iJz.hideBottomLine();
        this.iJA = this.mRootView.findViewById(R.id.divider_shadow);
        xE(0);
        this.iJw = (ImageView) this.iJp.findViewById(R.id.navigationBarGoSignall);
        this.iJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.iJo.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.iJr != null) {
            this.iJz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.iJp, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.iJp.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.iJr.setPadding(this.iJr.getPaddingLeft(), this.iJr.getPaddingTop(), this.iJr.getPaddingRight(), this.iJr.getPaddingBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.iJr != null && aVar != null) {
            this.iJr.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xC(int i) {
        if (i < 0 || i > this.iJu.size()) {
            return false;
        }
        this.iJs.setCurrentItem(i, true);
        return true;
    }

    public void Jj(String str) {
        this.iJD = str;
    }

    public int Jk(String str) {
        if (StringUtils.isNull(str) || this.iJu == null || this.iJu.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iJu.size(); i2++) {
            if (str.equals(this.iJu.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.iJo.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cwm() {
        return this.iJE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xD(this.iJs.getCurrentItem());
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(getPageContext(), i);
        }
        if (this.iJu != null && this.iJu.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iJu.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iJu.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.iJA, R.drawable.personalize_tab_shadow);
        this.iJr.onChangeSkinType();
        this.iJq.onChangeSkinType();
        ap.a(this.iJy, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.iJx, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cwn() {
        xD(this.iJs.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, float f, int i2) {
        if (this.iJz != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xD(i);
                } else if (this.iGR != null && this.iGR.iHt && this.iGR.iHv > 0) {
                    if (this.iJB != null && this.iJB.getRefreshView() != null && this.iJB.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iJz.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iJz.setBackgroundColor(0);
                    ap.a(this.iJz.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xD(i);
            } else if (this.iGR != null && this.iGR.iHt && this.iGR.iHv > 0) {
                if (this.iJB != null && this.iJB.getRefreshView() != null && this.iJB.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.iJz.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iJz.setBackgroundColor(0);
                ap.a(this.iJz.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD(int i) {
        int i2;
        if (this.iJw != null) {
            if (i == 0) {
                if (this.iGR != null && this.iGR.iHt && this.iGR.iHv > 0) {
                    if (this.iJB != null && this.iJB.getRefreshView() != null && this.iJB.getRefreshView().isViewAttached()) {
                        SvgManager.bsR().a(this.iJw, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.iGR.iHw > 0 && this.iGR.iHv > this.iGR.iHw / 2) {
                        SvgManager.bsR().a(this.iJw, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bsR().a(this.iJw, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bsR().a(this.iJw, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bsR().a(this.iJw, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iJz != null) {
            this.iJz.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.iGR != null && this.iGR.iHt && this.iGR.iHv > 0) {
                    if (this.iJB != null && this.iJB.getRefreshView() != null && this.iJB.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iJz.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.iGR.iHw > 0) {
                            int i3 = (this.iGR.iHv * 255) / this.iGR.iHw;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iJz.setBackgroundColor(0);
                        ap.a(this.iJz.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.iJz.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.iJz.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.iGR != null && this.iGR.iHt && this.iGR.iHv > 0) {
                if (this.iGR.iHw > 0 && this.iGR.iHv > this.iGR.iHw / 2) {
                    if (this.iJB != null && this.iJB.getRefreshView() != null && this.iJB.getRefreshView().isViewAttached()) {
                        this.iJr.setWhiteStyle(false);
                    } else {
                        this.iJr.setWhiteStyle(true);
                    }
                } else {
                    this.iJr.setWhiteStyle(false);
                }
            } else {
                this.iJr.setWhiteStyle(false);
            }
        } else {
            this.iJr.setWhiteStyle(false);
        }
        if (i == 0) {
            this.iJq.setAdState(this.iGR);
        } else {
            this.iJq.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.iJo.isPrimary() && this.iGR != null && this.iGR.iHt && i == 0) {
            if (this.iGR.iHv > this.iGR.iHw / 2) {
                if (this.iJv != null && this.iJv.iHv <= this.iGR.iHw / 2) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iJv != null && this.iJv.iHv >= this.iGR.iHw / 2) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cwo() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iJs.getCurrentItem() == 0 && this.iJo.isPrimary()) {
            if (this.iJB != null && this.iJB.getRefreshView() != null && this.iJB.getRefreshView().isViewAttached()) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.iGR != null && this.iGR.iHt) {
                if (this.iGR.iHv > this.iGR.iHw / 2 || this.iGR.iHv == 0) {
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
        if (this.iJu != null && this.iJu.size() > 0 && this.iJs != null) {
            EnterForumTabPagerAdapter.a aVar = this.iJu.get(this.iJs.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajT() {
        if (this.iJo != null && this.iJu != null && this.iJs != null && this.iJt != null) {
            FragmentManager supportFragmentManager = this.iJo.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iJu.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iJs.getId(), this.iJt.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gAh != null) {
            this.gAh.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iJt != null) {
            this.iJt.setPrimary(z);
        }
        if (this.iJu != null && this.iJu.size() > 0 && this.iJs != null) {
            EnterForumTabPagerAdapter.a aVar = this.iJu.get(this.iJs.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iJu != null && this.iJu.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iJu.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iJu.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xD(this.iJs.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRJ() {
        if (this.iJp != null && this.iJp.getPaddingTop() < 0) {
            cwp();
        } else if (this.iJA != null) {
            this.iJA.clearAnimation();
            if (this.iJA.getVisibility() != 0) {
                this.iJA.setVisibility(0);
                if (this.gCG == null) {
                    this.gCG = new AlphaAnimation(0.0f, 1.0f);
                    this.gCG.setFillAfter(true);
                    this.gCG.setDuration(300L);
                }
                this.iJA.startAnimation(this.gCG);
            }
        }
    }

    public void bRK() {
        if (this.iJA != null && this.iJA.getVisibility() != 8) {
            if (this.gCH == null) {
                this.gCH = new AlphaAnimation(1.0f, 0.0f);
                this.gCH.setFillAfter(true);
                this.gCH.setDuration(300L);
                this.gCH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.iJA.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.iJA.startAnimation(this.gCH);
        }
    }

    private void cwp() {
        if (this.iJA != null && this.iJA.getVisibility() != 8) {
            this.iJA.clearAnimation();
            this.iJA.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.iJB = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iJv = this.iGR;
        this.iGR = cVar;
        this.iJq.setAdState(cVar);
        xD(this.iJs.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.iJq.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cwq() {
        return this.iJp;
    }

    public String getCurrentPageKey() {
        if (this.iJt != null) {
            return this.iJt.getCurrentPageKey();
        }
        return null;
    }

    private void xE(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iJA.getLayoutParams();
        layoutParams.topMargin = this.iJC + i;
        this.iJA.setLayoutParams(layoutParams);
    }

    public int cwr() {
        return this.iJs.getCurrentItem();
    }

    public void xF(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.iJu, i) != null && (this.iJu.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iJu.get(i).fragment).qb(true);
        }
    }

    public String xG(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.iJu, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
