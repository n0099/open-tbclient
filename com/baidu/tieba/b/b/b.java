package com.baidu.tieba.b.b;

import android.content.Context;
import com.baidu.tieba.b.a.b;
/* loaded from: classes.dex */
public class b extends a {
    public int bdK;
    private boolean cQN;
    private float cQO;

    public b(Context context) {
        super(context);
        this.bdK = 3;
        this.cQN = false;
        this.cQO = -8.0f;
        aa(this.cQO);
    }

    public void ajy() {
        Dk();
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.1
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajw();
            }

            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return i > 30;
            }
        });
    }

    public void ajz() {
        Dk();
        a(new b.c() { // from class: com.baidu.tieba.b.b.b.2
            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public boolean c(float f, float f2, float f3, int i) {
                return b.this.cQN && f % 360.0f == 0.0f;
            }

            @Override // com.baidu.tieba.b.a.b.c, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajw();
            }
        });
        a(new b.a() { // from class: com.baidu.tieba.b.b.b.3
            @Override // com.baidu.tieba.b.a.b.a, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajw();
                b.this.ajx();
            }
        });
        a(new b.C0100b() { // from class: com.baidu.tieba.b.b.b.4
            @Override // com.baidu.tieba.b.a.b.C0100b, com.baidu.tieba.b.a.a
            public void e(float f, float f2, float f3, int i) {
                b.this.ajw();
                b.this.ajx();
            }
        });
    }

    public void ajA() {
        this.cQN = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void Dk() {
        super.Dk();
        this.cQN = false;
    }
}
