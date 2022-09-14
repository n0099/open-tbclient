package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fv3 implements to1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ev3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777542, "Lcom/baidu/tieba/fv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777542, "Lcom/baidu/tieba/fv3;");
                return;
            }
        }
        b = ij1.a;
    }

    public fv3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        c();
    }

    @Override // com.baidu.tieba.to1
    public yu1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull cg2 cg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, cg2Var)) == null) ? b(str, jSONObject, cg2Var) : (yu1) invokeLLL.objValue;
    }

    public final yu1 b(String str, JSONObject jSONObject, cg2 cg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, cg2Var)) == null) {
            ev3 ev3Var = this.a.get(str);
            if (ev3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return ev3Var.a(jSONObject, cg2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new yu1(10002, "no such api.");
        }
        return (yu1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new cv3());
            d(new dv3());
            d(new au3());
            d(new eu3());
            d(new bu3());
            d(new tv3());
            d(new cu3());
            d(new jv3());
            d(new qv3());
            d(new zt3());
            d(new gu3());
            d(new du3());
            d(new fu3());
            d(new mv3());
            d(new sv3());
            d(new nv3());
            d(new pv3());
            d(new ov3());
        }
    }

    public void d(ev3 ev3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ev3Var) == null) {
            if (b && TextUtils.isEmpty(ev3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(ev3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + ev3Var);
            }
            this.a.put(ev3Var.a, ev3Var);
        }
    }
}
