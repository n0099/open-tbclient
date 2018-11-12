package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cPW;
    private List<am> bGM;

    public static v anQ() {
        if (cPW == null) {
            synchronized (v.class) {
                if (cPW == null) {
                    cPW = new v();
                }
            }
        }
        return cPW;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bGM == null) {
                this.bGM = new ArrayList();
            }
            if (this.bGM != null) {
                this.bGM.add(amVar);
            }
        }
    }

    public void dP(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bGM) != 0) {
            for (am amVar : this.bGM) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bGM.clear();
        }
    }

    public void fs(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bGM) != 0) {
            for (am amVar : this.bGM) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bGM.clear();
        }
    }

    public void Yi() {
        if (com.baidu.tbadk.core.util.v.H(this.bGM) != 0) {
            for (am amVar : this.bGM) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bGM.clear();
        }
    }
}
