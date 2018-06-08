package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cAl;
    private List<am> bpq;

    public static v ajh() {
        if (cAl == null) {
            synchronized (v.class) {
                if (cAl == null) {
                    cAl = new v();
                }
            }
        }
        return cAl;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bpq == null) {
                this.bpq = new ArrayList();
            }
            if (this.bpq != null) {
                this.bpq.add(amVar);
            }
        }
    }

    public void cG(boolean z) {
        if (com.baidu.tbadk.core.util.w.y(this.bpq) != 0) {
            for (am amVar : this.bpq) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.r("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bpq.clear();
        }
    }

    public void ey(boolean z) {
        if (com.baidu.tbadk.core.util.w.y(this.bpq) != 0) {
            for (am amVar : this.bpq) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.r("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bpq.clear();
        }
    }

    public void RT() {
        if (com.baidu.tbadk.core.util.w.y(this.bpq) != 0) {
            for (am amVar : this.bpq) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bpq.clear();
        }
    }
}
