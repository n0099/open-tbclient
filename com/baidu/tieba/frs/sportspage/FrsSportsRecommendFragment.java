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
    private View bxQ;
    private FrameLayout dXU;
    private NoNetworkView gbO;
    private CollapsingToolbarLayout gjh;
    private View iDR;
    private View iEq;
    private long iKH;
    private TextView iQS;
    private be iWq;
    private ObservedChangeLinearLayout iZk;
    private View iZl;
    private View iZm;
    private ImageView iZn;
    private a iZo;
    private b iZp;
    private int iZr;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean iZq = true;
    public final View.OnClickListener iEe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.iDR != null && view == FrsSportsRecommendFragment.this.iDR) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener gjF = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Yh.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.iKk.setSelection(0);
                    FrsSportsRecommendFragment.this.bNv();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iZs = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.iZr != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gbO == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gbO.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.iZr - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.yw(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.iEq != null) {
                                FrsSportsRecommendFragment.this.iEq.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.iEq != null && FrsSportsRecommendFragment.this.bxQ != null) {
                            if (FrsSportsRecommendFragment.this.bxQ.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.yw(0);
                            }
                            FrsSportsRecommendFragment.this.iEq.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.cxe();
                        }
                        FrsSportsRecommendFragment.this.i(i, f);
                        FrsSportsRecommendFragment.this.iZr = i;
                        FrsSportsRecommendFragment.this.zb(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gjF);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.iKk.pO(true);
        cCm();
        this.gjh = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.bxQ = this.mRootView.findViewById(R.id.statebar_view);
        this.iEq = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Yh = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Yh.addOnOffsetChangedListener(this.iZs);
        QR();
        this.iZo = new a(this, this.mRootView);
        this.iZo.g(this.iKm);
        this.iZp = new b(this, this.mRootView);
        if (this.iKl != null) {
            this.iKl.fk(0L);
        }
        this.dXU = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.iAs = currentTimeMillis + frsActivity.iAs;
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
                frsActivity.iAs = currentTimeMillis + frsActivity.iAs;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iZo != null) {
            this.iZo.onChangeSkinType();
        }
        if (this.iZp != null) {
            this.iZp.onChangeSkinType();
        }
        if (this.gbO != null) {
            this.gbO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ap.setBackgroundResource(this.iZl, R.drawable.top_shadow);
        ap.setBackgroundResource(this.iZm, R.drawable.top_shadow);
        ap.setBackgroundColor(this.bxQ, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iEq, R.color.cp_bg_line_d);
        SvgManager.boN().a(this.iZn, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.boN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        cxe();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.au
    public void bqb() {
        cCn();
        if (this.iKl != null) {
            this.iKl.fk(this.iKH);
        }
        super.bqb();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.iZo != null) {
                this.iZo.setData(dVar.iKJ, dVar.iKK, dVar.iKL);
            }
            if (this.iZp != null && this.iKm != null && this.iKm.getForum() != null) {
                this.iZp.a(dVar.iKM, this.iKm.getForum().getId());
            }
            if (this.iKl != null && this.iKl.cze()) {
                xJ(dVar.iKI);
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
                                this.iKH = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.iZq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.iKk != null) {
            this.iKk.kT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void cCm() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.iZk == null) {
            this.iZk = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iZk.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.gjh.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.iZl == null) {
            this.iZl = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.iZm == null) {
            this.iZm = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.iDR == null) {
            this.iDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iDR.setOnClickListener(this.iEe);
            this.mBackImageView = (ImageView) this.iDR.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iZn == null) {
            this.iZn = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gbO == null) {
            this.gbO = new NoNetworkView(getContext());
            this.gbO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.iZk.addView(this.gbO);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gbO.setVisibility(8);
        } else {
            this.gbO.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.iKm != null && this.iKm.getForum() != null) {
            String name = this.iKm.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 14) {
                name = at.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, float f) {
        if (this.iZl != null && this.iZm != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.iZl.setVisibility(8);
                this.iZm.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iZl.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.iZm.getLayoutParams();
            if (this.iKk.czc().getFirstCompletelyVisiblePosition() != 0) {
                this.iZl.setVisibility(8);
                this.iZm.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Yh.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.iZl.setVisibility(0);
                this.iZm.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.iZl.setVisibility(8);
                this.iZm.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.iZl.setVisibility(0);
                this.iZm.setVisibility(8);
            }
        }
    }

    private void QR() {
        if (this.bxQ != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.bxQ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bxQ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bxQ.setLayoutParams(layoutParams);
                this.bxQ.setVisibility(0);
                if (this.iZn != null && (this.iZn.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.iZn.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.bxQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxe() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.iZn != null) {
                this.iZn.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.bxQ != null) {
                this.bxQ.setAlpha(f);
            }
            if (this.iEq != null) {
                this.iEq.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.bxQ != null && this.iEq != null && this.bxQ.getLayoutParams() != null && this.iEq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bxQ.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.bxQ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.iEq.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.iEq.setLayoutParams(layoutParams2);
        }
    }

    private void xJ(int i) {
        String string;
        if (this.iQS == null) {
            this.iQS = new TextView(getContext());
            this.iQS.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.iQS.setGravity(17);
        }
        if (this.iQS != null) {
            if (this.iZq) {
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
            this.iQS.setText(string);
        }
        ap.setBackgroundResource(this.iQS, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iQS, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.iWq == null) {
            this.iWq = new be();
        }
        this.iWq.a(this.iQS, this.dXU, layoutParams, 2000);
    }

    private void cCn() {
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
        super.showNetRefreshView(this.dXU, str, z);
        zb(0);
    }
}
