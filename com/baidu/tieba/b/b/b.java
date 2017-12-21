package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int apG;
    private boolean bXF;
    private float bXG;

    public b(Context context) {
        super(context);
        this.apG = 3;
        this.bXF = false;
        this.bXG = -8.0f;
        L(this.bXG);
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
                return b.this.bXF && f % 360.0f == 0.0f;
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
        a(new b.C0088b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0088b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aaN();
                b.this.aaO();
            }
        });
    }

    public void aaR() {
        this.bXF = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vU() {
        super.vU();
        this.bXF = false;
    }
}
