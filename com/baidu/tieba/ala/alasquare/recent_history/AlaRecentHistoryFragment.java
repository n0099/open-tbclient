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
import d.a.i0.d0.h;
import d.a.i0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public AlaRecentHistoryModel f14563e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.t.d.e.c.a f14564f;

    /* renamed from: g  reason: collision with root package name */
    public int f14565g;

    /* renamed from: h  reason: collision with root package name */
    public h f14566h;

    /* renamed from: i  reason: collision with root package name */
    public f.g f14567i = new a();
    public BdListView.p j = new b();
    public AlaRecentHistoryModel.b k = new c();

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.f14563e != null) {
                AlaRecentHistoryFragment.this.f14563e.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.f14563e != null) {
                AlaRecentHistoryFragment.this.f14563e.A();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaRecentHistoryModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<d.a.j0.t.d.e.b.b> list) {
            AlaRecentHistoryFragment.this.f14564f.e();
            AlaRecentHistoryFragment alaRecentHistoryFragment = AlaRecentHistoryFragment.this;
            alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.f14564f.g());
            AlaRecentHistoryFragment.this.f14564f.o(list, z);
            if (!ListUtils.isEmpty(list)) {
                AlaRecentHistoryFragment.this.L0(false, null, null);
                return;
            }
            String string = AlaRecentHistoryFragment.this.f14565g == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip);
            AlaRecentHistoryFragment alaRecentHistoryFragment2 = AlaRecentHistoryFragment.this;
            alaRecentHistoryFragment2.L0(true, alaRecentHistoryFragment2.f14564f.g(), string);
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i2, String str, boolean z) {
            AlaRecentHistoryFragment.this.f14564f.e();
            if (z) {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            } else {
                AlaRecentHistoryFragment alaRecentHistoryFragment = AlaRecentHistoryFragment.this;
                alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.f14564f.g(), str, false);
            }
            AlaRecentHistoryFragment.this.f14564f.q();
        }
    }

    public static AlaRecentHistoryFragment J0(int i2) {
        AlaRecentHistoryFragment alaRecentHistoryFragment = new AlaRecentHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type", i2);
        alaRecentHistoryFragment.setArguments(bundle);
        return alaRecentHistoryFragment;
    }

    public final void K0() {
        hideNetRefreshView(this.f14564f.g());
        if (ListUtils.getCount(this.f14563e.getData()) == 0) {
            showLoadingView(this.f14564f.g());
        }
        AlaRecentHistoryModel alaRecentHistoryModel = this.f14563e;
        if (alaRecentHistoryModel != null) {
            alaRecentHistoryModel.B();
        }
    }

    public final void L0(boolean z, ViewGroup viewGroup, String str) {
        if (this.f14566h == null) {
            this.f14566h = new h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.f14566h.attachView(viewGroup);
            this.f14566h.c().setVisibility(8);
            this.f14566h.l(null);
            this.f14566h.d().setVisibility(0);
            this.f14566h.d().setText(str);
            return;
        }
        this.f14566h.dettachView(viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.j0.t.d.e.c.a aVar = this.f14564f;
        if (aVar != null) {
            aVar.k(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        int i2 = arguments.getInt("key_type");
        this.f14565g = i2;
        if (i2 < 0 || i2 > 1) {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14563e = new AlaRecentHistoryModel(getPageContext(), this.f14565g, this.k);
        d.a.j0.t.d.e.c.a aVar = new d.a.j0.t.d.e.c.a(getPageContext(), this.f14565g);
        this.f14564f = aVar;
        aVar.p(this.f14567i);
        this.f14564f.r(this.j);
        K0();
        if (this.f14565g == 0) {
            TiebaStatic.log("c12650");
        }
        return this.f14564f.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaRecentHistoryModel alaRecentHistoryModel = this.f14563e;
        if (alaRecentHistoryModel != null) {
            alaRecentHistoryModel.onDestroy();
        }
        d.a.j0.t.d.e.c.a aVar = this.f14564f;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        K0();
    }
}
