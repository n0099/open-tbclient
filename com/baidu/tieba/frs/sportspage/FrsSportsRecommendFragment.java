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
    private AppBarLayout PR;
    private FrameLayout bnL;
    private CollapsingToolbarLayout dqI;
    private aq dqo;
    private NoNetworkView eRU;
    private TextView fBl;
    private ObservedChangeLinearLayout fJh;
    private View fJi;
    private View fJj;
    private ImageView fJk;
    private a fJl;
    private b fJm;
    private int fJo;
    private View fqM;
    private View frm;
    private View frn;
    private long fwA;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean fJn = true;
    public final View.OnClickListener fqZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fqM != null && view == FrsSportsRecommendFragment.this.fqM) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener dre = new CustomMessageListener(2001446) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.f(split[1], 0)) {
                    FrsSportsRecommendFragment.this.PR.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fwh.setSelection(0);
                    FrsSportsRecommendFragment.this.aID();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fJp = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fJo != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.eRU == null || j.jS()) ? 0 : FrsSportsRecommendFragment.this.eRU.getHeight();
                int g = ((l.g(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + g;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - g;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - g) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fJo - i < 0) {
                        abs = 0.0f;
                    }
                    if (g + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.rb(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.frn != null) {
                                FrsSportsRecommendFragment.this.frn.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.frn != null && FrsSportsRecommendFragment.this.frm != null) {
                            if (FrsSportsRecommendFragment.this.frm.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.rb(0);
                            }
                            FrsSportsRecommendFragment.this.frn.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bkU();
                        }
                        FrsSportsRecommendFragment.this.f(i, f);
                        FrsSportsRecommendFragment.this.fJo = i;
                        FrsSportsRecommendFragment.this.rB(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dre);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fwh.kl(true);
        bpx();
        this.dqI = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.frm = this.mRootView.findViewById(R.id.statebar_view);
        this.frn = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.PR = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.PR.addOnOffsetChangedListener(this.fJp);
        aIw();
        this.fJl = new a(this, this.mRootView);
        this.fJl.g(this.fwj);
        this.fJm = new b(this, this.mRootView);
        if (this.fwi != null) {
            this.fwi.dc(0L);
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
                frsActivity.fnZ = currentTimeMillis + frsActivity.fnZ;
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
                frsActivity.fnZ = currentTimeMillis + frsActivity.fnZ;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fJl != null) {
            this.fJl.onChangeSkinType();
        }
        if (this.fJm != null) {
            this.fJm.onChangeSkinType();
        }
        if (this.eRU != null) {
            this.eRU.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        al.k(this.fJi, R.drawable.top_shadow);
        al.k(this.fJj, R.drawable.top_shadow);
        al.l(this.frm, R.color.cp_bg_line_d);
        al.l(this.frn, R.color.cp_bg_line_d);
        al.c(this.fJk, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
        al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        if (this.mNavigationBar != null) {
            al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bkU();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        bpy();
        if (this.fwi != null) {
            this.fwi.dc(this.fwA);
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
            if (this.fJl != null) {
                this.fJl.v(dVar.fwC, dVar.fwD, dVar.fwE);
            }
            if (this.fJm != null && this.fwj != null && this.fwj.getForum() != null) {
                this.fJm.a(dVar.fwF, this.fwj.getForum().getId());
            }
            if (this.fwi != null && this.fwi.bmy()) {
                mZ(dVar.fwB);
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
                                this.fwA = c;
                                break;
                            }
                        }
                    }
                }
            }
            this.fJn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fwh != null) {
            this.fwh.fY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void bpx() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fJh == null) {
            this.fJh = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fJh.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.dqI.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fJi == null) {
            this.fJi = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fJj == null) {
            this.fJj = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fqM == null) {
            this.fqM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqM.setOnClickListener(this.fqZ);
            this.mBackImageView = (ImageView) this.fqM.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fJk == null) {
            this.fJk = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.eRU == null) {
            this.eRU = new NoNetworkView(getContext());
            this.eRU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fJh.addView(this.eRU);
        }
        if (j.jG()) {
            this.eRU.setVisibility(8);
        } else {
            this.eRU.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fwj != null && this.fwj.getForum() != null) {
            String name = this.fwj.getForum().getName();
            if (ap.nP(name) > 14) {
                name = ap.k(name, 14, "...");
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, float f) {
        if (this.fJi != null && this.fJj != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fJi.setVisibility(8);
                this.fJj.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJi.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fJj.getLayoutParams();
            if (this.fwh.bmx().getFirstCompletelyVisiblePosition() != 0) {
                this.fJi.setVisibility(8);
                this.fJj.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.PR.getHeight() + i);
            int g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < g) {
                this.fJi.setVisibility(0);
                this.fJj.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(g - height2);
            } else if (height2 > g) {
                this.fJi.setVisibility(8);
                this.fJj.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fJi.setVisibility(0);
                this.fJj.setVisibility(8);
            }
        }
    }

    private void aIw() {
        if (this.frm != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.frm.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.frm.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.frm.setLayoutParams(layoutParams);
                this.frm.setVisibility(0);
                if (this.fJk != null && (this.fJk.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fJk.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.frm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkU() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.fJk != null) {
                this.fJk.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.frm != null) {
                this.frm.setAlpha(f);
            }
            if (this.frn != null) {
                this.frn.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rb(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.frm != null && this.frn != null && this.frm.getLayoutParams() != null && this.frn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.frm.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.frm.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.frn.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.frn.setLayoutParams(layoutParams2);
        }
    }

    private void mZ(int i) {
        String string;
        if (this.fBl == null) {
            this.fBl = new TextView(getContext());
            this.fBl.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fBl.setGravity(17);
        }
        if (this.fBl != null) {
            if (this.fJn) {
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
            this.fBl.setText(string);
        }
        al.k(this.fBl, R.color.cp_link_tip_a);
        al.j(this.fBl, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.dqo == null) {
            this.dqo = new aq();
        }
        this.dqo.a(this.fBl, this.bnL, layoutParams, 2000);
    }

    private void bpy() {
        this.PR.setExpanded(true);
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
