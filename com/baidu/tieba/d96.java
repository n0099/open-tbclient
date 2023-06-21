package com.baidu.tieba;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes5.dex */
public class d96 implements ww1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    @Override // com.baidu.tieba.ww1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ww1
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ww1
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a061" : (String) invokeV.objValue;
    }

    public yr5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (yr5) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659432, "Lcom/baidu/tieba/d96;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659432, "Lcom/baidu/tieba/d96;");
                return;
            }
        }
        b = js1.a;
    }

    public d96() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("a001");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppBackground");
            }
            long r = o95.p().r("smart_app_tid", 0L);
            String w = o95.p().w("smart_app_id", "");
            String w2 = o95.p().w("smart_app_name", "");
            if (this.a != 0 && r != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                as5 as5Var = new as5();
                as5Var.y(currentTimeMillis);
                as5Var.s(g());
                as5Var.C(r);
                as5Var.i = w;
                as5Var.j = w2;
                as5Var.x(h());
                bs5.b().j(true);
                bs5.b().k(TbadkApplication.getInst().getApplicationContext(), as5Var, i());
                o95.p().H("smart_app_tid", 0L);
            }
        }
    }

    @Override // com.baidu.tieba.ww1
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppForeground" + zb3.M().b);
            }
            File file = new File(om.b("libBaiduMapSDK.so"));
            if (file.exists() && file.isFile() && BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK.so") == null && qm.a(BdBaseApplication.getInst().getContext(), om.a("libBaiduMapSDK.so"))) {
                try {
                    System.loadLibrary("BaiduMapSDK");
                } catch (Throwable unused) {
                }
                BdBaseApplication.getInst().getResHashMap().put("libBaiduMapSDK.so", om.a("libBaiduMapSDK.so"));
            }
            this.a = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.ww1
    public void d(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable ww2 ww2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i, ww2Var) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppExit");
            }
            if (o95.p().l("key_ai_app_guide_display", true)) {
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra("class", 38);
                swanAppActivity.startService(intent);
            }
        }
    }
}
