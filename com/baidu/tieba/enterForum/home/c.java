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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
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
    private com.baidu.tieba.enterForum.data.c iFO;
    private String iIA;
    private boolean iIB;
    private com.baidu.adp.framework.listener.a iIC;
    private CustomMessageListener iID;
    private EnterForumTabFragment iIl;
    private LinearLayout iIm;
    private ForumHeaderView iIn;
    private NewPagerSlidingTabBaseStrip iIo;
    private PullLeftViewPager iIp;
    private EnterForumTabPagerAdapter iIq;
    private List<EnterForumTabPagerAdapter.a> iIr;
    private com.baidu.tieba.enterForum.data.c iIs;
    private ImageView iIt;
    private View iIu;
    private View iIv;
    private NavigationBar iIw;
    private View iIx;
    private com.baidu.tieba.enterForum.view.b iIy;
    private int iIz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.iIB = false;
        this.iIC = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cxL();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cxL();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.iID = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bUX();
                    } else {
                        c.this.bUY();
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
                c.this.yZ(i);
                if (c.this.iIr != null && c.this.iIr.size() > i) {
                    if (c.this.iIy != null) {
                        c.this.iIy.cAl();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iIr.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cyI();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.cva().pv(false);
                            boolean cyI = ((EnterForumTabFeedFragment) aVar.fragment).cyI();
                            TiebaStatic.log(new aq("c13366").an("obj_locate", 3).dX("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cyI;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bUX();
                        } else {
                            c.this.bUY();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").an("obj_locate", 1));
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
        this.iIl = enterForumTabFragment;
        this.iIl.registerListener(this.iIC);
        this.iIl.registerListener(this.iID);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.iIz = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
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
        this.iIp = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.iIl.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iIr = new ArrayList();
        this.iIr.add(aVar);
        this.iIq = new EnterForumTabPagerAdapter(this.iIl.getActivity().getSupportFragmentManager(), this.iIr);
        this.iIp.setAdapter(this.iIq);
        this.iIp.setOffscreenPageLimit(this.iIr.size());
    }

    public void ayp() {
    }

    private void al(Bundle bundle) {
        this.iIm = (LinearLayout) LayoutInflater.from(this.iIl.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.iIn = (ForumHeaderView) this.iIm.findViewById(R.id.recommend_forum_header_serch_view);
        this.iIn.setFrom(0);
        this.iIn.onChangeSkinType();
        this.iIo = (NewPagerSlidingTabBaseStrip) this.iIm.findViewById(R.id.tab_layout);
        this.iIo.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.iIo.setRectPaintColor(R.color.CAM_X0302);
        this.iIo.a(l.getDimens(this.iIl.getContext(), R.dimen.tbds46), l.getDimens(this.iIl.getContext(), R.dimen.tbds46), l.getDimens(this.iIl.getContext(), R.dimen.tbds10), l.getDimens(this.iIl.getContext(), R.dimen.tbds46), true);
        this.iIo.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.iIo.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iIo.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.iIo.setIndicatorMarginBottom(l.getDimens(this.iIl.getContext(), R.dimen.tbds0));
        this.iIo.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.iIo.setTabPadding(l.getDimens(this.iIl.getContext(), R.dimen.tbds36), 0, l.getDimens(this.iIl.getContext(), R.dimen.tbds36), 0);
        this.iIo.setViewPager(this.iIp);
        this.iIo.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iIv = this.iIm.findViewById(R.id.enter_forum_tab_left_grandient);
        this.iIu = this.iIm.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iIw = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iIw.setNavHeight(this.mNavHeight);
        this.iIw.hideBottomLine();
        this.iIx = this.mRootView.findViewById(R.id.divider_shadow);
        za(0);
        this.iIt = (ImageView) this.iIm.findViewById(R.id.navigationBarGoSignall);
        this.iIt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ad.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.iIl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.iIo != null) {
            this.iIw.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.iIm, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.iIm.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.iIo.setPadding(this.iIo.getPaddingLeft(), this.iIo.getPaddingTop(), this.iIo.getPaddingRight(), this.iIo.getPaddingBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.iIo != null && aVar != null) {
            this.iIo.setOnTabItemClickListener(aVar);
        }
    }

    public boolean yY(int i) {
        if (i < 0 || i > this.iIr.size()) {
            return false;
        }
        this.iIp.setCurrentItem(i, true);
        return true;
    }

    public void JK(String str) {
        this.iIA = str;
    }

    public int JL(String str) {
        if (StringUtils.isNull(str) || this.iIr == null || this.iIr.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iIr.size(); i2++) {
            if (str.equals(this.iIr.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.iIl.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cyR() {
        return this.iIB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        yZ(this.iIp.getCurrentItem());
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(getPageContext(), i);
        }
        if (this.iIr != null && this.iIr.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iIr.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iIr.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ao.setBackgroundResource(this.iIx, R.drawable.personalize_tab_shadow);
        this.iIo.onChangeSkinType();
        this.iIn.onChangeSkinType();
        ao.a(this.iIv, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ao.a(this.iIu, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cyS() {
        yZ(this.iIp.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, float f, int i2) {
        if (this.iIw != null) {
            if (i == 0) {
                if (i2 == 0) {
                    yZ(i);
                } else if (this.iFO != null && this.iFO.iGq && this.iFO.iGs > 0) {
                    if (this.iIy != null && this.iIy.getRefreshView() != null && this.iIy.getRefreshView().isViewAttached()) {
                        ao.setBackgroundColor(this.iIw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iIw.setBackgroundColor(0);
                    ao.a(this.iIw.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                yZ(i);
            } else if (this.iFO != null && this.iFO.iGq && this.iFO.iGs > 0) {
                if (this.iIy != null && this.iIy.getRefreshView() != null && this.iIy.getRefreshView().isViewAttached()) {
                    ao.setBackgroundColor(this.iIw.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iIw.setBackgroundColor(0);
                ao.a(this.iIw.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yZ(int i) {
        int i2;
        if (this.iIt != null) {
            if (i == 0) {
                if (this.iFO != null && this.iFO.iGq && this.iFO.iGs > 0) {
                    if (this.iIy != null && this.iIy.getRefreshView() != null && this.iIy.getRefreshView().isViewAttached()) {
                        SvgManager.bwq().a(this.iIt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.iFO.iGt > 0 && this.iFO.iGs > this.iFO.iGt / 2) {
                        SvgManager.bwq().a(this.iIt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bwq().a(this.iIt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bwq().a(this.iIt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bwq().a(this.iIt, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iIw != null) {
            this.iIw.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.iFO != null && this.iFO.iGq && this.iFO.iGs > 0) {
                    if (this.iIy != null && this.iIy.getRefreshView() != null && this.iIy.getRefreshView().isViewAttached()) {
                        ao.setBackgroundColor(this.iIw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.iFO.iGt > 0) {
                            int i3 = (this.iFO.iGs * 255) / this.iFO.iGt;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iIw.setBackgroundColor(0);
                        ao.a(this.iIw.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ao.setBackgroundColor(this.iIw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ao.setBackgroundColor(this.iIw.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.iFO != null && this.iFO.iGq && this.iFO.iGs > 0) {
                if (this.iFO.iGt > 0 && this.iFO.iGs > this.iFO.iGt / 2) {
                    if (this.iIy != null && this.iIy.getRefreshView() != null && this.iIy.getRefreshView().isViewAttached()) {
                        this.iIo.setWhiteStyle(false);
                    } else {
                        this.iIo.setWhiteStyle(true);
                    }
                } else {
                    this.iIo.setWhiteStyle(false);
                }
            } else {
                this.iIo.setWhiteStyle(false);
            }
        } else {
            this.iIo.setWhiteStyle(false);
        }
        if (i == 0) {
            this.iIn.setAdState(this.iFO);
        } else {
            this.iIn.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.iIl.isPrimary() && this.iFO != null && this.iFO.iGq && i == 0) {
            if (this.iFO.iGs > this.iFO.iGt / 2) {
                if (this.iIs != null && this.iIs.iGs <= this.iFO.iGt / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iIs != null && this.iIs.iGs >= this.iFO.iGt / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cyT() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iIp.getCurrentItem() == 0 && this.iIl.isPrimary()) {
            if (this.iIy != null && this.iIy.getRefreshView() != null && this.iIy.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.iFO != null && this.iFO.iGq) {
                if (this.iFO.iGs > this.iFO.iGt / 2 || this.iFO.iGs == 0) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.iIr != null && this.iIr.size() > 0 && this.iIp != null) {
            EnterForumTabPagerAdapter.a aVar = this.iIr.get(this.iIp.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ano() {
        if (this.iIl != null && this.iIr != null && this.iIp != null && this.iIq != null) {
            FragmentManager supportFragmentManager = this.iIl.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iIr.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iIp.getId(), this.iIq.getItemId(i)));
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
        if (this.iIq != null) {
            this.iIq.setPrimary(z);
        }
        if (this.iIr != null && this.iIr.size() > 0 && this.iIp != null) {
            EnterForumTabPagerAdapter.a aVar = this.iIr.get(this.iIp.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iIr != null && this.iIr.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iIr.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iIr.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        yZ(this.iIp.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUX() {
        if (this.iIm != null && this.iIm.getPaddingTop() < 0) {
            cyU();
        } else if (this.iIx != null) {
            this.iIx.clearAnimation();
            if (this.iIx.getVisibility() != 0) {
                this.iIx.setVisibility(0);
                if (this.gED == null) {
                    this.gED = new AlphaAnimation(0.0f, 1.0f);
                    this.gED.setFillAfter(true);
                    this.gED.setDuration(300L);
                }
                this.iIx.startAnimation(this.gED);
            }
        }
    }

    public void bUY() {
        if (this.iIx != null && this.iIx.getVisibility() != 8) {
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
                        c.this.iIx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.iIx.startAnimation(this.gEE);
        }
    }

    private void cyU() {
        if (this.iIx != null && this.iIx.getVisibility() != 8) {
            this.iIx.clearAnimation();
            this.iIx.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.iIy = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iIs = this.iFO;
        this.iFO = cVar;
        this.iIn.setAdState(cVar);
        yZ(this.iIp.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.iIn.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cyV() {
        return this.iIm;
    }

    public String getCurrentPageKey() {
        if (this.iIq != null) {
            return this.iIq.getCurrentPageKey();
        }
        return null;
    }

    private void za(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iIx.getLayoutParams();
        layoutParams.topMargin = this.iIz + i;
        this.iIx.setLayoutParams(layoutParams);
    }

    public int cyW() {
        return this.iIp.getCurrentItem();
    }

    public void zb(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (x.getItem(this.iIr, i) != null && (this.iIr.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iIr.get(i).fragment).pV(true);
        }
    }

    public String zc(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) x.getItem(this.iIr, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
