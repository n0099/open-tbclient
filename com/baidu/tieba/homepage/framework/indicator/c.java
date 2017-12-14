package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int dqu = -1;
    private boolean dqv = false;
    private boolean dqw = false;

    public void a(e eVar) {
        this.dqv = true;
        if (this.dqu != -1 && this.dqw) {
            eVar.lP(this.dqu);
        }
    }

    public void a(int i, e eVar) {
        this.dqu = i;
        if (this.dqv && this.dqw) {
            eVar.lP(this.dqu);
        }
    }
}
