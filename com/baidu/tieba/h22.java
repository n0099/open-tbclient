package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h22 extends g22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CalcMD5Api" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h22 c;

        public a(h22 h22Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h22Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                byte[] bytes = this.a.getBytes(StandardCharsets.UTF_8);
                if (bytes.length > 3145728) {
                    this.c.d(this.b, new h32(202, "Data Too Large."));
                    return;
                }
                String d = nr4.d(bytes, false);
                if (TextUtils.isEmpty(d)) {
                    this.c.d(this.b, new h32(1001, "Execute Fail."));
                    return;
                }
                h32 h32Var = new h32(0);
                h32Var.g("result", d);
                this.c.d(this.b, h32Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h22(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#calcMD5", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return new h32(202, "Empty Data.");
            }
            bo3.k(new a(this, optString, jSONObject.optString("cb")), "CalcMD5Api");
            return h32.f();
        }
        return (h32) invokeL.objValue;
    }
}
