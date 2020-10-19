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
    private AppBarLayout Yg;
    private View bvC;
    private FrameLayout dPx;
    private NoNetworkView fRL;
    private CollapsingToolbarLayout fZc;
    private TextView iEw;
    private be iJU;
    private ObservedChangeLinearLayout iMO;
    private View iMP;
    private View iMQ;
    private ImageView iMR;
    private a iMS;
    private b iMT;
    private int iMV;
    private View irU;
    private View irv;
    private long iyl;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean iMU = true;
    public final View.OnClickListener irI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.irv != null && view == FrsSportsRecommendFragment.this.irv) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener fZA = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Yg.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.ixO.setSelection(0);
                    FrsSportsRecommendFragment.this.bKT();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iMW = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.iMV != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fRL == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fRL.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.iMV - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yd(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.irU != null) {
                                FrsSportsRecommendFragment.this.irU.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.irU != null && FrsSportsRecommendFragment.this.bvC != null) {
                            if (FrsSportsRecommendFragment.this.bvC.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yd(0);
                            }
                            FrsSportsRecommendFragment.this.irU.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.ctX();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.iMV = i;
                        FrsSportsRecommendFragment.this.yI(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fZA);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.ixO.pw(true);
        czf();
        this.fZc = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bvC = this.mRootView.findViewById(R.id.statebar_view);
        this.irU = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Yg = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Yg.addOnOffsetChangedListener(this.iMW);
        PW();
        this.iMS = new a(this, this.mRootView);
        this.iMS.g(this.ixQ);
        this.iMT = new b(this, this.mRootView);
        if (this.ixP != null) {
            this.ixP.fj(0L);
        }
        this.dPx = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.inW = currentTimeMillis + frsActivity.inW;
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
                frsActivity.inW = currentTimeMillis + frsActivity.inW;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iMS != null) {
            this.iMS.onChangeSkinType();
        }
        if (this.iMT != null) {
            this.iMT.onChangeSkinType();
        }
        if (this.fRL != null) {
            this.fRL.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.iMP, R.drawable.top_shadow);
        ap.setBackgroundResource(this.iMQ, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bvC, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.irU, R.color.cp_bg_line_d);
        SvgManager.bmU().a(this.iMR, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.bmU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        ctX();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.au
    public void boi() {
        czg();
        if (this.ixP != null) {
            this.ixP.fj(this.iyl);
        }
        super.boi();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.iMS != null) {
                this.iMS.setData(dVar.iyn, dVar.iyo, dVar.iyp);
            }
            if (this.iMT != null && this.ixQ != null && this.ixQ.getForum() != null) {
                this.iMT.a(dVar.iyq, this.ixQ.getForum().getId());
            }
            if (this.ixP != null && this.ixP.cvX()) {
                xq(dVar.iym);
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
                                this.iyl = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.iMU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.ixO != null) {
            this.ixO.kG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void czf() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.iMO == null) {
            this.iMO = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iMO.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.fZc.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.iMP == null) {
            this.iMP = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.iMQ == null) {
            this.iMQ = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.irv == null) {
            this.irv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.irv.setOnClickListener(this.irI);
            this.mBackImageView = (ImageView) this.irv.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iMR == null) {
            this.iMR = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fRL == null) {
            this.fRL = new NoNetworkView(getContext());
            this.fRL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.iMO.addView(this.fRL);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fRL.setVisibility(8);
        } else {
            this.fRL.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.ixQ != null && this.ixQ.getForum() != null) {
            String name = this.ixQ.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.iMP != null && this.iMQ != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.iMP.setVisibility(8);
                this.iMQ.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iMP.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.iMQ.getLayoutParams();
            if (this.ixO.cvV().getFirstCompletelyVisiblePosition() != 0) {
                this.iMP.setVisibility(8);
                this.iMQ.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Yg.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.iMP.setVisibility(0);
                this.iMQ.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.iMP.setVisibility(8);
                this.iMQ.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.iMP.setVisibility(0);
                this.iMQ.setVisibility(8);
            }
        }
    }

    private void PW() {
        if (this.bvC != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bvC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bvC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bvC.setLayoutParams(layoutParams);
                this.bvC.setVisibility(0);
                if (this.iMR != null && (this.iMR.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.iMR.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bvC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctX() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.iMR != null) {
                this.iMR.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bvC != null) {
                this.bvC.setAlpha(f);
            }
            if (this.irU != null) {
                this.irU.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bvC != null && this.irU != null && this.bvC.getLayoutParams() != null && this.irU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bvC.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bvC.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.irU.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.irU.setLayoutParams(layoutParams2);
        }
    }

    private void xq(int i) {
        String string;
        if (this.iEw == null) {
            this.iEw = new TextView(getContext());
            this.iEw.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.iEw.setGravity(17);
        }
        if (this.iEw != null) {
            if (this.iMU) {
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
            this.iEw.setText(string);
        }
        ap.setBackgroundResource(this.iEw, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iEw, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.iJU == null) {
            this.iJU = new be();
        }
        this.iJU.a(this.iEw, this.dPx, layoutParams, 2000);
    }

    private void czg() {
        this.Yg.setExpanded(true);
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
        super.showNetRefreshView(this.dPx, str, z);
        yI(0);
    }
}
