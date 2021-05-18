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
import d.a.c.j.e.n;
import d.a.c.j.e.t;
import d.a.c.j.e.v;
import d.a.j0.m.f;
import d.a.j0.z0.b0;
import d.a.k0.q0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements o0, d.a.k0.a1.e.a.b {

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f16419e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f16420f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f16421g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f16422h = new a();

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f16423i = new b();

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
            if (HotTopicTabFragment.this.f16421g != null && HotTopicTabFragment.this.f16421g.tabId != frsTabItemData.tabId) {
                String str = frsTabItemData.tabCode;
                HotTopicTabFragment.this.f16419e.C(str);
                if (HotTopicTabFragment.this.f16419e.LoadData()) {
                    HotTopicTabFragment.this.f16420f.y();
                    HotTopicTabFragment.this.f16420f.h();
                    HotTopicTabFragment.this.f16420f.j();
                    HotTopicTabFragment.this.O0();
                } else {
                    HotTopicTabFragment.this.f16420f.y();
                    HotTopicTabFragment.this.f16420f.h();
                    List<n> y = HotTopicTabFragment.this.f16419e.y(str);
                    if (!ListUtils.isEmpty(y)) {
                        HotTopicTabFragment.this.f16420f.setListData(y);
                    } else {
                        HotTopicTabFragment.this.L0();
                    }
                }
            }
            HotTopicTabFragment.this.f16421g = frsTabItemData;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.f16420f.y();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<Object> {
        public b() {
        }

        @Override // d.a.j0.m.f
        public void a(View view, Object obj, int i2, long j) {
            if (obj == null) {
                return;
            }
            d.a.k0.a1.e.a.a.a(view, obj, i2 + 1, HotTopicTabFragment.this.J0());
        }

        @Override // d.a.j0.m.f
        public void c(View view, Object obj, int i2, long j) {
            if (obj == null) {
                return;
            }
            d.a.k0.a1.e.a.a.b(view, obj, HotTopicTabFragment.this.J0());
        }
    }

    public HotTopicTabFragment() {
    }

    @Override // d.a.k0.q0.o0
    public void G() {
    }

    @Override // d.a.k0.q0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final String J0() {
        HotTopicTabModel hotTopicTabModel = this.f16419e;
        return hotTopicTabModel != null ? hotTopicTabModel.z() : "";
    }

    public void K0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView = this.f16420f;
        if (hotTopicTabView != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void L0() {
        if (this.f16420f.p()) {
            this.f16420f.j();
            N0();
            return;
        }
        this.f16420f.v(false);
    }

    public final void M0() {
        if (this.f16420f.p()) {
            this.f16420f.h();
            O0();
            return;
        }
        this.f16420f.u(false);
    }

    public void N0() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f39662f = R.drawable.new_pic_emotion_05;
        vVar.f39661e = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.f16420f.k();
        this.f16420f.setListData(arrayList);
    }

    public void O0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f16420f.k();
        this.f16420f.setListData(arrayList);
    }

    @Override // d.a.k0.a1.e.a.b
    public void X(int i2, d.a.k0.a1.e.a.f.a aVar) {
        this.f16420f.h();
        this.f16420f.j();
        this.f16420f.y();
        if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
            this.f16420f.setData(aVar);
            this.f16420f.w();
        } else if (ListUtils.isEmpty(this.f16419e.x())) {
            L0();
        } else {
            this.f16420f.setListData(this.f16419e.x());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a076";
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

    @Override // d.a.k0.a1.e.a.b
    public void loadData() {
        boolean LoadData = this.f16419e.LoadData();
        HotTopicTabModel hotTopicTabModel = this.f16419e;
        List<n> y = hotTopicTabModel.y(hotTopicTabModel.z());
        if (LoadData) {
            if (!ListUtils.isEmpty(y) || this.f16420f.p()) {
                return;
            }
            this.f16420f.y();
            this.f16420f.j();
            M0();
            return;
        }
        this.f16420f.y();
        this.f16420f.h();
        if (!ListUtils.isEmpty(y)) {
            this.f16420f.setListData(y);
        } else if (j.A()) {
        } else {
            L0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f16420f.q();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16419e.B(this);
        this.f16419e.setUniqueId(getUniqueId());
        this.f16420f.setPresenter(this);
        this.f16420f.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f16420f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16420f.getParent()).removeView(this.f16420f);
        }
        return this.f16420f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16420f.g();
        this.f16419e.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f16420f.setViewForeground();
        }
    }

    @Override // d.a.k0.q0.o0
    public void p() {
        this.f16420f.s();
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

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f16419e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f16420f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f16422h);
        this.f16420f.setOnItemCoverListener(this.f16423i);
    }
}
