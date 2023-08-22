package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdptask.bdtls.AES;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bs {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bs a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public bs() {
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

    public static bs c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (bs.class) {
                    if (a == null) {
                        a = new bs();
                    }
                }
            }
            return a;
        }
        return (bs) invokeV.objValue;
    }

    public static int a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return 0;
            }
            int i = 0;
            for (byte b : bArr) {
                i = (i << 8) | (b & 255);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public sr b(tr trVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, trVar, bArr)) == null) {
            sr srVar = new sr();
            try {
                rr a2 = wr.a(bArr);
                byte i = a2.i();
                if (i != 21) {
                    if (i == 23) {
                        srVar.c(new String(AES.aesDecrypt(a2.p(), trVar.q())));
                        srVar.b(1);
                    }
                } else {
                    hr a3 = hr.a(a2.o());
                    if (a3 != null) {
                        String b = a3.b();
                        DebugTrace debugTrace = DebugTrace.a;
                        debugTrace.a("bdtls ubc application alert : " + b);
                        if (1 == a3.d()) {
                            srVar.b(-2);
                        } else if (TextUtils.equals(b, "down grade")) {
                            srVar.b(2);
                        } else {
                            srVar.b(-1);
                        }
                        if (gr.c.h().c()) {
                            if (a3.b() != null) {
                                DebugTrace debugTrace2 = DebugTrace.a;
                                debugTrace2.a("BdtlsPostRequest response alert message=" + b);
                            } else {
                                DebugTrace.a.a("BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        srVar.b(-1);
                    }
                }
            } catch (Exception e) {
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                srVar.b(-1);
            }
            return srVar;
        }
        return (sr) invokeLL.objValue;
    }

    public byte[] e(tr trVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trVar)) == null) {
            if (trVar == null) {
                return null;
            }
            try {
                byte[] b = vr.b(trVar, new pr());
                if (b == null) {
                    return null;
                }
                rr a2 = rr.i.a();
                a2.a((byte) 22);
                a2.c((short) b.length);
                a2.j(b);
                return wr.b(a2);
            } catch (Exception e) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] f(tr trVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, trVar, str)) == null) {
            if (trVar == null) {
                return null;
            }
            try {
                rr a2 = rr.i.a();
                a2.a((byte) 23);
                byte[] r = trVar.r();
                if (r != null && r.length > 0 && r.length <= 32767) {
                    a2.c((short) r.length);
                    a2.j(r);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, trVar.q());
                    a2.b(aesEncrypt.length);
                    a2.l(aesEncrypt);
                }
                return wr.b(a2);
            } catch (Exception e) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
