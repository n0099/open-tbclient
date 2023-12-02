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
public class i04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799676, "Lcom/baidu/tieba/i04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799676, "Lcom/baidu/tieba/i04;");
                return;
            }
        }
        a = vm1.a;
    }

    public i04(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        sy1 G = sy1.G(jsObject);
        if (G == null) {
            return;
        }
        k63 M = k63.M();
        if (M == null) {
            a(G, false, b("internal error"));
            return;
        }
        try {
            boolean n = G.n("mixWithOther", false);
            M.V().h("key_audio_is_mix_with_other", Boolean.valueOf(n));
            if (a) {
                Log.d("InnerAudioOptionApi", "Audio Mix Changed to " + n);
            }
            a(G, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            k32.c("InnerAudioOptionApi", "set swanApp global var error");
            a(G, false, b("internal error"));
        }
    }

    public final void a(sy1 sy1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{sy1Var, Boolean.valueOf(z), str}) == null) {
            t04 t04Var = new t04();
            t04Var.errMsg = str;
            w84.a(sy1Var, z, t04Var);
        }
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return String.format("setInnerAudioOption:fail %s", str);
        }
        return (String) invokeL.objValue;
    }
}
