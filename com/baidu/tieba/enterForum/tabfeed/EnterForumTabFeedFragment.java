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
import d.a.m0.k0.d;
import d.a.n0.j0.l.b;
import d.a.n0.j0.l.e.a;
import d.a.n0.z.t;
/* loaded from: classes4.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f14605e;

    /* renamed from: f  reason: collision with root package name */
    public String f14606f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumTabFeedNetModel f14607g;

    /* renamed from: h  reason: collision with root package name */
    public a f14608h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f14609i;
    public int j;

    public void G0(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14607g;
        if (enterForumTabFeedNetModel != null) {
            if (this.f14608h != null && z) {
                if (enterForumTabFeedNetModel.b()) {
                    this.f14608h.t();
                    this.f14608h.q(true);
                } else {
                    hideNetRefreshView(this.f14609i);
                    showLoadingView(this.f14609i);
                }
            }
            this.f14607g.refresh();
        }
    }

    public int H0() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    public String I0() {
        return this.f14605e;
    }

    public boolean J0() {
        a aVar = this.f14608h;
        if (aVar != null) {
            return aVar.k();
        }
        return true;
    }

    @Override // d.a.n0.j0.l.b
    public void X(int i2, int i3) {
        if (!this.f14607g.b()) {
            showNoDataRefreshView(this.f14609i, false);
            return;
        }
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.o(i2, i3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a068";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q = this.f14605e;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // d.a.n0.j0.l.b
    public void j() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14607g;
        if (enterForumTabFeedNetModel != null) {
            enterForumTabFeedNetModel.loadMore();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f14607g == null) {
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.f14607g = enterForumTabFeedNetModel;
            enterForumTabFeedNetModel.U(this.f14606f, this.f14605e);
            this.f14607g.S();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        a aVar = this.f14608h;
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
            this.f14605e = bundle.getString("tab_name");
            this.f14606f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(H0(), (ViewGroup) null);
        this.f14609i = viewGroup2;
        this.f14608h = new a(this, this, viewGroup2, this.f14605e);
        this.j = (l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2;
        return this.f14609i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.b().e(false);
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14607g;
        if (enterForumTabFeedNetModel != null) {
            enterForumTabFeedNetModel.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            showLoadingView(this.f14609i);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f14607g;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.refresh();
                return;
            }
            return;
        }
        showNetRefreshView(this.f14609i, null, true);
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        G0(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            hideNetRefreshView(this.f14609i);
            showLoadingView(this.f14609i);
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
            a aVar = this.f14608h;
            if (aVar != null) {
                aVar.p();
                return;
            }
            return;
        }
        a aVar2 = this.f14608h;
        if (aVar2 != null) {
            aVar2.n();
        }
    }

    @Override // d.a.n0.j0.l.b
    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.f14609i);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.f14607g.b()) {
            showNetRefreshView(this.f14609i, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.q(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showLoadingView(view, false, this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // d.a.n0.j0.l.b
    public void v0(d.a.n0.j0.l.d.b bVar) {
        hideLoadingView(this.f14609i);
        if (!this.f14607g.b()) {
            showNoDataRefreshView(this.f14609i, false);
            return;
        }
        a aVar = this.f14608h;
        if (aVar != null) {
            aVar.m(bVar);
        }
    }
}
