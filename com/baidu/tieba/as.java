package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class as {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static vr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            vr vrVar = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                vrVar = new vr();
                wrap.get();
                wrap.get();
                vrVar.a(wrap.get());
                vrVar.f(wrap.get());
                int i = wrap.getShort();
                vrVar.c(i);
                int i2 = wrap.getInt();
                vrVar.b(i2);
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                vrVar.j(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    vrVar.l(bArr3);
                }
            }
            return vrVar;
        }
        return (vr) invokeL.objValue;
    }

    public static byte[] b(vr vrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vrVar)) == null) {
            if (vrVar == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(vrVar.m() + 12 + vrVar.n());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (vrVar.e() != null && vrVar.e().length == 2) {
                allocate.put(vrVar.e()[0]);
                allocate.put(vrVar.e()[1]);
                allocate.put(vrVar.i());
                allocate.put(vrVar.k());
                if (vrVar.o() != null && vrVar.o().length != 0) {
                    int length = vrVar.o().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (vrVar.p() != null && vrVar.p().length != 0) {
                        allocate.putInt(vrVar.p().length);
                    } else {
                        allocate.putInt(0);
                    }
                    if (vrVar.o() != null) {
                        allocate.put(vrVar.o());
                    }
                    if (vrVar.p() != null) {
                        allocate.put(vrVar.p());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
