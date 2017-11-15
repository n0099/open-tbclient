package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aph;
    private boolean bPy;
    private float bPz;

    public b(Context context) {
        super(context);
        this.aph = 3;
        this.bPy = false;
        this.bPz = -8.0f;
        K(this.bPz);
    }

    public void Zf() {
        vU();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.Zd();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void Zg() {
        vU();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.bPy && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.Zd();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.Zd();
                b.this.Ze();
            }
        });
        a(new b.C0074b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0074b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.Zd();
                b.this.Ze();
            }
        });
    }

    public void Zh() {
        this.bPy = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vU() {
        super.vU();
        this.bPy = false;
    }
}
