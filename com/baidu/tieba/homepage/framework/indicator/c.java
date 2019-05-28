package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int gbd = -1;
    private boolean gbe = false;
    private boolean gbf = false;

    public void a(e eVar) {
        this.gbe = true;
        if (this.gbd != -1 && this.gbf) {
            eVar.tu(this.gbd);
        }
    }

    public void a(int i, e eVar) {
        this.gbd = i;
        if (this.gbe && this.gbf) {
            eVar.tu(this.gbd);
        }
    }
}
