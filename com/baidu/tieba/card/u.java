package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bIQ;
    private List<aj> bbY;

    public static u WB() {
        if (bIQ == null) {
            synchronized (u.class) {
                if (bIQ == null) {
                    bIQ = new u();
                }
            }
        }
        return bIQ;
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            if (this.bbY == null) {
                this.bbY = new ArrayList();
            }
            if (this.bbY != null) {
                this.bbY.add(ajVar);
            }
        }
    }

    public void jg(String str) {
        if (str != null) {
            if (this.bbY == null) {
                this.bbY = new ArrayList();
            }
            if (this.bbY != null) {
                this.bbY.add(new aj(str));
            }
        }
    }

    public void cA(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.bbY) != 0) {
            for (aj ajVar : this.bbY) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_param2", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.bbY.clear();
        }
    }

    public void dE(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.bbY) != 0) {
            for (aj ajVar : this.bbY) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_type", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.bbY.clear();
        }
    }
}
