package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ca {
    private static ca bwS;
    private List<com.baidu.tbadk.core.util.as> bwR;

    public static ca To() {
        if (bwS == null) {
            synchronized (ca.class) {
                if (bwS == null) {
                    bwS = new ca();
                }
            }
        }
        return bwS;
    }

    public void a(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (this.bwR == null) {
                this.bwR = new ArrayList();
            }
            if (this.bwR != null) {
                this.bwR.add(asVar);
            }
        }
    }

    public void ib(String str) {
        if (str != null) {
            if (this.bwR == null) {
                this.bwR = new ArrayList();
            }
            if (this.bwR != null) {
                this.bwR.add(new com.baidu.tbadk.core.util.as(str));
            }
        }
    }

    public void db(boolean z) {
        if (com.baidu.tbadk.core.util.x.q(this.bwR) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.bwR) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_param2", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.bwR.clear();
        }
    }

    public void dc(boolean z) {
        if (com.baidu.tbadk.core.util.x.q(this.bwR) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.bwR) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.s("obj_type", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.bwR.clear();
        }
    }
}
