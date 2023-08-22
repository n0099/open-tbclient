package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final qia b;
    public us6 c;
    public us6 d;
    public us6 e;

    public cja(MainTabActivity mainTabActivity, qia qiaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, qiaVar};
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
        this.b = qiaVar;
    }

    public void a() {
        us6 us6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (us6Var = this.e) != null && us6Var.i()) {
            this.e.h();
        }
    }

    public void b() {
        us6 us6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (us6Var = this.d) != null && us6Var.i()) {
            this.d.h();
            this.d = null;
        }
    }

    public void c() {
        us6 us6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (us6Var = this.c) != null && us6Var.i()) {
            this.c.h();
            this.c = null;
        }
    }

    public void d() {
        qia qiaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (qiaVar = this.b) != null && qiaVar.A() != null) {
            FragmentTabWidget fragmentTabWidget = this.b.A().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            us6 us6Var = new us6(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
            this.e = us6Var;
            us6Var.L(R.drawable.bg_tip_blue_down);
            this.e.l(2);
            this.e.o(32);
            this.e.N(true);
            this.e.R(-BdUtilHelper.getDimens(this.a, R.dimen.tbds10));
            this.e.C(R.color.CAM_X0101);
            this.e.p(R.dimen.tbds54);
            this.e.w(1);
            this.e.n(4000);
            this.e.F(BdUtilHelper.getDimens(this.a, R.dimen.tbds44));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            FragmentTabWidget fragmentTabWidget = this.b.A().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            us6 us6Var = new us6(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.c = us6Var;
            us6Var.L(R.drawable.bg_tip_blue_down);
            this.c.l(2);
            this.c.o(32);
            this.c.N(true);
            this.c.R(-BdUtilHelper.getDimens(this.a, R.dimen.tbds10));
            this.c.C(R.color.CAM_X0101);
            this.c.p(R.dimen.tbds54);
            this.c.w(999);
            this.c.n(5000);
            this.c.F(BdUtilHelper.getDimens(this.a, R.dimen.tbds44));
            this.c.V(str, "categoryUpdate", false, true);
        }
    }

    public void f() {
        us6 us6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (us6Var = this.e) != null && !us6Var.i()) {
            us6 us6Var2 = this.e;
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f067a);
            us6Var2.T(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }
}
