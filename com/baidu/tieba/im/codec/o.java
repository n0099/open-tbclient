package com.baidu.tieba.im.codec;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class o {
    private int b;
    private int d;
    private int f;

    /* renamed from: a  reason: collision with root package name */
    private final int f1565a = 1;
    private int c = 1;
    private final int e = 1;

    public static int a() {
        return 9;
    }

    public static byte[] a(int i, int i2, int i3, int i4, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
        allocate.put((byte) 1);
        allocate.put((byte) i2);
        allocate.put((byte) i3);
        allocate.put((byte) i);
        allocate.put((byte) 1);
        allocate.putInt(i4);
        allocate.put(bArr);
        allocate.flip();
        return allocate.array();
    }

    public static o a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.get() != 1) {
            return null;
        }
        o oVar = new o();
        oVar.c = wrap.get();
        oVar.d = wrap.get();
        oVar.b = wrap.get();
        if (wrap.get() == 1) {
            oVar.f = wrap.getInt();
            return oVar;
        }
        return null;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }
}
