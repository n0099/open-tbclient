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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.k0.d;
import d.a.i0.z0.b0;
import d.a.j0.a1.i.c;
import d.a.j0.a1.i.g.a;
import d.a.j0.q0.o0;
import d.a.j0.x.t;
/* loaded from: classes4.dex */
public class HomePageTabFeedFragment extends BaseFragment implements c, o0 {

    /* renamed from: e  reason: collision with root package name */
    public String f17270e;

    /* renamed from: f  reason: collision with root package name */
    public String f17271f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageTabFeedNetModel f17272g;

    /* renamed from: h  reason: collision with root package name */
    public a f17273h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f17274i;

    public void E0(boolean z) {
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f17272g;
        if (homePageTabFeedNetModel != null) {
            if (this.f17273h != null && z) {
                if (homePageTabFeedNetModel.A()) {
                    this.f17273h.p();
                    this.f17273h.m(true);
                } else {
                    hideNetRefreshView(this.f17274i);
                    showLoadingView(this.f17274i);
                }
            }
            this.f17272g.E();
        }
    }

    public int F0() {
        return R.layout.tab_feed_fragment;
    }

    @Override // d.a.j0.q0.o0
    public void G() {
    }

    public final int G0() {
        return (l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2;
    }

    @Override // d.a.j0.q0.o0
    public void H() {
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public String H0() {
        return this.f17270e;
    }

    public final void I0() {
        if (isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f17270e);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.j0.a1.i.c
    public void M(d.a.j0.a1.i.e.c cVar) {
        hideLoadingView(this.f17274i);
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f17272g;
        if (homePageTabFeedNetModel != null && !homePageTabFeedNetModel.A()) {
            showNoDataRefreshView(this.f17274i, false);
            return;
        }
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.j(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q = this.f17270e;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.n(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.n(true);
        }
    }

    @Override // d.a.j0.a1.i.c
    public void i() {
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f17272g;
        if (homePageTabFeedNetModel != null) {
            homePageTabFeedNetModel.C();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.h(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null && TextUtils.isEmpty(this.f17270e) && TextUtils.isEmpty(this.f17271f)) {
            this.f17270e = bundle.getString("tab_name");
            this.f17271f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = this.f17274i;
        if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f17274i.getParent()).removeView(this.f17274i);
        }
        if (this.f17274i == null) {
            ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(F0(), (ViewGroup) null);
            this.f17274i = viewGroup3;
            this.f17273h = new a(this, this, viewGroup3, this.f17270e);
        }
        if (this.f17272g == null) {
            HomePageTabFeedNetModel homePageTabFeedNetModel = new HomePageTabFeedNetModel(getPageContext(), this);
            this.f17272g = homePageTabFeedNetModel;
            homePageTabFeedNetModel.G(this.f17271f, this.f17270e);
        }
        this.f17272g.F(getUniqueId());
        return this.f17274i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.b().e(false);
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f17272g;
        if (homePageTabFeedNetModel != null) {
            homePageTabFeedNetModel.destory();
        }
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            showLoadingView(this.f17274i);
            HomePageTabFeedNetModel homePageTabFeedNetModel = this.f17272g;
            if (homePageTabFeedNetModel != null) {
                homePageTabFeedNetModel.E();
                return;
            }
            return;
        }
        showNetRefreshView(this.f17274i, null, true);
    }

    @Override // d.a.i0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        E0(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.f17274i);
            showLoadingView(this.f17274i);
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
            a aVar = this.f17273h;
            if (aVar != null) {
                aVar.l();
            }
            I0();
            return;
        }
        a aVar2 = this.f17273h;
        if (aVar2 != null) {
            aVar2.k();
        }
    }

    @Override // d.a.j0.a1.i.c
    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.f17274i);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        HomePageTabFeedNetModel homePageTabFeedNetModel = this.f17272g;
        if (homePageTabFeedNetModel != null && !homePageTabFeedNetModel.A()) {
            showNetRefreshView(this.f17274i, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.m(false);
        }
    }

    @Override // d.a.j0.q0.o0
    public void p() {
        E0(true);
    }

    @Override // d.a.j0.q0.o0
    public void s() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.n(false);
        }
        super.showLoadingView(view, false, G0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.n(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        a aVar = this.f17273h;
        if (aVar != null) {
            aVar.n(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // d.a.j0.q0.o0
    public void u() {
    }

    @Override // d.a.j0.q0.o0
    public void y(b0 b0Var) {
    }
}
