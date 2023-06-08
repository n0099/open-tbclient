package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class gj {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static hj b;
    public static String c;
    public static ij d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 6) {
                            if (gj.d != null) {
                                gj.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f180c));
                            }
                        } else {
                            if (gj.d != null) {
                                gj.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (gj.d != null) {
                        gj.d.error(message.what, nj.a(R.string.obfuscated_res_0x7f0f180a));
                    }
                } else if (gj.d != null) {
                    gj.d.c(gj.c, message.arg1);
                }
                int unused = gj.a = 0;
                ij unused2 = gj.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305450, "Lcom/baidu/tieba/gj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305450, "Lcom/baidu/tieba/gj;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            hj hjVar = b;
            if (hjVar != null) {
                hjVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, ij ijVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, ijVar, i)) == null) {
            if (a == 0) {
                hj hjVar = b;
                if (hjVar == null) {
                    b = new hj(e, i);
                } else {
                    hjVar.k(i);
                }
                c = str;
                d = ijVar;
                b.j(str);
                a = 2;
                ks6.a(b, "AmrAudioPlayer", 2);
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
