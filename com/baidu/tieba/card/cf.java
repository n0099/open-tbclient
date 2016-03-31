package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cf {
    private static cf aUY;
    private List<com.baidu.tbadk.core.util.aw> aUX;

    public static cf Lx() {
        if (aUY == null) {
            synchronized (cf.class) {
                if (aUY == null) {
                    aUY = new cf();
                }
            }
        }
        return aUY;
    }

    public void a(com.baidu.tbadk.core.util.aw awVar) {
        if (awVar != null) {
            if (this.aUX == null) {
                this.aUX = new ArrayList();
            }
            if (this.aUX != null) {
                this.aUX.add(awVar);
            }
        }
    }

    public void hd(String str) {
        if (str != null) {
            if (this.aUX == null) {
                this.aUX = new ArrayList();
            }
            if (this.aUX != null) {
                this.aUX.add(new com.baidu.tbadk.core.util.aw(str));
            }
        }
    }

    public void cc(boolean z) {
        if (com.baidu.tbadk.core.util.y.p(this.aUX) != 0) {
            for (com.baidu.tbadk.core.util.aw awVar : this.aUX) {
                if (awVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    awVar.r("obj_param2", i);
                    TiebaStatic.log(awVar);
                }
            }
            this.aUX.clear();
        }
    }
}
