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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.k0.d;
import d.b.i0.i0.l.b;
import d.b.i0.i0.l.e.a;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class EnterForumTabFeedFragment extends BaseFragment implements b {

    /* renamed from: e  reason: collision with root package name */
    public String f15525e;

    /* renamed from: f  reason: collision with root package name */
    public String f15526f;

    /* renamed from: g  reason: collision with root package name */
    public EnterForumTabFeedNetModel f15527g;

    /* renamed from: h  reason: collision with root package name */
    public a f15528h;
    public ViewGroup i;
    public int j;

    public void E0(boolean z) {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f15527g;
        if (enterForumTabFeedNetModel != null) {
            if (this.f15528h != null && z) {
                if (enterForumTabFeedNetModel.L()) {
                    this.f15528h.t();
                    this.f15528h.q(true);
                } else {
                    hideNetRefreshView(this.i);
                    showLoadingView(this.i);
                }
            }
            this.f15527g.Q();
        }
    }

    public int F0() {
        return R.layout.enter_forum_tab_feed_fragment;
    }

    public String G0() {
        return this.f15525e;
    }

    public boolean H0() {
        a aVar = this.f15528h;
        if (aVar != null) {
            return aVar.k();
        }
        return true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a068";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q = this.f15525e;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // d.b.i0.i0.l.b
    public void j() {
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f15527g;
        if (enterForumTabFeedNetModel != null) {
            enterForumTabFeedNetModel.O();
        }
    }

    @Override // d.b.i0.i0.l.b
    public void l0(d.b.i0.i0.l.d.b bVar) {
        hideLoadingView(this.i);
        if (!this.f15527g.L()) {
            showNoDataRefreshView(this.i, false);
            return;
        }
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.m(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f15527g == null) {
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = new EnterForumTabFeedNetModel(getPageContext(), this, getUniqueId());
            this.f15527g = enterForumTabFeedNetModel;
            enterForumTabFeedNetModel.T(this.f15526f, this.f15525e);
            this.f15527g.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.l(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.f15525e = bundle.getString("tab_name");
            this.f15526f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(F0(), (ViewGroup) null);
        this.i = viewGroup2;
        this.f15528h = new a(this, this, viewGroup2, this.f15525e);
        this.j = (l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2;
        return this.i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.b().e(false);
        EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f15527g;
        if (enterForumTabFeedNetModel != null) {
            enterForumTabFeedNetModel.destory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.z()) {
            showLoadingView(this.i);
            EnterForumTabFeedNetModel enterForumTabFeedNetModel = this.f15527g;
            if (enterForumTabFeedNetModel != null) {
                enterForumTabFeedNetModel.Q();
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
            a aVar = this.f15528h;
            if (aVar != null) {
                aVar.p();
                return;
            }
            return;
        }
        a aVar2 = this.f15528h;
        if (aVar2 != null) {
            aVar2.n();
        }
    }

    @Override // d.b.i0.i0.l.b
    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.i);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.f15527g.L()) {
            showNetRefreshView(this.i, errorData != null ? getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.q(false);
        }
    }

    @Override // d.b.i0.i0.l.b
    public void p(int i, int i2) {
        if (!this.f15527g.L()) {
            showNoDataRefreshView(this.i, false);
            return;
        }
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.o(i, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showLoadingView(view, false, this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        a aVar = this.f15528h;
        if (aVar != null) {
            aVar.r(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }
}
