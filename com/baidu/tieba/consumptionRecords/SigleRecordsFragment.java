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
import c.a.d.f.p.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
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
/* loaded from: classes5.dex */
public class SigleRecordsFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConsumptionRecordsActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ConsumptionRecordsModel f31693b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31694c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31695d;

    /* renamed from: e  reason: collision with root package name */
    public int f31696e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f31697f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f31698g;

    /* renamed from: h  reason: collision with root package name */
    public g f31699h;
    public c.a.p0.k0.c i;
    public NoDataView j;
    public TextView k;
    public TbImageView l;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.f31694c = true;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f31697f);
                if (this.a.f31695d) {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0a2b);
                } else {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0c43);
                }
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b(int i, String str, ArrayList<c.a.p0.k0.a> arrayList, c.a.p0.k0.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, arrayList, bVar, Boolean.valueOf(z)}) == null) {
                this.a.f31695d = z;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f31697f);
                this.a.f31698g.z();
                if (i == 0) {
                    this.a.f31694c = true;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (bVar != null) {
                            this.a.W0(bVar);
                            return;
                        } else {
                            this.a.V0();
                            return;
                        }
                    }
                    this.a.U0();
                    if (z) {
                        this.a.k.setText(R.string.obfuscated_res_0x7f0f0a31);
                    } else {
                        this.a.k.setText(R.string.obfuscated_res_0x7f0f0c43);
                    }
                    this.a.i.h(arrayList);
                    this.a.i.notifyDataSetChanged();
                    return;
                }
                this.a.showToast(str);
                if (!this.a.f31694c) {
                    this.a.V0();
                } else if (z) {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0a2b);
                } else {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0c43);
                }
                this.a.f31694c = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SigleRecordsFragment a;

        public b(SigleRecordsFragment sigleRecordsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sigleRecordsFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f31693b.E();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SigleRecordsFragment a;

        public c(SigleRecordsFragment sigleRecordsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sigleRecordsFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f31693b.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.k0.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SigleRecordsFragment f31700b;

        public d(SigleRecordsFragment sigleRecordsFragment, c.a.p0.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31700b = sigleRecordsFragment;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f31700b.getPageContext(), new String[]{this.a.b()});
            }
        }
    }

    public SigleRecordsFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31694c = false;
        this.f31695d = false;
        this.f31699h = null;
    }

    public final void Q0() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdListView = this.f31698g) == null) {
            return;
        }
        bdListView.setVisibility(8);
    }

    public final void R0() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void S0() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbImageView = this.l) == null) {
            return;
        }
        this.f31697f.removeView(tbImageView);
    }

    public void T0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f31696e = i;
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            R0();
            S0();
            BdListView bdListView = this.f31698g;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.f31696e;
            int i2 = i != 1 ? i != 2 ? i != 3 ? R.string.obfuscated_res_0x7f0f0c57 : R.string.obfuscated_res_0x7f0f0c55 : R.string.obfuscated_res_0x7f0f0c3f : R.string.obfuscated_res_0x7f0f0c34;
            if (this.j == null) {
                this.j = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f31697f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070297)), NoDataViewFactory.e.a(i2), null);
            }
            this.j.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
            this.j.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            S0();
            Q0();
            this.j.setVisibility(0);
        }
    }

    public final void W0(c.a.p0.k0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null || this.f31697f == null) {
            return;
        }
        if (this.l == null) {
            this.l = new TbImageView(getActivity());
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.l.J(bVar.a(), 10, false);
        this.l.setVisibility(0);
        this.l.setOnClickListener(new d(this, bVar));
        Q0();
        R0();
        this.f31697f.addView(this.l);
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31696e : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            LinearLayout linearLayout = this.f31697f;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.k;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0108);
            }
            g gVar = this.f31699h;
            if (gVar != null) {
                gVar.H(i);
            }
            if (this.i != null && (bdListView = this.f31698g) != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
                this.i.notifyDataSetChanged();
            }
            NoDataView noDataView = this.j;
            if (noDataView == null || noDataView.getVisibility() != 0) {
                return;
            }
            this.j.f(this.a.getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = (ConsumptionRecordsActivity) getBaseFragmentActivity();
            ConsumptionRecordsModel consumptionRecordsModel = new ConsumptionRecordsModel(getUniqueId());
            this.f31693b = consumptionRecordsModel;
            consumptionRecordsModel.setType(this.f31696e);
            if (this.f31696e == 3) {
                this.f31693b.setShowMember(1);
            } else {
                this.f31693b.setShowMember(0);
            }
            this.f31693b.H(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0782, (ViewGroup) null);
            this.f31697f = linearLayout;
            this.f31698g = (BdListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a22);
            this.f31699h = new g(this.a.getPageContext());
            c.a.p0.k0.c cVar = new c.a.p0.k0.c(this.a.getPageContext(), this.f31696e);
            this.i = cVar;
            this.f31698g.setAdapter((ListAdapter) cVar);
            this.f31698g.setPullRefresh(this.f31699h);
            TextView textView = new TextView(this.a.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070255)));
            this.f31698g.x(textView, 0);
            this.f31699h.f(new b(this));
            this.f31698g.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d052b, (ViewGroup) null);
            this.k = textView2;
            this.f31698g.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f31697f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            ConsumptionRecordsModel consumptionRecordsModel = this.f31693b;
            if (consumptionRecordsModel != null) {
                consumptionRecordsModel.destroy();
            }
            hideLoadingView(this.f31697f);
            this.f31698g.z();
            this.f31699h = null;
            this.j = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (this.f31694c) {
                return;
            }
            this.f31693b.E();
            showLoadingView(this.f31697f, true, 400);
        }
    }
}
