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
import d.b.i0.m.f;
import d.b.i0.z0.b0;
import d.b.j0.q0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements o0, d.b.j0.a1.e.a.b {

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f16841e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f16842f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f16843g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f16844h = new a();
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
            if (HotTopicTabFragment.this.f16843g != null && HotTopicTabFragment.this.f16843g.tabId != frsTabItemData.tabId) {
                String str = frsTabItemData.tabCode;
                HotTopicTabFragment.this.f16841e.C(str);
                if (HotTopicTabFragment.this.f16841e.LoadData()) {
                    HotTopicTabFragment.this.f16842f.z();
                    HotTopicTabFragment.this.f16842f.h();
                    HotTopicTabFragment.this.f16842f.i();
                    HotTopicTabFragment.this.P0();
                } else {
                    HotTopicTabFragment.this.f16842f.z();
                    HotTopicTabFragment.this.f16842f.h();
                    List<n> y = HotTopicTabFragment.this.f16841e.y(str);
                    if (!ListUtils.isEmpty(y)) {
                        HotTopicTabFragment.this.f16842f.setListData(y);
                    } else {
                        HotTopicTabFragment.this.M0();
                    }
                }
            }
            HotTopicTabFragment.this.f16843g = frsTabItemData;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.f16842f.z();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<Object> {
        public b() {
        }

        @Override // d.b.i0.m.f
        public void a(View view, Object obj, int i, long j) {
            if (obj == null) {
                return;
            }
            d.b.j0.a1.e.a.a.a(view, obj, i + 1, HotTopicTabFragment.this.K0());
        }

        @Override // d.b.i0.m.f
        public void c(View view, Object obj, int i, long j) {
            if (obj == null) {
                return;
            }
            d.b.j0.a1.e.a.a.b(view, obj, HotTopicTabFragment.this.K0());
        }
    }

    public HotTopicTabFragment() {
    }

    @Override // d.b.j0.q0.o0
    public void A() {
    }

    @Override // d.b.j0.q0.o0
    public void F() {
    }

    @Override // d.b.j0.q0.o0
    public void K(b0 b0Var) {
    }

    public final String K0() {
        HotTopicTabModel hotTopicTabModel = this.f16841e;
        return hotTopicTabModel != null ? hotTopicTabModel.z() : "";
    }

    public void L0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView = this.f16842f;
        if (hotTopicTabView != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void M0() {
        if (this.f16842f.q()) {
            this.f16842f.i();
            O0();
            return;
        }
        this.f16842f.w(false);
    }

    public final void N0() {
        if (this.f16842f.q()) {
            this.f16842f.h();
            P0();
            return;
        }
        this.f16842f.v(false);
    }

    public void O0() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f43185f = R.drawable.new_pic_emotion_05;
        vVar.f43184e = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.f16842f.k();
        this.f16842f.setListData(arrayList);
    }

    public void P0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f16842f.k();
        this.f16842f.setListData(arrayList);
    }

    @Override // d.b.j0.q0.o0
    public void W() {
    }

    @Override // d.b.j0.q0.o0
    public void b0() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a076";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
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

    @Override // d.b.j0.a1.e.a.b
    public void loadData() {
        boolean LoadData = this.f16841e.LoadData();
        HotTopicTabModel hotTopicTabModel = this.f16841e;
        List<n> y = hotTopicTabModel.y(hotTopicTabModel.z());
        if (LoadData) {
            if (!ListUtils.isEmpty(y) || this.f16842f.q()) {
                return;
            }
            this.f16842f.z();
            this.f16842f.i();
            N0();
            return;
        }
        this.f16842f.z();
        this.f16842f.h();
        if (!ListUtils.isEmpty(y)) {
            this.f16842f.setListData(y);
        } else if (j.A()) {
        } else {
            M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.f16842f.r();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16841e.B(this);
        this.f16841e.setUniqueId(getUniqueId());
        this.f16842f.setPresenter(this);
        this.f16842f.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16842f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16842f.getParent()).removeView(this.f16842f);
        }
        return this.f16842f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16842f.g();
        this.f16841e.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16842f.setViewForeground();
        }
    }

    @Override // d.b.j0.a1.e.a.b
    public void s(int i, d.b.j0.a1.e.a.f.a aVar) {
        this.f16842f.h();
        this.f16842f.i();
        this.f16842f.z();
        if (aVar != null && i == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
            this.f16842f.setData(aVar);
            this.f16842f.x();
        } else if (ListUtils.isEmpty(this.f16841e.x())) {
            M0();
        } else {
            this.f16842f.setListData(this.f16841e.x());
        }
    }

    @Override // d.b.j0.q0.o0
    public void w() {
        this.f16842f.t();
    }

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f16841e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f16842f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f16844h);
        this.f16842f.setOnItemCoverListener(this.i);
    }
}
