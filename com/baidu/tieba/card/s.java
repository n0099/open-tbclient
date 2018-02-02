package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s cWj;
    private List<ak> bVi;

    public static s akK() {
        if (cWj == null) {
            synchronized (s.class) {
                if (cWj == null) {
                    cWj = new s();
                }
            }
        }
        return cWj;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bVi == null) {
                this.bVi = new ArrayList();
            }
            if (this.bVi != null) {
                this.bVi.add(akVar);
            }
        }
    }

    public void dg(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bVi) != 0) {
            for (ak akVar : this.bVi) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bVi.clear();
        }
    }

    public void eI(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bVi) != 0) {
            for (ak akVar : this.bVi) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bVi.clear();
        }
    }

    public void Vf() {
        if (com.baidu.tbadk.core.util.v.D(this.bVi) != 0) {
            for (ak akVar : this.bVi) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bVi.clear();
        }
    }
}
