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
/* loaded from: classes9.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout CD;
    private View aCa;
    private FrameLayout cwu;
    private CollapsingToolbarLayout eqz;
    private NoNetworkView fUO;
    private TextView gAQ;
    private ar gFX;
    private ObservedChangeLinearLayout gIP;
    private View gIQ;
    private View gIR;
    private ImageView gIS;
    private a gIT;
    private b gIU;
    private int gIW;
    private View gqB;
    private View gqb;
    private long gvT;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean gIV = true;
    public final View.OnClickListener gqo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.gqb != null && view == FrsSportsRecommendFragment.this.gqb) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener eqY = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.CD.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.gvA.setSelection(0);
                    FrsSportsRecommendFragment.this.bdo();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener gIX = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.gIW != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fUO == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fUO.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.gIW - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.sH(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.gqB != null) {
                                FrsSportsRecommendFragment.this.gqB.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.gqB != null && FrsSportsRecommendFragment.this.aCa != null) {
                            if (FrsSportsRecommendFragment.this.aCa.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.sH(0);
                            }
                            FrsSportsRecommendFragment.this.gqB.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bEY();
                        }
                        FrsSportsRecommendFragment.this.j(i, f);
                        FrsSportsRecommendFragment.this.gIW = i;
                        FrsSportsRecommendFragment.this.th(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eqY);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.gvA.lL(true);
        bJF();
        this.eqz = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.aCa = this.mRootView.findViewById(R.id.statebar_view);
        this.gqB = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.CD.addOnOffsetChangedListener(this.gIX);
        Af();
        this.gIT = new a(this, this.mRootView);
        this.gIT.g(this.gvC);
        this.gIU = new b(this, this.mRootView);
        if (this.gvB != null) {
            this.gvB.dw(0L);
        }
        this.cwu = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.gnq = currentTimeMillis + frsActivity.gnq;
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
                frsActivity.gnq = currentTimeMillis + frsActivity.gnq;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gIT != null) {
            this.gIT.onChangeSkinType();
        }
        if (this.gIU != null) {
            this.gIU.onChangeSkinType();
        }
        if (this.fUO != null) {
            this.fUO.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.gIQ, R.drawable.top_shadow);
        am.setBackgroundResource(this.gIR, R.drawable.top_shadow);
        am.setBackgroundColor(this.aCa, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gqB, R.color.cp_bg_line_d);
        SvgManager.aGA().a(this.gIS, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGA().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bEY();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bJG();
        if (this.gvB != null) {
            this.gvB.dw(this.gvT);
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
            if (this.gIT != null) {
                this.gIT.setData(dVar.gvV, dVar.gvW, dVar.gvX);
            }
            if (this.gIU != null && this.gvC != null && this.gvC.getForum() != null) {
                this.gIU.a(dVar.gvY, this.gvC.getForum().getId());
            }
            if (this.gvB != null && this.gvB.bGE()) {
                tT(dVar.gvU);
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
                                this.gvT = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.gIV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.gvA != null) {
            this.gvA.hu(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bJF() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.gIP == null) {
            this.gIP = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gIP.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.eqz.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.gIQ == null) {
            this.gIQ = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.gIR == null) {
            this.gIR = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.gqb == null) {
            this.gqb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqb.setOnClickListener(this.gqo);
            this.mBackImageView = (ImageView) this.gqb.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gIS == null) {
            this.gIS = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fUO == null) {
            this.fUO = new NoNetworkView(getContext());
            this.fUO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.gIP.addView(this.fUO);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fUO.setVisibility(8);
        } else {
            this.fUO.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.gvC != null && this.gvC.getForum() != null) {
            String name = this.gvC.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, float f) {
        if (this.gIQ != null && this.gIR != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.gIQ.setVisibility(8);
                this.gIR.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gIQ.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gIR.getLayoutParams();
            if (this.gvA.bGD().getFirstCompletelyVisiblePosition() != 0) {
                this.gIQ.setVisibility(8);
                this.gIR.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.CD.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.gIQ.setVisibility(0);
                this.gIR.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.gIQ.setVisibility(8);
                this.gIR.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.gIQ.setVisibility(0);
                this.gIR.setVisibility(8);
            }
        }
    }

    private void Af() {
        if (this.aCa != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.aCa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCa.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCa.setLayoutParams(layoutParams);
                this.aCa.setVisibility(0);
                if (this.gIS != null && (this.gIS.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.gIS.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.aCa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEY() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.gIS != null) {
                this.gIS.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.aCa != null) {
                this.aCa.setAlpha(f);
            }
            if (this.gqB != null) {
                this.gqB.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.aCa != null && this.gqB != null && this.aCa.getLayoutParams() != null && this.gqB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aCa.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.aCa.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.gqB.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.gqB.setLayoutParams(layoutParams2);
        }
    }

    private void tT(int i) {
        String string;
        if (this.gAQ == null) {
            this.gAQ = new TextView(getContext());
            this.gAQ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.gAQ.setGravity(17);
        }
        if (this.gAQ != null) {
            if (this.gIV) {
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
            this.gAQ.setText(string);
        }
        am.setBackgroundResource(this.gAQ, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gAQ, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.gFX == null) {
            this.gFX = new ar();
        }
        this.gFX.a(this.gAQ, this.cwu, layoutParams, 2000);
    }

    private void bJG() {
        this.CD.setExpanded(true);
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
        super.showNetRefreshView(this.cwu, str, z);
        th(0);
    }
}
