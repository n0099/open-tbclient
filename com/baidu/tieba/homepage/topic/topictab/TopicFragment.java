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
import d.a.c.k.e.n;
import d.a.n0.r.f0.f;
import d.a.n0.z0.b0;
import d.a.o0.b1.k.b.a;
import d.a.o0.r0.o0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f16776e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f16777f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16778g = false;

    @Override // d.a.o0.r0.o0
    public void H() {
    }

    @Override // d.a.o0.r0.o0
    public void I() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.k0.a
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

    @Override // d.a.o0.b1.k.b.a
    public void loadData() {
        if (j.z()) {
            this.f16777f.e();
            this.f16777f.l(false);
            this.f16776e.w();
        }
    }

    @Override // d.a.o0.b1.k.b.a
    public void netCallback(int i2, List<n> list) {
        this.f16777f.d();
        this.f16777f.p();
        if (i2 == 0 && !ListUtils.isEmpty(list)) {
            this.f16777f.e();
            this.f16777f.k();
            this.f16777f.setData(list);
            this.f16777f.n();
            return;
        }
        this.f16777f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f16777f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16776e.x(this);
        this.f16776e.setUniqueId(getUniqueId());
        this.f16777f.setPresenter(this);
        this.f16777f.setListPullRefreshListener(this);
        this.f16777f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16777f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16777f.getParent()).removeView(this.f16777f);
        }
        if (this.f16778g) {
            this.f16777f.f();
            this.f16778g = false;
        }
        return this.f16777f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16777f.c();
        this.f16776e.onDestroy();
        this.f16778g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f16777f.l(false);
        this.f16776e.w();
    }

    @Override // d.a.n0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f16776e.w();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16777f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.a.o0.r0.o0
    public void r() {
        this.f16777f.j();
    }

    @Override // d.a.o0.r0.o0
    public void t() {
    }

    @Override // d.a.o0.r0.o0
    public void v() {
    }

    @Override // d.a.o0.r0.o0
    public void z(b0 b0Var) {
    }
}
