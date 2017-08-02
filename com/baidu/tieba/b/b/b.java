package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aoR;
    private boolean bAB;
    private float bAC;

    public b(Context context) {
        super(context);
        this.aoR = 3;
        this.bAB = false;
        this.bAC = -8.0f;
        R(this.bAC);
    }

    public void UH() {
        wh();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UF();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void UI() {
        wh();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return b.this.bAB && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UF();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UF();
                b.this.UG();
            }
        });
        a(new b.C0071b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0071b, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UF();
                b.this.UG();
            }
        });
    }

    public void UJ() {
        this.bAB = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wh() {
        super.wh();
        this.bAB = false;
    }
}
