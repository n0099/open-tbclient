package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int enk = -1;
    private boolean enl = false;
    private boolean enm = false;

    public void a(e eVar) {
        this.enl = true;
        if (this.enk != -1 && this.enm) {
            eVar.oa(this.enk);
        }
    }

    public void a(int i, e eVar) {
        this.enk = i;
        if (this.enl && this.enm) {
            eVar.oa(this.enk);
        }
    }
}
