package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int api;
    private boolean bPl;
    private float bPm;

    public b(Context context) {
        super(context);
        this.api = 3;
        this.bPl = false;
        this.bPm = -8.0f;
        K(this.bPm);
    }

    public void YT() {
        vU();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.YR();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void YU() {
        vU();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.bPl && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.YR();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.YR();
                b.this.YS();
            }
        });
        a(new b.C0074b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0074b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.YR();
                b.this.YS();
            }
        });
    }

    public void YV() {
        this.bPl = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vU() {
        super.vU();
        this.bPl = false;
    }
}
