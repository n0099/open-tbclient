package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final se9 b;
    public ch6 c;
    public ch6 d;
    public ch6 e;

    public bf9(MainTabActivity mainTabActivity, se9 se9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, se9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = se9Var;
    }

    public void a() {
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ch6Var = this.e) != null && ch6Var.e()) {
            this.e.d();
        }
    }

    public void b() {
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ch6Var = this.d) != null && ch6Var.e()) {
            this.d.d();
            this.d = null;
        }
    }

    public void c() {
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ch6Var = this.c) != null && ch6Var.e()) {
            this.c.d();
            this.c = null;
        }
    }

    public void d() {
        se9 se9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (se9Var = this.b) != null && se9Var.y() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            ch6 ch6Var = new ch6(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = ch6Var;
            ch6Var.C(R.drawable.bg_tip_blue_down);
            this.e.h(2);
            this.e.k(32);
            this.e.E(true);
            this.e.I(-hi.g(this.a, R.dimen.tbds10));
            this.e.t(R.color.CAM_X0101);
            this.e.l(R.dimen.tbds54);
            this.e.p(1);
            this.e.j(4000);
            this.e.w(hi.g(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            ch6 ch6Var = new ch6(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = ch6Var;
            ch6Var.C(R.drawable.bg_tip_blue_down);
            this.c.h(2);
            this.c.k(32);
            this.c.E(true);
            this.c.I(-hi.g(this.a, R.dimen.tbds10));
            this.c.t(R.color.CAM_X0101);
            this.c.l(R.dimen.tbds54);
            this.c.p(999);
            this.c.j(5000);
            this.c.w(hi.g(this.a, R.dimen.tbds44));
            this.c.M(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ch6Var = this.e) != null && !ch6Var.e()) {
            ch6 ch6Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f05c3);
            ch6Var2.K(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
