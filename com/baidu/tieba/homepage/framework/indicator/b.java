package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int euf = -1;
    private boolean eug = false;
    private boolean euh = false;

    public void a(e eVar) {
        this.eug = true;
        if (this.euf != -1 && this.euh) {
            eVar.ou(this.euf);
        }
    }

    public void a(int i, e eVar) {
        this.euf = i;
        if (this.eug && this.euh) {
            eVar.ou(this.euf);
        }
    }
}
