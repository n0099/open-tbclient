package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cZt;
    private List<am> bKE;

    public static v aqs() {
        if (cZt == null) {
            synchronized (v.class) {
                if (cZt == null) {
                    cZt = new v();
                }
            }
        }
        return cZt;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bKE == null) {
                this.bKE = new ArrayList();
            }
            if (this.bKE != null) {
                this.bKE.add(amVar);
            }
        }
    }

    public void dQ(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bKE) != 0) {
            for (am amVar : this.bKE) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bKE.clear();
        }
    }

    public void fv(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bKE) != 0) {
            for (am amVar : this.bKE) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bKE.clear();
        }
    }

    public void Zp() {
        if (com.baidu.tbadk.core.util.v.H(this.bKE) != 0) {
            for (am amVar : this.bKE) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bKE.clear();
        }
    }
}
