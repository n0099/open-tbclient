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
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private AppBarLayout Wc;
    private View aWc;
    private FrameLayout cVI;
    private CollapsingToolbarLayout eUL;
    private NoNetworkView gAM;
    private View haS;
    private View har;
    private long hgg;
    private TextView hlE;
    private aw hqI;
    private ObservedChangeLinearLayout htF;
    private View htG;
    private View htH;
    private ImageView htI;
    private a htJ;
    private b htK;
    private int htM;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean htL = true;
    public final View.OnClickListener haG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.har != null && view == FrsSportsRecommendFragment.this.har) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener eVk = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Wc.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.hfM.setSelection(0);
                    FrsSportsRecommendFragment.this.bml();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener htN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.htM != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.gAM == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.gAM.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.htM - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.th(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.haS != null) {
                                FrsSportsRecommendFragment.this.haS.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.haS != null && FrsSportsRecommendFragment.this.aWc != null) {
                            if (FrsSportsRecommendFragment.this.aWc.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.th(0);
                            }
                            FrsSportsRecommendFragment.this.haS.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bPK();
                        }
                        FrsSportsRecommendFragment.this.h(i, f);
                        FrsSportsRecommendFragment.this.htM = i;
                        FrsSportsRecommendFragment.this.tH(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eVk);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.hfM.mU(true);
        bUq();
        this.eUL = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.aWc = this.mRootView.findViewById(R.id.statebar_view);
        this.haS = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Wc = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Wc.addOnOffsetChangedListener(this.htN);
        Fl();
        this.htJ = new a(this, this.mRootView);
        this.htJ.g(this.hfO);
        this.htK = new b(this, this.mRootView);
        if (this.hfN != null) {
            this.hfN.ef(0L);
        }
        this.cVI = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.gXA = currentTimeMillis + frsActivity.gXA;
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
                frsActivity.gXA = currentTimeMillis + frsActivity.gXA;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htJ != null) {
            this.htJ.onChangeSkinType();
        }
        if (this.htK != null) {
            this.htK.onChangeSkinType();
        }
        if (this.gAM != null) {
            this.gAM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.htG, R.drawable.top_shadow);
        am.setBackgroundResource(this.htH, R.drawable.top_shadow);
        am.setBackgroundColor(this.aWc, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.haS, R.color.cp_bg_line_d);
        SvgManager.aOR().a(this.htI, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aOR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bPK();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.frs.an
    public void aQk() {
        bUr();
        if (this.hfN != null) {
            this.hfN.ef(this.hgg);
        }
        super.aQk();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.htJ != null) {
                this.htJ.setData(dVar.hgi, dVar.hgj, dVar.hgk);
            }
            if (this.htK != null && this.hfO != null && this.hfO.getForum() != null) {
                this.htK.a(dVar.hgl, this.hfO.getForum().getId());
            }
            if (this.hfN != null && this.hfN.bRv()) {
                sw(dVar.hgh);
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
                                this.hgg = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.htL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.hfM != null) {
            this.hfM.it(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bUq() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.htF == null) {
            this.htF = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.htF.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.eUL.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.htG == null) {
            this.htG = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.htH == null) {
            this.htH = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.har == null) {
            this.har = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.har.setOnClickListener(this.haG);
            this.mBackImageView = (ImageView) this.har.findViewById(R.id.widget_navi_back_button);
        }
        if (this.htI == null) {
            this.htI = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.gAM == null) {
            this.gAM = new NoNetworkView(getContext());
            this.gAM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.htF.addView(this.gAM);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.gAM.setVisibility(8);
        } else {
            this.gAM.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.hfO != null && this.hfO.getForum() != null) {
            String name = this.hfO.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 14) {
                name = aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, float f) {
        if (this.htG != null && this.htH != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.htG.setVisibility(8);
                this.htH.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.htG.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.htH.getLayoutParams();
            if (this.hfM.bRu().getFirstCompletelyVisiblePosition() != 0) {
                this.htG.setVisibility(8);
                this.htH.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Wc.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.htG.setVisibility(0);
                this.htH.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.htG.setVisibility(8);
                this.htH.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.htG.setVisibility(0);
                this.htH.setVisibility(8);
            }
        }
    }

    private void Fl() {
        if (this.aWc != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.aWc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aWc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aWc.setLayoutParams(layoutParams);
                this.aWc.setVisibility(0);
                if (this.htI != null && (this.htI.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.htI.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.aWc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPK() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.htI != null) {
                this.htI.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.aWc != null) {
                this.aWc.setAlpha(f);
            }
            if (this.haS != null) {
                this.haS.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.aWc != null && this.haS != null && this.aWc.getLayoutParams() != null && this.haS.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.aWc.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.aWc.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.haS.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.haS.setLayoutParams(layoutParams2);
        }
    }

    private void sw(int i) {
        String string;
        if (this.hlE == null) {
            this.hlE = new TextView(getContext());
            this.hlE.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.hlE.setGravity(17);
        }
        if (this.hlE != null) {
            if (this.htL) {
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
            this.hlE.setText(string);
        }
        am.setBackgroundResource(this.hlE, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hlE, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.hqI == null) {
            this.hqI = new aw();
        }
        this.hqI.a(this.hlE, this.cVI, layoutParams, 2000);
    }

    private void bUr() {
        this.Wc.setExpanded(true);
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
        super.showNetRefreshView(this.cVI, str, z);
        tH(0);
    }
}
