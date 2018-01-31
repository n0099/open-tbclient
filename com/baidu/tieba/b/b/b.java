package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int bdS;
    private boolean cRi;
    private float cRj;

    public b(Context context) {
        super(context);
        this.bdS = 3;
        this.cRi = false;
        this.cRj = -8.0f;
        aa(this.cRj);
    }

    public void ajD() {
        Dl();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajB();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void ajE() {
        Dl();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cRi && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajB();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajB();
                b.this.ajC();
            }
        });
        a(new b.C0101b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0101b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajB();
                b.this.ajC();
            }
        });
    }

    public void ajF() {
        this.cRi = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void Dl() {
        super.Dl();
        this.cRi = false;
    }
}
