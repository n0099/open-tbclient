package com.baidu.tieba.frs.sportspage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i0.b1.j.e;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.q0.d1;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    public View G;
    public View H;
    public ObservedChangeLinearLayout I;
    public NavigationBar J;
    public View K;
    public View L;
    public View M;
    public ImageView N;
    public ImageView O;
    public NoNetworkView P;
    public d.a.j0.q0.i2.a Q;
    public d.a.j0.q0.i2.b R;
    public CollapsingToolbarLayout S;
    public AppBarLayout T;
    public FrameLayout U;
    public d1 V;
    public TextView W;
    public long X;
    public int Z;
    public boolean Y = true;
    public final View.OnClickListener a0 = new b();
    public CustomMessageListener b0 = new c(2001446);
    public AppBarLayout.OnOffsetChangedListener c0 = new d();

    /* loaded from: classes4.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.i0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            if (i3 != i5) {
                FrsSportsRecommendFragment.this.S.setMinimumHeight(i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsSportsRecommendFragment.this.M == null || view != FrsSportsRecommendFragment.this.M) {
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsSportsRecommendFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == d.a.c.e.m.b.d(split[1], 0)) {
                FrsSportsRecommendFragment.this.T.setExpanded(true, false);
                FrsSportsRecommendFragment.this.f16049e.y(0);
                FrsSportsRecommendFragment.this.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (FrsSportsRecommendFragment.this.Z != i2) {
                int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                int height = FrsSportsRecommendFragment.this.J.getHeight();
                int height2 = (FrsSportsRecommendFragment.this.P == null || j.z()) ? 0 : FrsSportsRecommendFragment.this.P.getHeight();
                int g2 = ((l.g(FrsSportsRecommendFragment.this.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
                int i3 = statusBarHeight + height + height2 + g2;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i3) - g2;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
                if (totalScrollRange <= 0) {
                    return;
                }
                float f2 = 1.0f;
                float abs = (Math.abs(i2 * 1.0f) - g2) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (Float.compare(abs, 0.05f) <= 0 && FrsSportsRecommendFragment.this.Z - i2 < 0) {
                    abs = 0.0f;
                }
                if (g2 + i2 <= 0 || FrsSportsRecommendFragment.this.J == null || FrsSportsRecommendFragment.this.J.getBarBgView() == null || FrsSportsRecommendFragment.this.J.getBarBgView().getAlpha() != 0.0f) {
                    if (Float.compare(abs, 1.0f) == 0) {
                        FrsSportsRecommendFragment.this.t1(Math.abs(i3 - totalScrollRange2));
                        if (FrsSportsRecommendFragment.this.G != null) {
                            FrsSportsRecommendFragment.this.G.setVisibility(0);
                        }
                    } else if (FrsSportsRecommendFragment.this.G != null && FrsSportsRecommendFragment.this.H != null) {
                        if (FrsSportsRecommendFragment.this.H.getHeight() != UtilHelper.getStatusBarHeight()) {
                            FrsSportsRecommendFragment.this.t1(0);
                        }
                        FrsSportsRecommendFragment.this.G.setVisibility(8);
                    }
                    if (abs > 0.5f) {
                        UtilHelper.changeStatusBarIconAndTextColor(false, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                    } else {
                        UtilHelper.changeStatusBarIconAndTextColor(true, FrsSportsRecommendFragment.this.getPageContext().getPageActivity());
                        f2 = abs;
                    }
                    if (FrsSportsRecommendFragment.this.J != null) {
                        FrsSportsRecommendFragment.this.J.getBarBgView().setAlpha(f2);
                        FrsSportsRecommendFragment.this.u1();
                    }
                    FrsSportsRecommendFragment.this.v1(i2, f2);
                    FrsSportsRecommendFragment.this.Z = i2;
                    FrsSportsRecommendFragment.this.L0(i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int P0() {
        return R.layout.frs_sports_recommend_fragment;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void V0(d.a.j0.q0.l1.d dVar) {
        FrsViewData frsViewData;
        super.V0(dVar);
        if (dVar == null) {
            return;
        }
        d.a.j0.q0.i2.a aVar = this.Q;
        if (aVar != null) {
            aVar.k(dVar.f58002i, dVar.j, dVar.k);
        }
        if (this.R != null && (frsViewData = this.f16052h) != null && frsViewData.getForum() != null) {
            this.R.e(dVar.l, this.f16052h.getForum().getId());
        }
        d.a.j0.q0.l1.c cVar = this.f16050f;
        if (cVar != null && cVar.j()) {
            s1(dVar.f58001h);
        }
        if (!ListUtils.isEmpty(dVar.f58000g)) {
            Iterator<n> it = dVar.f58000g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                a2 a2Var = null;
                if (next instanceof a2) {
                    a2Var = (a2) next;
                } else if (next instanceof z1) {
                    a2Var = ((z1) next).w;
                }
                if (a2Var != null && !a2Var.v2()) {
                    long f2 = d.a.c.e.m.b.f(a2Var.o0(), 0L);
                    if (f2 > 0) {
                        this.X = f2;
                        break;
                    }
                }
            }
        }
        this.Y = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a063";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.i0.k0.d getPageStayDurationItem() {
        d.a.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q(d.a.c.e.m.b.f(this.f16053i, 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, d.a.j0.q0.s0
    public void m() {
        p1();
        d.a.j0.q0.l1.c cVar = this.f16050f;
        if (cVar != null) {
            cVar.q(this.X);
        }
        super.m();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.q0.i2.a aVar = this.Q;
        if (aVar != null) {
            aVar.h();
        }
        d.a.j0.q0.i2.b bVar = this.R;
        if (bVar != null) {
            bVar.d();
        }
        NoNetworkView noNetworkView = this.P;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        SkinManager.setBackgroundResource(this.K, R.drawable.top_shadow);
        SkinManager.setBackgroundResource(this.L, R.drawable.top_shadow);
        SkinManager.setBackgroundColor(this.H, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.G, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        NavigationBar navigationBar = this.J;
        if (navigationBar != null) {
            SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207);
            this.J.onChangeSkinType(getPageContext(), i2);
            if (this.J.getBackground() != null && this.J.getBackground().mutate() != null) {
                this.J.getBackground().mutate().setAlpha(0);
            }
        }
        u1();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.b0);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f16049e.v(true);
        r1();
        this.S = (CollapsingToolbarLayout) this.f16051g.findViewById(R.id.frs_collapse_layout);
        this.H = this.f16051g.findViewById(R.id.statebar_view);
        this.G = this.f16051g.findViewById(R.id.statebar_view_holder);
        AppBarLayout appBarLayout = (AppBarLayout) this.f16051g.findViewById(R.id.frs_app_bar_layout);
        this.T = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.c0);
        q1();
        d.a.j0.q0.i2.a aVar = new d.a.j0.q0.i2.a(this, this.f16051g);
        this.Q = aVar;
        aVar.j(this.f16052h);
        this.R = new d.a.j0.q0.i2.b(this, this.f16051g);
        d.a.j0.q0.l1.c cVar = this.f16050f;
        if (cVar != null) {
            cVar.q(0L);
        }
        this.U = (FrameLayout) this.f16051g.findViewById(R.id.frs_sports_recommend_list_container);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f16051g;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                ((FrsActivity) getFragmentActivity()).mSpecialTabPageStayTime += currentTimeMillis;
            }
        }
        super.onPause();
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        if (!isPrimary() && this.lastResumeTime != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                ((FrsActivity) getFragmentActivity()).mSpecialTabPageStayTime += currentTimeMillis;
            }
        }
        super.onPrimary();
    }

    public final void p1() {
        this.T.setExpanded(true);
    }

    public final void q1() {
        if (this.H == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky() && this.H.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.H.setLayoutParams(layoutParams);
            this.H.setVisibility(0);
            ImageView imageView = this.O;
            if (imageView == null || !(imageView.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                return;
            }
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) this.O.getLayoutParams())).topMargin = layoutParams.height;
            return;
        }
        this.H.setVisibility(8);
    }

    public final void r1() {
        FrsViewData frsViewData;
        if (this.J == null) {
            NavigationBar navigationBar = (NavigationBar) this.f16051g.findViewById(R.id.view_navigation_bar);
            this.J = navigationBar;
            navigationBar.getBarBgView().setAlpha(0.0f);
        }
        if (this.I == null) {
            ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.f16051g.findViewById(R.id.navigation_bar_wrapperLayout);
            this.I = observedChangeLinearLayout;
            observedChangeLinearLayout.setOnSizeChangeListener(new a());
        }
        if (this.K == null) {
            this.K = this.f16051g.findViewById(R.id.navbar_bottom_divider_shadow);
        }
        if (this.L == null) {
            this.L = this.f16051g.findViewById(R.id.feed_top_divider_shadow);
        }
        if (this.M == null) {
            View addSystemImageButton = this.J.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.M = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.a0);
            this.N = (ImageView) this.M.findViewById(R.id.widget_navi_back_button);
        }
        if (this.O == null) {
            this.O = (ImageView) this.f16051g.findViewById(R.id.navbar_fake_back_icon);
        }
        if (this.P == null) {
            this.P = new NoNetworkView(getContext());
            this.P.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.I.addView(this.P);
        }
        if (j.A()) {
            this.P.setVisibility(8);
        } else {
            this.P.setVisibility(0);
        }
        if (this.J == null || (frsViewData = this.f16052h) == null || frsViewData.getForum() == null) {
            return;
        }
        String name = this.f16052h.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 14) {
            name = StringHelper.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
        }
        this.J.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
    }

    public final void s1(int i2) {
        String string;
        if (this.W == null) {
            TextView textView = new TextView(getContext());
            this.W = textView;
            textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.W.setGravity(17);
        }
        if (this.W != null) {
            if (this.Y) {
                if (i2 <= 0) {
                    return;
                }
                string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_first_time_tip);
            } else if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_get_new_thread), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_no_new_thread);
            }
            this.W.setText(string);
        }
        SkinManager.setBackgroundResource(this.W, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.W, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.V == null) {
            this.V = new d1();
        }
        this.V.h(this.W, this.U, layoutParams, 2000);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i2) {
        d.a.j0.q0.l1.b bVar = this.f16049e;
        if (bVar != null) {
            bVar.w(true);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(this.U, str, z);
        L0(0);
    }

    public final void t1(int i2) {
        View view;
        if (!UtilHelper.canUseStyleImmersiveSticky() || (view = this.H) == null || this.G == null || view.getLayoutParams() == null || this.G.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
        int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
        layoutParams.height = statusBarHeight;
        if (statusBarHeight < 0) {
            layoutParams.height = 0;
        }
        this.H.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.G.getLayoutParams();
        layoutParams2.height = i2;
        if (i2 > UtilHelper.getStatusBarHeight()) {
            layoutParams2.height = UtilHelper.getStatusBarHeight();
        }
        this.G.setLayoutParams(layoutParams2);
    }

    public final void u1() {
        ImageView imageView;
        NavigationBar navigationBar = this.J;
        if (navigationBar == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.J.getBarBgView().getAlpha() : 0.0f;
        TextView textView = this.J.mCenterText;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (this.N != null && (imageView = this.O) != null) {
            imageView.setAlpha(1.0f - alpha);
            this.N.setAlpha(alpha);
        }
        View view = this.H;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.G;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
    }

    public final void v1(int i2, float f2) {
        NavigationBar navigationBar;
        if (this.K == null || this.L == null || (navigationBar = this.J) == null) {
            return;
        }
        int height = navigationBar.getHeight();
        if (!(f2 == 1.0f)) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.L.getLayoutParams();
        if (this.f16049e.j().getFirstCompletelyVisiblePosition() != 0) {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
                return;
            }
            return;
        }
        int height2 = height - (this.T.getHeight() + i2);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        if (height2 > 0 && height2 < g2) {
            this.K.setVisibility(0);
            this.L.setVisibility(0);
            layoutParams.bottomMargin = -height2;
            layoutParams2.topMargin = -(g2 - height2);
        } else if (height2 > g2) {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
            }
        } else {
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
            }
            this.K.setVisibility(0);
            this.L.setVisibility(8);
        }
    }
}
