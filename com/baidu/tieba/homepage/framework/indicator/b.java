package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int ipr = -1;
    private boolean ips = false;
    private boolean ipt = false;

    public void a(e eVar) {
        this.ips = true;
        if (this.ipr != -1 && this.ipt) {
            eVar.wU(this.ipr);
        }
    }

    public void a(int i, e eVar) {
        this.ipr = i;
        if (this.ips && this.ipt) {
            eVar.wU(this.ipr);
        }
    }
}
