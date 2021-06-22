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
import d.a.c.e.p.l;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class SigleRecordsFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public ConsumptionRecordsActivity f14438e;

    /* renamed from: f  reason: collision with root package name */
    public ConsumptionRecordsModel f14439f;

    /* renamed from: i  reason: collision with root package name */
    public int f14442i;
    public LinearLayout j;
    public BdListView k;
    public d.a.o0.c0.c m;
    public NoDataView n;
    public TextView o;
    public TbImageView p;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14440g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14441h = false;
    public g l = null;

    /* loaded from: classes4.dex */
    public class a implements ConsumptionRecordsModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void a(int i2, String str, ArrayList<d.a.o0.c0.a> arrayList, d.a.o0.c0.b bVar, boolean z) {
            SigleRecordsFragment.this.f14441h = z;
            SigleRecordsFragment sigleRecordsFragment = SigleRecordsFragment.this;
            sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
            SigleRecordsFragment.this.k.z();
            if (i2 == 0) {
                SigleRecordsFragment.this.f14440g = true;
                if (arrayList == null || arrayList.size() <= 0) {
                    if (bVar != null) {
                        SigleRecordsFragment.this.a1(bVar);
                        return;
                    } else {
                        SigleRecordsFragment.this.Z0();
                        return;
                    }
                }
                SigleRecordsFragment.this.Y0();
                if (z) {
                    SigleRecordsFragment.this.o.setText(R.string.loading_more_now);
                } else {
                    SigleRecordsFragment.this.o.setText(R.string.no_more_data);
                }
                SigleRecordsFragment.this.m.h(arrayList);
                SigleRecordsFragment.this.m.notifyDataSetChanged();
                return;
            }
            SigleRecordsFragment.this.showToast(str);
            if (!SigleRecordsFragment.this.f14440g) {
                SigleRecordsFragment.this.Z0();
            } else if (z) {
                SigleRecordsFragment.this.o.setText(R.string.load_more);
            } else {
                SigleRecordsFragment.this.o.setText(R.string.no_more_data);
            }
            SigleRecordsFragment.this.f14440g = true;
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b() {
            SigleRecordsFragment.this.f14440g = true;
            SigleRecordsFragment sigleRecordsFragment = SigleRecordsFragment.this;
            sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
            if (SigleRecordsFragment.this.f14441h) {
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

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            SigleRecordsFragment.this.f14439f.C();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            SigleRecordsFragment.this.f14439f.D();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.c0.b f14446e;

        public d(d.a.o0.c0.b bVar) {
            this.f14446e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(SigleRecordsFragment.this.getPageContext(), new String[]{this.f14446e.b()});
        }
    }

    public final void U0() {
        BdListView bdListView = this.k;
        if (bdListView != null) {
            bdListView.setVisibility(8);
        }
    }

    public final void V0() {
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void W0() {
        TbImageView tbImageView = this.p;
        if (tbImageView != null) {
            this.j.removeView(tbImageView);
        }
    }

    public void X0(int i2) {
        this.f14442i = i2;
    }

    public final void Y0() {
        V0();
        W0();
        BdListView bdListView = this.k;
        if (bdListView != null) {
            bdListView.setVisibility(0);
        }
    }

    public final void Z0() {
        int i2;
        int i3 = this.f14442i;
        if (i3 == 1) {
            i2 = R.string.no_expenditure_records_tip;
        } else if (i3 == 2) {
            i2 = R.string.no_income_records_tip;
        } else if (i3 != 3) {
            i2 = R.string.no_records_tip;
        } else {
            i2 = R.string.no_recharge_records_tip;
        }
        if (this.n == null) {
            this.n = NoDataViewFactory.a(this.f14438e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f14438e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
        }
        this.n.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
        this.n.f(this.f14438e.getPageContext(), TbadkApplication.getInst().getSkinType());
        W0();
        U0();
        this.n.setVisibility(0);
    }

    public final void a1(d.a.o0.c0.b bVar) {
        if (bVar == null || this.j == null) {
            return;
        }
        if (this.p == null) {
            this.p = new TbImageView(getActivity());
            this.p.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.p.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.p.U(bVar.a(), 10, false);
        this.p.setVisibility(0);
        this.p.setOnClickListener(new d(bVar));
        U0();
        V0();
        this.j.addView(this.p);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        BdListView bdListView;
        super.onChangeSkinType(i2);
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
            gVar.I(i2);
        }
        if (this.m != null && (bdListView = this.k) != null) {
            SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
            this.m.notifyDataSetChanged();
        }
        NoDataView noDataView = this.n;
        if (noDataView == null || noDataView.getVisibility() != 0) {
            return;
        }
        this.n.f(this.f14438e.getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14438e = (ConsumptionRecordsActivity) getBaseFragmentActivity();
        ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
        this.f14439f = consumptionRecordsModel;
        consumptionRecordsModel.setType(this.f14442i);
        if (this.f14442i == 3) {
            this.f14439f.setShowMember(1);
        } else {
            this.f14439f.setShowMember(0);
        }
        this.f14439f.F(new a());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
        this.j = linearLayout;
        this.k = (BdListView) linearLayout.findViewById(R.id.records_list_view);
        this.l = new g(this.f14438e.getPageContext());
        d.a.o0.c0.c cVar = new d.a.o0.c0.c(this.f14438e.getPageContext(), this.f14442i);
        this.m = cVar;
        this.k.setAdapter((ListAdapter) cVar);
        this.k.setPullRefresh(this.l);
        TextView textView = new TextView(this.f14438e.getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f14438e.getActivity(), R.dimen.ds176)));
        this.k.x(textView, 0);
        this.l.a(new b());
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
        ConsumptionRecordsModel consumptionRecordsModel = this.f14439f;
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
        if (this.f14440g) {
            return;
        }
        this.f14439f.C();
        showLoadingView(this.j, true, 400);
    }
}
