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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout CD;
    private View aCq;
    private FrameLayout cwH;
    private CollapsingToolbarLayout erj;
    private NoNetworkView fVM;
    private TextView gCc;
    private as gHj;
    private ObservedChangeLinearLayout gKi;
    private View gKj;
    private View gKk;
    private ImageView gKl;
    private a gKm;
    private b gKn;
    private int gKp;
    private View grA;
    private View gra;
    private long gwQ;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean gKo = true;
    public final View.OnClickListener grn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.gra != null && view == FrsSportsRecommendFragment.this.gra) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener erJ = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.CD.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.gwv.setSelection(0);
                    FrsSportsRecommendFragment.this.bdw();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener gKq = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.gKp != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fVM == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fVM.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.gKp - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.sJ(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.grA != null) {
                                FrsSportsRecommendFragment.this.grA.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.grA != null && FrsSportsRecommendFragment.this.aCq != null) {
                            if (FrsSportsRecommendFragment.this.aCq.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.sJ(0);
                            }
                            FrsSportsRecommendFragment.this.grA.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bFl();
                        }
                        FrsSportsRecommendFragment.this.j(i, f);
                        FrsSportsRecommendFragment.this.gKp = i;
                        FrsSportsRecommendFragment.this.tj(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.erJ);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.gwv.lQ(true);
        bJV();
        this.erj = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.aCq = this.mRootView.findViewById(R.id.statebar_view);
        this.grA = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.CD.addOnOffsetChangedListener(this.gKq);
        Ao();
        this.gKm = new a(this, this.mRootView);
        this.gKm.g(this.gwx);
        this.gKn = new b(this, this.mRootView);
        if (this.gww != null) {
            this.gww.dw(0L);
        }
        this.cwH = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.gop = currentTimeMillis + frsActivity.gop;
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
                frsActivity.gop = currentTimeMillis + frsActivity.gop;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gKm != null) {
            this.gKm.onChangeSkinType();
        }
        if (this.gKn != null) {
            this.gKn.onChangeSkinType();
        }
        if (this.fVM != null) {
            this.fVM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.gKj, R.drawable.top_shadow);
        am.setBackgroundResource(this.gKk, R.drawable.top_shadow);
        am.setBackgroundColor(this.aCq, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.grA, R.color.cp_bg_line_d);
        SvgManager.aGG().a(this.gKl, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGG().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bFl();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bJW();
        if (this.gww != null) {
            this.gww.dw(this.gwQ);
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
            if (this.gKm != null) {
                this.gKm.setData(dVar.gwS, dVar.gwT, dVar.gwU);
            }
            if (this.gKn != null && this.gwx != null && this.gwx.getForum() != null) {
                this.gKn.a(dVar.gwV, this.gwx.getForum().getId());
            }
            if (this.gww != null && this.gww.bGW()) {
                tZ(dVar.gwR);
            }
            if (!v.isEmpty(dVar.threadList)) {
                Iterator<m> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof bj) {
                        bj bjVar = (bj) next;
                        if (bjVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bjVar.getId(), 0L);
                            if (j > 0) {
                                this.gwQ = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.gKo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.gwv != null) {
            this.gwv.hv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bJV() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.gKi == null) {
            this.gKi = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gKi.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.erj.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.gKj == null) {
            this.gKj = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.gKk == null) {
            this.gKk = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.gra == null) {
            this.gra = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gra.setOnClickListener(this.grn);
            this.mBackImageView = (ImageView) this.gra.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gKl == null) {
            this.gKl = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fVM == null) {
            this.fVM = new NoNetworkView(getContext());
            this.fVM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.gKi.addView(this.fVM);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fVM.setVisibility(8);
        } else {
            this.fVM.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.gwx != null && this.gwx.getForum() != null) {
            String name = this.gwx.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, float f) {
        if (this.gKj != null && this.gKk != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.gKj.setVisibility(8);
                this.gKk.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKj.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gKk.getLayoutParams();
            if (this.gwv.bGV().getFirstCompletelyVisiblePosition() != 0) {
                this.gKj.setVisibility(8);
                this.gKk.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.CD.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.gKj.setVisibility(0);
                this.gKk.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.gKj.setVisibility(8);
                this.gKk.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.gKj.setVisibility(0);
                this.gKk.setVisibility(8);
            }
        }
    }

    private void Ao() {
        if (this.aCq != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.aCq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCq.setLayoutParams(layoutParams);
                this.aCq.setVisibility(0);
                if (this.gKl != null && (this.gKl.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.gKl.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.aCq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFl() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.gKl != null) {
                this.gKl.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.aCq != null) {
                this.aCq.setAlpha(f);
            }
            if (this.grA != null) {
                this.grA.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.aCq != null && this.grA != null && this.aCq.getLayoutParams() != null && this.grA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aCq.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.aCq.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.grA.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.grA.setLayoutParams(layoutParams2);
        }
    }

    private void tZ(int i) {
        String string;
        if (this.gCc == null) {
            this.gCc = new TextView(getContext());
            this.gCc.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.gCc.setGravity(17);
        }
        if (this.gCc != null) {
            if (this.gKo) {
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
            this.gCc.setText(string);
        }
        am.setBackgroundResource(this.gCc, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gCc, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.gHj == null) {
            this.gHj = new as();
        }
        this.gHj.a(this.gCc, this.cwH, layoutParams, 2000);
    }

    private void bJW() {
        this.CD.setExpanded(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.cwH, str, z);
        tj(0);
    }
}
