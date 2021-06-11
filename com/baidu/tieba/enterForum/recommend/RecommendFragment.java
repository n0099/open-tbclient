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
import d.a.c.e.p.j;
import d.a.m0.r.f0.f;
import d.a.n0.j0.h.c;
import d.a.n0.j0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f14559e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f14560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14561g;

    /* renamed from: h  reason: collision with root package name */
    public c f14562h;

    @Override // d.a.n0.j0.k.a
    public void f(int i2, d.a.n0.j0.k.c.a aVar) {
        this.f14560f.h();
        this.f14560f.v();
        if (i2 == 0 && aVar != null) {
            this.f14560f.i();
            this.f14560f.r();
            this.f14560f.setData(aVar);
            return;
        }
        this.f14560f.t(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.a.n0.j0.k.a
    public void loadData() {
        if (j.z()) {
            this.f14560f.i();
            this.f14560f.s(false);
            this.f14559e.z();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f14559e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f14559e = recommendModel;
            recommendModel.A(this);
            this.f14559e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView = this.f14560f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f14560f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f14560f = recommendView;
            recommendView.setTabViewController(this.f14562h);
            this.f14560f.setPresenter(this);
            this.f14560f.setListPullRefreshListener(this);
            this.f14560f.setPageUniqueId(getUniqueId());
        }
        if (this.f14560f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f14560f.getParent()).removeView(this.f14560f);
        }
        d.a.n0.d3.c.g().i(getUniqueId());
        return this.f14560f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f14562h = null;
        this.f14560f.n();
        this.f14559e.onDestroy();
        d.a.n0.d3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f14561g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f14560f.s(false);
        this.f14559e.z();
        this.f14561g = true;
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f14559e;
        if (recommendModel != null) {
            recommendModel.z();
        }
        d.a.n0.d3.c.g().j(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (this.f14561g) {
                return;
            }
            loadData();
            this.f14561g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.a.n0.d3.c.g().h(getUniqueId(), false);
    }
}
