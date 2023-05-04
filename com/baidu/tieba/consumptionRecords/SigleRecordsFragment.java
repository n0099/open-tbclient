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
import com.baidu.tieba.el6;
import com.baidu.tieba.fl6;
import com.baidu.tieba.gl6;
import com.baidu.tieba.ii;
import com.baidu.tieba.p55;
import com.baidu.tieba.q55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
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
    public q55 h;
    public gl6 i;
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.c = true;
            SigleRecordsFragment sigleRecordsFragment = this.a;
            sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f);
            if (this.a.d) {
                this.a.k.setText(R.string.load_more);
            } else {
                this.a.k.setText(R.string.no_more_data);
            }
        }

        @Override // com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.b
        public void b(int i, String str, ArrayList<el6> arrayList, fl6 fl6Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, arrayList, fl6Var, Boolean.valueOf(z)}) == null) {
                this.a.d = z;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f);
                this.a.g.y();
                if (i == 0) {
                    this.a.c = true;
                    if (arrayList != null && arrayList.size() > 0) {
                        this.a.X1();
                        if (z) {
                            this.a.k.setText(R.string.loading_more_now);
                        } else {
                            this.a.k.setText(R.string.no_more_data);
                        }
                        this.a.i.h(arrayList);
                        this.a.i.notifyDataSetChanged();
                        return;
                    } else if (fl6Var == null) {
                        this.a.Y1();
                        return;
                    } else {
                        this.a.Z1(fl6Var);
                        return;
                    }
                }
                this.a.showToast(str);
                if (!this.a.c) {
                    this.a.Y1();
                } else if (z) {
                    this.a.k.setText(R.string.load_more);
                } else {
                    this.a.k.setText(R.string.no_more_data);
                }
                this.a.c = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements p55.g {
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

        @Override // com.baidu.tieba.p55.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.b.b0();
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
                this.a.b.c0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl6 a;
        public final /* synthetic */ SigleRecordsFragment b;

        public d(SigleRecordsFragment sigleRecordsFragment, fl6 fl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment, fl6Var};
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
            this.a = fl6Var;
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

    public final void T1() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bdListView = this.g) != null) {
            bdListView.setVisibility(8);
        }
    }

    public final void U1() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (noDataView = this.j) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void V1() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tbImageView = this.l) != null) {
            this.f.removeView(tbImageView);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            U1();
            V1();
            BdListView bdListView = this.g;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
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
            this.g.y();
            this.h = null;
            this.j = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            if (!this.c) {
                this.b.b0();
                showLoadingView(this.f, true, 400);
            }
        }
    }

    public void W1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.e = i;
        }
    }

    public final void Y1() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = R.string.obfuscated_res_0x7f0f0d7c;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0d7a;
                    }
                } else {
                    i = R.string.obfuscated_res_0x7f0f0d61;
                }
            } else {
                i = R.string.obfuscated_res_0x7f0f0d56;
            }
            if (this.j == null) {
                this.j = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ii.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07029f)), NoDataViewFactory.e.a(i), null);
            }
            this.j.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i)));
            this.j.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            V1();
            T1();
            this.j.setVisibility(0);
        }
    }

    public final void Z1(fl6 fl6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, fl6Var) == null) && fl6Var != null && this.f != null) {
            if (this.l == null) {
                this.l = new TbImageView(getActivity());
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.l.N(fl6Var.a(), 10, false);
            this.l.setVisibility(0);
            this.l.setOnClickListener(new d(this, fl6Var));
            T1();
            U1();
            this.f.addView(this.l);
        }
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
            q55 q55Var = this.h;
            if (q55Var != null) {
                q55Var.H(i);
            }
            if (this.i != null && (bdListView = this.g) != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204);
                this.i.notifyDataSetChanged();
            }
            NoDataView noDataView = this.j;
            if (noDataView != null && noDataView.getVisibility() == 0) {
                this.j.f(this.a.getPageContext(), i);
            }
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
            this.b.e0(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d083a, (ViewGroup) null);
            this.f = linearLayout;
            this.g = (BdListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091d5a);
            this.h = new q55(this.a.getPageContext());
            gl6 gl6Var = new gl6(this.a.getPageContext(), this.e);
            this.i = gl6Var;
            this.g.setAdapter((ListAdapter) gl6Var);
            this.g.setPullRefresh(this.h);
            TextView textView = new TextView(this.a.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ii.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07025e)));
            this.g.w(textView, 0);
            this.h.f(new b(this));
            this.g.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05ad, (ViewGroup) null);
            this.k = textView2;
            this.g.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }
}
