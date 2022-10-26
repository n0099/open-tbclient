package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class hs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static cs a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            cs csVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                csVar = new cs();
                wrap.get();
                wrap.get();
                csVar.a(wrap.get());
                csVar.f(wrap.get());
                int i = wrap.getShort();
                csVar.c(i);
                int i2 = wrap.getInt();
                csVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                csVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    csVar.l(bArr3);
                }
            }
            return csVar;
        }
        return (cs) invokeL.objValue;
    }

    public static byte[] b(cs csVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, csVar)) == null) {
            if (csVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(csVar.m() + 12 + csVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (csVar.e() != null && csVar.e().length == 2) {
                allocate.put(csVar.e()[0]);
                allocate.put(csVar.e()[1]);
                allocate.put(csVar.i());
                allocate.put(csVar.k());
                if (csVar.o() != null && csVar.o().length != 0) {
                    int length = csVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (csVar.p() != null && csVar.p().length != 0) {
                        allocate.putInt(csVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (csVar.o() != null) {
                        allocate.put(csVar.o());
                    }
                    if (csVar.p() != null) {
                        allocate.put(csVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
