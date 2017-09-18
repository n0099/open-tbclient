package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int apQ;
    private boolean bGg;
    private float bGh;

    public b(Context context) {
        super(context);
        this.apQ = 3;
        this.bGg = false;
        this.bGh = -8.0f;
        G(this.bGh);
    }

    public void Wt() {
        wp();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wr();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void Wu() {
        wp();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return b.this.bGg && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wr();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wr();
                b.this.Ws();
            }
        });
        a(new b.C0073b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0073b, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wr();
                b.this.Ws();
            }
        });
    }

    public void Wv() {
        this.bGg = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wp() {
        super.wp();
        this.bGg = false;
    }
}
