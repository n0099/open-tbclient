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
/* loaded from: classes6.dex */
public class hj {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ij b;
    public static String c;
    public static jj d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                            if (hj.d != null) {
                                hj.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f1810));
                            }
                        } else {
                            if (hj.d != null) {
                                hj.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (hj.d != null) {
                        hj.d.error(message.what, oj.a(R.string.obfuscated_res_0x7f0f180e));
                    }
                } else if (hj.d != null) {
                    hj.d.c(hj.c, message.arg1);
                }
                int unused = hj.a = 0;
                jj unused2 = hj.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306411, "Lcom/baidu/tieba/hj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306411, "Lcom/baidu/tieba/hj;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ij ijVar = b;
            if (ijVar != null) {
                ijVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, jj jjVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, jjVar, i)) == null) {
            if (a == 0) {
                ij ijVar = b;
                if (ijVar == null) {
                    b = new ij(e, i);
                } else {
                    ijVar.k(i);
                }
                c = str;
                d = jjVar;
                b.j(str);
                a = 2;
                ps6.a(b, "AmrAudioPlayer", 2);
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
