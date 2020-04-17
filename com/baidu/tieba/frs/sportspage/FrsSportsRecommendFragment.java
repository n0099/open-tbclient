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
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout VZ;
    private View aVX;
    private FrameLayout cVD;
    private CollapsingToolbarLayout eUG;
    private NoNetworkView gAG;
    private View haM;
    private View hal;
    private long hga;
    private TextView hly;
    private aw hqC;
    private View htA;
    private View htB;
    private ImageView htC;
    private a htD;
    private b htE;
    private int htG;
    private ObservedChangeLinearLayout htz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean htF = true;
    public final View.OnClickListener haA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.hal != null && view == FrsSportsRecommendFragment.this.hal) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener eVf = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.VZ.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.hfG.setSelection(0);
                    FrsSportsRecommendFragment.this.bmn();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener htH = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.htG != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gAG == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gAG.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.htG - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.th(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.haM != null) {
                                FrsSportsRecommendFragment.this.haM.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.haM != null && FrsSportsRecommendFragment.this.aVX != null) {
                            if (FrsSportsRecommendFragment.this.aVX.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.th(0);
                            }
                            FrsSportsRecommendFragment.this.haM.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bPM();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.htG = i;
                        FrsSportsRecommendFragment.this.tH(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eVf);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.hfG.mU(true);
        bUs();
        this.eUG = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.aVX = this.mRootView.findViewById(R.id.statebar_view);
        this.haM = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.VZ = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.VZ.addOnOffsetChangedListener(this.htH);
        Fm();
        this.htD = new a(this, this.mRootView);
        this.htD.g(this.hfI);
        this.htE = new b(this, this.mRootView);
        if (this.hfH != null) {
            this.hfH.ef(0L);
        }
        this.cVD = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.gXu = currentTimeMillis + frsActivity.gXu;
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
                frsActivity.gXu = currentTimeMillis + frsActivity.gXu;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htD != null) {
            this.htD.onChangeSkinType();
        }
        if (this.htE != null) {
            this.htE.onChangeSkinType();
        }
        if (this.gAG != null) {
            this.gAG.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.htA, R.drawable.top_shadow);
        am.setBackgroundResource(this.htB, R.drawable.top_shadow);
        am.setBackgroundColor(this.aVX, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.haM, R.color.cp_bg_line_d);
        SvgManager.aOU().a(this.htC, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bPM();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.an
    public void aQn() {
        bUt();
        if (this.hfH != null) {
            this.hfH.ef(this.hga);
        }
        super.aQn();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.htD != null) {
                this.htD.setData(dVar.hgc, dVar.hgd, dVar.hge);
            }
            if (this.htE != null && this.hfI != null && this.hfI.getForum() != null) {
                this.htE.a(dVar.hgf, this.hfI.getForum().getId());
            }
            if (this.hfH != null && this.hfH.bRx()) {
                sw(dVar.hgb);
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
                                this.hga = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.htF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.hfG != null) {
            this.hfG.it(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bUs() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.htz == null) {
            this.htz = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.htz.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.eUG.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.htA == null) {
            this.htA = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.htB == null) {
            this.htB = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.hal == null) {
            this.hal = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hal.setOnClickListener(this.haA);
            this.mBackImageView = (ImageView) this.hal.findViewById(R.id.widget_navi_back_button);
        }
        if (this.htC == null) {
            this.htC = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gAG == null) {
            this.gAG = new NoNetworkView(getContext());
            this.gAG.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.htz.addView(this.gAG);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gAG.setVisibility(8);
        } else {
            this.gAG.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.hfI != null && this.hfI.getForum() != null) {
            String name = this.hfI.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.htA != null && this.htB != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.htA.setVisibility(8);
                this.htB.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.htA.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.htB.getLayoutParams();
            if (this.hfG.bRw().getFirstCompletelyVisiblePosition() != 0) {
                this.htA.setVisibility(8);
                this.htB.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.VZ.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.htA.setVisibility(0);
                this.htB.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.htA.setVisibility(8);
                this.htB.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.htA.setVisibility(0);
                this.htB.setVisibility(8);
            }
        }
    }

    private void Fm() {
        if (this.aVX != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.aVX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aVX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aVX.setLayoutParams(layoutParams);
                this.aVX.setVisibility(0);
                if (this.htC != null && (this.htC.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.htC.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.aVX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPM() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.htC != null) {
                this.htC.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.aVX != null) {
                this.aVX.setAlpha(f);
            }
            if (this.haM != null) {
                this.haM.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.aVX != null && this.haM != null && this.aVX.getLayoutParams() != null && this.haM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aVX.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.aVX.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.haM.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.haM.setLayoutParams(layoutParams2);
        }
    }

    private void sw(int i) {
        String string;
        if (this.hly == null) {
            this.hly = new TextView(getContext());
            this.hly.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.hly.setGravity(17);
        }
        if (this.hly != null) {
            if (this.htF) {
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
            this.hly.setText(string);
        }
        am.setBackgroundResource(this.hly, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hly, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.hqC == null) {
            this.hqC = new aw();
        }
        this.hqC.a(this.hly, this.cVD, layoutParams, 2000);
    }

    private void bUt() {
        this.VZ.setExpanded(true);
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
        super.showNetRefreshView(this.cVD, str, z);
        tH(0);
    }
}
