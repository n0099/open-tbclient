package com.baidu.tbadk.widget;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import java.io.InputStream;
import java.util.Vector;
import protobuf.Im;
/* loaded from: classes.dex */
public final class h {
    protected Bitmap A;
    protected int H;
    protected short[] I;
    protected byte[] J;
    protected byte[] K;
    protected byte[] L;
    protected Vector<i> M;
    protected int N;
    private int Q;
    protected InputStream a;
    protected int b;
    protected int c;
    protected int d;
    protected boolean e;
    protected int f;
    protected int[] h;
    protected int[] i;
    protected int[] j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected boolean o;
    protected boolean p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected Bitmap z;
    protected int g = 1;
    protected byte[] B = new byte[256];
    protected int C = 0;
    protected int D = 0;
    protected int E = 0;
    protected boolean F = false;
    protected int G = 0;
    protected int O = 0;
    private volatile boolean P = false;

    public h(int i) {
        this.Q = GravityCompat.RELATIVE_LAYOUT_DIRECTION;
        this.Q = i;
    }

    public final boolean a() {
        return this.P;
    }

    public final int a(int i) {
        this.G = -1;
        if (i >= 0 && i < this.N) {
            this.G = this.M.elementAt(i).b;
        }
        return this.G;
    }

    public final int b() {
        return this.N;
    }

    public final Bitmap b(int i) {
        if (this.N <= 0) {
            return null;
        }
        return this.M.elementAt(i % this.N).a;
    }

    public final int a(InputStream inputStream) {
        if (this.P) {
            return 4;
        }
        this.b = 0;
        this.N = 0;
        this.M = new Vector<>();
        this.h = null;
        this.i = null;
        if (inputStream != null) {
            this.a = inputStream;
            h();
            if (!c()) {
                g();
                com.baidu.adp.lib.util.f.a(getClass().getName(), "read", "gif mem ==" + String.valueOf(this.O / 1024.0f) + "k");
                if (this.O >= this.Q) {
                    return 3;
                }
                if (this.N < 0) {
                    this.b = 1;
                }
            }
        } else {
            this.b = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        if (this.P) {
            return 4;
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        return this.b != 0;
    }

    private int e() {
        try {
            return this.a.read();
        } catch (Exception e) {
            this.b = 1;
            return 0;
        }
    }

    private int f() {
        this.C = e();
        int i = 0;
        if (this.C > 0) {
            while (i < this.C) {
                try {
                    int read = this.a.read(this.B, i, this.C - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.C) {
                this.b = 1;
            }
        }
        return i;
    }

    private int[] c(int i) {
        int i2;
        int i3 = 0;
        int i4 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i4];
        try {
            i2 = this.a.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i4) {
            this.b = 1;
        } else {
            iArr = new int[256];
            int i5 = 0;
            while (i5 < i) {
                int i6 = i3 + 1;
                int i7 = bArr[i3] & 255;
                int i8 = i6 + 1;
                iArr[i5] = (i7 << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i8] & 255);
                i5++;
                i3 = i8 + 1;
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:221:0x02e3 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v28, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0362 A[LOOP:4: B:51:0x0129->B:116:0x0362, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0003 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        short s;
        boolean z = false;
        while (!z && !c() && !this.P) {
            int e = e();
            if (this.O < this.Q) {
                switch (e) {
                    case Im.GroupInfo.ISRECENTLYREPLY_FIELD_NUMBER /* 33 */:
                        switch (e()) {
                            case 1:
                                k();
                                continue;
                            case 249:
                                e();
                                int e2 = e();
                                this.D = (e2 & 28) >> 2;
                                if (this.D == 0) {
                                    this.D = 1;
                                }
                                this.F = (e2 & 1) != 0;
                                this.G = j() * 10;
                                this.G = this.G < 15 ? 100 : this.G;
                                this.H = e();
                                e();
                                continue;
                            case 254:
                                k();
                                continue;
                            case MotionEventCompat.ACTION_MASK /* 255 */:
                                f();
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i12 = 0; i12 < 11; i12++) {
                                    stringBuffer.append((char) this.B[i12]);
                                }
                                if (stringBuffer.toString().equals("NETSCAPE2.0")) {
                                    i();
                                    break;
                                } else {
                                    k();
                                    continue;
                                }
                            default:
                                k();
                                continue;
                        }
                    case 44:
                        this.r = j();
                        this.s = j();
                        this.t = j();
                        this.u = j();
                        int e3 = e();
                        this.o = (e3 & 128) != 0;
                        this.q = (int) Math.pow(2.0d, (e3 & 7) + 1);
                        this.p = (e3 & 64) != 0;
                        if (this.o) {
                            this.i = c(this.q);
                            this.j = this.i;
                        } else {
                            this.j = this.h;
                            if (this.k == this.H) {
                                this.l = 0;
                            }
                        }
                        int i13 = 0;
                        if (this.F) {
                            i13 = this.j[this.H];
                            this.j[this.H] = 0;
                        }
                        int i14 = i13;
                        if (this.j == null) {
                            this.b = 1;
                        }
                        if (c()) {
                            break;
                        } else {
                            int i15 = this.t * this.u;
                            if (this.L == null || this.L.length < i15) {
                                this.L = new byte[i15];
                            }
                            if (this.I == null) {
                                this.I = new short[4096];
                            }
                            if (this.J == null) {
                                this.J = new byte[4096];
                            }
                            if (this.K == null) {
                                this.K = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
                            }
                            int e4 = e();
                            int i16 = 1 << e4;
                            int i17 = i16 + 1;
                            int i18 = i16 + 2;
                            int i19 = -1;
                            int i20 = e4 + 1;
                            int i21 = (1 << i20) - 1;
                            for (int i22 = 0; i22 < i16; i22++) {
                                this.I[i22] = 0;
                                this.J[i22] = (byte) i22;
                            }
                            int i23 = 0;
                            int i24 = 0;
                            int i25 = 0;
                            int i26 = 0;
                            int i27 = 0;
                            int i28 = 0;
                            int i29 = 0;
                            int i30 = 0;
                            while (i29 < i15) {
                                if (i24 != 0) {
                                    i3 = i21;
                                    i4 = i25;
                                    i5 = i28;
                                    i6 = i20;
                                    i7 = i24;
                                    i8 = i26;
                                    i9 = i19;
                                    i10 = i18;
                                } else if (i28 < i20) {
                                    if (i27 == 0) {
                                        i27 = f();
                                        if (i27 <= 0) {
                                            for (i = i23; i < i15; i++) {
                                                this.L[i] = 0;
                                            }
                                            k();
                                            if (c()) {
                                                break;
                                            } else {
                                                this.N++;
                                                this.z = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_4444);
                                                int[] iArr = new int[this.c * this.d];
                                                if (this.E > 0) {
                                                    if (this.E == 3) {
                                                        int i31 = this.N - 2;
                                                        if (i31 > 0) {
                                                            this.A = b(i31 - 1);
                                                        } else {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (this.A != null) {
                                                        this.A.getPixels(iArr, 0, this.c, 0, 0, this.c, this.d);
                                                        if (this.E == 2) {
                                                            int i32 = this.F ? 0 : this.m;
                                                            for (int i33 = 0; i33 < this.y; i33++) {
                                                                int i34 = ((this.w + i33) * this.c) + this.v;
                                                                int i35 = this.x + i34;
                                                                while (i34 < i35) {
                                                                    iArr[i34] = i32;
                                                                    i34++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                int i36 = 1;
                                                int i37 = 8;
                                                int i38 = 0;
                                                for (int i39 = 0; i39 < this.u; i39++) {
                                                    if (this.p) {
                                                        if (i38 >= this.u) {
                                                            i36++;
                                                            switch (i36) {
                                                                case 2:
                                                                    i38 = 4;
                                                                    break;
                                                                case 3:
                                                                    i38 = 2;
                                                                    i37 = 4;
                                                                    break;
                                                                case 4:
                                                                    i38 = 1;
                                                                    i37 = 2;
                                                                    break;
                                                            }
                                                        }
                                                        int i40 = i38;
                                                        i38 += i37;
                                                        i2 = i40;
                                                    } else {
                                                        i2 = i39;
                                                    }
                                                    int i41 = i2 + this.s;
                                                    if (i41 < this.d) {
                                                        int i42 = this.c * i41;
                                                        int i43 = i42 + this.r;
                                                        int i44 = this.t + i43;
                                                        if (this.c + i42 < i44) {
                                                            i44 = this.c + i42;
                                                        }
                                                        int i45 = this.t * i39;
                                                        int i46 = i43;
                                                        while (i46 < i44) {
                                                            int i47 = i45 + 1;
                                                            int i48 = this.j[this.L[i45] & 255];
                                                            if (i48 != 0) {
                                                                iArr[i46] = i48;
                                                            }
                                                            i46++;
                                                            i45 = i47;
                                                        }
                                                    }
                                                }
                                                this.z = Bitmap.createBitmap(iArr, this.c, this.d, Bitmap.Config.ARGB_4444);
                                                this.M.addElement(new i(this.z, this.G));
                                                this.O += this.c * this.d * 2;
                                                if (this.F) {
                                                    this.j[this.H] = i14;
                                                }
                                                this.E = this.D;
                                                this.v = this.r;
                                                this.w = this.s;
                                                this.x = this.t;
                                                this.y = this.u;
                                                this.A = this.z;
                                                this.m = this.l;
                                                this.D = 0;
                                                this.F = false;
                                                this.G = 0;
                                                this.i = null;
                                                break;
                                            }
                                        } else {
                                            i30 = 0;
                                        }
                                    }
                                    i26 += (this.B[i30] & 255) << i28;
                                    i28 += 8;
                                    i30++;
                                    i27--;
                                } else {
                                    int i49 = i26 & i21;
                                    i26 >>= i20;
                                    i28 -= i20;
                                    if (i49 <= i18 && i49 != i17) {
                                        if (i49 == i16) {
                                            i20 = e4 + 1;
                                            i21 = (1 << i20) - 1;
                                            i18 = i16 + 2;
                                            i19 = -1;
                                        } else if (i19 == -1) {
                                            this.K[i24] = this.J[i49];
                                            i24++;
                                            i19 = i49;
                                            i25 = i49;
                                        } else {
                                            if (i49 == i18) {
                                                i11 = i24 + 1;
                                                this.K[i24] = (byte) i25;
                                                s = i19;
                                            } else {
                                                i11 = i24;
                                                s = i49;
                                            }
                                            while (s > i16) {
                                                this.K[i11] = this.J[s];
                                                s = this.I[s];
                                                i11++;
                                            }
                                            int i50 = this.J[s] & 255;
                                            if (i18 < 4096) {
                                                int i51 = i11 + 1;
                                                this.K[i11] = (byte) i50;
                                                this.I[i18] = (short) i19;
                                                this.J[i18] = (byte) i50;
                                                i10 = i18 + 1;
                                                if ((i10 & i21) == 0 && i10 < 4096) {
                                                    i20++;
                                                    i21 += i10;
                                                }
                                                i8 = i26;
                                                i9 = i49;
                                                i3 = i21;
                                                i4 = i50;
                                                i5 = i28;
                                                i6 = i20;
                                                i7 = i51;
                                            }
                                        }
                                    }
                                    while (i < i15) {
                                    }
                                    k();
                                    if (c()) {
                                    }
                                }
                                int i52 = i7 - 1;
                                this.L[i23] = this.K[i52];
                                i29++;
                                i23++;
                                i20 = i6;
                                i28 = i5;
                                i25 = i4;
                                i21 = i3;
                                int i53 = i8;
                                i24 = i52;
                                i18 = i10;
                                i19 = i9;
                                i26 = i53;
                            }
                            while (i < i15) {
                            }
                            k();
                            if (c()) {
                            }
                        }
                        break;
                    case 59:
                        z = true;
                        break;
                    default:
                        this.b = 1;
                        break;
                }
            } else {
                return;
            }
        }
    }

    private void h() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) e());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.b = 1;
            return;
        }
        this.c = j();
        this.d = j();
        int e = e();
        this.e = (e & 128) != 0;
        this.f = 2 << (e & 7);
        this.k = e();
        this.n = e();
        if (this.e && !c()) {
            this.h = c(this.f);
            this.l = this.h[this.k];
        }
    }

    private void i() {
        do {
            f();
            if (this.B[0] == 1) {
                this.g = (this.B[1] & 255) | ((this.B[2] & 255) << 8);
            }
            if (this.C <= 0) {
                return;
            }
        } while (!c());
    }

    private int j() {
        return e() | (e() << 8);
    }

    private void k() {
        do {
            f();
            if (this.C <= 0) {
                return;
            }
        } while (!c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        this.P = true;
        if (this.M != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.M.size()) {
                    this.M.get(i2).a = null;
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
