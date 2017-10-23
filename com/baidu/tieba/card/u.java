package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bMA;
    private List<ak> bdm;

    public static u XN() {
        if (bMA == null) {
            synchronized (u.class) {
                if (bMA == null) {
                    bMA = new u();
                }
            }
        }
        return bMA;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bdm == null) {
                this.bdm = new ArrayList();
            }
            if (this.bdm != null) {
                this.bdm.add(akVar);
            }
        }
    }

    public void jo(String str) {
        if (str != null) {
            if (this.bdm == null) {
                this.bdm = new ArrayList();
            }
            if (this.bdm != null) {
                this.bdm.add(new ak(str));
            }
        }
    }

    public void cA(boolean z) {
        if (com.baidu.tbadk.core.util.v.t(this.bdm) != 0) {
            for (ak akVar : this.bdm) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bdm.clear();
        }
    }

    public void dB(boolean z) {
        if (com.baidu.tbadk.core.util.v.t(this.bdm) != 0) {
            for (ak akVar : this.bdm) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bdm.clear();
        }
    }

    public void MO() {
        if (com.baidu.tbadk.core.util.v.t(this.bdm) != 0) {
            for (ak akVar : this.bdm) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bdm.clear();
        }
    }
}
