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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class SigleRecordsFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConsumptionRecordsActivity f43314e;

    /* renamed from: f  reason: collision with root package name */
    public ConsumptionRecordsModel f43315f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43316g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43317h;

    /* renamed from: i  reason: collision with root package name */
    public int f43318i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f43319j;

    /* renamed from: k  reason: collision with root package name */
    public BdListView f43320k;
    public g l;
    public c.a.r0.j0.c m;
    public NoDataView n;
    public TextView o;
    public TbImageView p;

    /* loaded from: classes10.dex */
    public class a implements ConsumptionRecordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SigleRecordsFragment a;

        public a(SigleRecordsFragment sigleRecordsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sigleRecordsFragment;
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f43316g = true;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f43319j);
                if (this.a.f43317h) {
                    this.a.o.setText(R.string.load_more);
                } else {
                    this.a.o.setText(R.string.no_more_data);
                }
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b(int i2, String str, ArrayList<c.a.r0.j0.a> arrayList, c.a.r0.j0.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, arrayList, bVar, Boolean.valueOf(z)}) == null) {
                this.a.f43317h = z;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f43319j);
                this.a.f43320k.completePullRefresh();
                if (i2 == 0) {
                    this.a.f43316g = true;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (bVar != null) {
                            this.a.x(bVar);
                            return;
                        } else {
                            this.a.w();
                            return;
                        }
                    }
                    this.a.v();
                    if (z) {
                        this.a.o.setText(R.string.loading_more_now);
                    } else {
                        this.a.o.setText(R.string.no_more_data);
                    }
                    this.a.m.h(arrayList);
                    this.a.m.notifyDataSetChanged();
                    return;
                }
                this.a.showToast(str);
                if (!this.a.f43316g) {
                    this.a.w();
                } else if (z) {
                    this.a.o.setText(R.string.load_more);
                } else {
                    this.a.o.setText(R.string.no_more_data);
                }
                this.a.f43316g = true;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f43321e;

        public b(SigleRecordsFragment sigleRecordsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43321e = sigleRecordsFragment;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f43321e.f43315f.C();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f43322e;

        public c(SigleRecordsFragment sigleRecordsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43322e = sigleRecordsFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43322e.f43315f.D();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j0.b f43323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f43324f;

        public d(SigleRecordsFragment sigleRecordsFragment, c.a.r0.j0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43324f = sigleRecordsFragment;
            this.f43323e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f43324f.getPageContext(), new String[]{this.f43323e.b()});
            }
        }
    }

    public SigleRecordsFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43316g = false;
        this.f43317h = false;
        this.l = null;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43318i : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            LinearLayout linearLayout = this.f43319j;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.o;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0108);
            }
            g gVar = this.l;
            if (gVar != null) {
                gVar.C(i2);
            }
            if (this.m != null && (bdListView = this.f43320k) != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
                this.m.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView == null || noDataView.getVisibility() != 0) {
                return;
            }
            this.n.onChangeSkinType(this.f43314e.getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.f43314e = (ConsumptionRecordsActivity) getBaseFragmentActivity();
            ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
            this.f43315f = consumptionRecordsModel;
            consumptionRecordsModel.setType(this.f43318i);
            if (this.f43318i == 3) {
                this.f43315f.setShowMember(1);
            } else {
                this.f43315f.setShowMember(0);
            }
            this.f43315f.F(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
            this.f43319j = linearLayout;
            this.f43320k = (BdListView) linearLayout.findViewById(R.id.records_list_view);
            this.l = new g(this.f43314e.getPageContext());
            c.a.r0.j0.c cVar = new c.a.r0.j0.c(this.f43314e.getPageContext(), this.f43318i);
            this.m = cVar;
            this.f43320k.setAdapter((ListAdapter) cVar);
            this.f43320k.setPullRefresh(this.l);
            TextView textView = new TextView(this.f43314e.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.f43314e.getActivity(), R.dimen.ds176)));
            this.f43320k.addHeaderView(textView, 0);
            this.l.a(new b(this));
            this.f43320k.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
            this.o = textView2;
            this.f43320k.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f43319j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            ConsumptionRecordsModel consumptionRecordsModel = this.f43315f;
            if (consumptionRecordsModel != null) {
                consumptionRecordsModel.destroy();
            }
            hideLoadingView(this.f43319j);
            this.f43320k.completePullRefresh();
            this.l = null;
            this.n = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPrimary();
            if (this.f43316g) {
                return;
            }
            this.f43315f.C();
            showLoadingView(this.f43319j, true, 400);
        }
    }

    public final void s() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdListView = this.f43320k) == null) {
            return;
        }
        bdListView.setVisibility(8);
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f43318i = i2;
        }
    }

    public final void t() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (noDataView = this.n) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void u() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbImageView = this.p) == null) {
            return;
        }
        this.f43319j.removeView(tbImageView);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            t();
            u();
            BdListView bdListView = this.f43320k;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public final void w() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int i3 = this.f43318i;
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
                this.n = NoDataViewFactory.a(this.f43314e.getPageContext().getPageActivity(), this.f43319j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.f(this.f43314e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.n.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
            this.n.onChangeSkinType(this.f43314e.getPageContext(), TbadkApplication.getInst().getSkinType());
            u();
            s();
            this.n.setVisibility(0);
        }
    }

    public final void x(c.a.r0.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null || this.f43319j == null) {
            return;
        }
        if (this.p == null) {
            this.p = new TbImageView(getActivity());
            this.p.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.p.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.p.startLoad(bVar.a(), 10, false);
        this.p.setVisibility(0);
        this.p.setOnClickListener(new d(this, bVar));
        s();
        t();
        this.f43319j.addView(this.p);
    }
}
