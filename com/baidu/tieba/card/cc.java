package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cc {
    private static cc buK;
    private List<com.baidu.tbadk.core.util.as> buJ;

    public static cc Sv() {
        if (buK == null) {
            synchronized (cc.class) {
                if (buK == null) {
                    buK = new cc();
                }
            }
        }
        return buK;
    }

    public void a(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (this.buJ == null) {
                this.buJ = new ArrayList();
            }
            if (this.buJ != null) {
                this.buJ.add(asVar);
            }
        }
    }

    public void hX(String str) {
        if (str != null) {
            if (this.buJ == null) {
                this.buJ = new ArrayList();
            }
            if (this.buJ != null) {
                this.buJ.add(new com.baidu.tbadk.core.util.as(str));
            }
        }
    }

    public void cM(boolean z) {
        if (com.baidu.tbadk.core.util.x.p(this.buJ) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.buJ) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_param2", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.buJ.clear();
        }
    }

    public void cN(boolean z) {
        if (com.baidu.tbadk.core.util.x.p(this.buJ) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.buJ) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_type", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.buJ.clear();
        }
    }
}
