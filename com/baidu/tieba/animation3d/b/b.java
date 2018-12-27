package com.baidu.tieba.animation3d.b;

import android.content.Context;
import com.baidu.tieba.animation3d.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aLH;
    private boolean cTx;
    private float cTy;

    public b(Context context) {
        super(context);
        this.aLH = 3;
        this.cTx = false;
        this.cTy = -8.0f;
        aj(this.cTy);
    }

    public void apr() {
        Eq();
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.1
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.app();
            }

            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void aps() {
        Eq();
        a(new b.c() { // from class: com.baidu.tieba.animation3d.b.b.2
            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cTx && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.animation3d.a.b.c, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.app();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.animation3d.b.b.3
            @Override // com.baidu.tieba.animation3d.a.b.a, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.app();
                b.this.apq();
            }
        });
        a(new b.C0203b() { // from class: com.baidu.tieba.animation3d.b.b.4
            @Override // com.baidu.tieba.animation3d.a.b.C0203b, com.baidu.tieba.animation3d.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.app();
                b.this.apq();
            }
        });
    }

    public void apt() {
        this.cTx = true;
    }

    @Override // com.baidu.tieba.animation3d.b.a
    public void Eq() {
        super.Eq();
        this.cTx = false;
    }
}
