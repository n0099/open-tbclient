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
import d.a.n0.r.f0.f;
import d.a.o0.j0.h.c;
import d.a.o0.j0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f14641e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f14642f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14643g;

    /* renamed from: h  reason: collision with root package name */
    public c f14644h;

    @Override // d.a.o0.j0.k.a
    public void f(int i2, d.a.o0.j0.k.c.a aVar) {
        this.f14642f.h();
        this.f14642f.v();
        if (i2 == 0 && aVar != null) {
            this.f14642f.i();
            this.f14642f.r();
            this.f14642f.setData(aVar);
            return;
        }
        this.f14642f.t(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.a.o0.j0.k.a
    public void loadData() {
        if (j.z()) {
            this.f14642f.i();
            this.f14642f.s(false);
            this.f14641e.z();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f14641e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f14641e = recommendModel;
            recommendModel.A(this);
            this.f14641e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView = this.f14642f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f14642f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f14642f = recommendView;
            recommendView.setTabViewController(this.f14644h);
            this.f14642f.setPresenter(this);
            this.f14642f.setListPullRefreshListener(this);
            this.f14642f.setPageUniqueId(getUniqueId());
        }
        if (this.f14642f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f14642f.getParent()).removeView(this.f14642f);
        }
        d.a.o0.d3.c.g().i(getUniqueId());
        return this.f14642f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f14644h = null;
        this.f14642f.n();
        this.f14641e.onDestroy();
        d.a.o0.d3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f14643g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f14642f.s(false);
        this.f14641e.z();
        this.f14643g = true;
    }

    @Override // d.a.n0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f14641e;
        if (recommendModel != null) {
            recommendModel.z();
        }
        d.a.o0.d3.c.g().j(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (this.f14643g) {
                return;
            }
            loadData();
            this.f14643g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.a.o0.d3.c.g().h(getUniqueId(), false);
    }
}
