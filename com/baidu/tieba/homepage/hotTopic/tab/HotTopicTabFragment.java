package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.material.tabs.TabLayout;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.c.j.e.t;
import d.b.c.j.e.v;
import d.b.h0.m.f;
import d.b.h0.z0.b0;
import d.b.i0.q0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements o0, d.b.i0.a1.e.a.b {

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f16833e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f16834f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f16835g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f16836h = new a();
    public f<Object> i = new b();

    /* loaded from: classes4.dex */
    public class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab == null || !(tab.getTag() instanceof FrsTabItemData)) {
                return;
            }
            FrsTabItemData frsTabItemData = (FrsTabItemData) tab.getTag();
            if (HotTopicTabFragment.this.f16835g != null && HotTopicTabFragment.this.f16835g.tabId != frsTabItemData.tabId) {
                String str = frsTabItemData.tabCode;
                HotTopicTabFragment.this.f16833e.C(str);
                if (HotTopicTabFragment.this.f16833e.LoadData()) {
                    HotTopicTabFragment.this.f16834f.z();
                    HotTopicTabFragment.this.f16834f.h();
                    HotTopicTabFragment.this.f16834f.i();
                    HotTopicTabFragment.this.P0();
                } else {
                    HotTopicTabFragment.this.f16834f.z();
                    HotTopicTabFragment.this.f16834f.h();
                    List<n> y = HotTopicTabFragment.this.f16833e.y(str);
                    if (!ListUtils.isEmpty(y)) {
                        HotTopicTabFragment.this.f16834f.setListData(y);
                    } else {
                        HotTopicTabFragment.this.M0();
                    }
                }
            }
            HotTopicTabFragment.this.f16835g = frsTabItemData;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.f16834f.z();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<Object> {
        public b() {
        }

        @Override // d.b.h0.m.f
        public void a(View view, Object obj, int i, long j) {
            if (obj == null) {
                return;
            }
            d.b.i0.a1.e.a.a.a(view, obj, i + 1, HotTopicTabFragment.this.K0());
        }

        @Override // d.b.h0.m.f
        public void c(View view, Object obj, int i, long j) {
            if (obj == null) {
                return;
            }
            d.b.i0.a1.e.a.a.b(view, obj, HotTopicTabFragment.this.K0());
        }
    }

    public HotTopicTabFragment() {
    }

    @Override // d.b.i0.q0.o0
    public void A() {
    }

    @Override // d.b.i0.q0.o0
    public void F() {
    }

    @Override // d.b.i0.q0.o0
    public void K(b0 b0Var) {
    }

    public final String K0() {
        HotTopicTabModel hotTopicTabModel = this.f16833e;
        return hotTopicTabModel != null ? hotTopicTabModel.z() : "";
    }

    public void L0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView = this.f16834f;
        if (hotTopicTabView != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void M0() {
        if (this.f16834f.q()) {
            this.f16834f.i();
            O0();
            return;
        }
        this.f16834f.w(false);
    }

    public final void N0() {
        if (this.f16834f.q()) {
            this.f16834f.h();
            P0();
            return;
        }
        this.f16834f.v(false);
    }

    public void O0() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f42945f = R.drawable.new_pic_emotion_05;
        vVar.f42944e = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.f16834f.k();
        this.f16834f.setListData(arrayList);
    }

    public void P0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f16834f.k();
        this.f16834f.setListData(arrayList);
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
        return "a076";
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

    @Override // d.b.i0.a1.e.a.b
    public void loadData() {
        boolean LoadData = this.f16833e.LoadData();
        HotTopicTabModel hotTopicTabModel = this.f16833e;
        List<n> y = hotTopicTabModel.y(hotTopicTabModel.z());
        if (LoadData) {
            if (!ListUtils.isEmpty(y) || this.f16834f.q()) {
                return;
            }
            this.f16834f.z();
            this.f16834f.i();
            N0();
            return;
        }
        this.f16834f.z();
        this.f16834f.h();
        if (!ListUtils.isEmpty(y)) {
            this.f16834f.setListData(y);
        } else if (j.A()) {
        } else {
            M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.f16834f.r();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16833e.B(this);
        this.f16833e.setUniqueId(getUniqueId());
        this.f16834f.setPresenter(this);
        this.f16834f.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16834f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16834f.getParent()).removeView(this.f16834f);
        }
        return this.f16834f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16834f.g();
        this.f16833e.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16834f.setViewForeground();
        }
    }

    @Override // d.b.i0.a1.e.a.b
    public void s(int i, d.b.i0.a1.e.a.f.a aVar) {
        this.f16834f.h();
        this.f16834f.i();
        this.f16834f.z();
        if (aVar != null && i == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
            this.f16834f.setData(aVar);
            this.f16834f.x();
        } else if (ListUtils.isEmpty(this.f16833e.x())) {
            M0();
        } else {
            this.f16834f.setListData(this.f16833e.x());
        }
    }

    @Override // d.b.i0.q0.o0
    public void w() {
        this.f16834f.t();
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f16833e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f16834f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f16836h);
        this.f16834f.setOnItemCoverListener(this.i);
    }
}
