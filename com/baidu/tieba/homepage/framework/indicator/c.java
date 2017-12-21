package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int dqy = -1;
    private boolean dqz = false;
    private boolean dqA = false;

    public void a(e eVar) {
        this.dqz = true;
        if (this.dqy != -1 && this.dqA) {
            eVar.lP(this.dqy);
        }
    }

    public void a(int i, e eVar) {
        this.dqy = i;
        if (this.dqz && this.dqA) {
            eVar.lP(this.dqy);
        }
    }
}
