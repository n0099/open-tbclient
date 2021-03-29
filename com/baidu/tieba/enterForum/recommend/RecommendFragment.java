package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
import d.b.b.e.p.j;
import d.b.h0.r.f0.f;
import d.b.i0.i0.h.c;
import d.b.i0.i0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f15485e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f15486f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15487g;

    /* renamed from: h  reason: collision with root package name */
    public c f15488h;

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.b.i0.i0.k.a
    public void loadData() {
        if (j.z()) {
            this.f15486f.i();
            this.f15486f.s(false);
            this.f15485e.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f15485e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f15485e = recommendModel;
            recommendModel.w(this);
            this.f15485e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        RecommendView recommendView = this.f15486f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f15486f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f15486f = recommendView;
            recommendView.setTabViewController(this.f15488h);
            this.f15486f.setPresenter(this);
            this.f15486f.setListPullRefreshListener(this);
            this.f15486f.setPageUniqueId(getUniqueId());
        }
        if (this.f15486f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f15486f.getParent()).removeView(this.f15486f);
        }
        d.b.i0.b3.c.g().i(getUniqueId());
        return this.f15486f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f15488h = null;
        this.f15486f.n();
        this.f15485e.onDestroy();
        d.b.i0.b3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f15487g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f15486f.s(false);
        this.f15485e.v();
        this.f15487g = true;
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f15485e;
        if (recommendModel != null) {
            recommendModel.v();
        }
        d.b.i0.b3.c.g().j(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (this.f15487g) {
                return;
            }
            loadData();
            this.f15487g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.b.i0.b3.c.g().h(getUniqueId(), false);
    }

    @Override // d.b.i0.i0.k.a
    public void v(int i, d.b.i0.i0.k.c.a aVar) {
        this.f15486f.h();
        this.f15486f.v();
        if (i == 0 && aVar != null) {
            this.f15486f.i();
            this.f15486f.r();
            this.f15486f.setData(aVar);
            return;
        }
        this.f15486f.t(false);
    }
}
