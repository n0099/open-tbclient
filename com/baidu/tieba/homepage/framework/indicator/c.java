package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class c {
    private int eeo = -1;
    private boolean eep = false;
    private boolean eeq = false;

    public void a(e eVar) {
        this.eep = true;
        if (this.eeo != -1 && this.eeq) {
            eVar.oz(this.eeo);
        }
    }

    public void a(int i, e eVar) {
        this.eeo = i;
        if (this.eep && this.eeq) {
            eVar.oz(this.eeo);
        }
    }
}
