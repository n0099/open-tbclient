package com.baidu.tieba.enterForum.tabfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.model.EnterForumTabFeedNetModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.k0.d;
import d.a.o0.j0.l.b;
import d.a.o0.j0.l.e.a;
import d.a.o0.z.t;
/* loaded from: classes4.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f14687e;

    /* renamed from: f  reason: collision with root package name */
    public String f14688f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumTabFeedNetModel f14689g;

    /* renamed from: h  reason: collision with root package name */
    public a f14690h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f14691i;
    public int j;

    public void G0(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14689g;
        if (enterForumTabFeedNetModel != null) {
            if (this.f14690h != null && z) {
                if (enterForumTabFeedNetModel.b()) {
                    this.f14690h.t();
                    this.f14690h.q(true);
                } else {
                    hideNetRefreshView(this.f14691i);
                    showLoadingView(this.f14691i);
                }
            }
            this.f14689g.refresh();
        }
    }

    public int H0() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    public String I0() {
        return this.f14687e;
    }

    public boolean J0() {
        a aVar = this.f14690h;
        if (aVar != null) {
            return aVar.k();
        }
        return true;
    }

    @Override // d.a.o0.j0.l.b
    public void X(int i2, int i3) {
        if (!this.f14689g.b()) {
            showNoDataRefreshView(this.f14691i, false);
            return;
        }
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.o(i2, i3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a068";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q = this.f14687e;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // d.a.o0.j0.l.b
    public void j() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14689g;
        if (enterForumTabFeedNetModel != null) {
            enterForumTabFeedNetModel.loadMore();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f14689g == null) {
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.f14689g = enterForumTabFeedNetModel;
            enterForumTabFeedNetModel.U(this.f14688f, this.f14687e);
            this.f14689g.S();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.l(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.f14687e = bundle.getString("tab_name");
            this.f14688f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(H0(), (ViewGroup) null);
        this.f14691i = viewGroup2;
        this.f14690h = new a(this, this, viewGroup2, this.f14687e);
        this.j = (l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2;
        return this.f14691i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.b().e(false);
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14689g;
        if (enterForumTabFeedNetModel != null) {
            enterForumTabFeedNetModel.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            showLoadingView(this.f14691i);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14689g;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.f14691i, null, true);
    }

    @Override // d.a.n0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        G0(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.f14691i);
            showLoadingView(this.f14691i);
            G0(false);
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
            a aVar = this.f14690h;
            if (aVar != null) {
                aVar.p();
                return;
            }
            return;
        }
        a aVar2 = this.f14690h;
        if (aVar2 != null) {
            aVar2.n();
        }
    }

    @Override // d.a.o0.j0.l.b
    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.f14691i);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.f14689g.b()) {
            showNetRefreshView(this.f14691i, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.q(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showLoadingView(view, false, this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // d.a.o0.j0.l.b
    public void v0(d.a.o0.j0.l.d.b bVar) {
        hideLoadingView(this.f14691i);
        if (!this.f14689g.b()) {
            showNoDataRefreshView(this.f14691i, false);
            return;
        }
        a aVar = this.f14690h;
        if (aVar != null) {
            aVar.m(bVar);
        }
    }
}
