package com.baidu.tieba.homepage.tabfeed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.model.HomePageTabFeedNetModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.k0.d;
import d.b.h0.z0.b0;
import d.b.i0.a1.i.c;
import d.b.i0.a1.i.g.a;
import d.b.i0.q0.o0;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class HomePageTabFeedFragment extends BaseFragment implements c, o0 {

    /* renamed from: e  reason: collision with root package name */
    public String f16987e;

    /* renamed from: f  reason: collision with root package name */
    public String f16988f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageTabFeedNetModel f16989g;

    /* renamed from: h  reason: collision with root package name */
    public a f16990h;
    public ViewGroup i;

    @Override // d.b.i0.q0.o0
    public void A() {
    }

    public void E0(boolean z) {
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f16989g;
        if (homePageTabFeedNetModel != null) {
            if (this.f16990h != null && z) {
                if (homePageTabFeedNetModel.A()) {
                    this.f16990h.p();
                    this.f16990h.m(true);
                } else {
                    hideNetRefreshView(this.i);
                    showLoadingView(this.i);
                }
            }
            this.f16989g.E();
        }
    }

    @Override // d.b.i0.q0.o0
    public void F() {
    }

    public int F0() {
        return R.layout.tab_feed_fragment;
    }

    public final int G0() {
        return (l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2;
    }

    public String H0() {
        return this.f16987e;
    }

    public final void I0() {
        if (isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f16987e);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.b.i0.q0.o0
    public void K(b0 b0Var) {
    }

    @Override // d.b.i0.q0.o0
    public void W() {
    }

    @Override // d.b.i0.q0.o0
    public void b0() {
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q = this.f16987e;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.n(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.n(true);
        }
    }

    @Override // d.b.i0.a1.i.c
    public void j() {
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f16989g;
        if (homePageTabFeedNetModel != null) {
            homePageTabFeedNetModel.C();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.h(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null && TextUtils.isEmpty(this.f16987e) && TextUtils.isEmpty(this.f16988f)) {
            this.f16987e = bundle.getString("tab_name");
            this.f16988f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        if (this.i == null) {
            ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(F0(), (ViewGroup) null);
            this.i = viewGroup3;
            this.f16990h = new a(this, this, viewGroup3, this.f16987e);
        }
        if (this.f16989g == null) {
            HomePageTabFeedNetModel homePageTabFeedNetModel = new HomePageTabFeedNetModel(getPageContext(), this);
            this.f16989g = homePageTabFeedNetModel;
            homePageTabFeedNetModel.G(this.f16988f, this.f16987e);
        }
        this.f16989g.F(getUniqueId());
        return this.i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.b().e(false);
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f16989g;
        if (homePageTabFeedNetModel != null) {
            homePageTabFeedNetModel.destory();
        }
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            showLoadingView(this.i);
            HomePageTabFeedNetModel homePageTabFeedNetModel = this.f16989g;
            if (homePageTabFeedNetModel != null) {
                homePageTabFeedNetModel.E();
                return;
            }
            return;
        }
        showNetRefreshView(this.i, null, true);
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        E0(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.i);
            showLoadingView(this.i);
            E0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        t.b().e(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            a aVar = this.f16990h;
            if (aVar != null) {
                aVar.l();
            }
            I0();
            return;
        }
        a aVar2 = this.f16990h;
        if (aVar2 != null) {
            aVar2.k();
        }
    }

    @Override // d.b.i0.a1.i.c
    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.i);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f16989g;
        if (homePageTabFeedNetModel != null && !homePageTabFeedNetModel.A()) {
            showNetRefreshView(this.i, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.m(false);
        }
    }

    @Override // d.b.i0.a1.i.c
    public void q0(d.b.i0.a1.i.e.c cVar) {
        hideLoadingView(this.i);
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f16989g;
        if (homePageTabFeedNetModel != null && !homePageTabFeedNetModel.A()) {
            showNoDataRefreshView(this.i, false);
            return;
        }
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.j(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.n(false);
        }
        super.showLoadingView(view, false, G0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.n(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        a aVar = this.f16990h;
        if (aVar != null) {
            aVar.n(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // d.b.i0.q0.o0
    public void w() {
        E0(true);
    }
}
