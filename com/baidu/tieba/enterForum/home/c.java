package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fDV;
    private AlphaAnimation fGm;
    private AlphaAnimation fGn;
    private com.baidu.tieba.enterForum.data.c hto;
    private EnterForumTabFragment hvK;
    private LinearLayout hvL;
    private ForumHeaderView hvM;
    private NewPagerSlidingTabBaseStrip hvN;
    private PullLeftViewPager hvO;
    private EnterForumTabPagerAdapter hvP;
    private List<EnterForumTabPagerAdapter.a> hvQ;
    private com.baidu.tieba.enterForum.data.c hvR;
    private ImageView hvS;
    private View hvT;
    private View hvU;
    private NavigationBar hvV;
    private View hvW;
    private com.baidu.tieba.enterForum.view.b hvX;
    private int hvY;
    private String hvZ;
    private boolean hwa;
    private com.baidu.adp.framework.listener.a hwb;
    private CustomMessageListener hwc;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.hwa = false;
        this.hwb = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().ceG();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().ceG();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.hwc = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bGl();
                    } else {
                        c.this.bGm();
                    }
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.home.c.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                c.this.a(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z;
                c.this.vY(i);
                if (c.this.hvQ != null && c.this.hvQ.size() > i) {
                    if (c.this.hvX != null) {
                        c.this.hvX.chf();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.hvQ.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cfA();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.cbX().nk(false);
                            boolean cfA = ((EnterForumTabFeedFragment) aVar.fragment).cfA();
                            TiebaStatic.log(new aq("c13366").ai("obj_locate", 3).dD("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cfA;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bGl();
                        } else {
                            c.this.bGm();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").ai("obj_locate", 1));
                        }
                        if (i == 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
                        }
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        this.hvK = enterForumTabFragment;
        this.hvK.registerListener(this.hwb);
        this.hvK.registerListener(this.hwc);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.hvY = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fDV.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.hvO = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.hvK.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.hvQ = new ArrayList();
        this.hvQ.add(aVar);
        this.hvP = new EnterForumTabPagerAdapter(this.hvK.getActivity().getSupportFragmentManager(), this.hvQ);
        this.hvO.setAdapter(this.hvP);
        this.hvO.setOffscreenPageLimit(this.hvQ.size());
    }

    public void amH() {
    }

    private void al(Bundle bundle) {
        this.hvL = (LinearLayout) LayoutInflater.from(this.hvK.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.hvM = (ForumHeaderView) this.hvL.findViewById(R.id.recommend_forum_header_serch_view);
        this.hvM.setFrom(0);
        this.hvM.onChangeSkinType();
        this.hvN = (NewPagerSlidingTabBaseStrip) this.hvL.findViewById(R.id.tab_layout);
        this.hvN.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hvN.setRectPaintColor(R.color.cp_link_tip_a);
        this.hvN.a(l.getDimens(this.hvK.getContext(), R.dimen.tbds46), l.getDimens(this.hvK.getContext(), R.dimen.tbds46), l.getDimens(this.hvK.getContext(), R.dimen.tbds10), l.getDimens(this.hvK.getContext(), R.dimen.tbds46), true);
        this.hvN.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.hvN.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hvN.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hvN.setIndicatorMarginBottom(l.getDimens(this.hvK.getContext(), R.dimen.tbds0));
        this.hvN.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.hvN.setTabPadding(l.getDimens(this.hvK.getContext(), R.dimen.tbds36), 0, l.getDimens(this.hvK.getContext(), R.dimen.tbds36), 0);
        this.hvN.setViewPager(this.hvO);
        this.hvN.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hvU = this.hvL.findViewById(R.id.enter_forum_tab_left_grandient);
        this.hvT = this.hvL.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.hvV = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hvV.setNavHeight(this.mNavHeight);
        this.hvV.hideBottomLine();
        this.hvW = this.mRootView.findViewById(R.id.divider_shadow);
        vZ(0);
        this.hvS = (ImageView) this.hvL.findViewById(R.id.navigationBarGoSignall);
        this.hvS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.hvK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.hvN != null) {
            this.hvV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.hvL, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hvL.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hvN.setPadding(this.hvN.getPaddingLeft(), this.hvN.getPaddingTop(), this.hvN.getPaddingRight(), this.hvN.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.hvN != null && aVar != null) {
            this.hvN.setOnTabItemClickListener(aVar);
        }
    }

    public boolean vX(int i) {
        if (i < 0 || i > this.hvQ.size()) {
            return false;
        }
        this.hvO.setCurrentItem(i, true);
        return true;
    }

    public void Hu(String str) {
        this.hvZ = str;
    }

    public int Hv(String str) {
        if (StringUtils.isNull(str) || this.hvQ == null || this.hvQ.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.hvQ.size(); i2++) {
            if (str.equals(this.hvQ.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.hvK.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cfJ() {
        return this.hwa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        vY(this.hvO.getCurrentItem());
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(getPageContext(), i);
        }
        if (this.hvQ != null && this.hvQ.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hvQ.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hvQ.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.hvW, R.drawable.personalize_tab_shadow);
        this.hvN.onChangeSkinType();
        this.hvM.onChangeSkinType();
        ap.a(this.hvU, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.hvT, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cfK() {
        vY(this.hvO.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.hvV != null) {
            if (i == 0) {
                if (i2 == 0) {
                    vY(i);
                } else if (this.hto != null && this.hto.htQ && this.hto.htS > 0) {
                    if (this.hvX != null && this.hvX.getRefreshView() != null && this.hvX.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hvV.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.hvV.setBackgroundColor(0);
                    ap.a(this.hvV.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                vY(i);
            } else if (this.hto != null && this.hto.htQ && this.hto.htS > 0) {
                if (this.hvX != null && this.hvX.getRefreshView() != null && this.hvX.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.hvV.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hvV.setBackgroundColor(0);
                ap.a(this.hvV.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(int i) {
        int i2;
        if (this.hvS != null) {
            if (i == 0) {
                if (this.hto != null && this.hto.htQ && this.hto.htS > 0) {
                    if (this.hvX != null && this.hvX.getRefreshView() != null && this.hvX.getRefreshView().isViewAttached()) {
                        SvgManager.bjq().a(this.hvS, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.hto.htT > 0 && this.hto.htS > this.hto.htT / 2) {
                        SvgManager.bjq().a(this.hvS, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bjq().a(this.hvS, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bjq().a(this.hvS, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bjq().a(this.hvS, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.hvV != null) {
            this.hvV.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.hto != null && this.hto.htQ && this.hto.htS > 0) {
                    if (this.hvX != null && this.hvX.getRefreshView() != null && this.hvX.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.hvV.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.hto.htT > 0) {
                            int i3 = (this.hto.htS * 255) / this.hto.htT;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.hvV.setBackgroundColor(0);
                        ap.a(this.hvV.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.hvV.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.hvV.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.hto != null && this.hto.htQ && this.hto.htS > 0) {
                if (this.hto.htT > 0 && this.hto.htS > this.hto.htT / 2) {
                    if (this.hvX != null && this.hvX.getRefreshView() != null && this.hvX.getRefreshView().isViewAttached()) {
                        this.hvN.setWhiteStyle(false);
                    } else {
                        this.hvN.setWhiteStyle(true);
                    }
                } else {
                    this.hvN.setWhiteStyle(false);
                }
            } else {
                this.hvN.setWhiteStyle(false);
            }
        } else {
            this.hvN.setWhiteStyle(false);
        }
        if (i == 0) {
            this.hvM.setAdState(this.hto);
        } else {
            this.hvM.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.hvK.isPrimary() && this.hto != null && this.hto.htQ && i == 0) {
            if (this.hto.htS > this.hto.htT / 2) {
                if (this.hvR != null && this.hvR.htS <= this.hto.htT / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.hvR != null && this.hvR.htS >= this.hto.htT / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cfL() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.hvO.getCurrentItem() == 0 && this.hvK.isPrimary()) {
            if (this.hvX != null && this.hvX.getRefreshView() != null && this.hvX.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.hto != null && this.hto.htQ) {
                if (this.hto.htS > this.hto.htT / 2 || this.hto.htS == 0) {
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
        if (this.hvQ != null && this.hvQ.size() > 0 && this.hvO != null) {
            EnterForumTabPagerAdapter.a aVar = this.hvQ.get(this.hvO.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void abP() {
        if (this.hvK != null && this.hvQ != null && this.hvO != null && this.hvP != null) {
            FragmentManager supportFragmentManager = this.hvK.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hvQ.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hvO.getId(), this.hvP.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fDV != null) {
            this.fDV.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hvP != null) {
            this.hvP.setPrimary(z);
        }
        if (this.hvQ != null && this.hvQ.size() > 0 && this.hvO != null) {
            EnterForumTabPagerAdapter.a aVar = this.hvQ.get(this.hvO.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hvQ != null && this.hvQ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hvQ.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hvQ.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        vY(this.hvO.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGl() {
        if (this.hvL != null && this.hvL.getPaddingTop() < 0) {
            cfM();
        } else if (this.hvW != null) {
            this.hvW.clearAnimation();
            if (this.hvW.getVisibility() != 0) {
                this.hvW.setVisibility(0);
                if (this.fGm == null) {
                    this.fGm = new AlphaAnimation(0.0f, 1.0f);
                    this.fGm.setFillAfter(true);
                    this.fGm.setDuration(300L);
                }
                this.hvW.startAnimation(this.fGm);
            }
        }
    }

    public void bGm() {
        if (this.hvW != null && this.hvW.getVisibility() != 8) {
            if (this.fGn == null) {
                this.fGn = new AlphaAnimation(1.0f, 0.0f);
                this.fGn.setFillAfter(true);
                this.fGn.setDuration(300L);
                this.fGn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.hvW.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.hvW.startAnimation(this.fGn);
        }
    }

    private void cfM() {
        if (this.hvW != null && this.hvW.getVisibility() != 8) {
            this.hvW.clearAnimation();
            this.hvW.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.hvX = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hvR = this.hto;
        this.hto = cVar;
        this.hvM.setAdState(cVar);
        vY(this.hvO.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.hvM.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cfN() {
        return this.hvL;
    }

    public String getCurrentPageKey() {
        if (this.hvP != null) {
            return this.hvP.getCurrentPageKey();
        }
        return null;
    }

    private void vZ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hvW.getLayoutParams();
        layoutParams.topMargin = this.hvY + i;
        this.hvW.setLayoutParams(layoutParams);
    }

    public int cfO() {
        return this.hvO.getCurrentItem();
    }

    public void wa(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.hvQ, i) != null && (this.hvQ.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.hvQ.get(i).fragment).nL(true);
        }
    }

    public String wb(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.hvQ, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
