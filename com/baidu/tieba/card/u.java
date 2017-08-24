package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bJA;
    private List<aj> bca;

    public static u WU() {
        if (bJA == null) {
            synchronized (u.class) {
                if (bJA == null) {
                    bJA = new u();
                }
            }
        }
        return bJA;
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            if (this.bca == null) {
                this.bca = new ArrayList();
            }
            if (this.bca != null) {
                this.bca.add(ajVar);
            }
        }
    }

    public void jk(String str) {
        if (str != null) {
            if (this.bca == null) {
                this.bca = new ArrayList();
            }
            if (this.bca != null) {
                this.bca.add(new aj(str));
            }
        }
    }

    public void cA(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.bca) != 0) {
            for (aj ajVar : this.bca) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_param2", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.bca.clear();
        }
    }

    public void dF(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.bca) != 0) {
            for (aj ajVar : this.bca) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_type", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.bca.clear();
        }
    }
}
