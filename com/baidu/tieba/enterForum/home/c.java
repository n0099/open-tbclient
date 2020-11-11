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
import com.baidu.tieba.card.t;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView gjn;
    private AlphaAnimation glM;
    private AlphaAnimation glN;
    private com.baidu.tieba.enterForum.data.c ihS;
    private View ikA;
    private com.baidu.tieba.enterForum.view.b ikB;
    private int ikC;
    private String ikD;
    private boolean ikE;
    private com.baidu.adp.framework.listener.a ikF;
    private CustomMessageListener ikG;
    private EnterForumTabFragment iko;
    private LinearLayout ikp;
    private ForumHeaderView ikq;
    private NewPagerSlidingTabBaseStrip ikr;
    private PullLeftViewPager iks;
    private EnterForumTabPagerAdapter ikt;
    private List<EnterForumTabPagerAdapter.a> iku;
    private com.baidu.tieba.enterForum.data.c ikv;
    private ImageView ikw;
    private View ikx;
    private View iky;
    private NavigationBar ikz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.ikE = false;
        this.ikF = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cra();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cra();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.ikG = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bPq();
                    } else {
                        c.this.bPr();
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
                c.this.xJ(i);
                if (c.this.iku != null && c.this.iku.size() > i) {
                    if (c.this.ikB != null) {
                        c.this.ikB.ctz();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iku.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).crW();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.cor().oy(false);
                            boolean crW = ((EnterForumTabFeedFragment) aVar.fragment).crW();
                            TiebaStatic.log(new aq("c13366").al("obj_locate", 3).dR("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = crW;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bPq();
                        } else {
                            c.this.bPr();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").al("obj_locate", 1));
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
        this.iko = enterForumTabFragment;
        this.iko.registerListener(this.ikF);
        this.iko.registerListener(this.ikG);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.ikC = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gjn.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iks = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.iko.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iku = new ArrayList();
        this.iku.add(aVar);
        this.ikt = new EnterForumTabPagerAdapter(this.iko.getActivity().getSupportFragmentManager(), this.iku);
        this.iks.setAdapter(this.ikt);
        this.iks.setOffscreenPageLimit(this.iku.size());
    }

    public void auy() {
    }

    private void al(Bundle bundle) {
        this.ikp = (LinearLayout) LayoutInflater.from(this.iko.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.ikq = (ForumHeaderView) this.ikp.findViewById(R.id.recommend_forum_header_serch_view);
        this.ikq.setFrom(0);
        this.ikq.onChangeSkinType();
        this.ikr = (NewPagerSlidingTabBaseStrip) this.ikp.findViewById(R.id.tab_layout);
        this.ikr.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.ikr.setRectPaintColor(R.color.cp_link_tip_a);
        this.ikr.a(l.getDimens(this.iko.getContext(), R.dimen.tbds46), l.getDimens(this.iko.getContext(), R.dimen.tbds46), l.getDimens(this.iko.getContext(), R.dimen.tbds10), l.getDimens(this.iko.getContext(), R.dimen.tbds46), true);
        this.ikr.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.ikr.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ikr.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ikr.setIndicatorMarginBottom(l.getDimens(this.iko.getContext(), R.dimen.tbds0));
        this.ikr.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.ikr.setTabPadding(l.getDimens(this.iko.getContext(), R.dimen.tbds36), 0, l.getDimens(this.iko.getContext(), R.dimen.tbds36), 0);
        this.ikr.setViewPager(this.iks);
        this.ikr.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iky = this.ikp.findViewById(R.id.enter_forum_tab_left_grandient);
        this.ikx = this.ikp.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.ikz = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ikz.setNavHeight(this.mNavHeight);
        this.ikz.hideBottomLine();
        this.ikA = this.mRootView.findViewById(R.id.divider_shadow);
        xK(0);
        this.ikw = (ImageView) this.ikp.findViewById(R.id.navigationBarGoSignall);
        this.ikw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.iko.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.ikr != null) {
            this.ikz.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.ikp, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ikp.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ikr.setPadding(this.ikr.getPaddingLeft(), this.ikr.getPaddingTop(), this.ikr.getPaddingRight(), this.ikr.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.ikr != null && aVar != null) {
            this.ikr.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xI(int i) {
        if (i < 0 || i > this.iku.size()) {
            return false;
        }
        this.iks.setCurrentItem(i, true);
        return true;
    }

    public void Jv(String str) {
        this.ikD = str;
    }

    public int Jw(String str) {
        if (StringUtils.isNull(str) || this.iku == null || this.iku.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iku.size(); i2++) {
            if (str.equals(this.iku.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.iko.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean csf() {
        return this.ikE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xJ(this.iks.getCurrentItem());
        if (this.gjn != null) {
            this.gjn.onChangeSkinType(getPageContext(), i);
        }
        if (this.iku != null && this.iku.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iku.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iku.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.ikA, R.drawable.personalize_tab_shadow);
        this.ikr.onChangeSkinType();
        this.ikq.onChangeSkinType();
        ap.a(this.iky, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.ikx, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void csg() {
        xJ(this.iks.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.ikz != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xJ(i);
                } else if (this.ihS != null && this.ihS.iiu && this.ihS.iiw > 0) {
                    if (this.ikB != null && this.ikB.getRefreshView() != null && this.ikB.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.ikz.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.ikz.setBackgroundColor(0);
                    ap.a(this.ikz.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xJ(i);
            } else if (this.ihS != null && this.ihS.iiu && this.ihS.iiw > 0) {
                if (this.ikB != null && this.ikB.getRefreshView() != null && this.ikB.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.ikz.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.ikz.setBackgroundColor(0);
                ap.a(this.ikz.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xJ(int i) {
        int i2;
        if (this.ikw != null) {
            if (i == 0) {
                if (this.ihS != null && this.ihS.iiu && this.ihS.iiw > 0) {
                    if (this.ikB != null && this.ikB.getRefreshView() != null && this.ikB.getRefreshView().isViewAttached()) {
                        SvgManager.brn().a(this.ikw, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.ihS.iix > 0 && this.ihS.iiw > this.ihS.iix / 2) {
                        SvgManager.brn().a(this.ikw, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.brn().a(this.ikw, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.brn().a(this.ikw, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.brn().a(this.ikw, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.ikz != null) {
            this.ikz.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.ihS != null && this.ihS.iiu && this.ihS.iiw > 0) {
                    if (this.ikB != null && this.ikB.getRefreshView() != null && this.ikB.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.ikz.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.ihS.iix > 0) {
                            int i3 = (this.ihS.iiw * 255) / this.ihS.iix;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.ikz.setBackgroundColor(0);
                        ap.a(this.ikz.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.ikz.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.ikz.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.ihS != null && this.ihS.iiu && this.ihS.iiw > 0) {
                if (this.ihS.iix > 0 && this.ihS.iiw > this.ihS.iix / 2) {
                    if (this.ikB != null && this.ikB.getRefreshView() != null && this.ikB.getRefreshView().isViewAttached()) {
                        this.ikr.setWhiteStyle(false);
                    } else {
                        this.ikr.setWhiteStyle(true);
                    }
                } else {
                    this.ikr.setWhiteStyle(false);
                }
            } else {
                this.ikr.setWhiteStyle(false);
            }
        } else {
            this.ikr.setWhiteStyle(false);
        }
        if (i == 0) {
            this.ikq.setAdState(this.ihS);
        } else {
            this.ikq.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.iko.isPrimary() && this.ihS != null && this.ihS.iiu && i == 0) {
            if (this.ihS.iiw > this.ihS.iix / 2) {
                if (this.ikv != null && this.ikv.iiw <= this.ihS.iix / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.ikv != null && this.ikv.iiw >= this.ihS.iix / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void csh() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iks.getCurrentItem() == 0 && this.iko.isPrimary()) {
            if (this.ikB != null && this.ikB.getRefreshView() != null && this.ikB.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.ihS != null && this.ihS.iiu) {
                if (this.ihS.iiw > this.ihS.iix / 2 || this.ihS.iiw == 0) {
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
        if (this.iku != null && this.iku.size() > 0 && this.iks != null) {
            EnterForumTabPagerAdapter.a aVar = this.iku.get(this.iks.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ajE() {
        if (this.iko != null && this.iku != null && this.iks != null && this.ikt != null) {
            FragmentManager supportFragmentManager = this.iko.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iku.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iks.getId(), this.ikt.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gjn != null) {
            this.gjn.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.ikt != null) {
            this.ikt.setPrimary(z);
        }
        if (this.iku != null && this.iku.size() > 0 && this.iks != null) {
            EnterForumTabPagerAdapter.a aVar = this.iku.get(this.iks.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iku != null && this.iku.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iku.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iku.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xJ(this.iks.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPq() {
        if (this.ikp != null && this.ikp.getPaddingTop() < 0) {
            csi();
        } else if (this.ikA != null) {
            this.ikA.clearAnimation();
            if (this.ikA.getVisibility() != 0) {
                this.ikA.setVisibility(0);
                if (this.glM == null) {
                    this.glM = new AlphaAnimation(0.0f, 1.0f);
                    this.glM.setFillAfter(true);
                    this.glM.setDuration(300L);
                }
                this.ikA.startAnimation(this.glM);
            }
        }
    }

    public void bPr() {
        if (this.ikA != null && this.ikA.getVisibility() != 8) {
            if (this.glN == null) {
                this.glN = new AlphaAnimation(1.0f, 0.0f);
                this.glN.setFillAfter(true);
                this.glN.setDuration(300L);
                this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.ikA.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ikA.startAnimation(this.glN);
        }
    }

    private void csi() {
        if (this.ikA != null && this.ikA.getVisibility() != 8) {
            this.ikA.clearAnimation();
            this.ikA.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.ikB = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ikv = this.ihS;
        this.ihS = cVar;
        this.ikq.setAdState(cVar);
        xJ(this.iks.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.ikq.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View csj() {
        return this.ikp;
    }

    public String getCurrentPageKey() {
        if (this.ikt != null) {
            return this.ikt.getCurrentPageKey();
        }
        return null;
    }

    private void xK(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ikA.getLayoutParams();
        layoutParams.topMargin = this.ikC + i;
        this.ikA.setLayoutParams(layoutParams);
    }

    public int csk() {
        return this.iks.getCurrentItem();
    }

    public void xL(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.iku, i) != null && (this.iku.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iku.get(i).fragment).oZ(true);
        }
    }

    public String xM(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.iku, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
