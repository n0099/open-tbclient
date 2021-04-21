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
import d.b.c.e.p.j;
import d.b.i0.r.f0.f;
import d.b.j0.i0.h.c;
import d.b.j0.i0.k.a;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public RecommendModel f15156e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f15157f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15158g;

    /* renamed from: h  reason: collision with root package name */
    public c f15159h;

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.b.j0.i0.k.a
    public void loadData() {
        if (j.z()) {
            this.f15157f.i();
            this.f15157f.s(false);
            this.f15156e.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f15156e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f15156e = recommendModel;
            recommendModel.w(this);
            this.f15156e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        RecommendView recommendView = this.f15157f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f15157f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f15157f = recommendView;
            recommendView.setTabViewController(this.f15159h);
            this.f15157f.setPresenter(this);
            this.f15157f.setListPullRefreshListener(this);
            this.f15157f.setPageUniqueId(getUniqueId());
        }
        if (this.f15157f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f15157f.getParent()).removeView(this.f15157f);
        }
        d.b.j0.c3.c.g().i(getUniqueId());
        return this.f15157f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f15159h = null;
        this.f15157f.n();
        this.f15156e.onDestroy();
        d.b.j0.c3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f15158g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f15157f.s(false);
        this.f15156e.v();
        this.f15158g = true;
    }

    @Override // d.b.i0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f15156e;
        if (recommendModel != null) {
            recommendModel.v();
        }
        d.b.j0.c3.c.g().j(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (this.f15158g) {
                return;
            }
            loadData();
            this.f15158g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.b.j0.c3.c.g().h(getUniqueId(), false);
    }

    @Override // d.b.j0.i0.k.a
    public void v(int i, d.b.j0.i0.k.c.a aVar) {
        this.f15157f.h();
        this.f15157f.v();
        if (i == 0 && aVar != null) {
            this.f15157f.i();
            this.f15157f.r();
            this.f15157f.setData(aVar);
            return;
        }
        this.f15157f.t(false);
    }
}
