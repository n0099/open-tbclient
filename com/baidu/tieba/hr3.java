package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class hr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static dr3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            dr3 dr3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                dr3Var = new dr3();
                wrap.get();
                wrap.get();
                dr3Var.r(wrap.get());
                dr3Var.p(wrap.get());
                int i = wrap.getShort();
                dr3Var.q(i);
                int i2 = wrap.getInt();
                dr3Var.k(i2);
                dr3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                dr3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    dr3Var.j(bArr3);
                }
            }
            return dr3Var;
        }
        return (dr3) invokeL.objValue;
    }

    public static byte[] b(dr3 dr3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dr3Var)) == null) {
            if (dr3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(dr3Var.h() + 20 + dr3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (dr3Var.e() != null && dr3Var.e().length == 2) {
                allocate.put(dr3Var.e()[0]);
                allocate.put(dr3Var.e()[1]);
                allocate.put(dr3Var.i());
                allocate.put(dr3Var.g());
                if (dr3Var.f() != null && dr3Var.f().length != 0) {
                    int length = dr3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (dr3Var.a() != null && dr3Var.a().length != 0) {
                        allocate.putInt(dr3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(dr3Var.c());
                    if (dr3Var.f() != null) {
                        allocate.put(dr3Var.f());
                    }
                    if (dr3Var.a() != null) {
                        allocate.put(dr3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
