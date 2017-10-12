package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bMM;
    private List<ak> bdA;

    public static u XR() {
        if (bMM == null) {
            synchronized (u.class) {
                if (bMM == null) {
                    bMM = new u();
                }
            }
        }
        return bMM;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bdA == null) {
                this.bdA = new ArrayList();
            }
            if (this.bdA != null) {
                this.bdA.add(akVar);
            }
        }
    }

    public void jp(String str) {
        if (str != null) {
            if (this.bdA == null) {
                this.bdA = new ArrayList();
            }
            if (this.bdA != null) {
                this.bdA.add(new ak(str));
            }
        }
    }

    public void cB(boolean z) {
        if (com.baidu.tbadk.core.util.v.t(this.bdA) != 0) {
            for (ak akVar : this.bdA) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bdA.clear();
        }
    }

    public void dC(boolean z) {
        if (com.baidu.tbadk.core.util.v.t(this.bdA) != 0) {
            for (ak akVar : this.bdA) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bdA.clear();
        }
    }

    public void MU() {
        if (com.baidu.tbadk.core.util.v.t(this.bdA) != 0) {
            for (ak akVar : this.bdA) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bdA.clear();
        }
    }
}
