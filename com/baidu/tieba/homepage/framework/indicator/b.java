package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes7.dex */
public class b {
    private int gYo = -1;
    private boolean gYp = false;
    private boolean gYq = false;

    public void a(e eVar) {
        this.gYp = true;
        if (this.gYo != -1 && this.gYq) {
            eVar.uV(this.gYo);
        }
    }

    public void a(int i, e eVar) {
        this.gYo = i;
        if (this.gYp && this.gYq) {
            eVar.uV(this.gYo);
        }
    }
}
