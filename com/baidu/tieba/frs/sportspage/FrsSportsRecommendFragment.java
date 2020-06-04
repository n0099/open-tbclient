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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
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
    private AppBarLayout Wr;
    private View bdq;
    private FrameLayout dgJ;
    private NoNetworkView fay;
    private CollapsingToolbarLayout fhE;
    private TextView hBf;
    private aw hGj;
    private ObservedChangeLinearLayout hJg;
    private View hJh;
    private View hJi;
    private ImageView hJj;
    private a hJk;
    private b hJl;
    private int hJn;
    private View hpR;
    private View hpq;
    private long hvf;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean hJm = true;
    public final View.OnClickListener hpF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.hpq != null && view == FrsSportsRecommendFragment.this.hpq) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener fie = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Wr.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.huL.setSelection(0);
                    FrsSportsRecommendFragment.this.brL();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hJo = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.hJn != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fay == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fay.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.hJn - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.tO(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.hpR != null) {
                                FrsSportsRecommendFragment.this.hpR.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.hpR != null && FrsSportsRecommendFragment.this.bdq != null) {
                            if (FrsSportsRecommendFragment.this.bdq.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.tO(0);
                            }
                            FrsSportsRecommendFragment.this.hpR.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bWj();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.hJn = i;
                        FrsSportsRecommendFragment.this.uo(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fie);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.huL.np(true);
        caW();
        this.fhE = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bdq = this.mRootView.findViewById(R.id.statebar_view);
        this.hpR = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Wr = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Wr.addOnOffsetChangedListener(this.hJo);
        Hc();
        this.hJk = new a(this, this.mRootView);
        this.hJk.g(this.huN);
        this.hJl = new b(this, this.mRootView);
        if (this.huM != null) {
            this.huM.eg(0L);
        }
        this.dgJ = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.hmx = currentTimeMillis + frsActivity.hmx;
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
                frsActivity.hmx = currentTimeMillis + frsActivity.hmx;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hJk != null) {
            this.hJk.onChangeSkinType();
        }
        if (this.hJl != null) {
            this.hJl.onChangeSkinType();
        }
        if (this.fay != null) {
            this.fay.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.hJh, R.drawable.top_shadow);
        am.setBackgroundResource(this.hJi, R.drawable.top_shadow);
        am.setBackgroundColor(this.bdq, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hpR, R.color.cp_bg_line_d);
        SvgManager.aUW().a(this.hJj, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bWj();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.an
    public void aWp() {
        caX();
        if (this.huM != null) {
            this.huM.eg(this.hvf);
        }
        super.aWp();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.hJk != null) {
                this.hJk.setData(dVar.hvh, dVar.hvi, dVar.hvj);
            }
            if (this.hJl != null && this.huN != null && this.huN.getForum() != null) {
                this.hJl.a(dVar.hvk, this.huN.getForum().getId());
            }
            if (this.huM != null && this.huM.bXV()) {
                td(dVar.hvg);
            }
            if (!v.isEmpty(dVar.threadList)) {
                Iterator<o> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    o next = it.next();
                    if (next instanceof bk) {
                        bk bkVar = (bk) next;
                        if (bkVar.isTop()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.f.b.toLong(bkVar.getId(), 0L);
                            if (j > 0) {
                                this.hvf = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.hJm = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.huL != null) {
            this.huL.iQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void caW() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.hJg == null) {
            this.hJg = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hJg.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.fhE.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.hJh == null) {
            this.hJh = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.hJi == null) {
            this.hJi = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.hpq == null) {
            this.hpq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hpq.setOnClickListener(this.hpF);
            this.mBackImageView = (ImageView) this.hpq.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hJj == null) {
            this.hJj = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fay == null) {
            this.fay = new NoNetworkView(getContext());
            this.fay.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.hJg.addView(this.fay);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fay.setVisibility(8);
        } else {
            this.fay.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.huN != null && this.huN.getForum() != null) {
            String name = this.huN.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.hJh != null && this.hJi != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.hJh.setVisibility(8);
                this.hJi.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hJh.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hJi.getLayoutParams();
            if (this.huL.bXU().getFirstCompletelyVisiblePosition() != 0) {
                this.hJh.setVisibility(8);
                this.hJi.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Wr.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.hJh.setVisibility(0);
                this.hJi.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.hJh.setVisibility(8);
                this.hJi.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.hJh.setVisibility(0);
                this.hJi.setVisibility(8);
            }
        }
    }

    private void Hc() {
        if (this.bdq != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bdq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bdq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bdq.setLayoutParams(layoutParams);
                this.bdq.setVisibility(0);
                if (this.hJj != null && (this.hJj.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.hJj.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bdq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWj() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.hJj != null) {
                this.hJj.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bdq != null) {
                this.bdq.setAlpha(f);
            }
            if (this.hpR != null) {
                this.hpR.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bdq != null && this.hpR != null && this.bdq.getLayoutParams() != null && this.hpR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bdq.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bdq.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hpR.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.hpR.setLayoutParams(layoutParams2);
        }
    }

    private void td(int i) {
        String string;
        if (this.hBf == null) {
            this.hBf = new TextView(getContext());
            this.hBf.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.hBf.setGravity(17);
        }
        if (this.hBf != null) {
            if (this.hJm) {
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
            this.hBf.setText(string);
        }
        am.setBackgroundResource(this.hBf, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hBf, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.hGj == null) {
            this.hGj = new aw();
        }
        this.hGj.a(this.hBf, this.dgJ, layoutParams, 2000);
    }

    private void caX() {
        this.Wr.setExpanded(true);
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
        super.showNetRefreshView(this.dgJ, str, z);
        uo(0);
    }
}
