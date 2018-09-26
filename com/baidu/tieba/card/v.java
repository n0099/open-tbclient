package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cGw;
    private List<am> bxr;

    public static v akM() {
        if (cGw == null) {
            synchronized (v.class) {
                if (cGw == null) {
                    cGw = new v();
                }
            }
        }
        return cGw;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bxr == null) {
                this.bxr = new ArrayList();
            }
            if (this.bxr != null) {
                this.bxr.add(amVar);
            }
        }
    }

    public void dc(boolean z) {
        if (com.baidu.tbadk.core.util.v.y(this.bxr) != 0) {
            for (am amVar : this.bxr) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.w("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bxr.clear();
        }
    }

    public void eP(boolean z) {
        if (com.baidu.tbadk.core.util.v.y(this.bxr) != 0) {
            for (am amVar : this.bxr) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.w("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bxr.clear();
        }
    }

    public void Up() {
        if (com.baidu.tbadk.core.util.v.y(this.bxr) != 0) {
            for (am amVar : this.bxr) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bxr.clear();
        }
    }
}
