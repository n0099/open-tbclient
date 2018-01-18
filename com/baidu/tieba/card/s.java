package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s cVO;
    private List<ak> bVa;

    public static s akF() {
        if (cVO == null) {
            synchronized (s.class) {
                if (cVO == null) {
                    cVO = new s();
                }
            }
        }
        return cVO;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bVa == null) {
                this.bVa = new ArrayList();
            }
            if (this.bVa != null) {
                this.bVa.add(akVar);
            }
        }
    }

    public void de(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bVa) != 0) {
            for (ak akVar : this.bVa) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bVa.clear();
        }
    }

    public void eF(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bVa) != 0) {
            for (ak akVar : this.bVa) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bVa.clear();
        }
    }

    public void Vd() {
        if (com.baidu.tbadk.core.util.v.D(this.bVa) != 0) {
            for (ak akVar : this.bVa) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bVa.clear();
        }
    }
}
