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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.do6;
import com.baidu.tieba.eo6;
import com.baidu.tieba.fo6;
import com.baidu.tieba.l45;
import com.baidu.tieba.m45;
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
    public ConsumptionRecordsModel b;
    public boolean c;
    public boolean d;
    public int e;
    public LinearLayout f;
    public BdListView g;
    public m45 h;
    public fo6 i;
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
        public void b(int i, String str, ArrayList<do6> arrayList, eo6 eo6Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, arrayList, eo6Var, Boolean.valueOf(z)}) == null) {
                this.a.d = z;
                SigleRecordsFragment sigleRecordsFragment = this.a;
                sigleRecordsFragment.hideLoadingView(sigleRecordsFragment.f);
                this.a.g.y();
                if (i == 0) {
                    this.a.c = true;
                    if (arrayList != null && arrayList.size() > 0) {
                        this.a.u2();
                        if (z) {
                            this.a.k.setText(R.string.loading_more_now);
                        } else {
                            this.a.k.setText(R.string.no_more_data);
                        }
                        this.a.i.h(arrayList);
                        this.a.i.notifyDataSetChanged();
                        return;
                    } else if (eo6Var == null) {
                        this.a.v2();
                        return;
                    } else {
                        this.a.w2(eo6Var);
                        return;
                    }
                }
                this.a.showToast(str);
                if (!this.a.c) {
                    this.a.v2();
                } else if (z) {
                    this.a.k.setText(R.string.load_more);
                } else {
                    this.a.k.setText(R.string.no_more_data);
                }
                this.a.c = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l45.g {
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

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.b.T();
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
                this.a.b.U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo6 a;
        public final /* synthetic */ SigleRecordsFragment b;

        public d(SigleRecordsFragment sigleRecordsFragment, eo6 eo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sigleRecordsFragment, eo6Var};
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
            this.a = eo6Var;
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrimary();
            if (!this.c) {
                this.b.T();
                showLoadingView(this.f, true, 400);
            }
        }
    }

    public final void q2() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bdListView = this.g) != null) {
            bdListView.setVisibility(8);
        }
    }

    public final void r2() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (noDataView = this.j) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void s2() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (tbImageView = this.l) != null) {
            this.f.removeView(tbImageView);
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            r2();
            s2();
            BdListView bdListView = this.g;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
        }
    }

    public void t2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0201);
            }
            TextView textView = this.k;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0108);
            }
            m45 m45Var = this.h;
            if (m45Var != null) {
                m45Var.D(i);
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
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
            this.b.W(new a(this));
        }
    }

    public final void w2(eo6 eo6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, eo6Var) == null) && eo6Var != null && this.f != null) {
            if (this.l == null) {
                this.l = new TbImageView(getActivity());
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.l.startLoad(eo6Var.a(), 10, false);
            this.l.setVisibility(0);
            this.l.setOnClickListener(new d(this, eo6Var));
            q2();
            r2();
            this.f.addView(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08c3, (ViewGroup) null);
            this.f = linearLayout;
            this.g = (BdListView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091eb9);
            this.h = new m45(this.a.getPageContext());
            fo6 fo6Var = new fo6(this.a.getPageContext(), this.e);
            this.i = fo6Var;
            this.g.setAdapter((ListAdapter) fo6Var);
            this.g.setPullRefresh(this.h);
            TextView textView = new TextView(this.a.getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070383)));
            this.g.w(textView, 0);
            this.h.a(new b(this));
            this.g.setOnSrollToBottomListener(new c(this));
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05f4, (ViewGroup) null);
            this.k = textView2;
            this.g.addFooterView(textView2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    public final void v2() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i2 = this.e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = R.string.obfuscated_res_0x7f0f0e9d;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0e9b;
                    }
                } else {
                    i = R.string.obfuscated_res_0x7f0f0e82;
                }
            } else {
                i = R.string.obfuscated_res_0x7f0f0e77;
            }
            if (this.j == null) {
                this.j = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0703bc)), NoDataViewFactory.e.a(i), null);
            }
            this.j.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i)));
            this.j.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            s2();
            q2();
            this.j.setVisibility(0);
        }
    }
}
