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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout WP;
    private View biX;
    private FrameLayout drp;
    private NoNetworkView fqQ;
    private CollapsingToolbarLayout fya;
    private View hHY;
    private View hIx;
    private long hNZ;
    private TextView hUo;
    private bc hZx;
    private ObservedChangeLinearLayout ics;
    private View ict;
    private View icu;
    private ImageView icv;
    private a icw;
    private b icx;
    private int icz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean icy = true;
    public final View.OnClickListener hIl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.hHY != null && view == FrsSportsRecommendFragment.this.hHY) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener fyz = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.WP.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.hNC.setSelection(0);
                    FrsSportsRecommendFragment.this.bxR();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener icA = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.icz != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fqQ == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fqQ.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.icz - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.uJ(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.hIx != null) {
                                FrsSportsRecommendFragment.this.hIx.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.hIx != null && FrsSportsRecommendFragment.this.biX != null) {
                            if (FrsSportsRecommendFragment.this.biX.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.uJ(0);
                            }
                            FrsSportsRecommendFragment.this.hIx.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.ccP();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.icz = i;
                        FrsSportsRecommendFragment.this.vl(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fyz);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.hNC.of(true);
        chO();
        this.fya = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.biX = this.mRootView.findViewById(R.id.statebar_view);
        this.hIx = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.WP = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.WP.addOnOffsetChangedListener(this.icA);
        Iv();
        this.icw = new a(this, this.mRootView);
        this.icw.g(this.hNE);
        this.icx = new b(this, this.mRootView);
        if (this.hND != null) {
            this.hND.ew(0L);
        }
        this.drp = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.hEB = currentTimeMillis + frsActivity.hEB;
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
                frsActivity.hEB = currentTimeMillis + frsActivity.hEB;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.icw != null) {
            this.icw.onChangeSkinType();
        }
        if (this.icx != null) {
            this.icx.onChangeSkinType();
        }
        if (this.fqQ != null) {
            this.fqQ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ao.setBackgroundResource(this.ict, R.drawable.top_shadow);
        ao.setBackgroundResource(this.icu, R.drawable.top_shadow);
        ao.setBackgroundColor(this.biX, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hIx, R.color.cp_bg_line_d);
        SvgManager.baR().a(this.icv, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.baR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        ccP();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.as
    public void bcg() {
        chP();
        if (this.hND != null) {
            this.hND.ew(this.hNZ);
        }
        super.bcg();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.icw != null) {
                this.icw.setData(dVar.hOb, dVar.hOc, dVar.hOd);
            }
            if (this.icx != null && this.hNE != null && this.hNE.getForum() != null) {
                this.icx.a(dVar.hOe, this.hNE.getForum().getId());
            }
            if (this.hND != null && this.hND.ceI()) {
                tW(dVar.hOa);
            }
            if (!x.isEmpty(dVar.threadList)) {
                Iterator<q> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof bv) {
                        bv bvVar = (bv) next;
                        if (bvVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bvVar.getId(), 0L);
                            if (j > 0) {
                                this.hNZ = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.icy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.hNC != null) {
            this.hNC.jH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void chO() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.ics == null) {
            this.ics = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.ics.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.fya.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.ict == null) {
            this.ict = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.icu == null) {
            this.icu = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.hHY == null) {
            this.hHY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hHY.setOnClickListener(this.hIl);
            this.mBackImageView = (ImageView) this.hHY.findViewById(R.id.widget_navi_back_button);
        }
        if (this.icv == null) {
            this.icv = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fqQ == null) {
            this.fqQ = new NoNetworkView(getContext());
            this.fqQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.ics.addView(this.fqQ);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fqQ.setVisibility(8);
        } else {
            this.fqQ.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.hNE != null && this.hNE.getForum() != null) {
            String name = this.hNE.getForum().getName();
            if (as.getChineseAndEnglishLength(name) > 14) {
                name = as.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.ict != null && this.icu != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.ict.setVisibility(8);
                this.icu.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ict.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.icu.getLayoutParams();
            if (this.hNC.ceG().getFirstCompletelyVisiblePosition() != 0) {
                this.ict.setVisibility(8);
                this.icu.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.WP.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.ict.setVisibility(0);
                this.icu.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.ict.setVisibility(8);
                this.icu.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.ict.setVisibility(0);
                this.icu.setVisibility(8);
            }
        }
    }

    private void Iv() {
        if (this.biX != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.biX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.biX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.biX.setLayoutParams(layoutParams);
                this.biX.setVisibility(0);
                if (this.icv != null && (this.icv.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.icv.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.biX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccP() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.icv != null) {
                this.icv.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.biX != null) {
                this.biX.setAlpha(f);
            }
            if (this.hIx != null) {
                this.hIx.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.biX != null && this.hIx != null && this.biX.getLayoutParams() != null && this.hIx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.biX.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.biX.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hIx.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.hIx.setLayoutParams(layoutParams2);
        }
    }

    private void tW(int i) {
        String string;
        if (this.hUo == null) {
            this.hUo = new TextView(getContext());
            this.hUo.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.hUo.setGravity(17);
        }
        if (this.hUo != null) {
            if (this.icy) {
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
            this.hUo.setText(string);
        }
        ao.setBackgroundResource(this.hUo, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.hUo, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.hZx == null) {
            this.hZx = new bc();
        }
        this.hZx.a(this.hUo, this.drp, layoutParams, 2000);
    }

    private void chP() {
        this.WP.setExpanded(true);
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
        super.showNetRefreshView(this.drp, str, z);
        vl(0);
    }
}
