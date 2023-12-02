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
public class be {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ce b;
    public static String c;
    public static de d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
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
                            if (be.d != null) {
                                be.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f187f));
                            }
                        } else {
                            if (be.d != null) {
                                be.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (be.d != null) {
                        be.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f187d));
                    }
                } else if (be.d != null) {
                    be.d.c(be.c, message.arg1);
                }
                int unused = be.a = 0;
                de unused2 = be.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300490, "Lcom/baidu/tieba/be;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300490, "Lcom/baidu/tieba/be;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            ce ceVar = b;
            if (ceVar != null) {
                ceVar.l();
            } else {
                a = 0;
            }
        }
    }

    public static boolean e(String str, de deVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, deVar, i)) == null) {
            if (a == 0) {
                ce ceVar = b;
                if (ceVar == null) {
                    b = new ce(e, i);
                } else {
                    ceVar.k(i);
                }
                c = str;
                d = deVar;
                b.j(str);
                a = 2;
                pr6.a(b, "AmrAudioPlayer", 2);
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
