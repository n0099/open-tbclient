package com.baidu.tieba.im.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class b {
    private static byte a = Byte.MIN_VALUE;
    private static byte b = 64;
    private boolean c = false;
    private boolean d = false;
    private int e;
    private int f;

    public static int a() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + 9);
        byte b2 = z ? (byte) (a | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (b2 | b);
        }
        allocate.put(b2);
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static b a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 9);
        b bVar = new b();
        byte b2 = wrap.get();
        if ((a & b2) != 0) {
            bVar.c = true;
        }
        if ((b2 & b) != 0) {
            bVar.d = true;
        }
        bVar.e = wrap.getInt();
        bVar.f = wrap.getInt();
        return bVar;
    }

    public final boolean b() {
        return this.d;
    }

    public final int c() {
        return this.e;
    }

    public final boolean d() {
        return this.c;
    }

    public final int e() {
        return this.f;
    }
}
