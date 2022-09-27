package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.m84;
import com.baidu.tieba.w84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b94 extends x74<vp2> implements w84.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public up2 a;
    public vp2 b;

    /* loaded from: classes3.dex */
    public class a implements m84.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ up2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ b94 c;

        public a(b94 b94Var, up2 up2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b94Var, up2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b94Var;
            this.a = up2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.m84.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l02.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.m84.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l02.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947599788, "Lcom/baidu/tieba/b94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947599788, "Lcom/baidu/tieba/b94;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    public b94() {
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

    public static b94 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new b94() : (b94) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w84.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        up2 up2Var;
        vp2 vp2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (up2Var = this.a) == null || (vp2Var = this.b) == null) {
            return;
        }
        up2Var.c(vp2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, vp2 vp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, vp2Var, up2Var, l33Var)) == null) {
            l02.i("map", "ChooseLocationAction start");
            if (!vp2Var.isValid()) {
                l02.c("map", "model is invalid");
                return false;
            }
            String str = vp2Var.z;
            if (TextUtils.isEmpty(str)) {
                l02.c("map", "cb is empty");
                return false;
            }
            this.a = up2Var;
            this.b = vp2Var;
            m84.b(context, new a(this, up2Var, str));
            l02.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x74
    /* renamed from: f */
    public boolean b(Context context, vp2 vp2Var, up2 up2Var, l33 l33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, vp2Var, up2Var, l33Var, jSONObject)) == null) ? e(context, vp2Var, up2Var, l33Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w84 b3 = w84.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.w84.b
    public void onCancel() {
        vp2 vp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l02.i("map", "choose location cancel");
            up2 up2Var = this.a;
            if (up2Var == null || (vp2Var = this.b) == null) {
                return;
            }
            up2Var.b(vp2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.tieba.w84.b
    public void onError() {
        vp2 vp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l02.i("map", "choose location fail");
            up2 up2Var = this.a;
            if (up2Var == null || (vp2Var = this.b) == null) {
                return;
            }
            up2Var.b(vp2Var.z, 1007, "choose location failed");
        }
    }
}
