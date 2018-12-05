package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cWD;
    private List<am> bKB;

    public static v apD() {
        if (cWD == null) {
            synchronized (v.class) {
                if (cWD == null) {
                    cWD = new v();
                }
            }
        }
        return cWD;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bKB == null) {
                this.bKB = new ArrayList();
            }
            if (this.bKB != null) {
                this.bKB.add(amVar);
            }
        }
    }

    public void dQ(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bKB) != 0) {
            for (am amVar : this.bKB) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bKB.clear();
        }
    }

    public void ft(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bKB) != 0) {
            for (am amVar : this.bKB) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bKB.clear();
        }
    }

    public void Zn() {
        if (com.baidu.tbadk.core.util.v.H(this.bKB) != 0) {
            for (am amVar : this.bKB) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bKB.clear();
        }
    }
}
