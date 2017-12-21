package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s ccJ;
    private List<ak> bhJ;

    public static s abW() {
        if (ccJ == null) {
            synchronized (s.class) {
                if (ccJ == null) {
                    ccJ = new s();
                }
            }
        }
        return ccJ;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bhJ == null) {
                this.bhJ = new ArrayList();
            }
            if (this.bhJ != null) {
                this.bhJ.add(akVar);
            }
        }
    }

    public void cC(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhJ) != 0) {
            for (ak akVar : this.bhJ) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bhJ.clear();
        }
    }

    public void dU(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhJ) != 0) {
            for (ak akVar : this.bhJ) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bhJ.clear();
        }
    }

    public void NQ() {
        if (com.baidu.tbadk.core.util.v.v(this.bhJ) != 0) {
            for (ak akVar : this.bhJ) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bhJ.clear();
        }
    }
}
