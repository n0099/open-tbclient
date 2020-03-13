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
    private View aCc;
    private FrameLayout cww;
    private CollapsingToolbarLayout eqN;
    private NoNetworkView fVd;
    private TextView gBe;
    private ar gGl;
    private ObservedChangeLinearLayout gJd;
    private View gJe;
    private View gJf;
    private ImageView gJg;
    private a gJh;
    private b gJi;
    private int gJk;
    private View gqQ;
    private View gqq;
    private long gwh;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean gJj = true;
    public final View.OnClickListener gqD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.gqq != null && view == FrsSportsRecommendFragment.this.gqq) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener erm = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.CD.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.gvO.setSelection(0);
                    FrsSportsRecommendFragment.this.bdr();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener gJl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.gJk != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.fVd == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.fVd.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.gJk - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.sH(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.gqQ != null) {
                                FrsSportsRecommendFragment.this.gqQ.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.gqQ != null && FrsSportsRecommendFragment.this.aCc != null) {
                            if (FrsSportsRecommendFragment.this.aCc.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.sH(0);
                            }
                            FrsSportsRecommendFragment.this.gqQ.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bFb();
                        }
                        FrsSportsRecommendFragment.this.j(i, f);
                        FrsSportsRecommendFragment.this.gJk = i;
                        FrsSportsRecommendFragment.this.th(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.erm);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.gvO.lL(true);
        bJI();
        this.eqN = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.aCc = this.mRootView.findViewById(R.id.statebar_view);
        this.gqQ = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.CD = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.CD.addOnOffsetChangedListener(this.gJl);
        Ah();
        this.gJh = new a(this, this.mRootView);
        this.gJh.g(this.gvQ);
        this.gJi = new b(this, this.mRootView);
        if (this.gvP != null) {
            this.gvP.dw(0L);
        }
        this.cww = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.gnF = currentTimeMillis + frsActivity.gnF;
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
                frsActivity.gnF = currentTimeMillis + frsActivity.gnF;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gJh != null) {
            this.gJh.onChangeSkinType();
        }
        if (this.gJi != null) {
            this.gJi.onChangeSkinType();
        }
        if (this.fVd != null) {
            this.fVd.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.gJe, R.drawable.top_shadow);
        am.setBackgroundResource(this.gJf, R.drawable.top_shadow);
        am.setBackgroundColor(this.aCc, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gqQ, R.color.cp_bg_line_d);
        SvgManager.aGC().a(this.gJg, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bFb();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        bJJ();
        if (this.gvP != null) {
            this.gvP.dw(this.gwh);
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
            if (this.gJh != null) {
                this.gJh.setData(dVar.gwj, dVar.gwk, dVar.gwl);
            }
            if (this.gJi != null && this.gvQ != null && this.gvQ.getForum() != null) {
                this.gJi.a(dVar.gwm, this.gvQ.getForum().getId());
            }
            if (this.gvP != null && this.gvP.bGH()) {
                tT(dVar.gwi);
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
                                this.gwh = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.gJj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.gvO != null) {
            this.gvO.hu(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bJI() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.gJd == null) {
            this.gJd = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gJd.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.eqN.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.gJe == null) {
            this.gJe = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.gJf == null) {
            this.gJf = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.gqq == null) {
            this.gqq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqq.setOnClickListener(this.gqD);
            this.mBackImageView = (ImageView) this.gqq.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gJg == null) {
            this.gJg = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.fVd == null) {
            this.fVd = new NoNetworkView(getContext());
            this.fVd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.gJd.addView(this.fVd);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.fVd.setVisibility(8);
        } else {
            this.fVd.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.gvQ != null && this.gvQ.getForum() != null) {
            String name = this.gvQ.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, float f) {
        if (this.gJe != null && this.gJf != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.gJe.setVisibility(8);
                this.gJf.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJe.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gJf.getLayoutParams();
            if (this.gvO.bGG().getFirstCompletelyVisiblePosition() != 0) {
                this.gJe.setVisibility(8);
                this.gJf.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.CD.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.gJe.setVisibility(0);
                this.gJf.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.gJe.setVisibility(8);
                this.gJf.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.gJe.setVisibility(0);
                this.gJf.setVisibility(8);
            }
        }
    }

    private void Ah() {
        if (this.aCc != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.aCc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCc.setLayoutParams(layoutParams);
                this.aCc.setVisibility(0);
                if (this.gJg != null && (this.gJg.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.gJg.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.aCc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFb() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.gJg != null) {
                this.gJg.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.aCc != null) {
                this.aCc.setAlpha(f);
            }
            if (this.gqQ != null) {
                this.gqQ.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.aCc != null && this.gqQ != null && this.aCc.getLayoutParams() != null && this.gqQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aCc.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.aCc.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.gqQ.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.gqQ.setLayoutParams(layoutParams2);
        }
    }

    private void tT(int i) {
        String string;
        if (this.gBe == null) {
            this.gBe = new TextView(getContext());
            this.gBe.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.gBe.setGravity(17);
        }
        if (this.gBe != null) {
            if (this.gJj) {
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
            this.gBe.setText(string);
        }
        am.setBackgroundResource(this.gBe, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gBe, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.gGl == null) {
            this.gGl = new ar();
        }
        this.gGl.a(this.gBe, this.cww, layoutParams, 2000);
    }

    private void bJJ() {
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
        super.showNetRefreshView(this.cww, str, z);
        th(0);
    }
}
