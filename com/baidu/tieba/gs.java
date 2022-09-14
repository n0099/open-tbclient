package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class gs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static bs a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            bs bsVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                bsVar = new bs();
                wrap.get();
                wrap.get();
                bsVar.a(wrap.get());
                bsVar.f(wrap.get());
                int i = wrap.getShort();
                bsVar.c(i);
                int i2 = wrap.getInt();
                bsVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                bsVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    bsVar.l(bArr3);
                }
            }
            return bsVar;
        }
        return (bs) invokeL.objValue;
    }

    public static byte[] b(bs bsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bsVar)) == null) {
            if (bsVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(bsVar.m() + 12 + bsVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (bsVar.e() != null && bsVar.e().length == 2) {
                allocate.put(bsVar.e()[0]);
                allocate.put(bsVar.e()[1]);
                allocate.put(bsVar.i());
                allocate.put(bsVar.k());
                if (bsVar.o() != null && bsVar.o().length != 0) {
                    int length = bsVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (bsVar.p() != null && bsVar.p().length != 0) {
                        allocate.putInt(bsVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (bsVar.o() != null) {
                        allocate.put(bsVar.o());
                    }
                    if (bsVar.p() != null) {
                        allocate.put(bsVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
