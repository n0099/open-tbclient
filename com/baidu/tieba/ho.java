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
public class ho {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static io b;
    public static String c;
    public static yi d;
    public static long e;
    public static Handler f;
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
                if (i != 100) {
                    switch (i) {
                        case 0:
                            if (ho.d != null) {
                                ho.d.c(ho.c, message.arg1);
                                yi unused = ho.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (ho.d != null) {
                                if (ci.d()) {
                                    ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a1));
                                } else {
                                    ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16aa));
                                }
                                yi unused2 = ho.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (ho.d != null) {
                                ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a2));
                                yi unused3 = ho.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (ho.d != null) {
                                ho.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (ho.d != null) {
                                ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a6));
                                yi unused4 = ho.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (ho.d != null) {
                                ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a3));
                                yi unused5 = ho.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (ho.d != null) {
                                ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16b3));
                                yi unused6 = ho.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (ho.d != null) {
                                ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16b0));
                                yi unused7 = ho.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (ho.d != null) {
                                ho.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (ho.d != null) {
                                ho.d.error(message.what, zi.a(R.string.obfuscated_res_0x7f0f16a8));
                                yi unused8 = ho.d = null;
                                break;
                            }
                            break;
                    }
                } else if (ho.d != null) {
                    ho.d.e();
                }
                int unused9 = ho.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306566, "Lcom/baidu/tieba/ho;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306566, "Lcom/baidu/tieba/ho;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            io ioVar = b;
            if (ioVar != null) {
                ioVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            io ioVar = b;
            if (ioVar != null) {
                ioVar.k();
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

    public static boolean g(String str, int i, yi yiVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, yiVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new io(f);
                }
                c = str;
                d = yiVar;
                if (b.j(str, i)) {
                    a = 3;
                    new Thread(b).start();
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }
}
