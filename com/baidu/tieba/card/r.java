package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r cYI;
    private List<ak> bXf;

    public static r als() {
        if (cYI == null) {
            synchronized (r.class) {
                if (cYI == null) {
                    cYI = new r();
                }
            }
        }
        return cYI;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bXf == null) {
                this.bXf = new ArrayList();
            }
            if (this.bXf != null) {
                this.bXf.add(akVar);
            }
        }
    }

    public void dk(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bXf) != 0) {
            for (ak akVar : this.bXf) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bXf.clear();
        }
    }

    public void eO(boolean z) {
        if (com.baidu.tbadk.core.util.v.D(this.bXf) != 0) {
            for (ak akVar : this.bXf) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bXf.clear();
        }
    }

    public void VW() {
        if (com.baidu.tbadk.core.util.v.D(this.bXf) != 0) {
            for (ak akVar : this.bXf) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bXf.clear();
        }
    }
}
