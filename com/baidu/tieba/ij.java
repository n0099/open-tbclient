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
/* loaded from: classes4.dex */
public class ij {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static jj b;
    public static String c;
    public static kj d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
                            if (ij.d != null) {
                                ij.d.error(message.what, pj.a(R.string.voice_err_play));
                            }
                        } else {
                            if (ij.d != null) {
                                ij.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (ij.d != null) {
                        ij.d.error(message.what, pj.a(R.string.voice_err_no_file));
                    }
                } else if (ij.d != null) {
                    ij.d.c(ij.c, message.arg1);
                }
                int unused = ij.a = 0;
                kj unused2 = ij.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307372, "Lcom/baidu/tieba/ij;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307372, "Lcom/baidu/tieba/ij;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            jj jjVar = b;
            if (jjVar != null) {
                jjVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, kj kjVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, kjVar, i)) == null) {
            if (a == 0) {
                jj jjVar = b;
                if (jjVar == null) {
                    b = new jj(e, i);
                } else {
                    jjVar.k(i);
                }
                c = str;
                d = kjVar;
                b.j(str);
                a = 2;
                new Thread(b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
