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
/* loaded from: classes3.dex */
public class bj {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static cj b;
    public static String c;
    public static dj d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
                            if (bj.d != null) {
                                bj.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f156b));
                            }
                        } else {
                            if (bj.d != null) {
                                bj.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (bj.d != null) {
                        bj.d.error(message.what, ij.a(R.string.obfuscated_res_0x7f0f1569));
                    }
                } else if (bj.d != null) {
                    bj.d.c(bj.c, message.arg1);
                }
                int unused = bj.a = 0;
                dj unused2 = bj.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300645, "Lcom/baidu/tieba/bj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300645, "Lcom/baidu/tieba/bj;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static boolean e(String str, dj djVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, djVar, i)) == null) {
            if (a == 0) {
                cj cjVar = b;
                if (cjVar == null) {
                    b = new cj(e, i);
                } else {
                    cjVar.k(i);
                }
                c = str;
                d = djVar;
                b.j(str);
                a = 2;
                new Thread(b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            cj cjVar = b;
            if (cjVar != null) {
                cjVar.l();
            } else {
                a = 0;
            }
        }
    }
}
