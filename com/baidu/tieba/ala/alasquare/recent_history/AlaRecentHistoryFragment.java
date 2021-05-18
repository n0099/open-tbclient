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
import d.a.j0.d0.h;
import d.a.j0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaRecentHistoryFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public AlaRecentHistoryModel f13878e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.t.d.e.c.a f13879f;

    /* renamed from: g  reason: collision with root package name */
    public int f13880g;

    /* renamed from: h  reason: collision with root package name */
    public h f13881h;

    /* renamed from: i  reason: collision with root package name */
    public f.g f13882i = new a();
    public BdListView.p j = new b();
    public AlaRecentHistoryModel.b k = new c();

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaRecentHistoryFragment.this.f13878e != null) {
                AlaRecentHistoryFragment.this.f13878e.B();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (AlaRecentHistoryFragment.this.f13878e != null) {
                AlaRecentHistoryFragment.this.f13878e.A();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaRecentHistoryModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void a(boolean z, List<d.a.k0.t.d.e.b.b> list) {
            AlaRecentHistoryFragment.this.f13879f.e();
            AlaRecentHistoryFragment alaRecentHistoryFragment = AlaRecentHistoryFragment.this;
            alaRecentHistoryFragment.hideLoadingView(alaRecentHistoryFragment.f13879f.g());
            AlaRecentHistoryFragment.this.f13879f.o(list, z);
            if (!ListUtils.isEmpty(list)) {
                AlaRecentHistoryFragment.this.K0(false, null, null);
                return;
            }
            String string = AlaRecentHistoryFragment.this.f13880g == 0 ? AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_living_no_data_tip) : AlaRecentHistoryFragment.this.getPageContext().getPageActivity().getResources().getString(R.string.sqaure_recent_whole_no_data_tip);
            AlaRecentHistoryFragment alaRecentHistoryFragment2 = AlaRecentHistoryFragment.this;
            alaRecentHistoryFragment2.K0(true, alaRecentHistoryFragment2.f13879f.g(), string);
        }

        @Override // com.baidu.tieba.ala.alasquare.recent_history.model.AlaRecentHistoryModel.b
        public void b(int i2, String str, boolean z) {
            AlaRecentHistoryFragment.this.f13879f.e();
            if (z) {
                AlaRecentHistoryFragment.this.showToast(R.string.square_load_data_failed_tip);
            } else {
                AlaRecentHistoryFragment alaRecentHistoryFragment = AlaRecentHistoryFragment.this;
                alaRecentHistoryFragment.showNetRefreshView(alaRecentHistoryFragment.f13879f.g(), str, false);
            }
            AlaRecentHistoryFragment.this.f13879f.q();
        }
    }

    public static AlaRecentHistoryFragment I0(int i2) {
        AlaRecentHistoryFragment alaRecentHistoryFragment = new AlaRecentHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type", i2);
        alaRecentHistoryFragment.setArguments(bundle);
        return alaRecentHistoryFragment;
    }

    public final void J0() {
        hideNetRefreshView(this.f13879f.g());
        if (ListUtils.getCount(this.f13878e.getData()) == 0) {
            showLoadingView(this.f13879f.g());
        }
        AlaRecentHistoryModel alaRecentHistoryModel = this.f13878e;
        if (alaRecentHistoryModel != null) {
            alaRecentHistoryModel.B();
        }
    }

    public final void K0(boolean z, ViewGroup viewGroup, String str) {
        if (this.f13881h == null) {
            this.f13881h = new h(getPageContext().getPageActivity(), null);
        }
        if (z) {
            this.f13881h.attachView(viewGroup);
            this.f13881h.c().setVisibility(8);
            this.f13881h.l(null);
            this.f13881h.d().setVisibility(0);
            this.f13881h.d().setText(str);
            return;
        }
        this.f13881h.dettachView(viewGroup);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.t.d.e.c.a aVar = this.f13879f;
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
        this.f13880g = i2;
        if (i2 < 0 || i2 > 1) {
            getPageContext().getPageActivity().finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13878e = new AlaRecentHistoryModel(getPageContext(), this.f13880g, this.k);
        d.a.k0.t.d.e.c.a aVar = new d.a.k0.t.d.e.c.a(getPageContext(), this.f13880g);
        this.f13879f = aVar;
        aVar.p(this.f13882i);
        this.f13879f.r(this.j);
        J0();
        if (this.f13880g == 0) {
            TiebaStatic.log("c12650");
        }
        return this.f13879f.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaRecentHistoryModel alaRecentHistoryModel = this.f13878e;
        if (alaRecentHistoryModel != null) {
            alaRecentHistoryModel.onDestroy();
        }
        d.a.k0.t.d.e.c.a aVar = this.f13879f;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        J0();
    }
}
