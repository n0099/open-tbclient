package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s ccA;
    private List<ak> bhE;

    public static s abU() {
        if (ccA == null) {
            synchronized (s.class) {
                if (ccA == null) {
                    ccA = new s();
                }
            }
        }
        return ccA;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bhE == null) {
                this.bhE = new ArrayList();
            }
            if (this.bhE != null) {
                this.bhE.add(akVar);
            }
        }
    }

    public void cB(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhE) != 0) {
            for (ak akVar : this.bhE) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bhE.clear();
        }
    }

    public void dT(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhE) != 0) {
            for (ak akVar : this.bhE) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bhE.clear();
        }
    }

    public void NQ() {
        if (com.baidu.tbadk.core.util.v.v(this.bhE) != 0) {
            for (ak akVar : this.bhE) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bhE.clear();
        }
    }
}
