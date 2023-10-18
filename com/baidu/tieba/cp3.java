package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class cp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static yo3 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            yo3 yo3Var = null;
            if (bArr == null) {
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b = wrap.get();
            byte b2 = wrap.get();
            if (b == -27 && b2 == -89) {
                yo3Var = new yo3();
                wrap.get();
                wrap.get();
                yo3Var.r(wrap.get());
                yo3Var.p(wrap.get());
                int i = wrap.getShort();
                yo3Var.q(i);
                int i2 = wrap.getInt();
                yo3Var.k(i2);
                yo3Var.l(wrap.getLong());
                byte[] bArr2 = new byte[i];
                wrap.get(bArr2, 0, i);
                yo3Var.o(bArr2);
                if (i2 > 0) {
                    byte[] bArr3 = new byte[i2];
                    wrap.get(bArr3, 0, i2);
                    yo3Var.j(bArr3);
                }
            }
            return yo3Var;
        }
        return (yo3) invokeL.objValue;
    }

    public static byte[] b(yo3 yo3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yo3Var)) == null) {
            if (yo3Var == null) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(yo3Var.h() + 20 + yo3Var.b());
            allocate.put((byte) -27);
            allocate.put((byte) -89);
            if (yo3Var.e() != null && yo3Var.e().length == 2) {
                allocate.put(yo3Var.e()[0]);
                allocate.put(yo3Var.e()[1]);
                allocate.put(yo3Var.i());
                allocate.put(yo3Var.g());
                if (yo3Var.f() != null && yo3Var.f().length != 0) {
                    int length = yo3Var.f().length;
                    allocate.put((byte) ((length >> 8) & 255));
                    allocate.put((byte) (length & 255));
                    if (yo3Var.a() != null && yo3Var.a().length != 0) {
                        allocate.putInt(yo3Var.a().length);
                    } else {
                        allocate.putInt(0);
                    }
                    allocate.putLong(yo3Var.c());
                    if (yo3Var.f() != null) {
                        allocate.put(yo3Var.f());
                    }
                    if (yo3Var.a() != null) {
                        allocate.put(yo3Var.a());
                    }
                    return allocate.array();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
