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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.enterForum.data.j;
import com.baidu.tieba.enterForum.data.k;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fns;
    private AlphaAnimation fpJ;
    private AlphaAnimation fpK;
    private com.baidu.tieba.enterForum.data.c haQ;
    private EnterForumTabFragment hdc;
    private LinearLayout hdd;
    private ForumHeaderView hde;
    private NewPagerSlidingTabBaseStrip hdf;
    private PullLeftViewPager hdg;
    private EnterForumTabPagerAdapter hdh;
    private List<EnterForumTabPagerAdapter.a> hdi;
    private com.baidu.tieba.enterForum.data.c hdj;
    private ImageView hdk;
    private View hdl;
    private View hdm;
    private NavigationBar hdn;
    private View hdo;
    private com.baidu.tieba.enterForum.view.b hdp;
    private int hdq;
    private String hdr;
    private k hds;
    private boolean hdt;
    private com.baidu.adp.framework.listener.a hdu;
    private CustomMessageListener hdv;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.hdt = false;
        this.hdu = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bRj();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bRj();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.hdv = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.bud();
                    } else {
                        c.this.bue();
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
                c.this.tq(i);
                if (c.this.hdi != null && c.this.hdi.size() > i) {
                    if (c.this.hdp != null) {
                        c.this.hdp.bTz();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.hdi.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).bRS();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.bOB().mc(false);
                            boolean bRS = ((EnterForumTabFeedFragment) aVar.fragment).bRS();
                            TiebaStatic.log(new ao("c13366").ag("obj_locate", 3).dk("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = bRS;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.bud();
                        } else {
                            c.this.bue();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new ao("c13366").ag("obj_locate", 1));
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
        this.hdc = enterForumTabFragment;
        this.hdc.registerListener(this.hdu);
        this.hdc.registerListener(this.hdv);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.hdq = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fns.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.hdg = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.hdc.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.hdi = new ArrayList();
        this.hdi.add(aVar);
        this.hdh = new EnterForumTabPagerAdapter(this.hdc.getActivity().getSupportFragmentManager(), this.hdi);
        this.hdg.setAdapter(this.hdh);
        this.hdg.setOffscreenPageLimit(this.hdi.size());
    }

    public void aen() {
    }

    private void al(Bundle bundle) {
        this.hdd = (LinearLayout) LayoutInflater.from(this.hdc.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.hde = (ForumHeaderView) this.hdd.findViewById(R.id.recommend_forum_header_serch_view);
        this.hde.setFrom(0);
        this.hde.onChangeSkinType();
        this.hdf = (NewPagerSlidingTabBaseStrip) this.hdd.findViewById(R.id.tab_layout);
        this.hdf.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.hdf.setRectPaintColor(R.color.cp_link_tip_a);
        this.hdf.a(l.getDimens(this.hdc.getContext(), R.dimen.tbds46), l.getDimens(this.hdc.getContext(), R.dimen.tbds46), l.getDimens(this.hdc.getContext(), R.dimen.tbds10), l.getDimens(this.hdc.getContext(), R.dimen.tbds46), true);
        this.hdf.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.hdf.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hdf.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.hdf.setIndicatorMarginBottom(l.getDimens(this.hdc.getContext(), R.dimen.tbds0));
        this.hdf.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.hdf.setTabPadding(l.getDimens(this.hdc.getContext(), R.dimen.tbds36), 0, l.getDimens(this.hdc.getContext(), R.dimen.tbds36), 0);
        this.hdf.setViewPager(this.hdg);
        this.hdf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.hdm = this.hdd.findViewById(R.id.enter_forum_tab_left_grandient);
        this.hdl = this.hdd.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.hdn = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hdn.setNavHeight(this.mNavHeight);
        this.hdn.hideBottomLine();
        this.hdo = this.mRootView.findViewById(R.id.divider_shadow);
        tr(0);
        this.hdk = (ImageView) this.hdd.findViewById(R.id.navigationBarGoSignall);
        this.hdk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.CheckFile("scan_flag") && ac.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    be.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.hdc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.hdf != null) {
            this.hdn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.hdd, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.hdd.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.hdf.setPadding(this.hdf.getPaddingLeft(), this.hdf.getPaddingTop(), this.hdf.getPaddingRight(), this.hdf.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.hdf != null && aVar != null) {
            this.hdf.setOnTabItemClickListener(aVar);
        }
    }

    public boolean tp(int i) {
        if (i < 0 || i > this.hdi.size()) {
            return false;
        }
        this.hdg.setCurrentItem(i, true);
        return true;
    }

    public void Ek(String str) {
        this.hdr = str;
    }

    public int El(String str) {
        if (StringUtils.isNull(str) || this.hdi == null || this.hdi.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.hdi.size(); i2++) {
            if (str.equals(this.hdi.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.hdc.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean bSb() {
        return this.hdt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        tq(this.hdg.getCurrentItem());
        if (this.fns != null) {
            this.fns.onChangeSkinType(getPageContext(), i);
        }
        if (this.hdi != null && this.hdi.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.hdi.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hdi.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        an.setBackgroundResource(this.hdo, R.drawable.personalize_tab_shadow);
        this.hdf.onChangeSkinType();
        this.hde.onChangeSkinType();
        an.a(this.hdm, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        an.a(this.hdl, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void bSc() {
        tq(this.hdg.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.hdn != null) {
            if (i == 0) {
                if (i2 == 0) {
                    tq(i);
                } else if (this.haQ != null && this.haQ.hbs && this.haQ.hbu > 0) {
                    if (this.hdp != null && this.hdp.getRefreshView() != null && this.hdp.getRefreshView().isViewAttached()) {
                        an.setBackgroundColor(this.hdn.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.hdn.setBackgroundColor(0);
                    an.a(this.hdn.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                tq(i);
            } else if (this.haQ != null && this.haQ.hbs && this.haQ.hbu > 0) {
                if (this.hdp != null && this.hdp.getRefreshView() != null && this.hdp.getRefreshView().isViewAttached()) {
                    an.setBackgroundColor(this.hdn.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hdn.setBackgroundColor(0);
                an.a(this.hdn.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(int i) {
        int i2;
        if (this.hdk != null) {
            if (i == 0) {
                if (this.haQ != null && this.haQ.hbs && this.haQ.hbu > 0) {
                    if (this.hdp != null && this.hdp.getRefreshView() != null && this.hdp.getRefreshView().isViewAttached()) {
                        SvgManager.aWQ().a(this.hdk, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.haQ.hbv > 0 && this.haQ.hbu > this.haQ.hbv / 2) {
                        SvgManager.aWQ().a(this.hdk, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.aWQ().a(this.hdk, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.aWQ().a(this.hdk, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.aWQ().a(this.hdk, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.hdn != null) {
            this.hdn.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.haQ != null && this.haQ.hbs && this.haQ.hbu > 0) {
                    if (this.hdp != null && this.hdp.getRefreshView() != null && this.hdp.getRefreshView().isViewAttached()) {
                        an.setBackgroundColor(this.hdn.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.haQ.hbv > 0) {
                            int i3 = (this.haQ.hbu * 255) / this.haQ.hbv;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.hdn.setBackgroundColor(0);
                        an.a(this.hdn.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    an.setBackgroundColor(this.hdn.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                an.setBackgroundColor(this.hdn.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.haQ != null && this.haQ.hbs && this.haQ.hbu > 0) {
                if (this.haQ.hbv > 0 && this.haQ.hbu > this.haQ.hbv / 2) {
                    if (this.hdp != null && this.hdp.getRefreshView() != null && this.hdp.getRefreshView().isViewAttached()) {
                        this.hdf.setWhiteStyle(false);
                    } else {
                        this.hdf.setWhiteStyle(true);
                    }
                } else {
                    this.hdf.setWhiteStyle(false);
                }
            } else {
                this.hdf.setWhiteStyle(false);
            }
        } else {
            this.hdf.setWhiteStyle(false);
        }
        if (i == 0) {
            this.hde.setAdState(this.haQ);
        } else {
            this.hde.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.hdc.isPrimary() && this.haQ != null && this.haQ.hbs && i == 0) {
            if (this.haQ.hbu > this.haQ.hbv / 2) {
                if (this.hdj != null && this.hdj.hbu <= this.haQ.hbv / 2) {
                    ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.hdj != null && this.hdj.hbu >= this.haQ.hbv / 2) {
                ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bSd() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.hdg.getCurrentItem() == 0 && this.hdc.isPrimary()) {
            if (this.hdp != null && this.hdp.getRefreshView() != null && this.hdp.getRefreshView().isViewAttached()) {
                ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.haQ != null && this.haQ.hbs) {
                if (this.haQ.hbu > this.haQ.hbv / 2 || this.haQ.hbu == 0) {
                    ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            ap.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hdi != null && this.hdi.size() > 0 && this.hdg != null) {
            EnterForumTabPagerAdapter.a aVar = this.hdi.get(this.hdg.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void Ve() {
        if (this.hdc != null && this.hdi != null && this.hdg != null && this.hdh != null) {
            FragmentManager supportFragmentManager = this.hdc.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.hdi.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hdg.getId(), this.hdh.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fns != null) {
            this.fns.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.hdh != null) {
            this.hdh.setPrimary(z);
        }
        if (this.hdi != null && this.hdi.size() > 0 && this.hdg != null) {
            EnterForumTabPagerAdapter.a aVar = this.hdi.get(this.hdg.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.hdi != null && this.hdi.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hdi.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.hdi.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        tq(this.hdg.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bud() {
        if (this.hdd != null && this.hdd.getPaddingTop() < 0) {
            bSe();
        } else if (this.hdo != null) {
            this.hdo.clearAnimation();
            if (this.hdo.getVisibility() != 0) {
                this.hdo.setVisibility(0);
                if (this.fpJ == null) {
                    this.fpJ = new AlphaAnimation(0.0f, 1.0f);
                    this.fpJ.setFillAfter(true);
                    this.fpJ.setDuration(300L);
                }
                this.hdo.startAnimation(this.fpJ);
            }
        }
    }

    public void bue() {
        if (this.hdo != null && this.hdo.getVisibility() != 8) {
            if (this.fpK == null) {
                this.fpK = new AlphaAnimation(1.0f, 0.0f);
                this.fpK.setFillAfter(true);
                this.fpK.setDuration(300L);
                this.fpK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.hdo.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.hdo.startAnimation(this.fpK);
        }
    }

    private void bSe() {
        if (this.hdo != null && this.hdo.getVisibility() != 8) {
            this.hdo.clearAnimation();
            this.hdo.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.hdp = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hdj = this.haQ;
        this.haQ = cVar;
        this.hde.setAdState(cVar);
        tq(this.hdg.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.hde.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bSf() {
        return this.hdd;
    }

    public String getCurrentPageKey() {
        if (this.hdh != null) {
            return this.hdh.getCurrentPageKey();
        }
        return null;
    }

    private void tr(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdo.getLayoutParams();
        layoutParams.topMargin = this.hdq + i;
        this.hdo.setLayoutParams(layoutParams);
    }

    public void a(k kVar, boolean z) {
        int i = 0;
        if (!this.hdc.getActivity().getSupportFragmentManager().isDestroyed()) {
            this.hdt = true;
            if (this.hds == null || !this.hds.b(kVar)) {
                bSh();
                this.hdi.clear();
                this.hdi.add(this.hdi.get(0));
                Iterator<j> it = kVar.bRz().iterator();
                while (it.hasNext()) {
                    j next = it.next();
                    EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
                    aVar.fragment = new EnterForumTabFeedFragment();
                    aVar.title = next.getTabName();
                    if (z) {
                        if (this.hds == null) {
                            aVar.hdb = true;
                        } else {
                            aVar.hdb = this.hds.b(next);
                        }
                    }
                    aVar.tabName = next.getTabName();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", next.bRy());
                    bundle.putString("tab_name", next.getTabName());
                    aVar.fragment.setArguments(bundle);
                    this.hdi.add(aVar);
                }
                this.hds = kVar;
                this.hdf.notifyDataSetChanged();
                this.hdh.notifyDataSetChanged();
                this.hdg.setOffscreenPageLimit(this.hdi.size());
                bSg();
            } else if (kVar != null && this.hds != null && w.getCount(this.hdi) - 1 == w.getCount(kVar.bRz())) {
                if (z) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= kVar.bRz().size()) {
                            break;
                        }
                        if (this.hdi.get(i2 + 1) != null && kVar.bRz().get(i2) != null) {
                            this.hdi.get(i2 + 1).hdb = this.hds.b(kVar.bRz().get(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.hds = kVar;
                this.hdf.notifyDataSetChanged();
                bSg();
            }
        }
    }

    private void bSg() {
        if (TextUtils.isEmpty(this.hdr)) {
            if (this.hdc.getActivity() != null && this.hdc.getActivity().getIntent() != null) {
                Intent intent = this.hdc.getActivity().getIntent();
                if (intent.hasExtra("sub_locate_type")) {
                    String stringExtra = intent.getStringExtra("sub_locate_type");
                    intent.removeExtra("sub_locate_type");
                    int El = El(stringExtra);
                    if (El != -1) {
                        tp(El);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int El2 = El(this.hdr);
        if (El2 == -1) {
            El2 = 0;
        }
        if (tp(El2)) {
            Intent intent2 = getPageContext().getPageActivity().getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sub_locate_type");
                intent2.removeExtra("is_from_scheme");
            }
            this.hdr = null;
        }
    }

    private void bSh() {
        if (this.hdh != null && this.hdi != null) {
            try {
                FragmentManager supportFragmentManager = this.hdc.getActivity().getSupportFragmentManager();
                if (!supportFragmentManager.isDestroyed()) {
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    for (int i = 1; i < this.hdi.size(); i++) {
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.hdg.getId(), this.hdh.getItemId(i)));
                        if (findFragmentByTag != null) {
                            beginTransaction.remove(findFragmentByTag);
                        }
                    }
                    beginTransaction.commit();
                    supportFragmentManager.executePendingTransactions();
                }
            } catch (Throwable th) {
            }
        }
    }

    public int bSi() {
        return this.hdg.getCurrentItem();
    }

    public void ts(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (w.getItem(this.hdi, i) != null && (this.hdi.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.hdi.get(i).fragment).mC(true);
        }
    }

    public String tt(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) w.getItem(this.hdi, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
