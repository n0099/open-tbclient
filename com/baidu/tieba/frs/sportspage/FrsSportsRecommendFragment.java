package com.baidu.tieba.frs.sportspage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Aa;
    private View apC;
    private FrameLayout bHI;
    private CollapsingToolbarLayout dBh;
    private long fDp;
    private TextView fIe;
    private aq fNs;
    private ObservedChangeLinearLayout fQf;
    private View fQg;
    private View fQh;
    private ImageView fQi;
    private a fQj;
    private b fQk;
    private int fQm;
    private NoNetworkView fbw;
    private View fxL;
    private View fxl;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean fQl = true;
    public final View.OnClickListener fxy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fxl != null && view == FrsSportsRecommendFragment.this.fxl) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener dBH = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Aa.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fCW.setSelection(0);
                    FrsSportsRecommendFragment.this.aKh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fQn = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fQm != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fbw == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fbw.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fQm - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.qr(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.fxL != null) {
                                FrsSportsRecommendFragment.this.fxL.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.fxL != null && FrsSportsRecommendFragment.this.apC != null) {
                            if (FrsSportsRecommendFragment.this.apC.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.qr(0);
                            }
                            FrsSportsRecommendFragment.this.fxL.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bkZ();
                        }
                        FrsSportsRecommendFragment.this.g(i, f);
                        FrsSportsRecommendFragment.this.fQm = i;
                        FrsSportsRecommendFragment.this.qR(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dBH);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fCW.kl(true);
        bpH();
        this.dBh = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.apC = this.mRootView.findViewById(R.id.statebar_view);
        this.fxL = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Aa = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Aa.addOnOffsetChangedListener(this.fQn);
        vz();
        this.fQj = new a(this, this.mRootView);
        this.fQj.g(this.fCY);
        this.fQk = new b(this, this.mRootView);
        if (this.fCX != null) {
            this.fCX.cM(0L);
        }
        this.bHI = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.fuy = currentTimeMillis + frsActivity.fuy;
            }
        }
        super.onPrimary();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.fuy = currentTimeMillis + frsActivity.fuy;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fQj != null) {
            this.fQj.onChangeSkinType();
        }
        if (this.fQk != null) {
            this.fQk.onChangeSkinType();
        }
        if (this.fbw != null) {
            this.fbw.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.fQg, R.drawable.top_shadow);
        am.setBackgroundResource(this.fQh, R.drawable.top_shadow);
        am.setBackgroundColor(this.apC, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fxL, R.color.cp_bg_line_d);
        SvgManager.amN().a(this.fQi, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bkZ();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        bpI();
        if (this.fCX != null) {
            this.fCX.cM(this.fDp);
        }
        super.onListPullRefresh(z);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.fQj != null) {
                this.fQj.setData(dVar.fDr, dVar.fDs, dVar.fDt);
            }
            if (this.fQk != null && this.fCY != null && this.fCY.getForum() != null) {
                this.fQk.a(dVar.fDu, this.fCY.getForum().getId());
            }
            if (this.fCX != null && this.fCX.bmF()) {
                rD(dVar.fDq);
            }
            if (!v.isEmpty(dVar.threadList)) {
                Iterator<m> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof bh) {
                        bh bhVar = (bh) next;
                        if (bhVar.ajn()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.g.b.toLong(bhVar.getId(), 0L);
                            if (j > 0) {
                                this.fDp = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.fQl = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fCW != null) {
            this.fCW.fU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bpH() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fQf == null) {
            this.fQf = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fQf.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.dBh.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fQg == null) {
            this.fQg = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fQh == null) {
            this.fQh = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fxl == null) {
            this.fxl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fxl.setOnClickListener(this.fxy);
            this.mBackImageView = (ImageView) this.fxl.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fQi == null) {
            this.fQi = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fbw == null) {
            this.fbw = new NoNetworkView(getContext());
            this.fbw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fQf.addView(this.fbw);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fbw.setVisibility(8);
        } else {
            this.fbw.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fCY != null && this.fCY.getForum() != null) {
            String name = this.fCY.getForum().getName();
            if (com.baidu.tbadk.core.util.aq.getChineseAndEnglishLength(name) > 14) {
                name = com.baidu.tbadk.core.util.aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fQg != null && this.fQh != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fQg.setVisibility(8);
                this.fQh.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQg.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fQh.getLayoutParams();
            if (this.fCW.bmE().getFirstCompletelyVisiblePosition() != 0) {
                this.fQg.setVisibility(8);
                this.fQh.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Aa.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.fQg.setVisibility(0);
                this.fQh.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.fQg.setVisibility(8);
                this.fQh.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fQg.setVisibility(0);
                this.fQh.setVisibility(8);
            }
        }
    }

    private void vz() {
        if (this.apC != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.apC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apC.setLayoutParams(layoutParams);
                this.apC.setVisibility(0);
                if (this.fQi != null && (this.fQi.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fQi.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.apC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.fQi != null) {
                this.fQi.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.apC != null) {
                this.apC.setAlpha(f);
            }
            if (this.fxL != null) {
                this.fxL.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.apC != null && this.fxL != null && this.apC.getLayoutParams() != null && this.fxL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.apC.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.apC.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fxL.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.fxL.setLayoutParams(layoutParams2);
        }
    }

    private void rD(int i) {
        String string;
        if (this.fIe == null) {
            this.fIe = new TextView(getContext());
            this.fIe.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fIe.setGravity(17);
        }
        if (this.fIe != null) {
            if (this.fQl) {
                if (i > 0) {
                    string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_first_time_tip);
                } else {
                    return;
                }
            } else if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_get_new_thread), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_no_new_thread);
            }
            this.fIe.setText(string);
        }
        am.setBackgroundResource(this.fIe, R.color.cp_link_tip_a);
        am.setViewTextColor(this.fIe, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.fNs == null) {
            this.fNs = new aq();
        }
        this.fNs.a(this.fIe, this.bHI, layoutParams, 2000);
    }

    private void bpI() {
        this.Aa.setExpanded(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.forumId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.bHI, str, z);
        qR(0);
    }
}
