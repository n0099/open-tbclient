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
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.c.k.e.t;
import d.a.c.k.e.v;
import d.a.n0.m.f;
import d.a.n0.z0.b0;
import d.a.o0.r0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements o0, d.a.o0.b1.f.a.b {

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f16474e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f16475f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f16476g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f16477h = new a();

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f16478i = new b();

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
            if (HotTopicTabFragment.this.f16476g != null && HotTopicTabFragment.this.f16476g.tabId != frsTabItemData.tabId) {
                String str = frsTabItemData.tabCode;
                HotTopicTabFragment.this.f16474e.G(str);
                if (HotTopicTabFragment.this.f16474e.LoadData()) {
                    HotTopicTabFragment.this.f16475f.y();
                    HotTopicTabFragment.this.f16475f.h();
                    HotTopicTabFragment.this.f16475f.i();
                    HotTopicTabFragment.this.R0();
                } else {
                    HotTopicTabFragment.this.f16475f.y();
                    HotTopicTabFragment.this.f16475f.h();
                    List<n> C = HotTopicTabFragment.this.f16474e.C(str);
                    if (!ListUtils.isEmpty(C)) {
                        HotTopicTabFragment.this.f16475f.setListData(C);
                    } else {
                        HotTopicTabFragment.this.O0();
                    }
                }
            }
            HotTopicTabFragment.this.f16476g = frsTabItemData;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.f16475f.y();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<Object> {
        public b() {
        }

        @Override // d.a.n0.m.f
        public void a(View view, Object obj, int i2, long j) {
            if (obj == null) {
                return;
            }
            d.a.o0.b1.f.a.a.a(view, obj, i2 + 1, HotTopicTabFragment.this.M0());
        }

        @Override // d.a.n0.m.f
        public void c(View view, Object obj, int i2, long j) {
            if (obj == null) {
                return;
            }
            d.a.o0.b1.f.a.a.b(view, obj, HotTopicTabFragment.this.M0());
        }
    }

    public HotTopicTabFragment() {
    }

    @Override // d.a.o0.r0.o0
    public void H() {
    }

    @Override // d.a.o0.r0.o0
    public void I() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final String M0() {
        HotTopicTabModel hotTopicTabModel = this.f16474e;
        return hotTopicTabModel != null ? hotTopicTabModel.D() : "";
    }

    public void N0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView = this.f16475f;
        if (hotTopicTabView != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void O0() {
        if (this.f16475f.p()) {
            this.f16475f.i();
            Q0();
            return;
        }
        this.f16475f.v(false);
    }

    public final void P0() {
        if (this.f16475f.p()) {
            this.f16475f.h();
            R0();
            return;
        }
        this.f16475f.u(false);
    }

    public void Q0() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f43110f = R.drawable.new_pic_emotion_05;
        vVar.f43109e = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.f16475f.k();
        this.f16475f.setListData(arrayList);
    }

    public void R0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f16475f.k();
        this.f16475f.setListData(arrayList);
    }

    @Override // d.a.o0.b1.f.a.b
    public void Z(int i2, d.a.o0.b1.f.a.f.a aVar) {
        this.f16475f.h();
        this.f16475f.i();
        this.f16475f.y();
        if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
            this.f16475f.setData(aVar);
            this.f16475f.w();
        } else if (ListUtils.isEmpty(this.f16474e.B())) {
            O0();
        } else {
            this.f16475f.setListData(this.f16474e.B());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a076";
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

    @Override // d.a.o0.b1.f.a.b
    public void loadData() {
        boolean LoadData = this.f16474e.LoadData();
        HotTopicTabModel hotTopicTabModel = this.f16474e;
        List<n> C = hotTopicTabModel.C(hotTopicTabModel.D());
        if (LoadData) {
            if (!ListUtils.isEmpty(C) || this.f16475f.p()) {
                return;
            }
            this.f16475f.y();
            this.f16475f.i();
            P0();
            return;
        }
        this.f16475f.y();
        this.f16475f.h();
        if (!ListUtils.isEmpty(C)) {
            this.f16475f.setListData(C);
        } else if (j.A()) {
        } else {
            O0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f16475f.q();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16474e.F(this);
        this.f16474e.setUniqueId(getUniqueId());
        this.f16475f.setPresenter(this);
        this.f16475f.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16475f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16475f.getParent()).removeView(this.f16475f);
        }
        return this.f16475f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16475f.g();
        this.f16474e.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16475f.setViewForeground();
        }
    }

    @Override // d.a.o0.r0.o0
    public void r() {
        this.f16475f.s();
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

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f16474e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f16475f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f16477h);
        this.f16475f.setOnItemCoverListener(this.f16478i);
    }
}
