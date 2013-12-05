package com.baidu.tieba.im.b;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class o {
    private int b;
    private int d;
    private int f;
    private int g;

    /* renamed from: a  reason: collision with root package name */
    private final int f1523a = 1;
    private int c = 1;
    private final int e = 1;

    public static int a() {
        return 13;
    }

    public static byte[] a(int i, int i2, int i3, int i4, int i5, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
        allocate.put((byte) 1);
        allocate.put((byte) i2);
        allocate.put((byte) i3);
        allocate.put((byte) i);
        allocate.put((byte) 1);
        allocate.putInt(i4);
        allocate.putInt(i5);
        allocate.put(bArr);
        allocate.flip();
        return allocate.array();
    }

    public static o a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
        if (wrap.get() != 1) {
            return null;
        }
        o oVar = new o();
        oVar.c = wrap.get();
        oVar.d = wrap.get();
        oVar.b = wrap.get();
        if (wrap.get() == 1) {
            oVar.f = wrap.getInt();
            oVar.g = wrap.getInt();
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

    public int f() {
        return this.g;
    }
}
