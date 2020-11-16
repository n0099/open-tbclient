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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView giU;
    private AlphaAnimation glt;
    private AlphaAnimation glu;
    private com.baidu.tieba.enterForum.data.c iiG;
    private EnterForumTabFragment ilc;
    private LinearLayout ild;
    private ForumHeaderView ile;
    private NewPagerSlidingTabBaseStrip ilf;
    private PullLeftViewPager ilg;
    private EnterForumTabPagerAdapter ilh;
    private List<EnterForumTabPagerAdapter.a> ili;
    private com.baidu.tieba.enterForum.data.c ilj;
    private ImageView ilk;
    private View ill;
    private View ilm;
    private NavigationBar iln;
    private View ilo;
    private com.baidu.tieba.enterForum.view.b ilp;
    private int ilq;
    private String ilr;
    private boolean ils;
    private com.baidu.adp.framework.listener.a ilt;
    private CustomMessageListener ilu;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.ils = false;
        this.ilt = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().cqD();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().cqD();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.ilu = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bOJ();
                    } else {
                        c.this.bOK();
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
                c.this.yh(i);
                if (c.this.ili != null && c.this.ili.size() > i) {
                    if (c.this.ilp != null) {
                        c.this.ilp.ctc();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.ili.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).crz();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            t.cnT().oB(false);
                            boolean crz = ((EnterForumTabFeedFragment) aVar.fragment).crz();
                            TiebaStatic.log(new ar("c13366").ak("obj_locate", 3).dR("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = crz;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bOJ();
                        } else {
                            c.this.bOK();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ar("c13366").ak("obj_locate", 1));
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
        this.ilc = enterForumTabFragment;
        this.ilc.registerListener(this.ilt);
        this.ilc.registerListener(this.ilu);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.ilq = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.giU.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.ilg = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.ilc.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.ili = new ArrayList();
        this.ili.add(aVar);
        this.ilh = new EnterForumTabPagerAdapter(this.ilc.getActivity().getSupportFragmentManager(), this.ili);
        this.ilg.setAdapter(this.ilh);
        this.ilg.setOffscreenPageLimit(this.ili.size());
    }

    public void atQ() {
    }

    private void al(Bundle bundle) {
        this.ild = (LinearLayout) LayoutInflater.from(this.ilc.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.ile = (ForumHeaderView) this.ild.findViewById(R.id.recommend_forum_header_serch_view);
        this.ile.setFrom(0);
        this.ile.onChangeSkinType();
        this.ilf = (NewPagerSlidingTabBaseStrip) this.ild.findViewById(R.id.tab_layout);
        this.ilf.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.ilf.setRectPaintColor(R.color.CAM_X0302);
        this.ilf.a(l.getDimens(this.ilc.getContext(), R.dimen.tbds46), l.getDimens(this.ilc.getContext(), R.dimen.tbds46), l.getDimens(this.ilc.getContext(), R.dimen.tbds10), l.getDimens(this.ilc.getContext(), R.dimen.tbds46), true);
        this.ilf.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.ilf.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ilf.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.ilf.setIndicatorMarginBottom(l.getDimens(this.ilc.getContext(), R.dimen.tbds0));
        this.ilf.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.ilf.setTabPadding(l.getDimens(this.ilc.getContext(), R.dimen.tbds36), 0, l.getDimens(this.ilc.getContext(), R.dimen.tbds36), 0);
        this.ilf.setViewPager(this.ilg);
        this.ilf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ilm = this.ild.findViewById(R.id.enter_forum_tab_left_grandient);
        this.ill = this.ild.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.iln = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iln.setNavHeight(this.mNavHeight);
        this.iln.hideBottomLine();
        this.ilo = this.mRootView.findViewById(R.id.divider_shadow);
        yi(0);
        this.ilk = (ImageView) this.ild.findViewById(R.id.navigationBarGoSignall);
        this.ilk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ae.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bh.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.ilc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.ilf != null) {
            this.iln.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.ild, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.ild.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.ilf.setPadding(this.ilf.getPaddingLeft(), this.ilf.getPaddingTop(), this.ilf.getPaddingRight(), this.ilf.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.ilf != null && aVar != null) {
            this.ilf.setOnTabItemClickListener(aVar);
        }
    }

    public boolean yg(int i) {
        if (i < 0 || i > this.ili.size()) {
            return false;
        }
        this.ilg.setCurrentItem(i, true);
        return true;
    }

    public void IW(String str) {
        this.ilr = str;
    }

    public int IX(String str) {
        if (StringUtils.isNull(str) || this.ili == null || this.ili.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.ili.size(); i2++) {
            if (str.equals(this.ili.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.ilc.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean crI() {
        return this.ils;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        yh(this.ilg.getCurrentItem());
        if (this.giU != null) {
            this.giU.onChangeSkinType(getPageContext(), i);
        }
        if (this.ili != null && this.ili.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.ili.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.ili.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        ap.setBackgroundResource(this.ilo, R.drawable.personalize_tab_shadow);
        this.ilf.onChangeSkinType();
        this.ile.onChangeSkinType();
        ap.a(this.ilm, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        ap.a(this.ill, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void crJ() {
        yh(this.ilg.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.iln != null) {
            if (i == 0) {
                if (i2 == 0) {
                    yh(i);
                } else if (this.iiG != null && this.iiG.iji && this.iiG.ijk > 0) {
                    if (this.ilp != null && this.ilp.getRefreshView() != null && this.ilp.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iln.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.iln.setBackgroundColor(0);
                    ap.a(this.iln.getBarBgView(), R.color.CAM_X0207, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                yh(i);
            } else if (this.iiG != null && this.iiG.iji && this.iiG.ijk > 0) {
                if (this.ilp != null && this.ilp.getRefreshView() != null && this.ilp.getRefreshView().isViewAttached()) {
                    ap.setBackgroundColor(this.iln.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iln.setBackgroundColor(0);
                ap.a(this.iln.getBarBgView(), R.color.CAM_X0201, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(int i) {
        int i2;
        if (this.ilk != null) {
            if (i == 0) {
                if (this.iiG != null && this.iiG.iji && this.iiG.ijk > 0) {
                    if (this.ilp != null && this.ilp.getRefreshView() != null && this.ilp.getRefreshView().isViewAttached()) {
                        SvgManager.bqB().a(this.ilk, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.iiG.ijl > 0 && this.iiG.ijk > this.iiG.ijl / 2) {
                        SvgManager.bqB().a(this.ilk, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.bqB().a(this.ilk, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.bqB().a(this.ilk, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.bqB().a(this.ilk, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.iln != null) {
            this.iln.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.iiG != null && this.iiG.iji && this.iiG.ijk > 0) {
                    if (this.ilp != null && this.ilp.getRefreshView() != null && this.ilp.getRefreshView().isViewAttached()) {
                        ap.setBackgroundColor(this.iln.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.iiG.ijl > 0) {
                            int i3 = (this.iiG.ijk * 255) / this.iiG.ijl;
                            i2 = 255 - (i3 <= 255 ? i3 : 255);
                        } else {
                            i2 = 0;
                        }
                        this.iln.setBackgroundColor(0);
                        ap.a(this.iln.getBarBgView(), R.color.CAM_X0201, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    ap.setBackgroundColor(this.iln.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                ap.setBackgroundColor(this.iln.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.iiG != null && this.iiG.iji && this.iiG.ijk > 0) {
                if (this.iiG.ijl > 0 && this.iiG.ijk > this.iiG.ijl / 2) {
                    if (this.ilp != null && this.ilp.getRefreshView() != null && this.ilp.getRefreshView().isViewAttached()) {
                        this.ilf.setWhiteStyle(false);
                    } else {
                        this.ilf.setWhiteStyle(true);
                    }
                } else {
                    this.ilf.setWhiteStyle(false);
                }
            } else {
                this.ilf.setWhiteStyle(false);
            }
        } else {
            this.ilf.setWhiteStyle(false);
        }
        if (i == 0) {
            this.ile.setAdState(this.iiG);
        } else {
            this.ile.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.ilc.isPrimary() && this.iiG != null && this.iiG.iji && i == 0) {
            if (this.iiG.ijk > this.iiG.ijl / 2) {
                if (this.ilj != null && this.ilj.ijk <= this.iiG.ijl / 2) {
                    as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.ilj != null && this.ilj.ijk >= this.iiG.ijl / 2) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void crK() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.ilg.getCurrentItem() == 0 && this.ilc.isPrimary()) {
            if (this.ilp != null && this.ilp.getRefreshView() != null && this.ilp.getRefreshView().isViewAttached()) {
                as.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.iiG != null && this.iiG.iji) {
                if (this.iiG.ijk > this.iiG.ijl / 2 || this.iiG.ijk == 0) {
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
        if (this.ili != null && this.ili.size() > 0 && this.ilg != null) {
            EnterForumTabPagerAdapter.a aVar = this.ili.get(this.ilg.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void aiW() {
        if (this.ilc != null && this.ili != null && this.ilg != null && this.ilh != null) {
            FragmentManager supportFragmentManager = this.ilc.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.ili.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.ilg.getId(), this.ilh.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.giU != null) {
            this.giU.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.ilh != null) {
            this.ilh.setPrimary(z);
        }
        if (this.ili != null && this.ili.size() > 0 && this.ilg != null) {
            EnterForumTabPagerAdapter.a aVar = this.ili.get(this.ilg.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.ili != null && this.ili.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ili.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.ili.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        yh(this.ilg.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOJ() {
        if (this.ild != null && this.ild.getPaddingTop() < 0) {
            crL();
        } else if (this.ilo != null) {
            this.ilo.clearAnimation();
            if (this.ilo.getVisibility() != 0) {
                this.ilo.setVisibility(0);
                if (this.glt == null) {
                    this.glt = new AlphaAnimation(0.0f, 1.0f);
                    this.glt.setFillAfter(true);
                    this.glt.setDuration(300L);
                }
                this.ilo.startAnimation(this.glt);
            }
        }
    }

    public void bOK() {
        if (this.ilo != null && this.ilo.getVisibility() != 8) {
            if (this.glu == null) {
                this.glu = new AlphaAnimation(1.0f, 0.0f);
                this.glu.setFillAfter(true);
                this.glu.setDuration(300L);
                this.glu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.ilo.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ilo.startAnimation(this.glu);
        }
    }

    private void crL() {
        if (this.ilo != null && this.ilo.getVisibility() != 8) {
            this.ilo.clearAnimation();
            this.ilo.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.ilp = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ilj = this.iiG;
        this.iiG = cVar;
        this.ile.setAdState(cVar);
        yh(this.ilg.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.ile.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View crM() {
        return this.ild;
    }

    public String getCurrentPageKey() {
        if (this.ilh != null) {
            return this.ilh.getCurrentPageKey();
        }
        return null;
    }

    private void yi(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ilo.getLayoutParams();
        layoutParams.topMargin = this.ilq + i;
        this.ilo.setLayoutParams(layoutParams);
    }

    public int crN() {
        return this.ilg.getCurrentItem();
    }

    public void yj(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (y.getItem(this.ili, i) != null && (this.ili.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.ili.get(i).fragment).pc(true);
        }
    }

    public String yk(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) y.getItem(this.ili, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
