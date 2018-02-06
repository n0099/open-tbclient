package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r cYU;
    private List<ak> bXr;

    public static r alt() {
        if (cYU == null) {
            synchronized (r.class) {
                if (cYU == null) {
                    cYU = new r();
                }
            }
        }
        return cYU;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bXr == null) {
                this.bXr = new ArrayList();
            }
            if (this.bXr != null) {
                this.bXr.add(akVar);
            }
        }
    }

    public void dk(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bXr) != 0) {
            for (ak akVar : this.bXr) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bXr.clear();
        }
    }

    public void eO(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bXr) != 0) {
            for (ak akVar : this.bXr) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bXr.clear();
        }
    }

    public void VX() {
        if (com.baidu.tbadk.core.util.v.D(this.bXr) != 0) {
            for (ak akVar : this.bXr) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bXr.clear();
        }
    }
}
