package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aoZ;
    private boolean bHR;
    private float bHS;

    public b(Context context) {
        super(context);
        this.aoZ = 3;
        this.bHR = false;
        this.bHS = -8.0f;
        J(this.bHS);
    }

    public void WN() {
        vT();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WL();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void WO() {
        vT();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.bHR && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WL();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WL();
                b.this.WM();
            }
        });
        a(new b.C0074b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0074b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WL();
                b.this.WM();
            }
        });
    }

    public void WP() {
        this.bHR = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vT() {
        super.vT();
        this.bHR = false;
    }
}
