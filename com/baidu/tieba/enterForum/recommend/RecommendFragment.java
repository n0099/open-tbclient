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
import d.a.j0.r.f0.f;
import d.a.k0.i0.h.c;
import d.a.k0.i0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f14599e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f14600f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14601g;

    /* renamed from: h  reason: collision with root package name */
    public c f14602h;

    @Override // d.a.k0.i0.k.a
    public void f(int i2, d.a.k0.i0.k.c.a aVar) {
        this.f14600f.h();
        this.f14600f.v();
        if (i2 == 0 && aVar != null) {
            this.f14600f.i();
            this.f14600f.r();
            this.f14600f.setData(aVar);
            return;
        }
        this.f14600f.t(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.a.k0.i0.k.a
    public void loadData() {
        if (j.z()) {
            this.f14600f.i();
            this.f14600f.s(false);
            this.f14599e.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f14599e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f14599e = recommendModel;
            recommendModel.w(this);
            this.f14599e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        RecommendView recommendView = this.f14600f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f14600f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f14600f = recommendView;
            recommendView.setTabViewController(this.f14602h);
            this.f14600f.setPresenter(this);
            this.f14600f.setListPullRefreshListener(this);
            this.f14600f.setPageUniqueId(getUniqueId());
        }
        if (this.f14600f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f14600f.getParent()).removeView(this.f14600f);
        }
        d.a.k0.c3.c.g().i(getUniqueId());
        return this.f14600f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f14602h = null;
        this.f14600f.n();
        this.f14599e.onDestroy();
        d.a.k0.c3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f14601g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f14600f.s(false);
        this.f14599e.v();
        this.f14601g = true;
    }

    @Override // d.a.j0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f14599e;
        if (recommendModel != null) {
            recommendModel.v();
        }
        d.a.k0.c3.c.g().j(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (this.f14601g) {
                return;
            }
            loadData();
            this.f14601g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.a.k0.c3.c.g().h(getUniqueId(), false);
    }
}
