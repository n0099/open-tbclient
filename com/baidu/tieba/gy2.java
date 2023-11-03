package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gy2 extends fy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;

    @Override // com.baidu.tieba.fy2
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "payinfo" : (String) invokeV.objValue;
    }

    public gy2() {
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
        this.a = "SwanAppPayCheckNode";
    }

    @Override // com.baidu.tieba.fy2
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b) {
            Log.d(this.a, "onFail: ");
        }
    }

    @Override // com.baidu.tieba.fy2
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b) {
            Log.d(this.a, "onFiltered: ");
        }
    }

    @Override // com.baidu.tieba.fy2
    public void d(String str, JSONObject jSONObject, String str2) {
        g63 c0;
        pa3 f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            if (this.b) {
                Log.d(this.a, "onUpdate: ");
            }
            if (jSONObject != null && (c0 = g63.c0()) != null && (f0 = c0.f0()) != null) {
                f0.B("note_data_pay_check_list", jSONObject.toString());
            }
        }
    }
}
