package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h02 extends d02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "OpenIdApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements rq3<bh3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h02 b;

        public a(h02 h02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h02Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<JSONObject> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                y32 y32Var = new y32();
                String z = this.b.z(bh3Var);
                if (TextUtils.isEmpty(z)) {
                    y32Var.b = 1001;
                    y32Var.c = "openid is empty";
                    this.b.d(this.a, y32Var);
                    return;
                }
                y32Var.g("openid", z);
                y32Var.b = 0;
                this.b.d(this.a, y32Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947769823, "Lcom/baidu/tieba/h02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947769823, "Lcom/baidu/tieba/h02;");
                return;
            }
        }
        f = is1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h02(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public y32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getOpenId", false);
            if (f) {
                Log.d("OpenIdApi", "#getOpenId params = " + str);
            }
            Pair<y32, JSONObject> s = s(str);
            if (!((y32) s.first).isSuccess()) {
                return (y32) s.first;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new y32(202, "cb is empty");
            }
            fh3 f2 = xb3.K().x().a().b().f(xb3.K());
            f2.o(new a(this, optString));
            f2.call();
            return y32.f();
        }
        return (y32) invokeL.objValue;
    }

    public final String z(bh3<JSONObject> bh3Var) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bh3Var)) == null) {
            if (bh3Var.c() && (jSONObject = bh3Var.a) != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                return optJSONObject.optString("openid");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
