package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int apD;
    private boolean bXB;
    private float bXC;

    public b(Context context) {
        super(context);
        this.apD = 3;
        this.bXB = false;
        this.bXC = -8.0f;
        L(this.bXC);
    }

    public void aaP() {
        vU();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaN();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void aaQ() {
        vU();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.bXB && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaN();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaN();
                b.this.aaO();
            }
        });
        a(new b.C0089b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0089b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaN();
                b.this.aaO();
            }
        });
    }

    public void aaR() {
        this.bXB = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vU() {
        super.vU();
        this.bXB = false;
    }
}
