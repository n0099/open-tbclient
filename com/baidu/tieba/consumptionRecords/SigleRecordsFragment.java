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
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
/* loaded from: classes8.dex */
public class SigleRecordsFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConsumptionRecordsActivity f48342e;

    /* renamed from: f  reason: collision with root package name */
    public ConsumptionRecordsModel f48343f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48344g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48345h;

    /* renamed from: i  reason: collision with root package name */
    public int f48346i;
    public LinearLayout j;
    public BdListView k;
    public g l;
    public b.a.r0.e0.c m;
    public NoDataView n;
    public TextView o;
    public TbImageView p;

    /* loaded from: classes8.dex */
    public class a implements ConsumptionRecordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f48347a;

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
            this.f48347a = sigleRecordsFragment;
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void a(int i2, String str, ArrayList<b.a.r0.e0.a> arrayList, b.a.r0.e0.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, arrayList, bVar, Boolean.valueOf(z)}) == null) {
                this.f48347a.f48345h = z;
                SigleRecordsFragment sigleRecordsFragment = this.f48347a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
                this.f48347a.k.completePullRefresh();
                if (i2 == 0) {
                    this.f48347a.f48344g = true;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (bVar != null) {
                            this.f48347a.t(bVar);
                            return;
                        } else {
                            this.f48347a.s();
                            return;
                        }
                    }
                    this.f48347a.r();
                    if (z) {
                        this.f48347a.o.setText(R.string.loading_more_now);
                    } else {
                        this.f48347a.o.setText(R.string.no_more_data);
                    }
                    this.f48347a.m.h(arrayList);
                    this.f48347a.m.notifyDataSetChanged();
                    return;
                }
                this.f48347a.showToast(str);
                if (!this.f48347a.f48344g) {
                    this.f48347a.s();
                } else if (z) {
                    this.f48347a.o.setText(R.string.load_more);
                } else {
                    this.f48347a.o.setText(R.string.no_more_data);
                }
                this.f48347a.f48344g = true;
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f48347a.f48344g = true;
                SigleRecordsFragment sigleRecordsFragment = this.f48347a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.j);
                if (this.f48347a.f48345h) {
                    this.f48347a.o.setText(R.string.load_more);
                } else {
                    this.f48347a.o.setText(R.string.no_more_data);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f48348e;

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
            this.f48348e = sigleRecordsFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f48348e.f48343f.C();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f48349e;

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
            this.f48349e = sigleRecordsFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48349e.f48343f.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.e0.b f48350e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f48351f;

        public d(SigleRecordsFragment sigleRecordsFragment, b.a.r0.e0.b bVar) {
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
            this.f48351f = sigleRecordsFragment;
            this.f48350e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f48351f.getPageContext(), new String[]{this.f48350e.b()});
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
        this.f48344g = false;
        this.f48345h = false;
        this.l = null;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48346i : invokeV.intValue;
    }

    public final void o() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.k) == null) {
            return;
        }
        bdListView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
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
                gVar.C(i2);
            }
            if (this.m != null && (bdListView = this.k) != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
                this.m.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView == null || noDataView.getVisibility() != 0) {
                return;
            }
            this.n.onChangeSkinType(this.f48342e.getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.f48342e = (ConsumptionRecordsActivity) getBaseFragmentActivity();
            ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
            this.f48343f = consumptionRecordsModel;
            consumptionRecordsModel.setType(this.f48346i);
            if (this.f48346i == 3) {
                this.f48343f.setShowMember(1);
            } else {
                this.f48343f.setShowMember(0);
            }
            this.f48343f.F(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
            this.j = linearLayout;
            this.k = (BdListView) linearLayout.findViewById(R.id.records_list_view);
            this.l = new g(this.f48342e.getPageContext());
            b.a.r0.e0.c cVar = new b.a.r0.e0.c(this.f48342e.getPageContext(), this.f48346i);
            this.m = cVar;
            this.k.setAdapter((ListAdapter) cVar);
            this.k.setPullRefresh(this.l);
            TextView textView = new TextView(this.f48342e.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f48342e.getActivity(), R.dimen.ds176)));
            this.k.addHeaderView(textView, 0);
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            ConsumptionRecordsModel consumptionRecordsModel = this.f48343f;
            if (consumptionRecordsModel != null) {
                consumptionRecordsModel.destroy();
            }
            hideLoadingView(this.j);
            this.k.completePullRefresh();
            this.l = null;
            this.n = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrimary();
            if (this.f48344g) {
                return;
            }
            this.f48343f.C();
            showLoadingView(this.j, true, 400);
        }
    }

    public final void p() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (noDataView = this.n) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void q() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tbImageView = this.p) == null) {
            return;
        }
        this.j.removeView(tbImageView);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p();
            q();
            BdListView bdListView = this.k;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public final void s() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i3 = this.f48346i;
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
                this.n = NoDataViewFactory.a(this.f48342e.getPageContext().getPageActivity(), this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f48342e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.n.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
            this.n.onChangeSkinType(this.f48342e.getPageContext(), TbadkApplication.getInst().getSkinType());
            q();
            o();
            this.n.setVisibility(0);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f48346i = i2;
        }
    }

    public final void t(b.a.r0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null || this.j == null) {
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
        o();
        p();
        this.j.addView(this.p);
    }
}
