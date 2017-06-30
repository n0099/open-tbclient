package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
public class l {
    private int cIf = -1;
    private boolean cIg = false;
    private boolean cIh = false;

    public void a(v vVar) {
        this.cIg = true;
        if (this.cIf != -1 && this.cIh) {
            vVar.kp(this.cIf);
        }
    }

    public void a(int i, v vVar) {
        this.cIf = i;
        if (this.cIg && this.cIh) {
            vVar.kp(this.cIf);
        }
    }

    public void b(v vVar) {
        this.cIh = true;
        if (this.cIf != -1 && this.cIg) {
            vVar.kp(this.cIf);
        }
    }
}
