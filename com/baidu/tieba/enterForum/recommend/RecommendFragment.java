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
    public RecommendModel f15484e;

    /* renamed from: f  reason: collision with root package name */
    public RecommendView f15485f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15486g;

    /* renamed from: h  reason: collision with root package name */
    public c f15487h;

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a025";
    }

    @Override // d.b.i0.i0.k.a
    public void loadData() {
        if (j.z()) {
            this.f15485f.i();
            this.f15485f.s(false);
            this.f15484e.v();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f15484e == null) {
            RecommendModel recommendModel = new RecommendModel(getPageContext());
            this.f15484e = recommendModel;
            recommendModel.w(this);
            this.f15484e.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        RecommendView recommendView = this.f15485f;
        if (recommendView != null) {
            recommendView.m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f15485f == null) {
            RecommendView recommendView = new RecommendView(getPageContext());
            this.f15485f = recommendView;
            recommendView.setTabViewController(this.f15487h);
            this.f15485f.setPresenter(this);
            this.f15485f.setListPullRefreshListener(this);
            this.f15485f.setPageUniqueId(getUniqueId());
        }
        if (this.f15485f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f15485f.getParent()).removeView(this.f15485f);
        }
        d.b.i0.b3.c.g().i(getUniqueId());
        return this.f15485f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f15487h = null;
        this.f15485f.n();
        this.f15484e.onDestroy();
        d.b.i0.b3.c.g().k(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (this.f15486g || TbadkCoreApplication.getInst().checkInterrupt()) {
            return;
        }
        this.f15485f.s(false);
        this.f15484e.v();
        this.f15486g = true;
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        RecommendModel recommendModel = this.f15484e;
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
            if (this.f15486g) {
                return;
            }
            loadData();
            this.f15486g = true;
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        d.b.i0.b3.c.g().h(getUniqueId(), false);
    }

    @Override // d.b.i0.i0.k.a
    public void v(int i, d.b.i0.i0.k.c.a aVar) {
        this.f15485f.h();
        this.f15485f.v();
        if (i == 0 && aVar != null) {
            this.f15485f.i();
            this.f15485f.r();
            this.f15485f.setData(aVar);
            return;
        }
        this.f15485f.t(false);
    }
}
