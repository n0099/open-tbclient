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
public class dk {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ek b;
    public static String c;
    public static ge d;
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
                            if (dk.d != null) {
                                dk.d.c(dk.c, message.arg1);
                                ge unused = dk.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (dk.d != null) {
                                if (md.d()) {
                                    dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f1866));
                                } else {
                                    dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f186f));
                                }
                                ge unused2 = dk.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (dk.d != null) {
                                dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f1867));
                                ge unused3 = dk.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (dk.d != null) {
                                dk.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (dk.d != null) {
                                dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f186b));
                                ge unused4 = dk.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (dk.d != null) {
                                dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f1868));
                                ge unused5 = dk.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (dk.d != null) {
                                dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f1878));
                                ge unused6 = dk.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (dk.d != null) {
                                dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f1875));
                                ge unused7 = dk.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (dk.d != null) {
                                dk.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (dk.d != null) {
                                dk.d.error(message.what, he.a(R.string.obfuscated_res_0x7f0f186d));
                                ge unused8 = dk.d = null;
                                break;
                            }
                            break;
                    }
                } else if (dk.d != null) {
                    dk.d.e();
                }
                int unused9 = dk.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302598, "Lcom/baidu/tieba/dk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302598, "Lcom/baidu/tieba/dk;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ek ekVar = b;
            if (ekVar != null) {
                ekVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ek ekVar = b;
            if (ekVar != null) {
                ekVar.k();
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

    public static boolean g(String str, int i, ge geVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, geVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new ek(f);
                }
                c = str;
                d = geVar;
                if (b.j(str, i)) {
                    a = 3;
                    br6.a(b, "AmrRecorder", 1);
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
