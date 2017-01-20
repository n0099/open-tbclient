package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cc {
    private static cc bnO;
    private List<com.baidu.tbadk.core.util.ar> bnN;

    public static cc Rx() {
        if (bnO == null) {
            synchronized (cc.class) {
                if (bnO == null) {
                    bnO = new cc();
                }
            }
        }
        return bnO;
    }

    public void a(com.baidu.tbadk.core.util.ar arVar) {
        if (arVar != null) {
            if (this.bnN == null) {
                this.bnN = new ArrayList();
            }
            if (this.bnN != null) {
                this.bnN.add(arVar);
            }
        }
    }

    public void ih(String str) {
        if (str != null) {
            if (this.bnN == null) {
                this.bnN = new ArrayList();
            }
            if (this.bnN != null) {
                this.bnN.add(new com.baidu.tbadk.core.util.ar(str));
            }
        }
    }

    public void cM(boolean z) {
        if (com.baidu.tbadk.core.util.w.r(this.bnN) != 0) {
            for (com.baidu.tbadk.core.util.ar arVar : this.bnN) {
                if (arVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    arVar.s("obj_param2", i);
                    TiebaStatic.log(arVar);
                }
            }
            this.bnN.clear();
        }
    }

    public void cN(boolean z) {
        if (com.baidu.tbadk.core.util.w.r(this.bnN) != 0) {
            for (com.baidu.tbadk.core.util.ar arVar : this.bnN) {
                if (arVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    arVar.s("obj_type", i);
                    TiebaStatic.log(arVar);
                }
            }
            this.bnN.clear();
        }
    }
}
