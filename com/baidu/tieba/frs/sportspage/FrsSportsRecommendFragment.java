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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private AppBarLayout PQ;
    private FrameLayout bnL;
    private CollapsingToolbarLayout dqJ;
    private aq dqp;
    private NoNetworkView eRV;
    private TextView fBm;
    private ObservedChangeLinearLayout fJk;
    private View fJl;
    private View fJm;
    private ImageView fJn;
    private a fJo;
    private b fJp;
    private int fJr;
    private View fqN;
    private View frn;
    private View fro;
    private long fwB;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean fJq = true;
    public final View.OnClickListener fra = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fqN != null && view == FrsSportsRecommendFragment.this.fqN) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener drf = new CustomMessageListener(2001446) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.f(split[1], 0)) {
                    FrsSportsRecommendFragment.this.PQ.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fwi.setSelection(0);
                    FrsSportsRecommendFragment.this.aIG();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fJs = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fJr != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.eRV == null || j.jS()) ? 0 : FrsSportsRecommendFragment.this.eRV.getHeight();
                int g = ((l.g(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + g;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - g;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - g) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fJr - i < 0) {
                        abs = 0.0f;
                    }
                    if (g + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.rb(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.fro != null) {
                                FrsSportsRecommendFragment.this.fro.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.fro != null && FrsSportsRecommendFragment.this.frn != null) {
                            if (FrsSportsRecommendFragment.this.frn.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.rb(0);
                            }
                            FrsSportsRecommendFragment.this.fro.setVisibility(8);
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
                        FrsSportsRecommendFragment.this.f(i, f);
                        FrsSportsRecommendFragment.this.fJr = i;
                        FrsSportsRecommendFragment.this.rB(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.drf);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fwi.kl(true);
        bpC();
        this.dqJ = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.frn = this.mRootView.findViewById(R.id.statebar_view);
        this.fro = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.PQ = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.PQ.addOnOffsetChangedListener(this.fJs);
        aIz();
        this.fJo = new a(this, this.mRootView);
        this.fJo.g(this.fwk);
        this.fJp = new b(this, this.mRootView);
        if (this.fwj != null) {
            this.fwj.dc(0L);
        }
        this.bnL = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                FrsActivity frsActivity = (FrsActivity) getFragmentActivity();
                frsActivity.foa = currentTimeMillis + frsActivity.foa;
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
                frsActivity.foa = currentTimeMillis + frsActivity.foa;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fJo != null) {
            this.fJo.onChangeSkinType();
        }
        if (this.fJp != null) {
            this.fJp.onChangeSkinType();
        }
        if (this.eRV != null) {
            this.eRV.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        al.k(this.fJl, R.drawable.top_shadow);
        al.k(this.fJm, R.drawable.top_shadow);
        al.l(this.frn, R.color.cp_bg_line_d);
        al.l(this.fro, R.color.cp_bg_line_d);
        al.c(this.fJn, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
        al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        if (this.mNavigationBar != null) {
            al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bkX();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        bpD();
        if (this.fwj != null) {
            this.fwj.dc(this.fwB);
        }
        super.en(z);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void a(d dVar) {
        super.a(dVar);
        if (dVar != null) {
            if (this.fJo != null) {
                this.fJo.v(dVar.fwD, dVar.fwE, dVar.fwF);
            }
            if (this.fJp != null && this.fwk != null && this.fwk.getForum() != null) {
                this.fJp.a(dVar.fwG, this.fwk.getForum().getId());
            }
            if (this.fwj != null && this.fwj.bmB()) {
                mZ(dVar.fwC);
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
                        if (bgVar.aec()) {
                            continue;
                        } else {
                            long c = com.baidu.adp.lib.g.b.c(bgVar.getId(), 0L);
                            if (c > 0) {
                                this.fwB = c;
                                break;
                            }
                        }
                    }
                }
            }
            this.fJq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fwi != null) {
            this.fwi.fY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bpC() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fJk == null) {
            this.fJk = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fJk.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.dqJ.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fJl == null) {
            this.fJl = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fJm == null) {
            this.fJm = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fqN == null) {
            this.fqN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqN.setOnClickListener(this.fra);
            this.mBackImageView = (ImageView) this.fqN.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fJn == null) {
            this.fJn = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.eRV == null) {
            this.eRV = new NoNetworkView(getContext());
            this.eRV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fJk.addView(this.eRV);
        }
        if (j.jG()) {
            this.eRV.setVisibility(8);
        } else {
            this.eRV.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fwk != null && this.fwk.getForum() != null) {
            String name = this.fwk.getForum().getName();
            if (ap.nO(name) > 14) {
                name = ap.k(name, 14, "...");
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, float f) {
        if (this.fJl != null && this.fJm != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fJl.setVisibility(8);
                this.fJm.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJl.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fJm.getLayoutParams();
            if (this.fwi.bmA().getFirstCompletelyVisiblePosition() != 0) {
                this.fJl.setVisibility(8);
                this.fJm.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.PQ.getHeight() + i);
            int g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < g) {
                this.fJl.setVisibility(0);
                this.fJm.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(g - height2);
            } else if (height2 > g) {
                this.fJl.setVisibility(8);
                this.fJm.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fJl.setVisibility(0);
                this.fJm.setVisibility(8);
            }
        }
    }

    private void aIz() {
        if (this.frn != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.frn.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.frn.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.frn.setLayoutParams(layoutParams);
                this.frn.setVisibility(0);
                if (this.fJn != null && (this.fJn.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fJn.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.frn.setVisibility(8);
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
            if (this.mBackImageView != null && this.fJn != null) {
                this.fJn.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.frn != null) {
                this.frn.setAlpha(f);
            }
            if (this.fro != null) {
                this.fro.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rb(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.frn != null && this.fro != null && this.frn.getLayoutParams() != null && this.fro.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.frn.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.frn.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fro.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.fro.setLayoutParams(layoutParams2);
        }
    }

    private void mZ(int i) {
        String string;
        if (this.fBm == null) {
            this.fBm = new TextView(getContext());
            this.fBm.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fBm.setGravity(17);
        }
        if (this.fBm != null) {
            if (this.fJq) {
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
            this.fBm.setText(string);
        }
        al.k(this.fBm, R.color.cp_link_tip_a);
        al.j(this.fBm, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.dqp == null) {
            this.dqp = new aq();
        }
        this.dqp.a(this.fBm, this.bnL, layoutParams, 2000);
    }

    private void bpD() {
        this.PQ.setExpanded(true);
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
        super.showNetRefreshView(this.bnL, str, z);
        rB(0);
    }
}
