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
public class ap9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final ro9 b;
    public bk6 c;
    public bk6 d;
    public bk6 e;

    public ap9(MainTabActivity mainTabActivity, ro9 ro9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ro9Var};
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
        this.b = ro9Var;
    }

    public void a() {
        bk6 bk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bk6Var = this.e) != null && bk6Var.e()) {
            this.e.d();
        }
    }

    public void b() {
        bk6 bk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bk6Var = this.d) != null && bk6Var.e()) {
            this.d.d();
            this.d = null;
        }
    }

    public void c() {
        bk6 bk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bk6Var = this.c) != null && bk6Var.e()) {
            this.c.d();
            this.c = null;
        }
    }

    public void d() {
        ro9 ro9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ro9Var = this.b) != null && ro9Var.y() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            bk6 bk6Var = new bk6(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = bk6Var;
            bk6Var.C(R.drawable.bg_tip_blue_down);
            this.e.h(2);
            this.e.k(32);
            this.e.E(true);
            this.e.I(-ii.g(this.a, R.dimen.tbds10));
            this.e.t(R.color.CAM_X0101);
            this.e.l(R.dimen.tbds54);
            this.e.p(1);
            this.e.j(4000);
            this.e.w(ii.g(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.y().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            bk6 bk6Var = new bk6(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = bk6Var;
            bk6Var.C(R.drawable.bg_tip_blue_down);
            this.c.h(2);
            this.c.k(32);
            this.c.E(true);
            this.c.I(-ii.g(this.a, R.dimen.tbds10));
            this.c.t(R.color.CAM_X0101);
            this.c.l(R.dimen.tbds54);
            this.c.p(999);
            this.c.j(5000);
            this.c.w(ii.g(this.a, R.dimen.tbds44));
            this.c.M(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        bk6 bk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bk6Var = this.e) != null && !bk6Var.e()) {
            bk6 bk6Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f05bd);
            bk6Var2.K(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
