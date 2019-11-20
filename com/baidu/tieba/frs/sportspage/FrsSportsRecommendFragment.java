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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.d;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    private View apj;
    private FrameLayout bGR;
    private CollapsingToolbarLayout dAq;
    private long fCy;
    private TextView fHn;
    private aq fMB;
    private ObservedChangeLinearLayout fPo;
    private View fPp;
    private View fPq;
    private ImageView fPr;
    private a fPs;
    private b fPt;
    private int fPv;
    private NoNetworkView faF;
    private View fwU;
    private View fwu;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private AppBarLayout zA;
    private boolean fPu = true;
    public final View.OnClickListener fwH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fwu != null && view == FrsSportsRecommendFragment.this.fwu) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener dAQ = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_REFRESH) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.toInt(split[1], 0)) {
                    FrsSportsRecommendFragment.this.zA.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fCf.setSelection(0);
                    FrsSportsRecommendFragment.this.aKf();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fPw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fPv != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.faF == null || j.isNetWorkAvailable()) ? 0 : FrsSportsRecommendFragment.this.faF.getHeight();
                int dimens = ((l.getDimens(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fPv - i < 0) {
                        abs = 0.0f;
                    }
                    if (dimens + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.qq(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.fwU != null) {
                                FrsSportsRecommendFragment.this.fwU.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.fwU != null && FrsSportsRecommendFragment.this.apj != null) {
                            if (FrsSportsRecommendFragment.this.apj.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.qq(0);
                            }
                            FrsSportsRecommendFragment.this.fwU.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bkX();
                        }
                        FrsSportsRecommendFragment.this.g(i, f);
                        FrsSportsRecommendFragment.this.fPv = i;
                        FrsSportsRecommendFragment.this.qQ(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dAQ);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fCf.kl(true);
        bpF();
        this.dAq = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.apj = this.mRootView.findViewById(R.id.statebar_view);
        this.fwU = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.zA = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.zA.addOnOffsetChangedListener(this.fPw);
        vA();
        this.fPs = new a(this, this.mRootView);
        this.fPs.g(this.fCh);
        this.fPt = new b(this, this.mRootView);
        if (this.fCg != null) {
            this.fCg.cL(0L);
        }
        this.bGR = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.ftH = currentTimeMillis + frsActivity.ftH;
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
                frsActivity.ftH = currentTimeMillis + frsActivity.ftH;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fPs != null) {
            this.fPs.onChangeSkinType();
        }
        if (this.fPt != null) {
            this.fPt.onChangeSkinType();
        }
        if (this.faF != null) {
            this.faF.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundResource(this.fPp, R.drawable.top_shadow);
        am.setBackgroundResource(this.fPq, R.drawable.top_shadow);
        am.setBackgroundColor(this.apj, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.fwU, R.color.cp_bg_line_d);
        SvgManager.amL().a(this.fPr, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bkX();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        bpG();
        if (this.fCg != null) {
            this.fCg.cL(this.fCy);
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
            if (this.fPs != null) {
                this.fPs.setData(dVar.fCA, dVar.fCB, dVar.fCC);
            }
            if (this.fPt != null && this.fCh != null && this.fCh.getForum() != null) {
                this.fPt.a(dVar.fCD, this.fCh.getForum().getId());
            }
            if (this.fCg != null && this.fCg.bmD()) {
                rC(dVar.fCz);
            }
            if (!v.isEmpty(dVar.threadList)) {
                Iterator<m> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof bh) {
                        bh bhVar = (bh) next;
                        if (bhVar.ajl()) {
                            continue;
                        } else {
                            long j = com.baidu.adp.lib.g.b.toLong(bhVar.getId(), 0L);
                            if (j > 0) {
                                this.fCy = j;
                                break;
                            }
                        }
                    }
                }
            }
            this.fPu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fCf != null) {
            this.fCf.fU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bpF() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fPo == null) {
            this.fPo = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fPo.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.dAq.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fPp == null) {
            this.fPp = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fPq == null) {
            this.fPq = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fwu == null) {
            this.fwu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fwu.setOnClickListener(this.fwH);
            this.mBackImageView = (ImageView) this.fwu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fPr == null) {
            this.fPr = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.faF == null) {
            this.faF = new NoNetworkView(getContext());
            this.faF.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fPo.addView(this.faF);
        }
        if (j.isNetworkAvailableForImmediately()) {
            this.faF.setVisibility(8);
        } else {
            this.faF.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fCh != null && this.fCh.getForum() != null) {
            String name = this.fCh.getForum().getName();
            if (com.baidu.tbadk.core.util.aq.getChineseAndEnglishLength(name) > 14) {
                name = com.baidu.tbadk.core.util.aq.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, float f) {
        if (this.fPp != null && this.fPq != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fPp.setVisibility(8);
                this.fPq.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPp.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fPq.getLayoutParams();
            if (this.fCf.bmC().getFirstCompletelyVisiblePosition() != 0) {
                this.fPp.setVisibility(8);
                this.fPq.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.zA.getHeight() + i);
            int dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.fPp.setVisibility(0);
                this.fPq.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.fPp.setVisibility(8);
                this.fPq.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fPp.setVisibility(0);
                this.fPq.setVisibility(8);
            }
        }
    }

    private void vA() {
        if (this.apj != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.apj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apj.setLayoutParams(layoutParams);
                this.apj.setVisibility(0);
                if (this.fPr != null && (this.fPr.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fPr.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.apj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkX() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.fPr != null) {
                this.fPr.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.apj != null) {
                this.apj.setAlpha(f);
            }
            if (this.fwU != null) {
                this.fwU.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.apj != null && this.fwU != null && this.apj.getLayoutParams() != null && this.fwU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.apj.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.apj.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fwU.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.fwU.setLayoutParams(layoutParams2);
        }
    }

    private void rC(int i) {
        String string;
        if (this.fHn == null) {
            this.fHn = new TextView(getContext());
            this.fHn.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fHn.setGravity(17);
        }
        if (this.fHn != null) {
            if (this.fPu) {
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
            this.fHn.setText(string);
        }
        am.setBackgroundResource(this.fHn, R.color.cp_link_tip_a);
        am.setViewTextColor(this.fHn, (int) R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.fMB == null) {
            this.fMB = new aq();
        }
        this.fMB.a(this.fHn, this.bGR, layoutParams, 2000);
    }

    private void bpG() {
        this.zA.setExpanded(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.forumId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.bGR, str, z);
        qQ(0);
    }
}
