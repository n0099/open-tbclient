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
/* loaded from: classes5.dex */
public class f54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715108, "Lcom/baidu/tieba/f54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715108, "Lcom/baidu/tieba/f54;");
                return;
            }
        }
        a = rr1.a;
    }

    public f54(JsObject jsObject) {
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
        o32 F = o32.F(jsObject);
        if (F == null) {
            return;
        }
        hb3 M = hb3.M();
        if (M == null) {
            a(F, false, b("internal error"));
            return;
        }
        try {
            boolean m = F.m("mixWithOther", false);
            M.U().h("key_audio_is_mix_with_other", Boolean.valueOf(m));
            if (a) {
                Log.d("InnerAudioOptionApi", "Audio Mix Changed to " + m);
            }
            a(F, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            h82.c("InnerAudioOptionApi", "set swanApp global var error");
            a(F, false, b("internal error"));
        }
    }

    public final void a(o32 o32Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{o32Var, Boolean.valueOf(z), str}) == null) {
            q54 q54Var = new q54();
            q54Var.errMsg = str;
            td4.call(o32Var, z, q54Var);
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
