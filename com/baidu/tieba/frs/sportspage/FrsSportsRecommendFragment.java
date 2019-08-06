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
    private aq dsF;
    private CollapsingToolbarLayout dsZ;
    private NoNetworkView eXf;
    private long fCl;
    private TextView fGY;
    private ObservedChangeLinearLayout fOW;
    private View fOX;
    private View fOY;
    private ImageView fOZ;
    private a fPa;
    private b fPb;
    private int fPd;
    private View fwK;
    private View fwL;
    private View fwk;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private boolean fPc = true;
    public final View.OnClickListener fwx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.fwk != null && view == FrsSportsRecommendFragment.this.fwk) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener dtv = new CustomMessageListener(2001446) { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == com.baidu.adp.lib.g.b.f(split[1], 0)) {
                    FrsSportsRecommendFragment.this.Qj.setExpanded(true, false);
                    FrsSportsRecommendFragment.this.fBS.setSelection(0);
                    FrsSportsRecommendFragment.this.aKj();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fPe = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.4
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 1.0f;
            if (FrsSportsRecommendFragment.this.fPd != i) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.mNavigationBar.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.eXf == null || j.kc()) ? 0 : FrsSportsRecommendFragment.this.eXf.getHeight();
                int g = ((l.g(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i2 = statusBarHeight + height + height2 + g;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - g;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = (Math.abs(i * 1.0f) - g) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.fPd - i < 0) {
                        abs = 0.0f;
                    }
                    if (g + i <= 0 || FrsSportsRecommendFragment.this.mNavigationBar == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView() == null || FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                        if (Float.compare(abs, 1.0f) == 0) {
                            FrsSportsRecommendFragment.this.rv(Math.abs(i2 - totalScrollRange2));
                            if (FrsSportsRecommendFragment.this.fwL != null) {
                                FrsSportsRecommendFragment.this.fwL.setVisibility(0);
                            }
                        } else if (FrsSportsRecommendFragment.this.fwL != null && FrsSportsRecommendFragment.this.fwK != null) {
                            if (FrsSportsRecommendFragment.this.fwK.getHeight() != UtilHelper.getStatusBarHeight()) {
                                FrsSportsRecommendFragment.this.rv(0);
                            }
                            FrsSportsRecommendFragment.this.fwL.setVisibility(8);
                        }
                        if (abs > 0.5f) {
                            UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        } else {
                            UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                            f = abs;
                        }
                        if (FrsSportsRecommendFragment.this.mNavigationBar != null) {
                            FrsSportsRecommendFragment.this.mNavigationBar.getBarBgView().setAlpha(f);
                            FrsSportsRecommendFragment.this.bnj();
                        }
                        FrsSportsRecommendFragment.this.f(i, f);
                        FrsSportsRecommendFragment.this.fPd = i;
                        FrsSportsRecommendFragment.this.rV(i);
                    }
                }
            }
        }
    };

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dtv);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fBS.kv(true);
        brQ();
        this.dsZ = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
        this.fwK = this.mRootView.findViewById(R.id.statebar_view);
        this.fwL = this.mRootView.findViewById(R.id.statebar_view_holder);
        this.Qj = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
        this.Qj.addOnOffsetChangedListener(this.fPe);
        aKc();
        this.fPa = new a(this, this.mRootView);
        this.fPa.g(this.fBU);
        this.fPb = new b(this, this.mRootView);
        if (this.fBT != null) {
            this.fBT.dj(0L);
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
                frsActivity.fty = currentTimeMillis + frsActivity.fty;
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
                frsActivity.fty = currentTimeMillis + frsActivity.fty;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fPa != null) {
            this.fPa.onChangeSkinType();
        }
        if (this.fPb != null) {
            this.fPb.onChangeSkinType();
        }
        if (this.eXf != null) {
            this.eXf.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        am.k(this.fOX, R.drawable.top_shadow);
        am.k(this.fOY, R.drawable.top_shadow);
        am.l(this.fwK, R.color.cp_bg_line_d);
        am.l(this.fwL, R.color.cp_bg_line_d);
        am.c(this.fOZ, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
        am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        if (this.mNavigationBar != null) {
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
        }
        bnj();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        brR();
        if (this.fBT != null) {
            this.fBT.dj(this.fCl);
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
            if (this.fPa != null) {
                this.fPa.v(dVar.fCn, dVar.fCo, dVar.fCp);
            }
            if (this.fPb != null && this.fBU != null && this.fBU.getForum() != null) {
                this.fPb.a(dVar.fCq, this.fBU.getForum().getId());
            }
            if (this.fBT != null && this.fBT.boP()) {
                nh(dVar.fCm);
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
                        if (bhVar.aff()) {
                            continue;
                        } else {
                            long c = com.baidu.adp.lib.g.b.c(bhVar.getId(), 0L);
                            if (c > 0) {
                                this.fCl = c;
                                break;
                            }
                        }
                    }
                }
            }
            this.fPc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i) {
        if (this.fBS != null) {
            this.fBS.gc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    private void brQ() {
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.fOW == null) {
            this.fOW = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fOW.setOnSizeChangeListener(new e() { // from class: com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        FrsSportsRecommendFragment.this.dsZ.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.fOX == null) {
            this.fOX = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.fOY == null) {
            this.fOY = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.fwk == null) {
            this.fwk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fwk.setOnClickListener(this.fwx);
            this.mBackImageView = (ImageView) this.fwk.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fOZ == null) {
            this.fOZ = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.eXf == null) {
            this.eXf = new NoNetworkView(getContext());
            this.eXf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.fOW.addView(this.eXf);
        }
        if (j.jQ()) {
            this.eXf.setVisibility(8);
        } else {
            this.eXf.setVisibility(0);
        }
        if (this.mNavigationBar != null && this.fBU != null && this.fBU.getForum() != null) {
            String name = this.fBU.getForum().getName();
            if (com.baidu.tbadk.core.util.aq.ob(name) > 14) {
                name = com.baidu.tbadk.core.util.aq.k(name, 14, "...");
            }
            this.mNavigationBar.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, float f) {
        if (this.fOX != null && this.fOY != null && this.mNavigationBar != null) {
            int height = this.mNavigationBar.getHeight();
            if (!(f == 1.0f)) {
                this.fOX.setVisibility(8);
                this.fOY.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fOX.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fOY.getLayoutParams();
            if (this.fBS.boO().getFirstCompletelyVisiblePosition() != 0) {
                this.fOX.setVisibility(8);
                this.fOY.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.Qj.getHeight() + i);
            int g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < g) {
                this.fOX.setVisibility(0);
                this.fOY.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(g - height2);
            } else if (height2 > g) {
                this.fOX.setVisibility(8);
                this.fOY.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.fOX.setVisibility(0);
                this.fOY.setVisibility(8);
            }
        }
    }

    private void aKc() {
        if (this.fwK != null) {
            if (UtilHelper.canUseStyleImmersiveSticky() && this.fwK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fwK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fwK.setLayoutParams(layoutParams);
                this.fwK.setVisibility(0);
                if (this.fOZ != null && (this.fOZ.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                    ((CollapsingToolbarLayout.LayoutParams) this.fOZ.getLayoutParams()).topMargin = layoutParams.height;
                    return;
                }
                return;
            }
            this.fwK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnj() {
        if (this.mNavigationBar != null) {
            float f = 0.0f;
            if (this.mNavigationBar.getBarBgView() != null) {
                f = this.mNavigationBar.getBarBgView().getAlpha();
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(f);
            }
            if (this.mBackImageView != null && this.fOZ != null) {
                this.fOZ.setAlpha(1.0f - f);
                this.mBackImageView.setAlpha(f);
            }
            if (this.fwK != null) {
                this.fwK.setAlpha(f);
            }
            if (this.fwL != null) {
                this.fwL.setAlpha(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv(int i) {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fwK != null && this.fwL != null && this.fwK.getLayoutParams() != null && this.fwL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fwK.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            this.fwK.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fwL.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.fwL.setLayoutParams(layoutParams2);
        }
    }

    private void nh(int i) {
        String string;
        if (this.fGY == null) {
            this.fGY = new TextView(getContext());
            this.fGY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.fGY.setGravity(17);
        }
        if (this.fGY != null) {
            if (this.fPc) {
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
            this.fGY.setText(string);
        }
        am.k(this.fGY, R.color.cp_link_tip_a);
        am.j(this.fGY, R.color.cp_cont_i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.dsF == null) {
            this.dsF = new aq();
        }
        this.dsF.a(this.fGY, this.boy, layoutParams, 2000);
    }

    private void brR() {
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
        rV(0);
    }
}
