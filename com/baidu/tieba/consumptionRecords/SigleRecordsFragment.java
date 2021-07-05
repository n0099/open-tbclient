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
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class SigleRecordsFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConsumptionRecordsActivity f14525e;

    /* renamed from: f  reason: collision with root package name */
    public ConsumptionRecordsModel f14526f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14527g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14528h;

    /* renamed from: i  reason: collision with root package name */
    public int f14529i;
    public LinearLayout j;
    public BdListView k;
    public g l;
    public d.a.s0.d0.c m;
    public NoDataView n;
    public TextView o;
    public TbImageView p;

    /* loaded from: classes5.dex */
    public class a implements ConsumptionRecordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f14530a;

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
            this.f14530a = sigleRecordsFragment;
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void a(int i2, String str, ArrayList<d.a.s0.d0.a> arrayList, d.a.s0.d0.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, arrayList, bVar, Boolean.valueOf(z)}) == null) {
                this.f14530a.f14528h = z;
                SigleRecordsFragment sigleRecordsFragment = this.f14530a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
                this.f14530a.k.z();
                if (i2 == 0) {
                    this.f14530a.f14527g = true;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (bVar != null) {
                            this.f14530a.a1(bVar);
                            return;
                        } else {
                            this.f14530a.Z0();
                            return;
                        }
                    }
                    this.f14530a.Y0();
                    if (z) {
                        this.f14530a.o.setText(R.string.loading_more_now);
                    } else {
                        this.f14530a.o.setText(R.string.no_more_data);
                    }
                    this.f14530a.m.h(arrayList);
                    this.f14530a.m.notifyDataSetChanged();
                    return;
                }
                this.f14530a.showToast(str);
                if (!this.f14530a.f14527g) {
                    this.f14530a.Z0();
                } else if (z) {
                    this.f14530a.o.setText(R.string.load_more);
                } else {
                    this.f14530a.o.setText(R.string.no_more_data);
                }
                this.f14530a.f14527g = true;
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f14530a.f14527g = true;
                SigleRecordsFragment sigleRecordsFragment = this.f14530a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
                if (this.f14530a.f14528h) {
                    this.f14530a.o.setText(R.string.load_more);
                } else {
                    this.f14530a.o.setText(R.string.no_more_data);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f14531e;

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
            this.f14531e = sigleRecordsFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f14531e.f14526f.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f14532e;

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
            this.f14532e = sigleRecordsFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14532e.f14526f.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.d0.b f14533e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f14534f;

        public d(SigleRecordsFragment sigleRecordsFragment, d.a.s0.d0.b bVar) {
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
            this.f14534f = sigleRecordsFragment;
            this.f14533e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f14534f.getPageContext(), new String[]{this.f14533e.b()});
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
        this.f14527g = false;
        this.f14528h = false;
        this.l = null;
    }

    public final void U0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdListView = this.k) == null) {
            return;
        }
        bdListView.setVisibility(8);
    }

    public final void V0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (noDataView = this.n) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void W0() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbImageView = this.p) == null) {
            return;
        }
        this.j.removeView(tbImageView);
    }

    public void X0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f14529i = i2;
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            V0();
            W0();
            BdListView bdListView = this.k;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public final void Z0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i3 = this.f14529i;
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
                this.n = NoDataViewFactory.a(this.f14525e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f14525e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.n.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
            this.n.f(this.f14525e.getPageContext(), TbadkApplication.getInst().getSkinType());
            W0();
            U0();
            this.n.setVisibility(0);
        }
    }

    public final void a1(d.a.s0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null || this.j == null) {
            return;
        }
        if (this.p == null) {
            this.p = new TbImageView(getActivity());
            this.p.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.p.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.p.M(bVar.a(), 10, false);
        this.p.setVisibility(0);
        this.p.setOnClickListener(new d(this, bVar));
        U0();
        V0();
        this.j.addView(this.p);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
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
            this.n.f(this.f14525e.getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            this.f14525e = (ConsumptionRecordsActivity) getBaseFragmentActivity();
            ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
            this.f14526f = consumptionRecordsModel;
            consumptionRecordsModel.setType(this.f14529i);
            if (this.f14529i == 3) {
                this.f14526f.setShowMember(1);
            } else {
                this.f14526f.setShowMember(0);
            }
            this.f14526f.F(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
            this.j = linearLayout;
            this.k = (BdListView) linearLayout.findViewById(R.id.records_list_view);
            this.l = new g(this.f14525e.getPageContext());
            d.a.s0.d0.c cVar = new d.a.s0.d0.c(this.f14525e.getPageContext(), this.f14529i);
            this.m = cVar;
            this.k.setAdapter((ListAdapter) cVar);
            this.k.setPullRefresh(this.l);
            TextView textView = new TextView(this.f14525e.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f14525e.getActivity(), R.dimen.ds176)));
            this.k.x(textView, 0);
            this.l.a(new b(this));
            this.k.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
            this.o = textView2;
            this.k.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            ConsumptionRecordsModel consumptionRecordsModel = this.f14526f;
            if (consumptionRecordsModel != null) {
                consumptionRecordsModel.destroy();
            }
            hideLoadingView(this.j);
            this.k.z();
            this.l = null;
            this.n = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (this.f14527g) {
                return;
            }
            this.f14526f.C();
            showLoadingView(this.j, true, 400);
        }
    }
}
