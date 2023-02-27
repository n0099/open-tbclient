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
public class ep {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static fp b;
    public static String c;
    public static vj d;
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
                            if (ep.d != null) {
                                ep.d.c(ep.c, message.arg1);
                                vj unused = ep.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (ep.d != null) {
                                if (zi.d()) {
                                    ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f168d));
                                } else {
                                    ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f1696));
                                }
                                vj unused2 = ep.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (ep.d != null) {
                                ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f168e));
                                vj unused3 = ep.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (ep.d != null) {
                                ep.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (ep.d != null) {
                                ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f1692));
                                vj unused4 = ep.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (ep.d != null) {
                                ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f168f));
                                vj unused5 = ep.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (ep.d != null) {
                                ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f169f));
                                vj unused6 = ep.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (ep.d != null) {
                                ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f169c));
                                vj unused7 = ep.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (ep.d != null) {
                                ep.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (ep.d != null) {
                                ep.d.error(message.what, wj.a(R.string.obfuscated_res_0x7f0f1694));
                                vj unused8 = ep.d = null;
                                break;
                            }
                            break;
                    }
                } else if (ep.d != null) {
                    ep.d.e();
                }
                int unused9 = ep.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303714, "Lcom/baidu/tieba/ep;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303714, "Lcom/baidu/tieba/ep;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            fp fpVar = b;
            if (fpVar != null) {
                fpVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            fp fpVar = b;
            if (fpVar != null) {
                fpVar.k();
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

    public static boolean g(String str, int i, vj vjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, vjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new fp(f);
                }
                c = str;
                d = vjVar;
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
