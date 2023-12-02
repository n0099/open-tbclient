package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.lb4;
import com.baidu.tieba.vb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ac4 extends wa4<us2> implements vb4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ts2 a;
    public us2 b;

    /* loaded from: classes5.dex */
    public class a implements lb4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ac4 c;

        public a(ac4 ac4Var, ts2 ts2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac4Var, ts2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ac4Var;
            this.a = ts2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.lb4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k32.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.lb4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                k32.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947610359, "Lcom/baidu/tieba/ac4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947610359, "Lcom/baidu/tieba/ac4;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public ac4() {
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

    public static ac4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new ac4();
        }
        return (ac4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            vb4 i3 = vb4.i3(null);
            i3.n3(this);
            i3.p3();
        }
    }

    @Override // com.baidu.tieba.vb4.b
    public void onCancel() {
        us2 us2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k32.i("map", "choose location cancel");
            ts2 ts2Var = this.a;
            if (ts2Var != null && (us2Var = this.b) != null) {
                ts2Var.b(us2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.vb4.b
    public void onError() {
        us2 us2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k32.i("map", "choose location fail");
            ts2 ts2Var = this.a;
            if (ts2Var != null && (us2Var = this.b) != null) {
                ts2Var.b(us2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.vb4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        ts2 ts2Var;
        us2 us2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (ts2Var = this.a) != null && (us2Var = this.b) != null) {
            ts2Var.c(us2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wa4
    /* renamed from: f */
    public boolean b(Context context, us2 us2Var, ts2 ts2Var, k63 k63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, us2Var, ts2Var, k63Var, jSONObject)) == null) {
            return e(context, us2Var, ts2Var, k63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, us2 us2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, us2Var, ts2Var, k63Var)) == null) {
            k32.i("map", "ChooseLocationAction start");
            if (!us2Var.isValid()) {
                k32.c("map", "model is invalid");
                return false;
            }
            String str = us2Var.z;
            if (TextUtils.isEmpty(str)) {
                k32.c("map", "cb is empty");
                return false;
            }
            this.a = ts2Var;
            this.b = us2Var;
            lb4.b(context, new a(this, ts2Var, str));
            k32.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
