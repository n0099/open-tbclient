package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s cRm;
    private List<ak> bUT;

    public static s ajC() {
        if (cRm == null) {
            synchronized (s.class) {
                if (cRm == null) {
                    cRm = new s();
                }
            }
        }
        return cRm;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bUT == null) {
                this.bUT = new ArrayList();
            }
            if (this.bUT != null) {
                this.bUT.add(akVar);
            }
        }
    }

    public void df(boolean z) {
        if (com.baidu.tbadk.core.util.v.F(this.bUT) != 0) {
            for (ak akVar : this.bUT) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bUT.clear();
        }
    }

    public void eB(boolean z) {
        if (com.baidu.tbadk.core.util.v.F(this.bUT) != 0) {
            for (ak akVar : this.bUT) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.s("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bUT.clear();
        }
    }

    public void Vp() {
        if (com.baidu.tbadk.core.util.v.F(this.bUT) != 0) {
            for (ak akVar : this.bUT) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.bUT.clear();
        }
    }
}
