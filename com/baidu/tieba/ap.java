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
public class ap {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static bp b;
    public static String c;
    public static wj d;
    public static long e;
    public static Handler f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements Handler.Callback {
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
                            if (ap.d != null) {
                                ap.d.c(ap.c, message.arg1);
                                wj unused = ap.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (ap.d != null) {
                                if (aj.d()) {
                                    ap.d.error(message.what, xj.a(R.string.voice_err_create_file_fail));
                                } else {
                                    ap.d.error(message.what, xj.a(R.string.voice_err_sdcard_nospace));
                                }
                                wj unused2 = ap.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (ap.d != null) {
                                ap.d.error(message.what, xj.a(R.string.voice_err_file_fail));
                                wj unused3 = ap.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (ap.d != null) {
                                ap.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (ap.d != null) {
                                ap.d.error(message.what, xj.a(R.string.voice_err_load_lib_fail));
                                wj unused4 = ap.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (ap.d != null) {
                                ap.d.error(message.what, xj.a(R.string.voice_err_init_fail));
                                wj unused5 = ap.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (ap.d != null) {
                                ap.d.error(message.what, xj.a(R.string.voice_record_timeout_tip));
                                wj unused6 = ap.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (ap.d != null) {
                                ap.d.error(message.what, xj.a(R.string.voice_record_short_tip));
                                wj unused7 = ap.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (ap.d != null) {
                                ap.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (ap.d != null) {
                                ap.d.error(message.what, xj.a(R.string.voice_err_other));
                                wj unused8 = ap.d = null;
                                break;
                            }
                            break;
                    }
                } else if (ap.d != null) {
                    ap.d.e();
                }
                int unused9 = ap.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299870, "Lcom/baidu/tieba/ap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299870, "Lcom/baidu/tieba/ap;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            bp bpVar = b;
            if (bpVar != null) {
                bpVar.cancel();
            }
            a = 0;
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            bp bpVar = b;
            if (bpVar != null) {
                bpVar.k();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        bp bpVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65542, null, i) == null) && (bpVar = b) != null) {
            bpVar.h(i);
        }
    }

    public static boolean g(String str, int i, wj wjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, wjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new bp(f);
                }
                c = str;
                d = wjVar;
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
