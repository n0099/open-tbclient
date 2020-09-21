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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout XP;
    private View brO;
    private FrameLayout dDw;
    private NoNetworkView fFC;
    private CollapsingToolbarLayout fML;
    private View icT;
    private View icu;
    private long ijo;
    private TextView ipD;
    private be ivb;
    private ObservedChangeLinearLayout ixV;
    private View ixW;
    private View ixX;
    private ImageView ixY;
    private a ixZ;
    private b iya;
    private int iyc;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean iyb = true;
    public final View.OnClickListener icH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.icu != null && view == FrsSportsRecommendFragment.this.icu) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener fNj = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.XP.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.iiR.setSelection(0);
                    FrsSportsRecommendFragment.this.bIh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iyd = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.iyc != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fFC == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fFC.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.iyc - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.xx(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.icT != null) {
                                FrsSportsRecommendFragment.this.icT.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.icT != null && FrsSportsRecommendFragment.this.brO != null) {
                            if (FrsSportsRecommendFragment.this.brO.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.xx(0);
                            }
                            FrsSportsRecommendFragment.this.icT.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cqz();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.iyc = i;
                        FrsSportsRecommendFragment.this.yc(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fNj);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.iiR.oR(true);
        cvI();
        this.fML = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.brO = this.mRootView.findViewById(R.id.statebar_view);
        this.icT = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.XP = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.XP.addOnOffsetChangedListener(this.iyd);
        OR();
        this.ixZ = new a(this, this.mRootView);
        this.ixZ.g(this.iiT);
        this.iya = new b(this, this.mRootView);
        if (this.iiS != null) {
            this.iiS.eS(0L);
        }
        this.dDw = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.hYV = currentTimeMillis + frsActivity.hYV;
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
                frsActivity.hYV = currentTimeMillis + frsActivity.hYV;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ixZ != null) {
            this.ixZ.onChangeSkinType();
        }
        if (this.iya != null) {
            this.iya.onChangeSkinType();
        }
        if (this.fFC != null) {
            this.fFC.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.ixW, R.drawable.top_shadow);
        ap.setBackgroundResource(this.ixX, R.drawable.top_shadow);
        ap.setBackgroundColor(this.brO, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.icT, R.color.cp_bg_line_d);
        SvgManager.bkl().a(this.ixY, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bkl().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cqz();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.au
    public void bly() {
        cvJ();
        if (this.iiS != null) {
            this.iiS.eS(this.ijo);
        }
        super.bly();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.ixZ != null) {
                this.ixZ.setData(dVar.ijq, dVar.ijr, dVar.ijs);
            }
            if (this.iya != null && this.iiT != null && this.iiT.getForum() != null) {
                this.iya.a(dVar.ijt, this.iiT.getForum().getId());
            }
            if (this.iiS != null && this.iiS.csA()) {
                wK(dVar.ijp);
            }
            if (!y.isEmpty(dVar.threadList)) {
                Iterator<q> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof bw) {
                        bw bwVar = (bw) next;
                        if (bwVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bwVar.getId(), 0L);
                            if (j > 0) {
                                this.ijo = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.iyb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.iiR != null) {
            this.iiR.ki(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cvI() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.ixV == null) {
            this.ixV = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.ixV.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.fML.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.ixW == null) {
            this.ixW = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.ixX == null) {
            this.ixX = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.icu == null) {
            this.icu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.icu.setOnClickListener(this.icH);
            this.mBackImageView = (ImageView) this.icu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.ixY == null) {
            this.ixY = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fFC == null) {
            this.fFC = new NoNetworkView(getContext());
            this.fFC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.ixV.addView(this.fFC);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fFC.setVisibility(8);
        } else {
            this.fFC.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.iiT != null && this.iiT.getForum() != null) {
            String name = this.iiT.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.ixW != null && this.ixX != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.ixW.setVisibility(8);
                this.ixX.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ixW.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ixX.getLayoutParams();
            if (this.iiR.csy().getFirstCompletelyVisiblePosition() != 0) {
                this.ixW.setVisibility(8);
                this.ixX.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.XP.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.ixW.setVisibility(0);
                this.ixX.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.ixW.setVisibility(8);
                this.ixX.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.ixW.setVisibility(0);
                this.ixX.setVisibility(8);
            }
        }
    }

    private void OR() {
        if (this.brO != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.brO.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.brO.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.brO.setLayoutParams(layoutParams);
                this.brO.setVisibility(0);
                if (this.ixY != null && (this.ixY.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.ixY.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.brO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqz() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.ixY != null) {
                this.ixY.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.brO != null) {
                this.brO.setAlpha(f);
            }
            if (this.icT != null) {
                this.icT.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.brO != null && this.icT != null && this.brO.getLayoutParams() != null && this.icT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.brO.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.brO.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.icT.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.icT.setLayoutParams(layoutParams2);
        }
    }

    private void wK(int i) {
        String string;
        if (this.ipD == null) {
            this.ipD = new TextView(getContext());
            this.ipD.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.ipD.setGravity(17);
        }
        if (this.ipD != null) {
            if (this.iyb) {
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
            this.ipD.setText(string);
        }
        ap.setBackgroundResource(this.ipD, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.ipD, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.ivb == null) {
            this.ivb = new be();
        }
        this.ivb.a(this.ipD, this.dDw, layoutParams, 2000);
    }

    private void cvJ() {
        this.XP.setExpanded(true);
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
        super.showNetRefreshView(this.dDw, str, z);
        yc(0);
    }
}
