package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int apS;
    private boolean bFp;
    private float bFq;

    public b(Context context) {
        super(context);
        this.apS = 3;
        this.bFp = false;
        this.bFq = -8.0f;
        G(this.bFq);
    }

    public void Wi() {
        wp();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wg();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void Wj() {
        wp();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return b.this.bFp && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wg();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wg();
                b.this.Wh();
            }
        });
        a(new b.C0074b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0074b, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.Wg();
                b.this.Wh();
            }
        });
    }

    public void Wk() {
        this.bFp = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wp() {
        super.wp();
        this.bFp = false;
    }
}
