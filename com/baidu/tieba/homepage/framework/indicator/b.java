package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int gUQ = -1;
    private boolean gUR = false;
    private boolean gUS = false;

    public void a(e eVar) {
        this.gUR = true;
        if (this.gUQ != -1 && this.gUS) {
            eVar.uQ(this.gUQ);
        }
    }

    public void a(int i, e eVar) {
        this.gUQ = i;
        if (this.gUR && this.gUS) {
            eVar.uQ(this.gUQ);
        }
    }
}
