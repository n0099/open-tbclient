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
public class ek {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static fk b;
    public static String c;
    public static he d;
    public static long e;
    public static Handler f;
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
                if (i != 100) {
                    switch (i) {
                        case 0:
                            if (ek.d != null) {
                                ek.d.c(ek.c, message.arg1);
                                he unused = ek.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (ek.d != null) {
                                if (nd.d()) {
                                    ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f1876));
                                } else {
                                    ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f187f));
                                }
                                he unused2 = ek.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (ek.d != null) {
                                ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f1877));
                                he unused3 = ek.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (ek.d != null) {
                                ek.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (ek.d != null) {
                                ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f187b));
                                he unused4 = ek.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (ek.d != null) {
                                ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f1878));
                                he unused5 = ek.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (ek.d != null) {
                                ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f1888));
                                he unused6 = ek.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (ek.d != null) {
                                ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f1885));
                                he unused7 = ek.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (ek.d != null) {
                                ek.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (ek.d != null) {
                                ek.d.error(message.what, ie.a(R.string.obfuscated_res_0x7f0f187d));
                                he unused8 = ek.d = null;
                                break;
                            }
                            break;
                    }
                } else if (ek.d != null) {
                    ek.d.e();
                }
                int unused9 = ek.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303559, "Lcom/baidu/tieba/ek;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303559, "Lcom/baidu/tieba/ek;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            fk fkVar = b;
            if (fkVar != null) {
                fkVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            fk fkVar = b;
            if (fkVar != null) {
                fkVar.k();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            try {
                if (b != null) {
                    b.h(i);
                }
            } catch (NoClassDefFoundError e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean g(String str, int i, he heVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, heVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new fk(f);
                }
                c = str;
                d = heVar;
                if (b.j(str, i)) {
                    a = 3;
                    lr6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
