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
    private AppBarLayout Qi;
    private FrameLayout boW;
    private CollapsingToolbarLayout duK;
    private aq duq;
    private NoNetworkView eYL;
    private long fDY;
    private TextView fIN;
    private ObservedChangeLinearLayout fQM;
    private View fQN;
    private View fQO;
    private ImageView fQP;
    private a fQQ;
    private b fQR;
    private int fQT;
    private View fxX;
    private View fyx;
    private View fyy;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean fQS = true;
    public final View.OnClickListener fyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fxX != null && view == FrsSportsRecommendFragment.this.fxX) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener dvg = new CustomMessageListener(2001446) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.f(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Qi.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fDF.setSelection(0);
                    FrsSportsRecommendFragment.this.aKN();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fQU = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fQT != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.eYL == null || j.kc()) ? 0 : FrsSportsRecommendFragment.this.eYL.getHeight();
                int g = ((l.g(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + g;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - g;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - g) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fQT - i < 0) {
                        abs = 0.0f;
                    }
                    if (g + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.ry(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.fyy != null) {
                                FrsSportsRecommendFragment.this.fyy.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.fyy != null && FrsSportsRecommendFragment.this.fyx != null) {
                            if (FrsSportsRecommendFragment.this.fyx.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.ry(0);
                            }
                            FrsSportsRecommendFragment.this.fyy.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bnU();
                        }
                        FrsSportsRecommendFragment.this.f(i, f);
                        FrsSportsRecommendFragment.this.fQT = i;
                        FrsSportsRecommendFragment.this.rY(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dvg);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fDF.ky(true);
        bsD();
        this.duK = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.fyx = this.mRootView.findViewById(R.id.statebar_view);
        this.fyy = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Qi = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Qi.addOnOffsetChangedListener(this.fQU);
        aKG();
        this.fQQ = new a(this, this.mRootView);
        this.fQQ.g(this.fDH);
        this.fQR = new b(this, this.mRootView);
        if (this.fDG != null) {
            this.fDG.dm(0L);
        }
        this.boW = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.fvl = currentTimeMillis + frsActivity.fvl;
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
                frsActivity.fvl = currentTimeMillis + frsActivity.fvl;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fQQ != null) {
            this.fQQ.onChangeSkinType();
        }
        if (this.fQR != null) {
            this.fQR.onChangeSkinType();
        }
        if (this.eYL != null) {
            this.eYL.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.k(this.fQN, R.drawable.top_shadow);
        am.k(this.fQO, R.drawable.top_shadow);
        am.l(this.fyx, R.color.cp_bg_line_d);
        am.l(this.fyy, R.color.cp_bg_line_d);
        SvgManager.ajv().a(this.fQP, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.mNavigationBar != null) {
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bnU();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        bsE();
        if (this.fDG != null) {
            this.fDG.dm(this.fDY);
        }
        super.eu(z);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.fQQ != null) {
                this.fQQ.w(dVar.fEa, dVar.fEb, dVar.fEc);
            }
            if (this.fQR != null && this.fDH != null && this.fDH.getForum() != null) {
                this.fQR.a(dVar.fEd, this.fDH.getForum().getId());
            }
            if (this.fDG != null && this.fDG.bpA()) {
                nl(dVar.fDZ);
            }
            if (!v.aa(dVar.threadList)) {
                Iterator<m> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof bh) {
                        bh bhVar = (bh) next;
                        if (bhVar.afj()) {
                            continue;
                        } else {
                            long e = com.baidu.adp.lib.g.b.e(bhVar.getId(), 0L);
                            if (e > 0) {
                                this.fDY = e;
                                break;
                            }
                        }
                    }
                }
            }
            this.fQS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fDF != null) {
            this.fDF.gf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bsD() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fQM == null) {
            this.fQM = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fQM.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.duK.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fQN == null) {
            this.fQN = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fQO == null) {
            this.fQO = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fxX == null) {
            this.fxX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fxX.setOnClickListener(this.fyk);
            this.mBackImageView = (ImageView) this.fxX.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fQP == null) {
            this.fQP = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.eYL == null) {
            this.eYL = new NoNetworkView(getContext());
            this.eYL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fQM.addView(this.eYL);
        }
        if (j.jQ()) {
            this.eYL.setVisibility(8);
        } else {
            this.eYL.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fDH != null && this.fDH.getForum() != null) {
            String name = this.fDH.getForum().getName();
            if (com.baidu.tbadk.core.util.aq.od(name) > 14) {
                name = com.baidu.tbadk.core.util.aq.k(name, 14, "...");
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, float f) {
        if (this.fQN != null && this.fQO != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fQN.setVisibility(8);
                this.fQO.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQN.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fQO.getLayoutParams();
            if (this.fDF.bpz().getFirstCompletelyVisiblePosition() != 0) {
                this.fQN.setVisibility(8);
                this.fQO.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Qi.getHeight() + i);
            int g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < g) {
                this.fQN.setVisibility(0);
                this.fQO.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(g - height2);
            } else if (height2 > g) {
                this.fQN.setVisibility(8);
                this.fQO.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fQN.setVisibility(0);
                this.fQO.setVisibility(8);
            }
        }
    }

    private void aKG() {
        if (this.fyx != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.fyx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fyx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fyx.setLayoutParams(layoutParams);
                this.fyx.setVisibility(0);
                if (this.fQP != null && (this.fQP.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fQP.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.fyx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnU() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.fQP != null) {
                this.fQP.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.fyx != null) {
                this.fyx.setAlpha(f);
            }
            if (this.fyy != null) {
                this.fyy.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fyx != null && this.fyy != null && this.fyx.getLayoutParams() != null && this.fyy.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fyx.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.fyx.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fyy.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.fyy.setLayoutParams(layoutParams2);
        }
    }

    private void nl(int i) {
        String string;
        if (this.fIN == null) {
            this.fIN = new TextView(getContext());
            this.fIN.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fIN.setGravity(17);
        }
        if (this.fIN != null) {
            if (this.fQS) {
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
            this.fIN.setText(string);
        }
        am.k(this.fIN, R.color.cp_link_tip_a);
        am.j(this.fIN, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.duq == null) {
            this.duq = new aq();
        }
        this.duq.a(this.fIN, this.boW, layoutParams, 2000);
    }

    private void bsE() {
        this.Qi.setExpanded(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.e(this.forumId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.boW, str, z);
        rY(0);
    }
}
