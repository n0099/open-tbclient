package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cAE;
    private List<an> brA;

    public static v ajb() {
        if (cAE == null) {
            synchronized (v.class) {
                if (cAE == null) {
                    cAE = new v();
                }
            }
        }
        return cAE;
    }

    public void a(an anVar) {
        if (anVar != null) {
            if (this.brA == null) {
                this.brA = new ArrayList();
            }
            if (this.brA != null) {
                this.brA.add(anVar);
            }
        }
    }

    public void cL(boolean z) {
        if (com.baidu.tbadk.core.util.w.y(this.brA) != 0) {
            for (an anVar : this.brA) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    anVar.r("obj_param2", i);
                    TiebaStatic.log(anVar);
                }
            }
            this.brA.clear();
        }
    }

    public void ey(boolean z) {
        if (com.baidu.tbadk.core.util.w.y(this.brA) != 0) {
            for (an anVar : this.brA) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    anVar.r("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            }
            this.brA.clear();
        }
    }

    public void SC() {
        if (com.baidu.tbadk.core.util.w.y(this.brA) != 0) {
            for (an anVar : this.brA) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.brA.clear();
        }
    }
}
