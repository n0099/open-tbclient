package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aoN;
    private boolean bHF;
    private float bHG;

    public b(Context context) {
        super(context);
        this.aoN = 3;
        this.bHF = false;
        this.bHG = -8.0f;
        J(this.bHG);
    }

    public void WJ() {
        vM();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WH();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void WK() {
        vM();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.bHF && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WH();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WH();
                b.this.WI();
            }
        });
        a(new b.C0074b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0074b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.WH();
                b.this.WI();
            }
        });
    }

    public void WL() {
        this.bHF = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vM() {
        super.vM();
        this.bHF = false;
    }
}
