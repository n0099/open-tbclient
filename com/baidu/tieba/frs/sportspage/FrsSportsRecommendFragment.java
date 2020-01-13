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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Ck;
    private View axK;
    private FrameLayout css;
    private CollapsingToolbarLayout eml;
    private NoNetworkView fSu;
    private ar gDY;
    private ObservedChangeLinearLayout gGQ;
    private View gGR;
    private View gGS;
    private ImageView gGT;
    private a gGU;
    private b gGV;
    private int gGX;
    private View goA;
    private View goa;
    private long gtS;
    private TextView gyQ;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean gGW = true;
    public final View.OnClickListener gon = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.goa != null && view == FrsSportsRecommendFragment.this.goa) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener emK = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Ck.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.gtz.setSelection(0);
                    FrsSportsRecommendFragment.this.baZ();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener gGY = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.gGX != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fSu == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fSu.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.gGX - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.sB(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.goA != null) {
                                FrsSportsRecommendFragment.this.goA.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.goA != null && FrsSportsRecommendFragment.this.axK != null) {
                            if (FrsSportsRecommendFragment.this.axK.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.sB(0);
                            }
                            FrsSportsRecommendFragment.this.goA.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bDv();
                        }
                        FrsSportsRecommendFragment.this.j(i, f);
                        FrsSportsRecommendFragment.this.gGX = i;
                        FrsSportsRecommendFragment.this.tb(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.emK);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.gtz.lI(true);
        bId();
        this.eml = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.axK = this.mRootView.findViewById(R.id.statebar_view);
        this.goA = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Ck = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Ck.addOnOffsetChangedListener(this.gGY);
        xO();
        this.gGU = new a(this, this.mRootView);
        this.gGU.g(this.gtB);
        this.gGV = new b(this, this.mRootView);
        if (this.gtA != null) {
            this.gtA.dw(0L);
        }
        this.css = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.glp = currentTimeMillis + frsActivity.glp;
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
                frsActivity.glp = currentTimeMillis + frsActivity.glp;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGU != null) {
            this.gGU.onChangeSkinType();
        }
        if (this.gGV != null) {
            this.gGV.onChangeSkinType();
        }
        if (this.fSu != null) {
            this.fSu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.gGR, R.drawable.top_shadow);
        am.setBackgroundResource(this.gGS, R.drawable.top_shadow);
        am.setBackgroundColor(this.axK, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.goA, R.color.cp_bg_line_d);
        SvgManager.aEp().a(this.gGT, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bDv();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bIe();
        if (this.gtA != null) {
            this.gtA.dw(this.gtS);
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
            if (this.gGU != null) {
                this.gGU.setData(dVar.gtU, dVar.gtV, dVar.gtW);
            }
            if (this.gGV != null && this.gtB != null && this.gtB.getForum() != null) {
                this.gGV.a(dVar.gtX, this.gtB.getForum().getId());
            }
            if (this.gtA != null && this.gtA.bFc()) {
                tN(dVar.gtT);
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
                                this.gtS = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.gGW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.gtz != null) {
            this.gtz.hn(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bId() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.gGQ == null) {
            this.gGQ = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gGQ.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.eml.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.gGR == null) {
            this.gGR = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.gGS == null) {
            this.gGS = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.goa == null) {
            this.goa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.goa.setOnClickListener(this.gon);
            this.mBackImageView = (ImageView) this.goa.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gGT == null) {
            this.gGT = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fSu == null) {
            this.fSu = new NoNetworkView(getContext());
            this.fSu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.gGQ.addView(this.fSu);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fSu.setVisibility(8);
        } else {
            this.fSu.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.gtB != null && this.gtB.getForum() != null) {
            String name = this.gtB.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, float f) {
        if (this.gGR != null && this.gGS != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.gGR.setVisibility(8);
                this.gGS.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGR.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gGS.getLayoutParams();
            if (this.gtz.bFb().getFirstCompletelyVisiblePosition() != 0) {
                this.gGR.setVisibility(8);
                this.gGS.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Ck.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.gGR.setVisibility(0);
                this.gGS.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.gGR.setVisibility(8);
                this.gGS.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.gGR.setVisibility(0);
                this.gGS.setVisibility(8);
            }
        }
    }

    private void xO() {
        if (this.axK != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.axK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axK.setLayoutParams(layoutParams);
                this.axK.setVisibility(0);
                if (this.gGT != null && (this.gGT.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.gGT.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.axK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDv() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.gGT != null) {
                this.gGT.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.axK != null) {
                this.axK.setAlpha(f);
            }
            if (this.goA != null) {
                this.goA.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.axK != null && this.goA != null && this.axK.getLayoutParams() != null && this.goA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.axK.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.axK.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.goA.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.goA.setLayoutParams(layoutParams2);
        }
    }

    private void tN(int i) {
        String string;
        if (this.gyQ == null) {
            this.gyQ = new TextView(getContext());
            this.gyQ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.gyQ.setGravity(17);
        }
        if (this.gyQ != null) {
            if (this.gGW) {
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
            this.gyQ.setText(string);
        }
        am.setBackgroundResource(this.gyQ, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gyQ, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.gDY == null) {
            this.gDY = new ar();
        }
        this.gDY.a(this.gyQ, this.css, layoutParams, 2000);
    }

    private void bIe() {
        this.Ck.setExpanded(true);
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
        super.showNetRefreshView(this.css, str, z);
        tb(0);
    }
}
