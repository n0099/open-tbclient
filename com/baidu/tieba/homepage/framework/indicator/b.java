package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int hao = -1;
    private boolean hap = false;
    private boolean haq = false;

    public void a(e eVar) {
        this.hap = true;
        if (this.hao != -1 && this.haq) {
            eVar.vb(this.hao);
        }
    }

    public void a(int i, e eVar) {
        this.hao = i;
        if (this.hap && this.haq) {
            eVar.vb(this.hao);
        }
    }
}
