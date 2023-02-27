package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.ne4;
import com.baidu.tieba.xe4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cf4 extends yd4<wv2> implements xe4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vv2 a;
    public wv2 b;

    /* loaded from: classes3.dex */
    public class a implements ne4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cf4 c;

        public a(cf4 cf4Var, vv2 vv2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf4Var, vv2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cf4Var;
            this.a = vv2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.ne4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m62.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ne4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m62.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947672824, "Lcom/baidu/tieba/cf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947672824, "Lcom/baidu/tieba/cf4;");
                return;
            }
        }
        boolean z = wp1.a;
    }

    public cf4() {
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

    public static cf4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new cf4();
        }
        return (cf4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xe4 b3 = xe4.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.xe4.b
    public void onCancel() {
        wv2 wv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            m62.i("map", "choose location cancel");
            vv2 vv2Var = this.a;
            if (vv2Var != null && (wv2Var = this.b) != null) {
                vv2Var.b(wv2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.xe4.b
    public void onError() {
        wv2 wv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            m62.i("map", "choose location fail");
            vv2 vv2Var = this.a;
            if (vv2Var != null && (wv2Var = this.b) != null) {
                vv2Var.b(wv2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.xe4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        vv2 vv2Var;
        wv2 wv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (vv2Var = this.a) != null && (wv2Var = this.b) != null) {
            vv2Var.c(wv2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4
    /* renamed from: f */
    public boolean b(Context context, wv2 wv2Var, vv2 vv2Var, m93 m93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, wv2Var, vv2Var, m93Var, jSONObject)) == null) {
            return e(context, wv2Var, vv2Var, m93Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, wv2 wv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, wv2Var, vv2Var, m93Var)) == null) {
            m62.i("map", "ChooseLocationAction start");
            if (!wv2Var.isValid()) {
                m62.c("map", "model is invalid");
                return false;
            }
            String str = wv2Var.z;
            if (TextUtils.isEmpty(str)) {
                m62.c("map", "cb is empty");
                return false;
            }
            this.a = vv2Var;
            this.b = wv2Var;
            ne4.b(context, new a(this, vv2Var, str));
            m62.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
