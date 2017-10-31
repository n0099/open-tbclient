package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bUe;
    private List<ak> bei;

    public static u ZX() {
        if (bUe == null) {
            synchronized (u.class) {
                if (bUe == null) {
                    bUe = new u();
                }
            }
        }
        return bUe;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bei == null) {
                this.bei = new ArrayList();
            }
            if (this.bei != null) {
                this.bei.add(akVar);
            }
        }
    }

    public void cv(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.bei) != 0) {
            for (ak akVar : this.bei) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bei.clear();
        }
    }

    public void dA(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.bei) != 0) {
            for (ak akVar : this.bei) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bei.clear();
        }
    }

    public void Nb() {
        if (com.baidu.tbadk.core.util.v.u(this.bei) != 0) {
            for (ak akVar : this.bei) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bei.clear();
        }
    }
}
