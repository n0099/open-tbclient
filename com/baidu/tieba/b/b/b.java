package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int bfC;
    private boolean cUv;
    private float cUw;

    public b(Context context) {
        super(context);
        this.bfC = 3;
        this.cUv = false;
        this.cUw = -8.0f;
        ag(this.cUw);
    }

    public void akB() {
        DF();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.akz();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void akC() {
        DF();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cUv && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.akz();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.akz();
                b.this.akA();
            }
        });
        a(new b.C0132b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0132b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.akz();
                b.this.akA();
            }
        });
    }

    public void akD() {
        this.cUv = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void DF() {
        super.DF();
        this.cUv = false;
    }
}
