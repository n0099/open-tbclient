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
import d.a.i0.m.f;
import d.a.i0.z0.b0;
import d.a.j0.q0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabFragment extends BaseFragment implements o0, d.a.j0.a1.e.a.b {

    /* renamed from: e  reason: collision with root package name */
    public HotTopicTabModel f17104e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabView f17105f;

    /* renamed from: g  reason: collision with root package name */
    public FrsTabItemData f17106g;

    /* renamed from: h  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f17107h = new a();

    /* renamed from: i  reason: collision with root package name */
    public f<Object> f17108i = new b();

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
            if (HotTopicTabFragment.this.f17106g != null && HotTopicTabFragment.this.f17106g.tabId != frsTabItemData.tabId) {
                String str = frsTabItemData.tabCode;
                HotTopicTabFragment.this.f17104e.C(str);
                if (HotTopicTabFragment.this.f17104e.LoadData()) {
                    HotTopicTabFragment.this.f17105f.y();
                    HotTopicTabFragment.this.f17105f.h();
                    HotTopicTabFragment.this.f17105f.j();
                    HotTopicTabFragment.this.P0();
                } else {
                    HotTopicTabFragment.this.f17105f.y();
                    HotTopicTabFragment.this.f17105f.h();
                    List<n> y = HotTopicTabFragment.this.f17104e.y(str);
                    if (!ListUtils.isEmpty(y)) {
                        HotTopicTabFragment.this.f17105f.setListData(y);
                    } else {
                        HotTopicTabFragment.this.M0();
                    }
                }
            }
            HotTopicTabFragment.this.f17106g = frsTabItemData;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            HotTopicTabFragment.this.f17105f.y();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<Object> {
        public b() {
        }

        @Override // d.a.i0.m.f
        public void a(View view, Object obj, int i2, long j) {
            if (obj == null) {
                return;
            }
            d.a.j0.a1.e.a.a.a(view, obj, i2 + 1, HotTopicTabFragment.this.K0());
        }

        @Override // d.a.i0.m.f
        public void c(View view, Object obj, int i2, long j) {
            if (obj == null) {
                return;
            }
            d.a.j0.a1.e.a.a.b(view, obj, HotTopicTabFragment.this.K0());
        }
    }

    public HotTopicTabFragment() {
    }

    @Override // d.a.j0.q0.o0
    public void G() {
    }

    @Override // d.a.j0.q0.o0
    public void H() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final String K0() {
        HotTopicTabModel hotTopicTabModel = this.f17104e;
        return hotTopicTabModel != null ? hotTopicTabModel.z() : "";
    }

    public void L0(ScrollFragmentTabHost scrollFragmentTabHost) {
        HotTopicTabView hotTopicTabView = this.f17105f;
        if (hotTopicTabView != null) {
            hotTopicTabView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public final void M0() {
        if (this.f17105f.p()) {
            this.f17105f.j();
            O0();
            return;
        }
        this.f17105f.v(false);
    }

    public final void N0() {
        if (this.f17105f.p()) {
            this.f17105f.h();
            P0();
            return;
        }
        this.f17105f.u(false);
    }

    public void O0() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.f40417f = R.drawable.new_pic_emotion_05;
        vVar.f40416e = getString(R.string.no_data_common_txt);
        arrayList.add(vVar);
        this.f17105f.k();
        this.f17105f.setListData(arrayList);
    }

    public void P0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f17105f.k();
        this.f17105f.setListData(arrayList);
    }

    @Override // d.a.j0.a1.e.a.b
    public void X(int i2, d.a.j0.a1.e.a.f.a aVar) {
        this.f17105f.h();
        this.f17105f.j();
        this.f17105f.y();
        if (aVar != null && i2 == 0 && !ListUtils.isEmpty(aVar.getDataList())) {
            this.f17105f.setData(aVar);
            this.f17105f.w();
        } else if (ListUtils.isEmpty(this.f17104e.x())) {
            M0();
        } else {
            this.f17105f.setListData(this.f17104e.x());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a076";
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

    @Override // d.a.j0.a1.e.a.b
    public void loadData() {
        boolean LoadData = this.f17104e.LoadData();
        HotTopicTabModel hotTopicTabModel = this.f17104e;
        List<n> y = hotTopicTabModel.y(hotTopicTabModel.z());
        if (LoadData) {
            if (!ListUtils.isEmpty(y) || this.f17105f.p()) {
                return;
            }
            this.f17105f.y();
            this.f17105f.j();
            N0();
            return;
        }
        this.f17105f.y();
        this.f17105f.h();
        if (!ListUtils.isEmpty(y)) {
            this.f17105f.setListData(y);
        } else if (j.A()) {
        } else {
            M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        this.f17105f.q();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17104e.B(this);
        this.f17104e.setUniqueId(getUniqueId());
        this.f17105f.setPresenter(this);
        this.f17105f.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.f17105f.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f17105f.getParent()).removeView(this.f17105f);
        }
        return this.f17105f;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f17105f.g();
        this.f17104e.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.f17105f.setViewForeground();
        }
    }

    @Override // d.a.j0.q0.o0
    public void p() {
        this.f17105f.s();
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

    @SuppressLint({"ValidFragment"})
    public HotTopicTabFragment(Context context) {
        TbPageContext pageContext = context instanceof TbPageContextSupport ? ((TbPageContextSupport) context).getPageContext() : null;
        this.f17104e = new HotTopicTabModel(pageContext);
        HotTopicTabView hotTopicTabView = new HotTopicTabView(pageContext);
        this.f17105f = hotTopicTabView;
        hotTopicTabView.setOnTabSelectedListener(this.f17107h);
        this.f17105f.setOnItemCoverListener(this.f17108i);
    }
}
