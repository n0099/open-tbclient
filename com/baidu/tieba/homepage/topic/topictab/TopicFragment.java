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
import d.b.b.e.p.j;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.z0.b0;
import d.b.i0.p0.o0;
import d.b.i0.z0.j.b.a;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f17422e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f17423f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17424g = false;

    @Override // d.b.i0.p0.o0
    public void A() {
    }

    @Override // d.b.i0.p0.o0
    public void F() {
    }

    @Override // d.b.i0.p0.o0
    public void K(b0 b0Var) {
    }

    @Override // d.b.i0.p0.o0
    public void W() {
    }

    @Override // d.b.i0.p0.o0
    public void b0() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
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

    @Override // d.b.i0.z0.j.b.a
    public void loadData() {
        if (j.z()) {
            this.f17423f.e();
            this.f17423f.l(false);
            this.f17422e.s();
        }
    }

    @Override // d.b.i0.z0.j.b.a
    public void netCallback(int i, List<n> list) {
        this.f17423f.d();
        this.f17423f.p();
        if (i == 0 && !ListUtils.isEmpty(list)) {
            this.f17423f.e();
            this.f17423f.k();
            this.f17423f.setData(list);
            this.f17423f.n();
            return;
        }
        this.f17423f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.f17423f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17422e.t(this);
        this.f17422e.setUniqueId(getUniqueId());
        this.f17423f.setPresenter(this);
        this.f17423f.setListPullRefreshListener(this);
        this.f17423f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f17423f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f17423f.getParent()).removeView(this.f17423f);
        }
        if (this.f17424g) {
            this.f17423f.f();
            this.f17424g = false;
        }
        return this.f17423f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f17423f.c();
        this.f17422e.onDestroy();
        this.f17424g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f17423f.l(false);
        this.f17422e.s();
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f17422e.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f17423f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.b.i0.p0.o0
    public void w() {
        this.f17423f.j();
    }
}
