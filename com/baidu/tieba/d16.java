package com.baidu.tieba;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d16 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public e16 b;
    public BaseFragmentActivity c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947651744, "Lcom/baidu/tieba/d16;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947651744, "Lcom/baidu/tieba/d16;");
        }
    }

    public d16(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.c = baseFragmentActivity;
    }

    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (rqa.a(this.c.getIntent())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            }
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
        }
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && intent != null) {
            if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("class", 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
                intent2.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
            }
            TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
        }
    }

    public void c(Configuration configuration) {
        e16 e16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) && (e16Var = this.b) != null) {
            e16Var.d(configuration);
        }
    }

    public void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.a = System.currentTimeMillis();
            if ("MuMu".equals(DeviceInfoHelper.getModel()) && "6.0.1".equals(DeviceInfoHelper.getOsVersion())) {
                this.c.finish();
                return;
            }
            b(bundle);
            if (!rqa.a(this.c.getIntent()) && (rqa.b(this.c.getIntent()) || this.c.isTaskRoot() || this.c.getIntent().getBooleanExtra(LogoActivityConfig.IS_DEAL_INTENT, false))) {
                a(this.c.getIntent());
            }
            pua.g().i(this.c.getUniqueId());
            e16 e16Var = new e16(this.c);
            this.b = e16Var;
            e16Var.i(d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pua.g().k(this.c.getUniqueId());
            d = false;
            e16 e16Var = this.b;
            if (e16Var != null) {
                e16Var.g();
            }
        }
    }

    public void f() {
        e16 e16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (e16Var = this.b) != null) {
            e16Var.e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (LogoActivityConfig.isFirst && this.a >= 0) {
                vp5.a().u(System.currentTimeMillis() - this.a);
            }
            e16 e16Var = this.b;
            if (e16Var != null) {
                e16Var.f();
            }
        }
    }
}
