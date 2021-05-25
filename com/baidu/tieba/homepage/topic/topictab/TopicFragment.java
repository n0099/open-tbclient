package com.baidu.tieba.homepage.topic.topictab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.m0.r.f0.f;
import d.a.m0.z0.b0;
import d.a.n0.b1.j.b.a;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f16618e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f16619f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16620g = false;

    @Override // d.a.n0.r0.o0
    public void G() {
    }

    @Override // d.a.n0.r0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // d.a.n0.b1.j.b.a
    public void loadData() {
        if (j.z()) {
            this.f16619f.e();
            this.f16619f.l(false);
            this.f16618e.s();
        }
    }

    @Override // d.a.n0.b1.j.b.a
    public void netCallback(int i2, List<n> list) {
        this.f16619f.d();
        this.f16619f.p();
        if (i2 == 0 && !ListUtils.isEmpty(list)) {
            this.f16619f.e();
            this.f16619f.k();
            this.f16619f.setData(list);
            this.f16619f.n();
            return;
        }
        this.f16619f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f16619f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16618e.t(this);
        this.f16618e.setUniqueId(getUniqueId());
        this.f16619f.setPresenter(this);
        this.f16619f.setListPullRefreshListener(this);
        this.f16619f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16619f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16619f.getParent()).removeView(this.f16619f);
        }
        if (this.f16620g) {
            this.f16619f.f();
            this.f16620g = false;
        }
        return this.f16619f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16619f.c();
        this.f16618e.onDestroy();
        this.f16620g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f16619f.l(false);
        this.f16618e.s();
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f16618e.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16619f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.a.n0.r0.o0
    public void p() {
        this.f16619f.j();
    }

    @Override // d.a.n0.r0.o0
    public void s() {
    }

    @Override // d.a.n0.r0.o0
    public void u() {
    }

    @Override // d.a.n0.r0.o0
    public void y(b0 b0Var) {
    }
}
