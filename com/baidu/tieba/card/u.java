package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bJz;
    private List<aj> bbZ;

    public static u WX() {
        if (bJz == null) {
            synchronized (u.class) {
                if (bJz == null) {
                    bJz = new u();
                }
            }
        }
        return bJz;
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            if (this.bbZ == null) {
                this.bbZ = new ArrayList();
            }
            if (this.bbZ != null) {
                this.bbZ.add(ajVar);
            }
        }
    }

    public void jh(String str) {
        if (str != null) {
            if (this.bbZ == null) {
                this.bbZ = new ArrayList();
            }
            if (this.bbZ != null) {
                this.bbZ.add(new aj(str));
            }
        }
    }

    public void cA(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.bbZ) != 0) {
            for (aj ajVar : this.bbZ) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_param2", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.bbZ.clear();
        }
    }

    public void dF(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.bbZ) != 0) {
            for (aj ajVar : this.bbZ) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_type", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.bbZ.clear();
        }
    }
}
