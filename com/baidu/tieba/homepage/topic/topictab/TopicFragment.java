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
import d.a.j0.r.f0.f;
import d.a.j0.z0.b0;
import d.a.k0.a1.j.b.a;
import d.a.k0.q0.o0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class TopicFragment extends BaseFragment implements o0, f.g, a {

    /* renamed from: e  reason: collision with root package name */
    public TopicModel f16708e;

    /* renamed from: f  reason: collision with root package name */
    public TopicListView f16709f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16710g = false;

    @Override // d.a.k0.q0.o0
    public void G() {
    }

    @Override // d.a.k0.q0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
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

    @Override // d.a.k0.a1.j.b.a
    public void loadData() {
        if (j.z()) {
            this.f16709f.e();
            this.f16709f.l(false);
            this.f16708e.s();
        }
    }

    @Override // d.a.k0.a1.j.b.a
    public void netCallback(int i2, List<n> list) {
        this.f16709f.d();
        this.f16709f.p();
        if (i2 == 0 && !ListUtils.isEmpty(list)) {
            this.f16709f.e();
            this.f16709f.k();
            this.f16709f.setData(list);
            this.f16709f.n();
            return;
        }
        this.f16709f.m(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f16709f.i();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16708e.t(this);
        this.f16708e.setUniqueId(getUniqueId());
        this.f16709f.setPresenter(this);
        this.f16709f.setListPullRefreshListener(this);
        this.f16709f.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16709f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16709f.getParent()).removeView(this.f16709f);
        }
        if (this.f16710g) {
            this.f16709f.f();
            this.f16710g = false;
        }
        return this.f16709f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16709f.c();
        this.f16708e.onDestroy();
        this.f16710g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.f16709f.l(false);
        this.f16708e.s();
    }

    @Override // d.a.j0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f16708e.s();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16709f.setViewForeground();
            TiebaStatic.log(new StatisticItem("c13349"));
        }
    }

    @Override // d.a.k0.q0.o0
    public void p() {
        this.f16709f.j();
    }

    @Override // d.a.k0.q0.o0
    public void s() {
    }

    @Override // d.a.k0.q0.o0
    public void u() {
    }

    @Override // d.a.k0.q0.o0
    public void y(b0 b0Var) {
    }
}
