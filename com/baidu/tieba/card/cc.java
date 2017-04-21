package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cc {
    private static cc bwT;
    private List<com.baidu.tbadk.core.util.as> bwS;

    public static cc TV() {
        if (bwT == null) {
            synchronized (cc.class) {
                if (bwT == null) {
                    bwT = new cc();
                }
            }
        }
        return bwT;
    }

    public void a(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (this.bwS == null) {
                this.bwS = new ArrayList();
            }
            if (this.bwS != null) {
                this.bwS.add(asVar);
            }
        }
    }

    public void ic(String str) {
        if (str != null) {
            if (this.bwS == null) {
                this.bwS = new ArrayList();
            }
            if (this.bwS != null) {
                this.bwS.add(new com.baidu.tbadk.core.util.as(str));
            }
        }
    }

    public void cY(boolean z) {
        if (com.baidu.tbadk.core.util.x.p(this.bwS) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.bwS) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_param2", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.bwS.clear();
        }
    }

    public void cZ(boolean z) {
        if (com.baidu.tbadk.core.util.x.p(this.bwS) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.bwS) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_type", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.bwS.clear();
        }
    }
}
