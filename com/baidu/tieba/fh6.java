package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.uy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class fh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public BdTypeListView e;
    public vy4 f;
    public NoNetworkView g;
    public eh6 h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh6 a;

        public a(fh6 fh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    public fh6(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseActivity;
        baseActivity.setContentView(R.layout.obfuscated_res_0x7f0d02bb);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f09007a);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f092604);
        this.d = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f06ed)).setOnClickListener(new a(this));
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.setNetRefreshViewTopMargin(BdListViewHelper.a);
        this.g = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f092606);
        this.e = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f090aa9);
        vy4 vy4Var = new vy4(this.a.getPageContext());
        this.f = vy4Var;
        vy4Var.b0(this.a.getUniqueId());
        BaseActivity baseActivity2 = this.a;
        if (baseActivity2 instanceof uy4.g) {
            this.f.f((uy4.g) baseActivity2);
        }
        BaseActivity baseActivity3 = this.a;
        if (baseActivity3 instanceof BdListView.p) {
            this.e.setOnSrollToBottomListener((BdListView.p) baseActivity3);
        }
        this.e.setPullRefresh(this.f);
        this.c = BdListViewHelper.d(this.a.getPageContext().getPageActivity(), this.e, BdListViewHelper.HeadType.DEFAULT);
        eh6 eh6Var = new eh6(this.a, this.e);
        this.h = eh6Var;
        this.e.a(eh6Var.a());
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            BdListViewHelper.c(this.c, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void f(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || list == null) {
            return;
        }
        this.e.setData(list);
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d.onChangeSkinType(this.a.getPageContext(), i);
            this.g.d(this.a.getPageContext(), i);
            g();
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) != null) || bVar == null) {
            return;
        }
        this.g.a(bVar);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.e.setVisibility(8);
            this.a.showNetRefreshView(this.b, str, true);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.A(0L);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.setVisibility(0);
            this.a.hideLoadingView(this.b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.setVisibility(0);
            this.a.hideNetRefreshView(this.b);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h.b();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h.c();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.setVisibility(8);
            this.a.showLoadingView(this.b, true);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.F();
        }
    }
}
