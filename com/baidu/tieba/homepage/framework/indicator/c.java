package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int gbf = -1;
    private boolean gbg = false;
    private boolean gbh = false;

    public void a(e eVar) {
        this.gbg = true;
        if (this.gbf != -1 && this.gbh) {
            eVar.tu(this.gbf);
        }
    }

    public void a(int i, e eVar) {
        this.gbf = i;
        if (this.gbg && this.gbh) {
            eVar.tu(this.gbf);
        }
    }
}
