package com.baidu.tieba.animation3d.b;

import android.content.Context;
import com.baidu.tieba.animation3d.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aIf;
    private boolean cJZ;
    private float cKa;

    public b(Context context) {
        super(context);
        this.aIf = 3;
        this.cJZ = false;
        this.cKa = -8.0f;
        aj(this.cKa);
    }

    public void amP() {
        Dm();
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.1
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.amN();
            }

            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void amQ() {
        Dm();
        a(new b.c() { // from class: com.baidu.tieba.animation3d.b.b.2
            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cJZ && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.amN();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.3
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.amN();
                b.this.amO();
            }
        });
        a(new b.C0193b() { // from class: com.baidu.tieba.animation3d.b.b.4
            @Override // com.baidu.tieba.animation3d.a.b.C0193b, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.amN();
                b.this.amO();
            }
        });
    }

    public void amR() {
        this.cJZ = true;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void Dm() {
        super.Dm();
        this.cJZ = false;
    }
}
