package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int haq = -1;
    private boolean har = false;
    private boolean has = false;

    public void a(e eVar) {
        this.har = true;
        if (this.haq != -1 && this.has) {
            eVar.vb(this.haq);
        }
    }

    public void a(int i, e eVar) {
        this.haq = i;
        if (this.har && this.has) {
            eVar.vb(this.haq);
        }
    }
}
