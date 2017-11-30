package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int apA;
    private boolean bXx;
    private float bXy;

    public b(Context context) {
        super(context);
        this.apA = 3;
        this.bXx = false;
        this.bXy = -8.0f;
        L(this.bXy);
    }

    public void aaO() {
        vX();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaM();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void aaP() {
        vX();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.bXx && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaM();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaM();
                b.this.aaN();
            }
        });
        a(new b.C0075b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0075b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaM();
                b.this.aaN();
            }
        });
    }

    public void aaQ() {
        this.bXx = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vX() {
        super.vX();
        this.bXx = false;
    }
}
