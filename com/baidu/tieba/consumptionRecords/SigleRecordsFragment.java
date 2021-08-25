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
import c.a.e.e.p.l;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
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
/* loaded from: classes7.dex */
public class SigleRecordsFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConsumptionRecordsActivity f49901e;

    /* renamed from: f  reason: collision with root package name */
    public ConsumptionRecordsModel f49902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49903g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49904h;

    /* renamed from: i  reason: collision with root package name */
    public int f49905i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f49906j;
    public BdListView k;
    public g l;
    public c.a.q0.d0.c m;
    public NoDataView n;
    public TextView o;
    public TbImageView p;

    /* loaded from: classes7.dex */
    public class a implements ConsumptionRecordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f49907a;

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
            this.f49907a = sigleRecordsFragment;
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void a(int i2, String str, ArrayList<c.a.q0.d0.a> arrayList, c.a.q0.d0.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, arrayList, bVar, Boolean.valueOf(z)}) == null) {
                this.f49907a.f49904h = z;
                SigleRecordsFragment sigleRecordsFragment = this.f49907a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f49906j);
                this.f49907a.k.completePullRefresh();
                if (i2 == 0) {
                    this.f49907a.f49903g = true;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (bVar != null) {
                            this.f49907a.t(bVar);
                            return;
                        } else {
                            this.f49907a.s();
                            return;
                        }
                    }
                    this.f49907a.r();
                    if (z) {
                        this.f49907a.o.setText(R.string.loading_more_now);
                    } else {
                        this.f49907a.o.setText(R.string.no_more_data);
                    }
                    this.f49907a.m.h(arrayList);
                    this.f49907a.m.notifyDataSetChanged();
                    return;
                }
                this.f49907a.showToast(str);
                if (!this.f49907a.f49903g) {
                    this.f49907a.s();
                } else if (z) {
                    this.f49907a.o.setText(R.string.load_more);
                } else {
                    this.f49907a.o.setText(R.string.no_more_data);
                }
                this.f49907a.f49903g = true;
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f49907a.f49903g = true;
                SigleRecordsFragment sigleRecordsFragment = this.f49907a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f49906j);
                if (this.f49907a.f49904h) {
                    this.f49907a.o.setText(R.string.load_more);
                } else {
                    this.f49907a.o.setText(R.string.no_more_data);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f49908e;

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
            this.f49908e = sigleRecordsFragment;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f49908e.f49902f.C();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f49909e;

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
            this.f49909e = sigleRecordsFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49909e.f49902f.D();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.d0.b f49910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f49911f;

        public d(SigleRecordsFragment sigleRecordsFragment, c.a.q0.d0.b bVar) {
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
            this.f49911f = sigleRecordsFragment;
            this.f49910e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f49911f.getPageContext(), new String[]{this.f49910e.b()});
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
        this.f49903g = false;
        this.f49904h = false;
        this.l = null;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49905i : invokeV.intValue;
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
            LinearLayout linearLayout = this.f49906j;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.o;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0108);
            }
            g gVar = this.l;
            if (gVar != null) {
                gVar.D(i2);
            }
            if (this.m != null && (bdListView = this.k) != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
                this.m.notifyDataSetChanged();
            }
            NoDataView noDataView = this.n;
            if (noDataView == null || noDataView.getVisibility() != 0) {
                return;
            }
            this.n.onChangeSkinType(this.f49901e.getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.f49901e = (ConsumptionRecordsActivity) getBaseFragmentActivity();
            ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
            this.f49902f = consumptionRecordsModel;
            consumptionRecordsModel.setType(this.f49905i);
            if (this.f49905i == 3) {
                this.f49902f.setShowMember(1);
            } else {
                this.f49902f.setShowMember(0);
            }
            this.f49902f.F(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.single_fragment_layout, (ViewGroup) null);
            this.f49906j = linearLayout;
            this.k = (BdListView) linearLayout.findViewById(R.id.records_list_view);
            this.l = new g(this.f49901e.getPageContext());
            c.a.q0.d0.c cVar = new c.a.q0.d0.c(this.f49901e.getPageContext(), this.f49905i);
            this.m = cVar;
            this.k.setAdapter((ListAdapter) cVar);
            this.k.setPullRefresh(this.l);
            TextView textView = new TextView(this.f49901e.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f49901e.getActivity(), R.dimen.ds176)));
            this.k.addHeaderView(textView, 0);
            this.l.a(new b(this));
            this.k.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.load_more_view, (ViewGroup) null);
            this.o = textView2;
            this.k.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f49906j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            ConsumptionRecordsModel consumptionRecordsModel = this.f49902f;
            if (consumptionRecordsModel != null) {
                consumptionRecordsModel.destroy();
            }
            hideLoadingView(this.f49906j);
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
            if (this.f49903g) {
                return;
            }
            this.f49902f.C();
            showLoadingView(this.f49906j, true, 400);
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
        this.f49906j.removeView(tbImageView);
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
            int i3 = this.f49905i;
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
                this.n = NoDataViewFactory.a(this.f49901e.getPageContext().getPageActivity(), this.f49906j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f49901e.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(i2), null);
            }
            this.n.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
            this.n.onChangeSkinType(this.f49901e.getPageContext(), TbadkApplication.getInst().getSkinType());
            q();
            o();
            this.n.setVisibility(0);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f49905i = i2;
        }
    }

    public final void t(c.a.q0.d0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null || this.f49906j == null) {
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
        this.f49906j.addView(this.p);
    }
}
