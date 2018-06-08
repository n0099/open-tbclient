package com.baidu.tieba.animation3d.b;

import android.content.Context;
import com.baidu.tieba.animation3d.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int ayX;
    private boolean ctU;
    private float ctV;

    public b(Context context) {
        super(context);
        this.ayX = 3;
        this.ctU = false;
        this.ctV = -8.0f;
        ae(this.ctV);
    }

    public void aid() {
        zR();
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.1
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aib();
            }

            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void aie() {
        zR();
        a(new b.c() { // from class: com.baidu.tieba.animation3d.b.b.2
            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.ctU && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aib();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.3
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aib();
                b.this.aic();
            }
        });
        a(new b.C0135b() { // from class: com.baidu.tieba.animation3d.b.b.4
            @Override // com.baidu.tieba.animation3d.a.b.C0135b, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aib();
                b.this.aic();
            }
        });
    }

    public void aif() {
        this.ctU = true;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void zR() {
        super.zR();
        this.ctU = false;
    }
}
