package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel;
import d.b.i0.d0.h;
import d.b.i0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public AlaRecentHistoryModel f14492e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.t.d.e.c.a f14493f;

    /* renamed from: g  reason: collision with root package name */
    public int f14494g;

    /* renamed from: h  reason: collision with root package name */
    public h f14495h;
    public f.g i = new a();
    public BdListView.p j = new b();
    public AlaRecentHistoryModel.b k = new c();

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.f14492e != null) {
                AlaRecentHistoryFragment.this.f14492e.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.f14492e != null) {
                AlaRecentHistoryFragment.this.f14492e.A();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaRecentHistoryModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<d.b.j0.t.d.e.b.b> list) {
            AlaRecentHistoryFragment.this.f14493f.e();
            AlaRecentHistoryFragment alaRecentHistoryFragment = AlaRecentHistoryFragment.this;
            alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.f14493f.g());
            AlaRecentHistoryFragment.this.f14493f.o(list, z);
            if (!ListUtils.isEmpty(list)) {
                AlaRecentHistoryFragment.this.L0(false, null, null);
                return;
            }
            String string = AlaRecentHistoryFragment.this.f14494g == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip);
            AlaRecentHistoryFragment alaRecentHistoryFragment2 = AlaRecentHistoryFragment.this;
            alaRecentHistoryFragment2.L0(true, alaRecentHistoryFragment2.f14493f.g(), string);
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i, String str, boolean z) {
            AlaRecentHistoryFragment.this.f14493f.e();
            if (z) {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            } else {
                AlaRecentHistoryFragment alaRecentHistoryFragment = AlaRecentHistoryFragment.this;
                alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.f14493f.g(), str, false);
            }
            AlaRecentHistoryFragment.this.f14493f.q();
        }
    }

    public static AlaRecentHistoryFragment J0(int i) {
        AlaRecentHistoryFragment alaRecentHistoryFragment = new AlaRecentHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type", i);
        alaRecentHistoryFragment.setArguments(bundle);
        return alaRecentHistoryFragment;
    }

    public final void K0() {
        hideNetRefreshView(this.f14493f.g());
        if (ListUtils.getCount(this.f14492e.getData()) == 0) {
            showLoadingView(this.f14493f.g());
        }
        AlaRecentHistoryModel alaRecentHistoryModel = this.f14492e;
        if (alaRecentHistoryModel != null) {
            alaRecentHistoryModel.B();
        }
    }

    public final void L0(boolean z, ViewGroup viewGroup, String str) {
        if (this.f14495h == null) {
            this.f14495h = new h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.f14495h.attachView(viewGroup);
            this.f14495h.c().setVisibility(8);
            this.f14495h.l(null);
            this.f14495h.d().setVisibility(0);
            this.f14495h.d().setText(str);
            return;
        }
        this.f14495h.dettachView(viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.t.d.e.c.a aVar = this.f14493f;
        if (aVar != null) {
            aVar.k(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        int i = arguments.getInt("key_type");
        this.f14494g = i;
        if (i < 0 || i > 1) {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14492e = new AlaRecentHistoryModel(getPageContext(), this.f14494g, this.k);
        d.b.j0.t.d.e.c.a aVar = new d.b.j0.t.d.e.c.a(getPageContext(), this.f14494g);
        this.f14493f = aVar;
        aVar.p(this.i);
        this.f14493f.r(this.j);
        K0();
        if (this.f14494g == 0) {
            TiebaStatic.log("c12650");
        }
        return this.f14493f.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaRecentHistoryModel alaRecentHistoryModel = this.f14492e;
        if (alaRecentHistoryModel != null) {
            alaRecentHistoryModel.onDestroy();
        }
        d.b.j0.t.d.e.c.a aVar = this.f14493f;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        K0();
    }
}
