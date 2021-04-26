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
import d.a.i0.r.f0.f;
import d.a.i0.z0.b0;
import d.a.j0.a1.j.b.a;
import d.a.j0.q0.o0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f17393e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f17394f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17395g = false;

    @Override // d.a.j0.q0.o0
    public void G() {
    }

    @Override // d.a.j0.q0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
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

    @Override // d.a.j0.a1.j.b.a
    public void loadData() {
        if (j.z()) {
            this.f17394f.e();
            this.f17394f.l(false);
            this.f17393e.s();
        }
    }

    @Override // d.a.j0.a1.j.b.a
    public void netCallback(int i2, List<n> list) {
        this.f17394f.d();
        this.f17394f.p();
        if (i2 == 0 && !ListUtils.isEmpty(list)) {
            this.f17394f.e();
            this.f17394f.k();
            this.f17394f.setData(list);
            this.f17394f.n();
            return;
        }
        this.f17394f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f17394f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17393e.t(this);
        this.f17393e.setUniqueId(getUniqueId());
        this.f17394f.setPresenter(this);
        this.f17394f.setListPullRefreshListener(this);
        this.f17394f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f17394f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f17394f.getParent()).removeView(this.f17394f);
        }
        if (this.f17395g) {
            this.f17394f.f();
            this.f17395g = false;
        }
        return this.f17394f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f17394f.c();
        this.f17393e.onDestroy();
        this.f17395g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f17394f.l(false);
        this.f17393e.s();
    }

    @Override // d.a.i0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f17393e.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f17394f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.a.j0.q0.o0
    public void p() {
        this.f17394f.j();
    }

    @Override // d.a.j0.q0.o0
    public void s() {
    }

    @Override // d.a.j0.q0.o0
    public void u() {
    }

    @Override // d.a.j0.q0.o0
    public void y(b0 b0Var) {
    }
}
