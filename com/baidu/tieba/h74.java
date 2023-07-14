package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements oq3<vg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c42 a;

        public a(c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(vg3 vg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg3Var) == null) {
                if (vg3Var == null || vg3Var.d || vg3Var.j != 1) {
                    h74.c(this.a, false, "system deny");
                } else {
                    h74.c(this.a, true, "authorize:ok");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776612, "Lcom/baidu/tieba/h74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776612, "Lcom/baidu/tieba/h74;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void b(JsObject jsObject) {
        c42 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jsObject) != null) || (F = c42.F(jsObject)) == null) {
            return;
        }
        vb3 b0 = vb3.b0();
        if (b0 == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            b0.e0().e("mapp_enable_eval", new a(F));
        }
    }

    public static void c(c42 c42Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{c42Var, Boolean.valueOf(z), str}) == null) {
            if (a) {
                Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
            }
            e64 e64Var = new e64();
            e64Var.errMsg = str;
            he4.call(c42Var, z, e64Var);
        }
    }
}
