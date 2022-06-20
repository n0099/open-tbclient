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
import com.repackage.ot4;
import com.repackage.pi;
import com.repackage.pt4;
import com.repackage.qy5;
import com.repackage.ry5;
import com.repackage.sy5;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class SigleRecordsFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConsumptionRecordsActivity a;
    public ConsumptionRecordsModel b;
    public boolean c;
    public boolean d;
    public int e;
    public LinearLayout f;
    public BdListView g;
    public pt4 h;
    public sy5 i;
    public NoDataView j;
    public TextView k;
    public TbImageView l;

    /* loaded from: classes3.dex */
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
                this.a.c = true;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f);
                if (this.a.d) {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0a3c);
                } else {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0c67);
                }
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b(int i, String str, ArrayList<qy5> arrayList, ry5 ry5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, arrayList, ry5Var, Boolean.valueOf(z)}) == null) {
                this.a.d = z;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f);
                this.a.g.z();
                if (i == 0) {
                    this.a.c = true;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (ry5Var != null) {
                            this.a.M1(ry5Var);
                            return;
                        } else {
                            this.a.L1();
                            return;
                        }
                    }
                    this.a.K1();
                    if (z) {
                        this.a.k.setText(R.string.obfuscated_res_0x7f0f0a43);
                    } else {
                        this.a.k.setText(R.string.obfuscated_res_0x7f0f0c67);
                    }
                    this.a.i.h(arrayList);
                    this.a.i.notifyDataSetChanged();
                    return;
                }
                this.a.showToast(str);
                if (!this.a.c) {
                    this.a.L1();
                } else if (z) {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0a3c);
                } else {
                    this.a.k.setText(R.string.obfuscated_res_0x7f0f0c67);
                }
                this.a.c = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ot4.g {
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

        @Override // com.repackage.ot4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.b.F();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.b.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry5 a;
        public final /* synthetic */ SigleRecordsFragment b;

        public d(SigleRecordsFragment sigleRecordsFragment, ry5 ry5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment, ry5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sigleRecordsFragment;
            this.a = ry5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{this.a.b()});
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
        this.c = false;
        this.d = false;
        this.h = null;
    }

    public final void G1() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdListView = this.g) == null) {
            return;
        }
        bdListView.setVisibility(8);
    }

    public final void H1() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (noDataView = this.j) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void I1() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbImageView = this.l) == null) {
            return;
        }
        this.f.removeView(tbImageView);
    }

    public void J1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.e = i;
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            H1();
            I1();
            BdListView bdListView = this.g;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.e;
            int i2 = i != 1 ? i != 2 ? i != 3 ? R.string.obfuscated_res_0x7f0f0c7d : R.string.obfuscated_res_0x7f0f0c7b : R.string.obfuscated_res_0x7f0f0c62 : R.string.obfuscated_res_0x7f0f0c57;
            if (this.j == null) {
                this.j = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, pi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.a(i2), null);
            }
            this.j.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
            this.j.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            I1();
            G1();
            this.j.setVisibility(0);
        }
    }

    public final void M1(ry5 ry5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ry5Var) == null) || ry5Var == null || this.f == null) {
            return;
        }
        if (this.l == null) {
            this.l = new TbImageView(getActivity());
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.l.J(ry5Var.a(), 10, false);
        this.l.setVisibility(0);
        this.l.setOnClickListener(new d(this, ry5Var));
        G1();
        H1();
        this.f.addView(this.l);
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.k;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0108);
            }
            pt4 pt4Var = this.h;
            if (pt4Var != null) {
                pt4Var.H(i);
            }
            if (this.i != null && (bdListView = this.g) != null) {
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
            this.b = consumptionRecordsModel;
            consumptionRecordsModel.setType(this.e);
            if (this.e == 3) {
                this.b.setShowMember(1);
            } else {
                this.b.setShowMember(0);
            }
            this.b.I(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0763, (ViewGroup) null);
            this.f = linearLayout;
            this.g = (BdListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a0d);
            this.h = new pt4(this.a.getPageContext());
            sy5 sy5Var = new sy5(this.a.getPageContext(), this.e);
            this.i = sy5Var;
            this.g.setAdapter((ListAdapter) sy5Var);
            this.g.setPullRefresh(this.h);
            TextView textView = new TextView(this.a.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + pi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070260)));
            this.g.x(textView, 0);
            this.h.f(new b(this));
            this.g.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d050c, (ViewGroup) null);
            this.k = textView2;
            this.g.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            ConsumptionRecordsModel consumptionRecordsModel = this.b;
            if (consumptionRecordsModel != null) {
                consumptionRecordsModel.destroy();
            }
            hideLoadingView(this.f);
            this.g.z();
            this.h = null;
            this.j = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (this.c) {
                return;
            }
            this.b.F();
            showLoadingView(this.f, true, 400);
        }
    }
}
