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
import com.baidu.tbadk.core.data.bg;
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
    private AppBarLayout Qj;
    private FrameLayout boy;
    private CollapsingToolbarLayout dsS;
    private aq dsy;
    private NoNetworkView eWV;
    private long fBx;
    private TextView fGk;
    private ObservedChangeLinearLayout fOi;
    private View fOj;
    private View fOk;
    private ImageView fOl;
    private a fOm;
    private b fOn;
    private int fOp;
    private View fvL;
    private View fwl;
    private View fwm;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean fOo = true;
    public final View.OnClickListener fvY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fvL != null && view == FrsSportsRecommendFragment.this.fvL) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener dto = new CustomMessageListener(2001446) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.f(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Qj.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fBe.setSelection(0);
                    FrsSportsRecommendFragment.this.aKh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fOq = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fOp != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.eWV == null || j.kc()) ? 0 : FrsSportsRecommendFragment.this.eWV.getHeight();
                int g = ((l.g(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + g;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - g;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - g) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fOp - i < 0) {
                        abs = 0.0f;
                    }
                    if (g + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.rt(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.fwm != null) {
                                FrsSportsRecommendFragment.this.fwm.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.fwm != null && FrsSportsRecommendFragment.this.fwl != null) {
                            if (FrsSportsRecommendFragment.this.fwl.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.rt(0);
                            }
                            FrsSportsRecommendFragment.this.fwm.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bmZ();
                        }
                        FrsSportsRecommendFragment.this.f(i, f);
                        FrsSportsRecommendFragment.this.fOp = i;
                        FrsSportsRecommendFragment.this.rT(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dto);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fBe.kv(true);
        brD();
        this.dsS = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.fwl = this.mRootView.findViewById(R.id.statebar_view);
        this.fwm = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Qj = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Qj.addOnOffsetChangedListener(this.fOq);
        aKa();
        this.fOm = new a(this, this.mRootView);
        this.fOm.g(this.fBg);
        this.fOn = new b(this, this.mRootView);
        if (this.fBf != null) {
            this.fBf.dj(0L);
        }
        this.boy = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.fsZ = currentTimeMillis + frsActivity.fsZ;
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
                frsActivity.fsZ = currentTimeMillis + frsActivity.fsZ;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fOm != null) {
            this.fOm.onChangeSkinType();
        }
        if (this.fOn != null) {
            this.fOn.onChangeSkinType();
        }
        if (this.eWV != null) {
            this.eWV.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.k(this.fOj, R.drawable.top_shadow);
        am.k(this.fOk, R.drawable.top_shadow);
        am.l(this.fwl, R.color.cp_bg_line_d);
        am.l(this.fwm, R.color.cp_bg_line_d);
        am.c(this.fOl, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
        am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        if (this.mNavigationBar != null) {
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bmZ();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        brE();
        if (this.fBf != null) {
            this.fBf.dj(this.fBx);
        }
        super.er(z);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.fOm != null) {
                this.fOm.v(dVar.fBz, dVar.fBA, dVar.fBB);
            }
            if (this.fOn != null && this.fBg != null && this.fBg.getForum() != null) {
                this.fOn.a(dVar.fBC, this.fBg.getForum().getId());
            }
            if (this.fBf != null && this.fBf.boC()) {
                ng(dVar.fBy);
            }
            if (!v.aa(dVar.threadList)) {
                Iterator<m> it = dVar.threadList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next instanceof bg) {
                        bg bgVar = (bg) next;
                        if (bgVar.afe()) {
                            continue;
                        } else {
                            long c = com.baidu.adp.lib.g.b.c(bgVar.getId(), 0L);
                            if (c > 0) {
                                this.fBx = c;
                                break;
                            }
                        }
                    }
                }
            }
            this.fOo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fBe != null) {
            this.fBe.gc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void brD() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fOi == null) {
            this.fOi = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fOi.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.dsS.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fOj == null) {
            this.fOj = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fOk == null) {
            this.fOk = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fvL == null) {
            this.fvL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fvL.setOnClickListener(this.fvY);
            this.mBackImageView = (ImageView) this.fvL.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fOl == null) {
            this.fOl = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.eWV == null) {
            this.eWV = new NoNetworkView(getContext());
            this.eWV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fOi.addView(this.eWV);
        }
        if (j.jQ()) {
            this.eWV.setVisibility(8);
        } else {
            this.eWV.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fBg != null && this.fBg.getForum() != null) {
            String name = this.fBg.getForum().getName();
            if (com.baidu.tbadk.core.util.aq.ob(name) > 14) {
                name = com.baidu.tbadk.core.util.aq.k(name, 14, "...");
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, float f) {
        if (this.fOj != null && this.fOk != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fOj.setVisibility(8);
                this.fOk.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fOj.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fOk.getLayoutParams();
            if (this.fBe.boB().getFirstCompletelyVisiblePosition() != 0) {
                this.fOj.setVisibility(8);
                this.fOk.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Qj.getHeight() + i);
            int g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < g) {
                this.fOj.setVisibility(0);
                this.fOk.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(g - height2);
            } else if (height2 > g) {
                this.fOj.setVisibility(8);
                this.fOk.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fOj.setVisibility(0);
                this.fOk.setVisibility(8);
            }
        }
    }

    private void aKa() {
        if (this.fwl != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.fwl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fwl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fwl.setLayoutParams(layoutParams);
                this.fwl.setVisibility(0);
                if (this.fOl != null && (this.fOl.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fOl.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.fwl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmZ() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.fOl != null) {
                this.fOl.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.fwl != null) {
                this.fwl.setAlpha(f);
            }
            if (this.fwm != null) {
                this.fwm.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fwl != null && this.fwm != null && this.fwl.getLayoutParams() != null && this.fwm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fwl.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.fwl.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fwm.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.fwm.setLayoutParams(layoutParams2);
        }
    }

    private void ng(int i) {
        String string;
        if (this.fGk == null) {
            this.fGk = new TextView(getContext());
            this.fGk.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fGk.setGravity(17);
        }
        if (this.fGk != null) {
            if (this.fOo) {
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
            this.fGk.setText(string);
        }
        am.k(this.fGk, R.color.cp_link_tip_a);
        am.j(this.fGk, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.dsy == null) {
            this.dsy = new aq();
        }
        this.dsy.a(this.fGk, this.boy, layoutParams, 2000);
    }

    private void brE() {
        this.Qj.setExpanded(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.forumId, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.boy, str, z);
        rT(0);
    }
}
