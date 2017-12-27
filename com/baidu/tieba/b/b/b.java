package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int bdE;
    private boolean cMm;
    private float cMn;

    public b(Context context) {
        super(context);
        this.bdE = 3;
        this.cMm = false;
        this.cMn = -8.0f;
        ab(this.cMn);
    }

    public void aiv() {
        Dt();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ait();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void aiw() {
        Dt();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cMm && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ait();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ait();
                b.this.aiu();
            }
        });
        a(new b.C0101b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0101b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ait();
                b.this.aiu();
            }
        });
    }

    public void aix() {
        this.cMm = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void Dt() {
        super.Dt();
        this.cMm = false;
    }
}
