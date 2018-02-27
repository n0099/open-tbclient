package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int bfz;
    private boolean cUs;
    private float cUt;

    public b(Context context) {
        super(context);
        this.bfz = 3;
        this.cUs = false;
        this.cUt = -8.0f;
        ag(this.cUt);
    }

    public void akA() {
        DE();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aky();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void akB() {
        DE();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cUs && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aky();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aky();
                b.this.akz();
            }
        });
        a(new b.C0132b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0132b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.aky();
                b.this.akz();
            }
        });
    }

    public void akC() {
        this.cUs = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void DE() {
        super.DE();
        this.cUs = false;
    }
}
