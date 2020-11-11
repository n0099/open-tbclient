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
/* loaded from: classes22.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Yh;
    private View bEb;
    private FrameLayout edL;
    private NoNetworkView ghD;
    private CollapsingToolbarLayout goU;
    private View iJO;
    private View iKn;
    private long iQE;
    private TextView iWP;
    private be jcn;
    private ObservedChangeLinearLayout jfh;
    private View jfi;
    private View jfj;
    private ImageView jfk;
    private a jfl;
    private b jfm;
    private int jfo;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean jfn = true;
    public final View.OnClickListener iKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.iJO != null && view == FrsSportsRecommendFragment.this.iJO) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gps = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Yh.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.iQh.setSelection(0);
                    FrsSportsRecommendFragment.this.bPV();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jfp = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.jfo != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.ghD == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.ghD.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.jfo - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yJ(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.iKn != null) {
                                FrsSportsRecommendFragment.this.iKn.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.iKn != null && FrsSportsRecommendFragment.this.bEb != null) {
                            if (FrsSportsRecommendFragment.this.bEb.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yJ(0);
                            }
                            FrsSportsRecommendFragment.this.iKn.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.czF();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.jfo = i;
                        FrsSportsRecommendFragment.this.zo(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gps);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.iQh.pX(true);
        cEN();
        this.goU = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bEb = this.mRootView.findViewById(R.id.statebar_view);
        this.iKn = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Yh.addOnOffsetChangedListener(this.jfp);
        Tz();
        this.jfl = new a(this, this.mRootView);
        this.jfl.g(this.iQj);
        this.jfm = new b(this, this.mRootView);
        if (this.iQi != null) {
            this.iQi.fG(0L);
        }
        this.edL = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.iGp = currentTimeMillis + frsActivity.iGp;
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
                frsActivity.iGp = currentTimeMillis + frsActivity.iGp;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jfl != null) {
            this.jfl.onChangeSkinType();
        }
        if (this.jfm != null) {
            this.jfm.onChangeSkinType();
        }
        if (this.ghD != null) {
            this.ghD.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.jfi, R.drawable.top_shadow);
        ap.setBackgroundResource(this.jfj, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bEb, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iKn, R.color.cp_bg_line_d);
        SvgManager.brn().a(this.jfk, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.brn().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        czF();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.au
    public void bsB() {
        cEO();
        if (this.iQi != null) {
            this.iQi.fG(this.iQE);
        }
        super.bsB();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.jfl != null) {
                this.jfl.setData(dVar.iQG, dVar.iQH, dVar.iQI);
            }
            if (this.jfm != null && this.iQj != null && this.iQj.getForum() != null) {
                this.jfm.a(dVar.iQJ, this.iQj.getForum().getId());
            }
            if (this.iQi != null && this.iQi.cBF()) {
                xW(dVar.iQF);
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
                                this.iQE = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.jfn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.iQh != null) {
            this.iQh.lc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cEN() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.jfh == null) {
            this.jfh = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jfh.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.goU.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.jfi == null) {
            this.jfi = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.jfj == null) {
            this.jfj = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.iJO == null) {
            this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iJO.setOnClickListener(this.iKb);
            this.mBackImageView = (ImageView) this.iJO.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jfk == null) {
            this.jfk = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.ghD == null) {
            this.ghD = new NoNetworkView(getContext());
            this.ghD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.jfh.addView(this.ghD);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.ghD.setVisibility(8);
        } else {
            this.ghD.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.iQj != null && this.iQj.getForum() != null) {
            String name = this.iQj.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.jfi != null && this.jfj != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.jfi.setVisibility(8);
                this.jfj.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jfi.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jfj.getLayoutParams();
            if (this.iQh.cBD().getFirstCompletelyVisiblePosition() != 0) {
                this.jfi.setVisibility(8);
                this.jfj.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Yh.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.jfi.setVisibility(0);
                this.jfj.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.jfi.setVisibility(8);
                this.jfj.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.jfi.setVisibility(0);
                this.jfj.setVisibility(8);
            }
        }
    }

    private void Tz() {
        if (this.bEb != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bEb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bEb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bEb.setLayoutParams(layoutParams);
                this.bEb.setVisibility(0);
                if (this.jfk != null && (this.jfk.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.jfk.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bEb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czF() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.jfk != null) {
                this.jfk.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bEb != null) {
                this.bEb.setAlpha(f);
            }
            if (this.iKn != null) {
                this.iKn.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bEb != null && this.iKn != null && this.bEb.getLayoutParams() != null && this.iKn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bEb.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bEb.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.iKn.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.iKn.setLayoutParams(layoutParams2);
        }
    }

    private void xW(int i) {
        String string;
        if (this.iWP == null) {
            this.iWP = new TextView(getContext());
            this.iWP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.iWP.setGravity(17);
        }
        if (this.iWP != null) {
            if (this.jfn) {
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
            this.iWP.setText(string);
        }
        ap.setBackgroundResource(this.iWP, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iWP, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.jcn == null) {
            this.jcn = new be();
        }
        this.jcn.a(this.iWP, this.edL, layoutParams, 2000);
    }

    private void cEO() {
        this.Yh.setExpanded(true);
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
        super.showNetRefreshView(this.edL, str, z);
        zo(0);
    }
}
