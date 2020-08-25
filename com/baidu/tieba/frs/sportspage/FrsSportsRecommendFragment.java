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
/* loaded from: classes16.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Xv;
    private View boC;
    private FrameLayout dBr;
    private NoNetworkView fCm;
    private CollapsingToolbarLayout fJs;
    private View hVN;
    private View hVo;
    private long ice;
    private TextView iiv;
    private be inF;
    private View iqA;
    private View iqB;
    private ImageView iqC;
    private a iqD;
    private b iqE;
    private int iqG;
    private ObservedChangeLinearLayout iqz;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean iqF = true;
    public final View.OnClickListener hVB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.hVo != null && view == FrsSportsRecommendFragment.this.hVo) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener fJR = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Xv.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.ibH.setSelection(0);
                    FrsSportsRecommendFragment.this.bGQ();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iqH = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.iqG != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fCm == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fCm.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.iqG - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.wY(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.hVN != null) {
                                FrsSportsRecommendFragment.this.hVN.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.hVN != null && FrsSportsRecommendFragment.this.boC != null) {
                            if (FrsSportsRecommendFragment.this.boC.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.wY(0);
                            }
                            FrsSportsRecommendFragment.this.hVN.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cnm();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.iqG = i;
                        FrsSportsRecommendFragment.this.xD(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fJR);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.ibH.oJ(true);
        css();
        this.fJs = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.boC = this.mRootView.findViewById(R.id.statebar_view);
        this.hVN = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Xv = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Xv.addOnOffsetChangedListener(this.iqH);
        Oo();
        this.iqD = new a(this, this.mRootView);
        this.iqD.g(this.ibJ);
        this.iqE = new b(this, this.mRootView);
        if (this.ibI != null) {
            this.ibI.eI(0L);
        }
        this.dBr = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.hRP = currentTimeMillis + frsActivity.hRP;
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
                frsActivity.hRP = currentTimeMillis + frsActivity.hRP;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iqD != null) {
            this.iqD.onChangeSkinType();
        }
        if (this.iqE != null) {
            this.iqE.onChangeSkinType();
        }
        if (this.fCm != null) {
            this.fCm.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.iqA, R.drawable.top_shadow);
        ap.setBackgroundResource(this.iqB, R.drawable.top_shadow);
        ap.setBackgroundColor(this.boC, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hVN, R.color.cp_bg_line_d);
        SvgManager.bjq().a(this.iqC, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cnm();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.au
    public void bkD() {
        cst();
        if (this.ibI != null) {
            this.ibI.eI(this.ice);
        }
        super.bkD();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.iqD != null) {
                this.iqD.setData(dVar.icg, dVar.ich, dVar.ici);
            }
            if (this.iqE != null && this.ibJ != null && this.ibJ.getForum() != null) {
                this.iqE.a(dVar.icj, this.ibJ.getForum().getId());
            }
            if (this.ibI != null && this.ibI.cpm()) {
                wl(dVar.icf);
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
                                this.ice = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.iqF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.ibH != null) {
            this.ibH.kf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void css() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.iqz == null) {
            this.iqz = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iqz.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.fJs.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.iqA == null) {
            this.iqA = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.iqB == null) {
            this.iqB = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.hVo == null) {
            this.hVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hVo.setOnClickListener(this.hVB);
            this.mBackImageView = (ImageView) this.hVo.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iqC == null) {
            this.iqC = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fCm == null) {
            this.fCm = new NoNetworkView(getContext());
            this.fCm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.iqz.addView(this.fCm);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fCm.setVisibility(8);
        } else {
            this.fCm.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.ibJ != null && this.ibJ.getForum() != null) {
            String name = this.ibJ.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.iqA != null && this.iqB != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.iqA.setVisibility(8);
                this.iqB.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iqA.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.iqB.getLayoutParams();
            if (this.ibH.cpk().getFirstCompletelyVisiblePosition() != 0) {
                this.iqA.setVisibility(8);
                this.iqB.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Xv.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.iqA.setVisibility(0);
                this.iqB.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.iqA.setVisibility(8);
                this.iqB.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.iqA.setVisibility(0);
                this.iqB.setVisibility(8);
            }
        }
    }

    private void Oo() {
        if (this.boC != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.boC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.boC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.boC.setLayoutParams(layoutParams);
                this.boC.setVisibility(0);
                if (this.iqC != null && (this.iqC.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.iqC.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.boC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnm() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.iqC != null) {
                this.iqC.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.boC != null) {
                this.boC.setAlpha(f);
            }
            if (this.hVN != null) {
                this.hVN.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.boC != null && this.hVN != null && this.boC.getLayoutParams() != null && this.hVN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.boC.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.boC.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hVN.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.hVN.setLayoutParams(layoutParams2);
        }
    }

    private void wl(int i) {
        String string;
        if (this.iiv == null) {
            this.iiv = new TextView(getContext());
            this.iiv.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.iiv.setGravity(17);
        }
        if (this.iiv != null) {
            if (this.iqF) {
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
            this.iiv.setText(string);
        }
        ap.setBackgroundResource(this.iiv, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iiv, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.inF == null) {
            this.inF = new be();
        }
        this.inF.a(this.iiv, this.dBr, layoutParams, 2000);
    }

    private void cst() {
        this.Xv.setExpanded(true);
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
        super.showNetRefreshView(this.dBr, str, z);
        xD(0);
    }
}
