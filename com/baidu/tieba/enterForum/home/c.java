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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.enterForum.data.o;
import com.baidu.tieba.enterForum.data.p;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.enterForum.view.PullLeftViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.base.c implements NoNetworkView.a {
    private NoNetworkView fci;
    private AlphaAnimation fey;
    private AlphaAnimation fez;
    private com.baidu.tieba.enterForum.data.d gNU;
    private com.baidu.tieba.enterForum.data.d gQA;
    private ImageView gQB;
    private View gQC;
    private View gQD;
    private NavigationBar gQE;
    private View gQF;
    private com.baidu.tieba.enterForum.view.b gQG;
    private int gQH;
    private String gQI;
    private p gQJ;
    private boolean gQK;
    private com.baidu.adp.framework.listener.a gQL;
    private CustomMessageListener gQM;
    private EnterForumTabFragment gQt;
    private LinearLayout gQu;
    private ForumHeaderView gQv;
    private NewPagerSlidingTabBaseStrip gQw;
    private PullLeftViewPager gQx;
    private EnterForumTabPagerAdapter gQy;
    private List<EnterForumTabPagerAdapter.a> gQz;
    private int mNavHeight;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private View mRootView;

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.gQK = false;
        this.gQL = new com.baidu.adp.framework.listener.a(1002400, CmdConfigSocket.CMD_FORUM_RECOMMEND) { // from class: com.baidu.tieba.enterForum.home.c.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().bOc();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().bOc();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
                }
                TbSingleton.getInstance().setHotSearch(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
            }
        };
        this.gQM = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        c.this.brg();
                    } else {
                        c.this.brh();
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
                c.this.sP(i);
                if (c.this.gQz != null && c.this.gQz.size() > i) {
                    if (c.this.gQG != null) {
                        c.this.gQG.bQv();
                    }
                    EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.gQz.get(i);
                    if (aVar != null && aVar.fragment != null) {
                        if (aVar.fragment instanceof EnterForumFragment) {
                            z = ((EnterForumFragment) aVar.fragment).bOO();
                        } else if (aVar.fragment instanceof EnterForumTabFeedFragment) {
                            s.bLs().lT(false);
                            boolean bOO = ((EnterForumTabFeedFragment) aVar.fragment).bOO();
                            TiebaStatic.log(new an("c13366").ag("obj_locate", 3).dh("resource_id", ((EnterForumTabFeedFragment) aVar.fragment).getTabName()));
                            z = bOO;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            c.this.brg();
                        } else {
                            c.this.brh();
                        }
                        if (i == 0) {
                            TiebaStatic.log(new an("c13366").ag("obj_locate", 1));
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
        this.gQt = enterForumTabFragment;
        this.gQt.registerListener(this.gQL);
        this.gQt.registerListener(this.gQM);
        this.mNavHeight = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.gQH = UtilHelper.getStatusBarHeight() + l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public void a(View view, Bundle bundle) {
        if (view != null) {
            this.mRootView = view;
            ak(bundle);
            al(bundle);
            am(bundle);
            this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.fci.a(this);
        }
    }

    private void ak(Bundle bundle) {
        this.gQx = (PullLeftViewPager) this.mRootView.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.fragment = new EnterForumFragment();
        aVar.title = this.gQt.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.fragment).setTabViewController(this);
        this.gQz = new ArrayList();
        this.gQz.add(aVar);
        this.gQy = new EnterForumTabPagerAdapter(this.gQt.getActivity().getSupportFragmentManager(), this.gQz);
        this.gQx.setAdapter(this.gQy);
        this.gQx.setOffscreenPageLimit(this.gQz.size());
    }

    public void adh() {
    }

    private void al(Bundle bundle) {
        this.gQu = (LinearLayout) LayoutInflater.from(this.gQt.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.gQv = (ForumHeaderView) this.gQu.findViewById(R.id.recommend_forum_header_serch_view);
        this.gQv.setFrom(0);
        this.gQv.onChangeSkinType();
        this.gQw = (NewPagerSlidingTabBaseStrip) this.gQu.findViewById(R.id.tab_layout);
        this.gQw.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        this.gQw.setRectPaintColor(R.color.cp_link_tip_a);
        this.gQw.a(l.getDimens(this.gQt.getContext(), R.dimen.tbds46), l.getDimens(this.gQt.getContext(), R.dimen.tbds46), l.getDimens(this.gQt.getContext(), R.dimen.tbds10), l.getDimens(this.gQt.getContext(), R.dimen.tbds46), true);
        this.gQw.setmIndicatorWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.gQw.setIndicatorOvershot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gQw.setIndicatorRadius(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.gQw.setIndicatorMarginBottom(l.getDimens(this.gQt.getContext(), R.dimen.tbds0));
        this.gQw.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.gQw.setTabPadding(l.getDimens(this.gQt.getContext(), R.dimen.tbds36), 0, l.getDimens(this.gQt.getContext(), R.dimen.tbds36), 0);
        this.gQw.setViewPager(this.gQx);
        this.gQw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gQD = this.gQu.findViewById(R.id.enter_forum_tab_left_grandient);
        this.gQC = this.gQu.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    private void am(Bundle bundle) {
        this.gQE = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.gQE.setNavHeight(this.mNavHeight);
        this.gQE.hideBottomLine();
        this.gQF = this.mRootView.findViewById(R.id.divider_shadow);
        sQ(0);
        this.gQB = (ImageView) this.gQu.findViewById(R.id.navigationBarGoSignall);
        this.gQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.CheckFile("scan_flag") && ab.checkCamera(c.this.mContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
                } else if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(c.this.getPageContext().getPageActivity());
                } else {
                    c.this.gQt.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
                }
            }
        });
        if (this.gQw != null) {
            this.gQE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.gQu, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.gQu.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.gQw.setPadding(this.gQw.getPaddingLeft(), this.gQw.getPaddingTop(), this.gQw.getPaddingRight(), this.gQw.getBottom());
        }
    }

    public void a(NewPagerSlidingTabBaseStrip.a aVar) {
        if (this.gQw != null && aVar != null) {
            this.gQw.setOnTabItemClickListener(aVar);
        }
    }

    public boolean sO(int i) {
        if (i < 0 || i > this.gQz.size()) {
            return false;
        }
        this.gQx.setCurrentItem(i, true);
        return true;
    }

    public void DJ(String str) {
        this.gQI = str;
    }

    public int DK(String str) {
        if (StringUtils.isNull(str) || this.gQz == null || this.gQz.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.gQz.size(); i2++) {
            if (str.equals(this.gQz.get(i2).tabName)) {
                i = i2;
            }
        }
        if (i == -1 && this.gQt.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public boolean bOX() {
        return this.gQK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        sP(this.gQx.getCurrentItem());
        if (this.fci != null) {
            this.fci.onChangeSkinType(getPageContext(), i);
        }
        if (this.gQz != null && this.gQz.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gQz.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gQz.get(i3);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) aVar.fragment).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            }
        }
        am.setBackgroundResource(this.gQF, R.drawable.personalize_tab_shadow);
        this.gQw.onChangeSkinType();
        this.gQv.onChangeSkinType();
        am.a(this.gQD, R.color.cp_bg_line_h, GradientDrawable.Orientation.LEFT_RIGHT);
        am.a(this.gQC, R.color.cp_bg_line_h, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void bOY() {
        sP(this.gQx.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, int i2) {
        if (this.gQE != null) {
            if (i == 0) {
                if (i2 == 0) {
                    sP(i);
                } else if (this.gNU != null && this.gNU.gOF && this.gNU.gOH > 0) {
                    if (this.gQG != null && this.gQG.getRefreshView() != null && this.gQG.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gQE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    this.gQE.setBackgroundColor(0);
                    am.a(this.gQE.getBarBgView(), (int) R.color.cp_bg_line_h, f, TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (i2 == 0) {
                sP(i);
            } else if (this.gNU != null && this.gNU.gOF && this.gNU.gOH > 0) {
                if (this.gQG != null && this.gQG.getRefreshView() != null && this.gQG.getRefreshView().isViewAttached()) {
                    am.setBackgroundColor(this.gQE.getBarBgView(), R.color.cp_bg_line_d, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.gQE.setBackgroundColor(0);
                am.a(this.gQE.getBarBgView(), (int) R.color.cp_bg_line_d, 1.0f - f, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(int i) {
        int i2;
        if (this.gQB != null) {
            if (i == 0) {
                if (this.gNU != null && this.gNU.gOF && this.gNU.gOH > 0) {
                    if (this.gQG != null && this.gQG.getRefreshView() != null && this.gQG.getRefreshView().isViewAttached()) {
                        SvgManager.aUW().a(this.gQB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else if (this.gNU.gOI > 0 && this.gNU.gOH > this.gNU.gOI / 2) {
                        SvgManager.aUW().a(this.gQB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        SvgManager.aUW().a(this.gQB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    }
                } else {
                    SvgManager.aUW().a(this.gQB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.aUW().a(this.gQB, R.drawable.icon_pure_topbar_sign44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.gQE != null) {
            this.gQE.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                if (this.gNU != null && this.gNU.gOF && this.gNU.gOH > 0) {
                    if (this.gQG != null && this.gQG.getRefreshView() != null && this.gQG.getRefreshView().isViewAttached()) {
                        am.setBackgroundColor(this.gQE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        if (this.gNU.gOI > 0) {
                            int i3 = (this.gNU.gOH * 255) / this.gNU.gOI;
                            if (i3 > 255) {
                                i3 = 255;
                            }
                            i2 = 255 - i3;
                        } else {
                            i2 = 0;
                        }
                        this.gQE.setBackgroundColor(0);
                        am.a(this.gQE.getBarBgView(), (int) R.color.cp_bg_line_d, i2 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    am.setBackgroundColor(this.gQE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                am.setBackgroundColor(this.gQE.getBarBgView(), R.color.cp_bg_line_h, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            if (this.gNU != null && this.gNU.gOF && this.gNU.gOH > 0) {
                if (this.gNU.gOI > 0 && this.gNU.gOH > this.gNU.gOI / 2) {
                    if (this.gQG != null && this.gQG.getRefreshView() != null && this.gQG.getRefreshView().isViewAttached()) {
                        this.gQw.setWhiteStyle(false);
                    } else {
                        this.gQw.setWhiteStyle(true);
                    }
                } else {
                    this.gQw.setWhiteStyle(false);
                }
            } else {
                this.gQw.setWhiteStyle(false);
            }
        } else {
            this.gQw.setWhiteStyle(false);
        }
        if (i == 0) {
            this.gQv.setAdState(this.gNU);
        } else {
            this.gQv.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.gQt.isPrimary() && this.gNU != null && this.gNU.gOF && i == 0) {
            if (this.gNU.gOH > this.gNU.gOI / 2) {
                if (this.gQA != null && this.gQA.gOH <= this.gNU.gOI / 2) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                }
            } else if (this.gQA != null && this.gQA.gOH >= this.gNU.gOI / 2) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        }
    }

    public void bOZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
        } else if (this.gQx.getCurrentItem() == 0 && this.gQt.isPrimary()) {
            if (this.gQG != null && this.gQG.getRefreshView() != null && this.gQG.getRefreshView().isViewAttached()) {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            } else if (this.gNU != null && this.gNU.gOF) {
                if (this.gNU.gOH > this.gNU.gOI / 2 || this.gNU.gOH == 0) {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                } else {
                    ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                }
            } else {
                ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            }
        } else {
            ao.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gQz != null && this.gQz.size() > 0 && this.gQx != null) {
            EnterForumTabPagerAdapter.a aVar = this.gQz.get(this.gQx.getCurrentItem());
            if (aVar != null && aVar.fragment != null) {
                aVar.fragment.onActivityResult(i, i2, intent);
            }
        }
    }

    public void TY() {
        if (this.gQt != null && this.gQz != null && this.gQx != null && this.gQy != null) {
            FragmentManager supportFragmentManager = this.gQt.getActivity().getSupportFragmentManager();
            if (!supportFragmentManager.isDestroyed()) {
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < this.gQz.size(); i++) {
                    Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gQx.getId(), this.gQy.getItemId(i)));
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                }
                beginTransaction.commitAllowingStateLoss();
            } else {
                return;
            }
        }
        if (this.fci != null) {
            this.fci.b(this);
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrimary(boolean z) {
        if (this.gQy != null) {
            this.gQy.setPrimary(z);
        }
        if (this.gQz != null && this.gQz.size() > 0 && this.gQx != null) {
            EnterForumTabPagerAdapter.a aVar = this.gQz.get(this.gQx.getCurrentItem());
            if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof BaseFragment)) {
                ((BaseFragment) aVar.fragment).setPrimary(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
        if (this.gQz != null && this.gQz.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gQz.size()) {
                    break;
                }
                EnterForumTabPagerAdapter.a aVar = this.gQz.get(i2);
                if (aVar != null && aVar.fragment != null && (aVar.fragment instanceof NoNetworkView.a)) {
                    ((NoNetworkView.a) aVar.fragment).onNetworkChange(z);
                }
                i = i2 + 1;
            }
        }
        sP(this.gQx.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brg() {
        if (this.gQu != null && this.gQu.getPaddingTop() < 0) {
            bPa();
        } else if (this.gQF != null) {
            this.gQF.clearAnimation();
            if (this.gQF.getVisibility() != 0) {
                this.gQF.setVisibility(0);
                if (this.fey == null) {
                    this.fey = new AlphaAnimation(0.0f, 1.0f);
                    this.fey.setFillAfter(true);
                    this.fey.setDuration(300L);
                }
                this.gQF.startAnimation(this.fey);
            }
        }
    }

    public void brh() {
        if (this.gQF != null && this.gQF.getVisibility() != 8) {
            if (this.fez == null) {
                this.fez = new AlphaAnimation(1.0f, 0.0f);
                this.fez.setFillAfter(true);
                this.fez.setDuration(300L);
                this.fez.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.home.c.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.gQF.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gQF.startAnimation(this.fez);
        }
    }

    private void bPa() {
        if (this.gQF != null && this.gQF.getVisibility() != 8) {
            this.gQF.clearAnimation();
            this.gQF.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.enterForum.view.b bVar) {
        this.gQG = bVar;
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gQA = this.gNU;
        this.gNU = dVar;
        this.gQv.setAdState(dVar);
        sP(this.gQx.getCurrentItem());
    }

    public void setSearchHint(String str) {
        this.gQv.setSearchHint(str);
    }

    public View getRootView() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public View bPb() {
        return this.gQu;
    }

    public String getCurrentPageKey() {
        if (this.gQy != null) {
            return this.gQy.getCurrentPageKey();
        }
        return null;
    }

    private void sQ(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gQF.getLayoutParams();
        layoutParams.topMargin = this.gQH + i;
        this.gQF.setLayoutParams(layoutParams);
    }

    public void a(p pVar, boolean z) {
        int i = 0;
        if (!this.gQt.getActivity().getSupportFragmentManager().isDestroyed()) {
            this.gQK = true;
            if (this.gQJ == null || !this.gQJ.b(pVar)) {
                bPd();
                this.gQz.clear();
                this.gQz.add(this.gQz.get(0));
                Iterator<o> it = pVar.bOv().iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
                    aVar.fragment = new EnterForumTabFeedFragment();
                    aVar.title = next.getTabName();
                    if (z) {
                        if (this.gQJ == null) {
                            aVar.gQs = true;
                        } else {
                            aVar.gQs = this.gQJ.b(next);
                        }
                    }
                    aVar.tabName = next.getTabName();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", next.bOu());
                    bundle.putString("tab_name", next.getTabName());
                    aVar.fragment.setArguments(bundle);
                    this.gQz.add(aVar);
                }
                this.gQJ = pVar;
                this.gQw.notifyDataSetChanged();
                this.gQy.notifyDataSetChanged();
                this.gQx.setOffscreenPageLimit(this.gQz.size());
                bPc();
            } else if (pVar != null && this.gQJ != null && v.getCount(this.gQz) - 1 == v.getCount(pVar.bOv())) {
                if (z) {
                    while (true) {
                        int i2 = i;
                        if (i2 >= pVar.bOv().size()) {
                            break;
                        }
                        if (this.gQz.get(i2 + 1) != null && pVar.bOv().get(i2) != null) {
                            this.gQz.get(i2 + 1).gQs = this.gQJ.b(pVar.bOv().get(i2));
                        }
                        i = i2 + 1;
                    }
                }
                this.gQJ = pVar;
                this.gQw.notifyDataSetChanged();
                bPc();
            }
        }
    }

    private void bPc() {
        if (TextUtils.isEmpty(this.gQI)) {
            if (this.gQt.getActivity() != null && this.gQt.getActivity().getIntent() != null) {
                Intent intent = this.gQt.getActivity().getIntent();
                if (intent.hasExtra("sub_locate_type")) {
                    String stringExtra = intent.getStringExtra("sub_locate_type");
                    intent.removeExtra("sub_locate_type");
                    int DK = DK(stringExtra);
                    if (DK != -1) {
                        sO(DK);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int DK2 = DK(this.gQI);
        if (DK2 == -1) {
            DK2 = 0;
        }
        if (sO(DK2)) {
            Intent intent2 = getPageContext().getPageActivity().getIntent();
            if (intent2 != null) {
                intent2.removeExtra("sub_locate_type");
                intent2.removeExtra("is_from_scheme");
            }
            this.gQI = null;
        }
    }

    private void bPd() {
        if (this.gQy != null && this.gQz != null) {
            try {
                FragmentManager supportFragmentManager = this.gQt.getActivity().getSupportFragmentManager();
                if (!supportFragmentManager.isDestroyed()) {
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    for (int i = 1; i < this.gQz.size(); i++) {
                        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(makeFragmentName(this.gQx.getId(), this.gQy.getItemId(i)));
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

    public int bPe() {
        return this.gQx.getCurrentItem();
    }

    public void sR(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (v.getItem(this.gQz, i) != null && (this.gQz.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            ((EnterForumTabFeedFragment) this.gQz.get(i).fragment).mr(true);
        }
    }

    public String sS(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) v.getItem(this.gQz, i);
        return (aVar == null || !(aVar.fragment instanceof EnterForumTabFeedFragment)) ? "" : ((EnterForumTabFeedFragment) aVar.fragment).getTabName();
    }
}
