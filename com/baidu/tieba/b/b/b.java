package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aqm;
    private boolean bCv;
    private float bCw;

    public b(Context context) {
        super(context);
        this.aqm = 3;
        this.bCv = false;
        this.bCw = -8.0f;
        R(this.bCw);
    }

    public void Vf() {
        ws();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Vd();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void Vg() {
        ws();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return b.this.bCv && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Vd();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Vd();
                b.this.Ve();
            }
        });
        a(new b.C0071b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0071b, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Vd();
                b.this.Ve();
            }
        });
    }

    public void Vh() {
        this.bCv = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void ws() {
        super.ws();
        this.bCv = false;
    }
}
