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
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.z0.b0;
import d.b.i0.a1.j.b.a;
import d.b.i0.q0.o0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f17099e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f17100f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17101g = false;

    @Override // d.b.i0.q0.o0
    public void A() {
    }

    @Override // d.b.i0.q0.o0
    public void F() {
    }

    @Override // d.b.i0.q0.o0
    public void K(b0 b0Var) {
    }

    @Override // d.b.i0.q0.o0
    public void W() {
    }

    @Override // d.b.i0.q0.o0
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

    @Override // d.b.i0.a1.j.b.a
    public void loadData() {
        if (j.z()) {
            this.f17100f.e();
            this.f17100f.l(false);
            this.f17099e.s();
        }
    }

    @Override // d.b.i0.a1.j.b.a
    public void netCallback(int i, List<n> list) {
        this.f17100f.d();
        this.f17100f.p();
        if (i == 0 && !ListUtils.isEmpty(list)) {
            this.f17100f.e();
            this.f17100f.k();
            this.f17100f.setData(list);
            this.f17100f.n();
            return;
        }
        this.f17100f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.f17100f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17099e.t(this);
        this.f17099e.setUniqueId(getUniqueId());
        this.f17100f.setPresenter(this);
        this.f17100f.setListPullRefreshListener(this);
        this.f17100f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f17100f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f17100f.getParent()).removeView(this.f17100f);
        }
        if (this.f17101g) {
            this.f17100f.f();
            this.f17101g = false;
        }
        return this.f17100f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f17100f.c();
        this.f17099e.onDestroy();
        this.f17101g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f17100f.l(false);
        this.f17099e.s();
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f17099e.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f17100f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.b.i0.q0.o0
    public void w() {
        this.f17100f.j();
    }
}
