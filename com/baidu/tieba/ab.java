package com.baidu.tieba;
/* loaded from: classes.dex */
class ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LabelActivity f629a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private float j = 0.0f;
    private long k;
    private long l;

    public ab(LabelActivity labelActivity, int i, int i2, int i3, int i4, long j) {
        this.f629a = labelActivity;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0;
        this.i = 0;
        this.k = 0L;
        this.l = 0L;
        this.d = i;
        this.e = i2;
        this.h = i3;
        this.i = i4;
        this.f = 0.0f;
        this.g = 0.0f;
        this.k = 0L;
        this.l = j;
        this.f = (i3 - i) / ((float) j);
        this.g = ((i4 - i2) << 1) / ((float) (j * j));
    }

    public float a() {
        if (this.l <= 0) {
            return 0.0f;
        }
        return ((float) this.k) / ((float) this.l);
    }

    public void a(long j) {
        this.k += j;
        this.b = this.d + (this.f * ((float) this.k));
        if (this.b < this.h) {
            this.b = this.h;
        }
        if (this.c == this.i - 1) {
            this.c = this.i;
            return;
        }
        this.j = this.e + (((float) ((this.k * this.k) >> 1)) * this.g);
        if (this.j > this.i) {
            this.c = this.i - 1;
        } else {
            this.c = this.j;
        }
    }

    public int b() {
        return (int) this.b;
    }

    public int c() {
        return (int) this.c;
    }

    public int d() {
        return this.i;
    }
}
