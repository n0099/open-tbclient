package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cOQ;
    private List<am> bGa;

    public static v aop() {
        if (cOQ == null) {
            synchronized (v.class) {
                if (cOQ == null) {
                    cOQ = new v();
                }
            }
        }
        return cOQ;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bGa == null) {
                this.bGa = new ArrayList();
            }
            if (this.bGa != null) {
                this.bGa.add(amVar);
            }
        }
    }

    public void dy(boolean z) {
        if (com.baidu.tbadk.core.util.v.I(this.bGa) != 0) {
            for (am amVar : this.bGa) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bGa.clear();
        }
    }

    public void fh(boolean z) {
        if (com.baidu.tbadk.core.util.v.I(this.bGa) != 0) {
            for (am amVar : this.bGa) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.x("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bGa.clear();
        }
    }

    public void XY() {
        if (com.baidu.tbadk.core.util.v.I(this.bGa) != 0) {
            for (am amVar : this.bGa) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bGa.clear();
        }
    }
}
