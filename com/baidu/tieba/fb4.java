package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.ab4;
import com.baidu.tieba.qa4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fb4 extends ba4<zr2> implements ab4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yr2 a;
    public zr2 b;

    /* loaded from: classes5.dex */
    public class a implements qa4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fb4 c;

        public a(fb4 fb4Var, yr2 yr2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb4Var, yr2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fb4Var;
            this.a = yr2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.qa4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p22.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.qa4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                p22.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947758353, "Lcom/baidu/tieba/fb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947758353, "Lcom/baidu/tieba/fb4;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public fb4() {
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

    public static fb4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new fb4();
        }
        return (fb4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ab4 i3 = ab4.i3(null);
            i3.n3(this);
            i3.p3();
        }
    }

    @Override // com.baidu.tieba.ab4.b
    public void onCancel() {
        zr2 zr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            p22.i("map", "choose location cancel");
            yr2 yr2Var = this.a;
            if (yr2Var != null && (zr2Var = this.b) != null) {
                yr2Var.b(zr2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.ab4.b
    public void onError() {
        zr2 zr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            p22.i("map", "choose location fail");
            yr2 yr2Var = this.a;
            if (yr2Var != null && (zr2Var = this.b) != null) {
                yr2Var.b(zr2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.ab4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        yr2 yr2Var;
        zr2 zr2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (yr2Var = this.a) != null && (zr2Var = this.b) != null) {
            yr2Var.c(zr2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ba4
    /* renamed from: f */
    public boolean b(Context context, zr2 zr2Var, yr2 yr2Var, p53 p53Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, zr2Var, yr2Var, p53Var, jSONObject)) == null) {
            return e(context, zr2Var, yr2Var, p53Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, zr2 zr2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, zr2Var, yr2Var, p53Var)) == null) {
            p22.i("map", "ChooseLocationAction start");
            if (!zr2Var.isValid()) {
                p22.c("map", "model is invalid");
                return false;
            }
            String str = zr2Var.z;
            if (TextUtils.isEmpty(str)) {
                p22.c("map", "cb is empty");
                return false;
            }
            this.a = yr2Var;
            this.b = zr2Var;
            qa4.b(context, new a(this, yr2Var, str));
            p22.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
