package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cf {
    private static cf bDv;
    private List<com.baidu.tbadk.core.util.au> aZx;

    public static cf VN() {
        if (bDv == null) {
            synchronized (cf.class) {
                if (bDv == null) {
                    bDv = new cf();
                }
            }
        }
        return bDv;
    }

    public void a(com.baidu.tbadk.core.util.au auVar) {
        if (auVar != null) {
            if (this.aZx == null) {
                this.aZx = new ArrayList();
            }
            if (this.aZx != null) {
                this.aZx.add(auVar);
            }
        }
    }

    public void iL(String str) {
        if (str != null) {
            if (this.aZx == null) {
                this.aZx = new ArrayList();
            }
            if (this.aZx != null) {
                this.aZx.add(new com.baidu.tbadk.core.util.au(str));
            }
        }
    }

    public void cw(boolean z) {
        if (com.baidu.tbadk.core.util.z.s(this.aZx) != 0) {
            for (com.baidu.tbadk.core.util.au auVar : this.aZx) {
                if (auVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    auVar.r("obj_param2", i);
                    TiebaStatic.log(auVar);
                }
            }
            this.aZx.clear();
        }
    }

    public void dv(boolean z) {
        if (com.baidu.tbadk.core.util.z.s(this.aZx) != 0) {
            for (com.baidu.tbadk.core.util.au auVar : this.aZx) {
                if (auVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    auVar.r("obj_type", i);
                    TiebaStatic.log(auVar);
                }
            }
            this.aZx.clear();
        }
    }
}
