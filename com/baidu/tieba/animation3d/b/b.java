package com.baidu.tieba.animation3d.b;

import android.content.Context;
import com.baidu.tieba.animation3d.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int azI;
    private boolean cuE;
    private float cuF;

    public b(Context context) {
        super(context);
        this.azI = 3;
        this.cuE = false;
        this.cuF = -8.0f;
        af(this.cuF);
    }

    public void ahV() {
        zV();
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.1
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ahT();
            }

            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void ahW() {
        zV();
        a(new b.c() { // from class: com.baidu.tieba.animation3d.b.b.2
            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cuE && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ahT();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.3
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ahT();
                b.this.ahU();
            }
        });
        a(new b.C0134b() { // from class: com.baidu.tieba.animation3d.b.b.4
            @Override // com.baidu.tieba.animation3d.a.b.C0134b, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ahT();
                b.this.ahU();
            }
        });
    }

    public void ahX() {
        this.cuE = true;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void zV() {
        super.zV();
        this.cuE = false;
    }
}
