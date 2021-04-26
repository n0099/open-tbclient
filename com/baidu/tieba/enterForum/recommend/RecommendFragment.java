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
import d.a.i0.r.f0.f;
import d.a.j0.i0.h.c;
import d.a.j0.i0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f15284e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f15285f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15286g;

    /* renamed from: h  reason: collision with root package name */
    public c f15287h;

    @Override // d.a.j0.i0.k.a
    public void f(int i2, d.a.j0.i0.k.c.a aVar) {
        this.f15285f.h();
        this.f15285f.v();
        if (i2 == 0 && aVar != null) {
            this.f15285f.i();
            this.f15285f.r();
            this.f15285f.setData(aVar);
            return;
        }
        this.f15285f.t(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.a.j0.i0.k.a
    public void loadData() {
        if (j.z()) {
            this.f15285f.i();
            this.f15285f.s(false);
            this.f15284e.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f15284e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f15284e = recommendModel;
            recommendModel.w(this);
            this.f15284e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView = this.f15285f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f15285f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f15285f = recommendView;
            recommendView.setTabViewController(this.f15287h);
            this.f15285f.setPresenter(this);
            this.f15285f.setListPullRefreshListener(this);
            this.f15285f.setPageUniqueId(getUniqueId());
        }
        if (this.f15285f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f15285f.getParent()).removeView(this.f15285f);
        }
        d.a.j0.c3.c.g().i(getUniqueId());
        return this.f15285f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f15287h = null;
        this.f15285f.n();
        this.f15284e.onDestroy();
        d.a.j0.c3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f15286g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f15285f.s(false);
        this.f15284e.v();
        this.f15286g = true;
    }

    @Override // d.a.i0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f15284e;
        if (recommendModel != null) {
            recommendModel.v();
        }
        d.a.j0.c3.c.g().j(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (this.f15286g) {
                return;
            }
            loadData();
            this.f15286g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.a.j0.c3.c.g().h(getUniqueId(), false);
    }
}
