package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.n84;
import com.baidu.tieba.x84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c94 extends y74 implements x84.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vp2 a;
    public wp2 b;

    /* loaded from: classes3.dex */
    public class a implements n84.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c94 c;

        public a(c94 c94Var, vp2 vp2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c94Var, vp2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c94Var;
            this.a = vp2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.n84.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m02.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.n84.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m02.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629579, "Lcom/baidu/tieba/c94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629579, "Lcom/baidu/tieba/c94;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public c94() {
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

    public static c94 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new c94();
        }
        return (c94) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x84 b3 = x84.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.x84.b
    public void onCancel() {
        wp2 wp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            m02.i("map", "choose location cancel");
            vp2 vp2Var = this.a;
            if (vp2Var != null && (wp2Var = this.b) != null) {
                vp2Var.b(wp2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.x84.b
    public void onError() {
        wp2 wp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            m02.i("map", "choose location fail");
            vp2 vp2Var = this.a;
            if (vp2Var != null && (wp2Var = this.b) != null) {
                vp2Var.b(wp2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.x84.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        vp2 vp2Var;
        wp2 wp2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (vp2Var = this.a) != null && (wp2Var = this.b) != null) {
            vp2Var.c(wp2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y74
    /* renamed from: f */
    public boolean b(Context context, wp2 wp2Var, vp2 vp2Var, m33 m33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, wp2Var, vp2Var, m33Var, jSONObject)) == null) {
            return e(context, wp2Var, vp2Var, m33Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, wp2 wp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, wp2Var, vp2Var, m33Var)) == null) {
            m02.i("map", "ChooseLocationAction start");
            if (!wp2Var.isValid()) {
                m02.c("map", "model is invalid");
                return false;
            }
            String str = wp2Var.z;
            if (TextUtils.isEmpty(str)) {
                m02.c("map", "cb is empty");
                return false;
            }
            this.a = vp2Var;
            this.b = wp2Var;
            n84.b(context, new a(this, vp2Var, str));
            m02.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
