package com.baidu.tieba;

import android.content.Intent;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class es5 implements jo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    @Override // com.baidu.tieba.jo1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jo1
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.jo1
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

    public ad5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (ad5) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744930, "Lcom/baidu/tieba/es5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744930, "Lcom/baidu/tieba/es5;");
                return;
            }
        }
        b = wj1.a;
    }

    public es5() {
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

    public List h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("a001");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jo1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppBackground");
            }
            long m = ux4.k().m("smart_app_tid", 0L);
            String q = ux4.k().q("smart_app_id", "");
            String q2 = ux4.k().q("smart_app_name", "");
            if (this.a != 0 && m != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                cd5 cd5Var = new cd5();
                cd5Var.y(currentTimeMillis);
                cd5Var.s(g());
                cd5Var.C(m);
                cd5Var.i = q;
                cd5Var.j = q2;
                cd5Var.x(h());
                dd5.b().j(true);
                dd5.b().k(TbadkApplication.getInst().getApplicationContext(), cd5Var, i());
                ux4.k().x("smart_app_tid", 0L);
            }
        }
    }

    @Override // com.baidu.tieba.jo1
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppForeground" + m33.M().b);
            }
            File file = new File(vm.b("libBaiduMapSDK_map_v5_4_4.so"));
            if (file.exists() && file.isFile() && BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK_map_v5_4_4.so") == null && xm.a(BdBaseApplication.getInst().getContext(), vm.a("libBaiduMapSDK_map_v5_4_4.so"))) {
                BdBaseApplication.getInst().getResHashMap().put("libBaiduMapSDK_map_v5_4_4.so", vm.a("libBaiduMapSDK_map_v5_4_4.so"));
            }
            this.a = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.jo1
    public void d(SwanAppActivity swanAppActivity, int i, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i, jo2Var) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppExit");
            }
            if (ux4.k().h("key_ai_app_guide_display", true)) {
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 38);
                swanAppActivity.startService(intent);
            }
        }
    }
}
