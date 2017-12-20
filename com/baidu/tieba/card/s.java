package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s ccF;
    private List<ak> bhF;

    public static s abW() {
        if (ccF == null) {
            synchronized (s.class) {
                if (ccF == null) {
                    ccF = new s();
                }
            }
        }
        return ccF;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bhF == null) {
                this.bhF = new ArrayList();
            }
            if (this.bhF != null) {
                this.bhF.add(akVar);
            }
        }
    }

    public void cC(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhF) != 0) {
            for (ak akVar : this.bhF) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bhF.clear();
        }
    }

    public void dU(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhF) != 0) {
            for (ak akVar : this.bhF) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bhF.clear();
        }
    }

    public void NQ() {
        if (com.baidu.tbadk.core.util.v.v(this.bhF) != 0) {
            for (ak akVar : this.bhF) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bhF.clear();
        }
    }
}
