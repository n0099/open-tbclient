package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int ewV = -1;
    private boolean ewW = false;
    private boolean ewX = false;

    public void a(e eVar) {
        this.ewW = true;
        if (this.ewV != -1 && this.ewX) {
            eVar.oH(this.ewV);
        }
    }

    public void a(int i, e eVar) {
        this.ewV = i;
        if (this.ewW && this.ewX) {
            eVar.oH(this.ewV);
        }
    }
}
