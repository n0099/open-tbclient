package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class gr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static cr3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            cr3 cr3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                cr3Var = new cr3();
                wrap.get();
                wrap.get();
                cr3Var.r(wrap.get());
                cr3Var.p(wrap.get());
                int i = wrap.getShort();
                cr3Var.q(i);
                int i2 = wrap.getInt();
                cr3Var.k(i2);
                cr3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                cr3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    cr3Var.j(bArr3);
                }
            }
            return cr3Var;
        }
        return (cr3) invokeL.objValue;
    }

    public static byte[] b(cr3 cr3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cr3Var)) == null) {
            if (cr3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(cr3Var.h() + 20 + cr3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (cr3Var.e() != null && cr3Var.e().length == 2) {
                allocate.put(cr3Var.e()[0]);
                allocate.put(cr3Var.e()[1]);
                allocate.put(cr3Var.i());
                allocate.put(cr3Var.g());
                if (cr3Var.f() != null && cr3Var.f().length != 0) {
                    int length = cr3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (cr3Var.a() != null && cr3Var.a().length != 0) {
                        allocate.putInt(cr3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(cr3Var.c());
                    if (cr3Var.f() != null) {
                        allocate.put(cr3Var.f());
                    }
                    if (cr3Var.a() != null) {
                        allocate.put(cr3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
