package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r cYL;
    private List<ak> bXi;

    public static r alt() {
        if (cYL == null) {
            synchronized (r.class) {
                if (cYL == null) {
                    cYL = new r();
                }
            }
        }
        return cYL;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bXi == null) {
                this.bXi = new ArrayList();
            }
            if (this.bXi != null) {
                this.bXi.add(akVar);
            }
        }
    }

    public void dk(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bXi) != 0) {
            for (ak akVar : this.bXi) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bXi.clear();
        }
    }

    public void eO(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bXi) != 0) {
            for (ak akVar : this.bXi) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bXi.clear();
        }
    }

    public void VX() {
        if (com.baidu.tbadk.core.util.v.D(this.bXi) != 0) {
            for (ak akVar : this.bXi) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bXi.clear();
        }
    }
}
