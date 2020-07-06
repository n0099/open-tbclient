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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout WW;
    private View biD;
    private FrameLayout dlv;
    private NoNetworkView flI;
    private CollapsingToolbarLayout fsS;
    private View hCa;
    private View hCz;
    private long hHX;
    private TextView hOn;
    private bc hTw;
    private ObservedChangeLinearLayout hWs;
    private View hWt;
    private View hWu;
    private ImageView hWv;
    private a hWw;
    private b hWx;
    private int hWz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean hWy = true;
    public final View.OnClickListener hCn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.hCa != null && view == FrsSportsRecommendFragment.this.hCa) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener ftr = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.WW.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.hHB.setSelection(0);
                    FrsSportsRecommendFragment.this.buI();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hWA = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.hWz != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.flI == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.flI.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.hWz - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.ur(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.hCz != null) {
                                FrsSportsRecommendFragment.this.hCz.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.hCz != null && FrsSportsRecommendFragment.this.biD != null) {
                            if (FrsSportsRecommendFragment.this.biD.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.ur(0);
                            }
                            FrsSportsRecommendFragment.this.hCz.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bZs();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.hWz = i;
                        FrsSportsRecommendFragment.this.uT(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ftr);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.hHB.nA(true);
        cep();
        this.fsS = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.biD = this.mRootView.findViewById(R.id.statebar_view);
        this.hCz = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.WW = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.WW.addOnOffsetChangedListener(this.hWA);
        Ip();
        this.hWw = new a(this, this.mRootView);
        this.hWw.g(this.hHD);
        this.hWx = new b(this, this.mRootView);
        if (this.hHC != null) {
            this.hHC.ej(0L);
        }
        this.dlv = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.hyN = currentTimeMillis + frsActivity.hyN;
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
                frsActivity.hyN = currentTimeMillis + frsActivity.hyN;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hWw != null) {
            this.hWw.onChangeSkinType();
        }
        if (this.hWx != null) {
            this.hWx.onChangeSkinType();
        }
        if (this.flI != null) {
            this.flI.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        an.setBackgroundResource(this.hWt, R.drawable.top_shadow);
        an.setBackgroundResource(this.hWu, R.drawable.top_shadow);
        an.setBackgroundColor(this.biD, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.hCz, R.color.cp_bg_line_d);
        SvgManager.aWQ().a(this.hWv, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aWQ().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            an.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bZs();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.as
    public void aYg() {
        ceq();
        if (this.hHC != null) {
            this.hHC.ej(this.hHX);
        }
        super.aYg();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.hWw != null) {
                this.hWw.setData(dVar.hHZ, dVar.hIa, dVar.hIb);
            }
            if (this.hWx != null && this.hHD != null && this.hHD.getForum() != null) {
                this.hWx.a(dVar.hIc, this.hHD.getForum().getId());
            }
            if (this.hHC != null && this.hHC.cbk()) {
                tE(dVar.hHY);
            }
            if (!w.isEmpty(dVar.threadList)) {
                Iterator<q> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    q next = it.next();
                    if (next instanceof bu) {
                        bu buVar = (bu) next;
                        if (buVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(buVar.getId(), 0L);
                            if (j > 0) {
                                this.hHX = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.hWy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.hHB != null) {
            this.hHB.jc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cep() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.hWs == null) {
            this.hWs = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hWs.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.fsS.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.hWt == null) {
            this.hWt = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.hWu == null) {
            this.hWu = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.hCa == null) {
            this.hCa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hCa.setOnClickListener(this.hCn);
            this.mBackImageView = (ImageView) this.hCa.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hWv == null) {
            this.hWv = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.flI == null) {
            this.flI = new NoNetworkView(getContext());
            this.flI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.hWs.addView(this.flI);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.flI.setVisibility(8);
        } else {
            this.flI.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.hHD != null && this.hHD.getForum() != null) {
            String name = this.hHD.getForum().getName();
            if (ar.getChineseAndEnglishLength(name) > 14) {
                name = ar.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.hWt != null && this.hWu != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.hWt.setVisibility(8);
                this.hWu.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hWt.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hWu.getLayoutParams();
            if (this.hHB.cbi().getFirstCompletelyVisiblePosition() != 0) {
                this.hWt.setVisibility(8);
                this.hWu.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.WW.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.hWt.setVisibility(0);
                this.hWu.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.hWt.setVisibility(8);
                this.hWu.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.hWt.setVisibility(0);
                this.hWu.setVisibility(8);
            }
        }
    }

    private void Ip() {
        if (this.biD != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.biD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.biD.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.biD.setLayoutParams(layoutParams);
                this.biD.setVisibility(0);
                if (this.hWv != null && (this.hWv.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.hWv.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.biD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZs() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.hWv != null) {
                this.hWv.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.biD != null) {
                this.biD.setAlpha(f);
            }
            if (this.hCz != null) {
                this.hCz.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.biD != null && this.hCz != null && this.biD.getLayoutParams() != null && this.hCz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.biD.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.biD.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hCz.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.hCz.setLayoutParams(layoutParams2);
        }
    }

    private void tE(int i) {
        String string;
        if (this.hOn == null) {
            this.hOn = new TextView(getContext());
            this.hOn.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.hOn.setGravity(17);
        }
        if (this.hOn != null) {
            if (this.hWy) {
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
            this.hOn.setText(string);
        }
        an.setBackgroundResource(this.hOn, R.color.cp_link_tip_a);
        an.setViewTextColor(this.hOn, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.hTw == null) {
            this.hTw = new bc();
        }
        this.hTw.a(this.hOn, this.dlv, layoutParams, 2000);
    }

    private void ceq() {
        this.WW.setExpanded(true);
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
        super.showNetRefreshView(this.dlv, str, z);
        uT(0);
    }
}
