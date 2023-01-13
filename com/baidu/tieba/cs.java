package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class cs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static xr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            xr xrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                xrVar = new xr();
                wrap.get();
                wrap.get();
                xrVar.a(wrap.get());
                xrVar.f(wrap.get());
                int i = wrap.getShort();
                xrVar.c(i);
                int i2 = wrap.getInt();
                xrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                xrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    xrVar.l(bArr3);
                }
            }
            return xrVar;
        }
        return (xr) invokeL.objValue;
    }

    public static byte[] b(xr xrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xrVar)) == null) {
            if (xrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(xrVar.m() + 12 + xrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (xrVar.e() != null && xrVar.e().length == 2) {
                allocate.put(xrVar.e()[0]);
                allocate.put(xrVar.e()[1]);
                allocate.put(xrVar.i());
                allocate.put(xrVar.k());
                if (xrVar.o() != null && xrVar.o().length != 0) {
                    int length = xrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (xrVar.p() != null && xrVar.p().length != 0) {
                        allocate.putInt(xrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (xrVar.o() != null) {
                        allocate.put(xrVar.o());
                    }
                    if (xrVar.p() != null) {
                        allocate.put(xrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
