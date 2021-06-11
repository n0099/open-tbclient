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
import d.a.m0.r.f0.f;
import d.a.m0.z0.b0;
import d.a.n0.b1.k.b.a;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f16694e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f16695f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16696g = false;

    @Override // d.a.n0.r0.o0
    public void H() {
    }

    @Override // d.a.n0.r0.o0
    public void I() {
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

    @Override // d.a.n0.b1.k.b.a
    public void loadData() {
        if (j.z()) {
            this.f16695f.e();
            this.f16695f.l(false);
            this.f16694e.w();
        }
    }

    @Override // d.a.n0.b1.k.b.a
    public void netCallback(int i2, List<n> list) {
        this.f16695f.d();
        this.f16695f.p();
        if (i2 == 0 && !ListUtils.isEmpty(list)) {
            this.f16695f.e();
            this.f16695f.k();
            this.f16695f.setData(list);
            this.f16695f.n();
            return;
        }
        this.f16695f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f16695f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16694e.x(this);
        this.f16694e.setUniqueId(getUniqueId());
        this.f16695f.setPresenter(this);
        this.f16695f.setListPullRefreshListener(this);
        this.f16695f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16695f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16695f.getParent()).removeView(this.f16695f);
        }
        if (this.f16696g) {
            this.f16695f.f();
            this.f16696g = false;
        }
        return this.f16695f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16695f.c();
        this.f16694e.onDestroy();
        this.f16696g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f16695f.l(false);
        this.f16694e.w();
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f16694e.w();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16695f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.a.n0.r0.o0
    public void r() {
        this.f16695f.j();
    }

    @Override // d.a.n0.r0.o0
    public void t() {
    }

    @Override // d.a.n0.r0.o0
    public void v() {
    }

    @Override // d.a.n0.r0.o0
    public void z(b0 b0Var) {
    }
}
