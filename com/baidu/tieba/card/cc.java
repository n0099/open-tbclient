package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cc {
    private static cc buC;
    private List<com.baidu.tbadk.core.util.as> buB;

    public static cc ST() {
        if (buC == null) {
            synchronized (cc.class) {
                if (buC == null) {
                    buC = new cc();
                }
            }
        }
        return buC;
    }

    public void a(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (this.buB == null) {
                this.buB = new ArrayList();
            }
            if (this.buB != null) {
                this.buB.add(asVar);
            }
        }
    }

    public void ib(String str) {
        if (str != null) {
            if (this.buB == null) {
                this.buB = new ArrayList();
            }
            if (this.buB != null) {
                this.buB.add(new com.baidu.tbadk.core.util.as(str));
            }
        }
    }

    public void cO(boolean z) {
        if (com.baidu.tbadk.core.util.x.p(this.buB) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.buB) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_param2", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.buB.clear();
        }
    }

    public void cP(boolean z) {
        if (com.baidu.tbadk.core.util.x.p(this.buB) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.buB) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_type", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.buB.clear();
        }
    }
}
