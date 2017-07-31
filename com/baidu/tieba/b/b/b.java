package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int aql;
    private boolean bBL;
    private float bBM;

    public b(Context context) {
        super(context);
        this.aql = 3;
        this.bBL = false;
        this.bBM = -8.0f;
        R(this.bBM);
    }

    public void UM() {
        wr();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UK();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void UN() {
        wr();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean b(float f, float f2, float f3, int i) {
                return b.this.bBL && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UK();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UK();
                b.this.UL();
            }
        });
        a(new b.C0071b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0071b, com.baidu.tieba.b.a.a
            public void d(float f, float f2, float f3, int i) {
                b.this.UK();
                b.this.UL();
            }
        });
    }

    public void UO() {
        this.bBL = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wr() {
        super.wr();
        this.bBL = false;
    }
}
