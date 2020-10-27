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
    private NoNetworkView gdx;
    private AlphaAnimation gfX;
    private AlphaAnimation gfY;
    private com.baidu.tieba.enterForum.data.c ibR;
    private View ieA;
    private View ieB;
    private NavigationBar ieC;
    private View ieD;
    private com.baidu.tieba.enterForum.view.b ieE;
    private int ieF;
    private String ieG;
    private boolean ieH;
    private com.baidu.adp.framework.listener.a ieI;
    private CustomMessageListener ieJ;
    private EnterForumTabFragment ier;
    private LinearLayout ies;
    private ForumHeaderView iet;
    private NewPagerSlidingTabBaseStrip ieu;
    private PullLeftViewPager iev;
    private EnterForumTabPagerAdapter iew;
    private List<EnterForumTabPagerAdapter.a> iex;
    private com.baidu.tieba.enterForum.data.c iey;
    private ImageView iez;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.ieH = false;
        this.ieI = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().coz();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().coz();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.ieJ = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bMQ();
                    } else {
                        c.this.bMR();
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
                c.this.xw(i);
                if (c.this.iex != null && c.this.iex.size() > i) {
                    if (c.this.ieE != null) {
                        c.this.ieE.cqY();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.iex.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).cpv();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.clQ().op(false);
                            boolean cpv = ((EnterForumTabFeedFragment) aVar.fragment).cpv();
                            TiebaStatic.log(new aq("c13366").aj("obj_locate", 3).dR("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = cpv;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bMQ();
                        } else {
                            c.this.bMR();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new aq("c13366").aj("obj_locate", 1));
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
        this.ier = enterForumTabFragment;
        this.ier.registerListener(this.ieI);
        this.ier.registerListener(this.ieJ);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.ieF = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.gdx.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.iev = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.ier.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.iex = new ArrayList();
        this.iex.add(aVar);
        this.iew = new EnterForumTabPagerAdapter(this.ier.getActivity().getSupportFragmentManager(), this.iex);
        this.iev.setAdapter(this.iew);
        this.iev.setOffscreenPageLimit(this.iex.size());
    }

    public void arX() {
    }

    private void al(Bundle bundle) {
        this.ies = (LinearLayout) LayoutInflater.from(this.ier.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.iet = (ForumHeaderView) this.ies.findViewById(R.id.recommend_forum_header_serch_view);
        this.iet.setFrom(0);
        this.iet.onChangeSkinType();
        this.ieu = (NewPagerSlidingTabBaseStrip) this.ies.findViewById(R.id.tab_layout);
        this.ieu.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.ieu.setRectPaintColor(R.color.cp_link_tip_a);
        this.ieu.a(l.getDimens(this.ier.getContext(), R.dimen.tbds46), l.getDimens(this.ier.getContext(), R.dimen.tbds46), l.getDimens(this.ier.getContext(), R.dimen.tbds10), l.getDimens(this.ier.getContext(), R.dimen.tbds46), true);
        this.ieu.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.ieu.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ieu.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ieu.setIndicatorMarginBottom(l.getDimens(this.ier.getContext(), R.dimen.tbds0));
        this.ieu.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.ieu.setTabPadding(l.getDimens(this.ier.getContext(), R.dimen.tbds36), 0, l.getDimens(this.ier.getContext(), R.dimen.tbds36), 0);
        this.ieu.setViewPager(this.iev);
        this.ieu.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ieB = this.ies.findViewById(R.id.enter_forum_tab_left_grandient);
        this.ieA = this.ies.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.ieC = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ieC.setNavHeight(this.mNavHeight);
        this.ieC.hideBottomLine();
        this.ieD = this.mRootView.findViewById(R.id.divider_shadow);
        xx(0);
        this.iez = (ImageView) this.ies.findViewById(R.id.navigationBarGoSignall);
        this.iez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bg.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.ier.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.ieu != null) {
            this.ieC.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.ies, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ies.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ieu.setPadding(this.ieu.getPaddingLeft(), this.ieu.getPaddingTop(), this.ieu.getPaddingRight(), this.ieu.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.ieu != null && aVar != null) {
            this.ieu.setOnTabItemClickListener(aVar);
        }
    }

    public boolean xv(int i) {
        if (i < 0 || i > this.iex.size()) {
            return false;
        }
        this.iev.setCurrentItem(i, true);
        return true;
    }

    public void Je(String str) {
        this.ieG = str;
    }

    public int Jf(String str) {
        if (StringUtils.isNull(str) || this.iex == null || this.iex.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.iex.size(); i2++) {
            if (str.equals(this.iex.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.ier.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean cpE() {
        return this.ieH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        xw(this.iev.getCurrentItem());
        if (this.gdx != null) {
            this.gdx.onChangeSkinType(getPageContext(), i);
        }
        if (this.iex != null && this.iex.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.iex.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iex.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.ieD, R.drawable.personalize_tab_shadow);
        this.ieu.onChangeSkinType();
        this.iet.onChangeSkinType();
        ap.a(this.ieB, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.ieA, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void cpF() {
        xw(this.iev.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.ieC != null) {
            if (i == 0) {
                if (i2 == 0) {
                    xw(i);
                } else if (this.ibR != null && this.ibR.ict && this.ibR.icv > 0) {
                    if (this.ieE != null && this.ieE.getRefreshView() != null && this.ieE.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.ieC.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.ieC.setBackgroundColor(0);
                    ap.a(this.ieC.getBarBgView(), R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                xw(i);
            } else if (this.ibR != null && this.ibR.ict && this.ibR.icv > 0) {
                if (this.ieE != null && this.ieE.getRefreshView() != null && this.ieE.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.ieC.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.ieC.setBackgroundColor(0);
                ap.a(this.ieC.getBarBgView(), R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(int i) {
        int i2;
        if (this.iez != null) {
            if (i == 0) {
                if (this.ibR != null && this.ibR.ict && this.ibR.icv > 0) {
                    if (this.ieE != null && this.ieE.getRefreshView() != null && this.ieE.getRefreshView().isViewAttached()) {
                        SvgManager.boN().a(this.iez, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.ibR.icw > 0 && this.ibR.icv > this.ibR.icw / 2) {
                        SvgManager.boN().a(this.iez, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.boN().a(this.iez, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.boN().a(this.iez, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.boN().a(this.iez, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.ieC != null) {
            this.ieC.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.ibR != null && this.ibR.ict && this.ibR.icv > 0) {
                    if (this.ieE != null && this.ieE.getRefreshView() != null && this.ieE.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.ieC.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.ibR.icw > 0) {
                            int i3 = (this.ibR.icv * 255) / this.ibR.icw;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.ieC.setBackgroundColor(0);
                        ap.a(this.ieC.getBarBgView(), R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.ieC.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.ieC.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.ibR != null && this.ibR.ict && this.ibR.icv > 0) {
                if (this.ibR.icw > 0 && this.ibR.icv > this.ibR.icw / 2) {
                    if (this.ieE != null && this.ieE.getRefreshView() != null && this.ieE.getRefreshView().isViewAttached()) {
                        this.ieu.setWhiteStyle(false);
                    } else {
                        this.ieu.setWhiteStyle(true);
                    }
                } else {
                    this.ieu.setWhiteStyle(false);
                }
            } else {
                this.ieu.setWhiteStyle(false);
            }
        } else {
            this.ieu.setWhiteStyle(false);
        }
        if (i == 0) {
            this.iet.setAdState(this.ibR);
        } else {
            this.iet.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.ier.isPrimary() && this.ibR != null && this.ibR.ict && i == 0) {
            if (this.ibR.icv > this.ibR.icw / 2) {
                if (this.iey != null && this.iey.icv <= this.ibR.icw / 2) {
                    ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.iey != null && this.iey.icv >= this.ibR.icw / 2) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void cpG() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.iev.getCurrentItem() == 0 && this.ier.isPrimary()) {
            if (this.ieE != null && this.ieE.getRefreshView() != null && this.ieE.getRefreshView().isViewAttached()) {
                ar.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.ibR != null && this.ibR.ict) {
                if (this.ibR.icv > this.ibR.icw / 2 || this.ibR.icv == 0) {
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
        if (this.iex != null && this.iex.size() > 0 && this.iev != null) {
            EnterForumTabPagerAdapter.a aVar = this.iex.get(this.iev.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void ahe() {
        if (this.ier != null && this.iex != null && this.iev != null && this.iew != null) {
            FragmentManager supportFragmentManager = this.ier.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.iex.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.iev.getId(), this.iew.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.gdx != null) {
            this.gdx.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.iew != null) {
            this.iew.setPrimary(z);
        }
        if (this.iex != null && this.iex.size() > 0 && this.iev != null) {
            EnterForumTabPagerAdapter.a aVar = this.iex.get(this.iev.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.iex != null && this.iex.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.iex.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.iex.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        xw(this.iev.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMQ() {
        if (this.ies != null && this.ies.getPaddingTop() < 0) {
            cpH();
        } else if (this.ieD != null) {
            this.ieD.clearAnimation();
            if (this.ieD.getVisibility() != 0) {
                this.ieD.setVisibility(0);
                if (this.gfX == null) {
                    this.gfX = new AlphaAnimation(0.0f, 1.0f);
                    this.gfX.setFillAfter(true);
                    this.gfX.setDuration(300L);
                }
                this.ieD.startAnimation(this.gfX);
            }
        }
    }

    public void bMR() {
        if (this.ieD != null && this.ieD.getVisibility() != 8) {
            if (this.gfY == null) {
                this.gfY = new AlphaAnimation(1.0f, 0.0f);
                this.gfY.setFillAfter(true);
                this.gfY.setDuration(300L);
                this.gfY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.ieD.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ieD.startAnimation(this.gfY);
        }
    }

    private void cpH() {
        if (this.ieD != null && this.ieD.getVisibility() != 8) {
            this.ieD.clearAnimation();
            this.ieD.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.ieE = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iey = this.ibR;
        this.ibR = cVar;
        this.iet.setAdState(cVar);
        xw(this.iev.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.iet.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View cpI() {
        return this.ies;
    }

    public String getCurrentPageKey() {
        if (this.iew != null) {
            return this.iew.getCurrentPageKey();
        }
        return null;
    }

    private void xx(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ieD.getLayoutParams();
        layoutParams.topMargin = this.ieF + i;
        this.ieD.setLayoutParams(layoutParams);
    }

    public int cpJ() {
        return this.iev.getCurrentItem();
    }

    public void xy(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.iex, i) != null && (this.iex.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.iex.get(i).fragment).oQ(true);
        }
    }

    public String xz(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.iex, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
