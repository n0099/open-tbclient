package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bMs;
    private List<ak> bbR;

    public static u XY() {
        if (bMs == null) {
            synchronized (u.class) {
                if (bMs == null) {
                    bMs = new u();
                }
            }
        }
        return bMs;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bbR == null) {
                this.bbR = new ArrayList();
            }
            if (this.bbR != null) {
                this.bbR.add(akVar);
            }
        }
    }

    public void jv(String str) {
        if (str != null) {
            if (this.bbR == null) {
                this.bbR = new ArrayList();
            }
            if (this.bbR != null) {
                this.bbR.add(new ak(str));
            }
        }
    }

    public void cC(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.bbR) != 0) {
            for (ak akVar : this.bbR) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bbR.clear();
        }
    }

    public void dI(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.bbR) != 0) {
            for (ak akVar : this.bbR) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bbR.clear();
        }
    }
}
