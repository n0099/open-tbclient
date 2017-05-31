package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
public class l {
    private int cAt = -1;
    private boolean cAu = false;
    private boolean cAv = false;

    public void a(v vVar) {
        this.cAu = true;
        if (this.cAt != -1 && this.cAv) {
            vVar.ke(this.cAt);
        }
    }

    public void a(int i, v vVar) {
        this.cAt = i;
        if (this.cAu && this.cAv) {
            vVar.ke(this.cAt);
        }
    }

    public void b(v vVar) {
        this.cAv = true;
        if (this.cAt != -1 && this.cAu) {
            vVar.ke(this.cAt);
        }
    }
}
