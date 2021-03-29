package com.baidu.tieba.consumptionRecords;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel;
import d.b.b.e.p.l;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class SigleRecordsFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public ConsumptionRecordsActivity f15295e;

    /* renamed from: f  reason: collision with root package name */
    public ConsumptionRecordsModel f15296f;
    public int i;
    public LinearLayout j;
    public BdListView k;
    public d.b.i0.a0.c m;
    public NoDataView n;
    public TextView o;
    public TbImageView p;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15297g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15298h = false;
    public g l = null;

    /* loaded from: classes4.dex */
    public class a implements ConsumptionRecordsModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void a(int i, String str, ArrayList<d.b.i0.a0.a> arrayList, d.b.i0.a0.b bVar, boolean z) {
            SigleRecordsFragment.this.f15298h = z;
            SigleRecordsFragment sigleRecordsFragment = SigleRecordsFragment.this;
            sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
            SigleRecordsFragment.this.k.z();
            if (i == 0) {
                SigleRecordsFragment.this.f15297g = true;
                if (arrayList == null || arrayList.size() <= 0) {
                    if (bVar != null) {
                        SigleRecordsFragment.this.Y0(bVar);
                        return;
                    } else {
                        SigleRecordsFragment.this.X0();
                        return;
                    }
                }
                SigleRecordsFragment.this.W0();
                if (z) {
                    SigleRecordsFragment.this.o.setText(R.string.loading_more_now);
                } else {
                    SigleRecordsFragment.this.o.setText(R.string.no_more_data);
                }
                SigleRecordsFragment.this.m.g(arrayList);
                SigleRecordsFragment.this.m.notifyDataSetChanged();
                return;
            }
            SigleRecordsFragment.this.showToast(str);
            if (!SigleRecordsFragment.this.f15297g) {
                SigleRecordsFragment.this.X0();
            } else if (z) {
                SigleRecordsFragment.this.o.setText(R.string.load_more);
            } else {
                SigleRecordsFragment.this.o.setText(R.string.no_more_data);
            }
            SigleRecordsFragment.this.f15297g = true;
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b() {
            SigleRecordsFragment.this.f15297g = true;
            SigleRecordsFragment sigleRecordsFragment = SigleRecordsFragment.this;
            sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
            if (SigleRecordsFragment.this.f15298h) {
                SigleRecordsFragment.this.o.setText(R.string.load_more);
            } else {
                SigleRecordsFragment.this.o.setText(R.string.no_more_data);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            SigleRecordsFragment.this.f15296f.y();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            SigleRecordsFragment.this.f15296f.z();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.a0.b f15302e;

        public d(d.b.i0.a0.b bVar) {
            this.f15302e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(SigleRecordsFragment.this.getPageContext(), new String[]{this.f15302e.b()});
        }
    }

    public final void S0() {
        BdListView bdListView = this.k;
        if (bdListView != null) {
            bdListView.setVisibility(8);
        }
    }

    public final void T0() {
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void U0() {
        TbImageView tbImageView = this.p;
        if (tbImageView != null) {
            this.j.removeView(tbImageView);
        }
    }

    public void V0(int i) {
        this.i = i;
    }

    public final void W0() {
        T0();
        U0();
        BdListView bdListView = this.k;
        if (bdListView != null) {
            bdListView.setVisibility(0);
        }
    }

    public final void X0() {
        int i;
        int i2 = this.i;
        if (i2 == 1) {
            i = R.string.no_expenditure_records_tip;
        } else if (i2 == 2) {
            i = R.string.no_income_records_tip;
        } else if (i2 != 3) {
            i = R.string.no_records_tip;
        } else {
            i = R.string.no_recharge_records_tip;
        }
        if (this.n == null) {
            this.n = NoDataViewFactory.a(this.f15295e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f15295e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(i), null);
        }
        this.n.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i)));
        this.n.f(this.f15295e.getPageContext(), TbadkApplication.getInst().getSkinType());
        U0();
        S0();
        this.n.setVisibility(0);
    }

    public final void Y0(d.b.i0.a0.b bVar) {
        if (bVar == null || this.j == null) {
            return;
        }
        if (this.p == null) {
            this.p = new TbImageView(getActivity());
            this.p.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.p.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.p.W(bVar.a(), 10, false);
        this.p.setVisibility(0);
        this.p.setOnClickListener(new d(bVar));
        S0();
        T0();
        this.j.addView(this.p);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        BdListView bdListView;
        super.onChangeSkinType(i);
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
        }
        TextView textView = this.o;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108);
        }
        g gVar = this.l;
        if (gVar != null) {
            gVar.I(i);
        }
        if (this.m != null && (bdListView = this.k) != null) {
            SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
            this.m.notifyDataSetChanged();
        }
        NoDataView noDataView = this.n;
        if (noDataView == null || noDataView.getVisibility() != 0) {
            return;
        }
        this.n.f(this.f15295e.getPageContext(), i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15295e = (ConsumptionRecordsActivity) getBaseFragmentActivity();
        ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
        this.f15296f = consumptionRecordsModel;
        consumptionRecordsModel.setType(this.i);
        if (this.i == 3) {
            this.f15296f.setShowMember(1);
        } else {
            this.f15296f.setShowMember(0);
        }
        this.f15296f.B(new a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
        this.j = linearLayout;
        this.k = (BdListView) linearLayout.findViewById(R.id.records_list_view);
        this.l = new g(this.f15295e.getPageContext());
        d.b.i0.a0.c cVar = new d.b.i0.a0.c(this.f15295e.getPageContext(), this.i);
        this.m = cVar;
        this.k.setAdapter((ListAdapter) cVar);
        this.k.setPullRefresh(this.l);
        TextView textView = new TextView(this.f15295e.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f15295e.getActivity(), R.dimen.ds176)));
        this.k.x(textView, 0);
        this.l.b(new b());
        this.k.setOnSrollToBottomListener(new c());
        TextView textView2 = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
        this.o = textView2;
        this.k.addFooterView(textView2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.j;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ConsumptionRecordsModel consumptionRecordsModel = this.f15296f;
        if (consumptionRecordsModel != null) {
            consumptionRecordsModel.destroy();
        }
        hideLoadingView(this.j);
        this.k.z();
        this.l = null;
        this.n = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.f15297g) {
            return;
        }
        this.f15296f.y();
        showLoadingView(this.j, true, 400);
    }
}
