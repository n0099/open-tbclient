package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v daf;
    private List<am> bLs;

    public static v aqP() {
        if (daf == null) {
            synchronized (v.class) {
                if (daf == null) {
                    daf = new v();
                }
            }
        }
        return daf;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bLs == null) {
                this.bLs = new ArrayList();
            }
            if (this.bLs != null) {
                this.bLs.add(amVar);
            }
        }
    }

    public void dT(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bLs) != 0) {
            for (am amVar : this.bLs) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.y("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bLs.clear();
        }
    }

    public void fy(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bLs) != 0) {
            for (am amVar : this.bLs) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.y("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bLs.clear();
        }
    }

    public void ZM() {
        if (com.baidu.tbadk.core.util.v.H(this.bLs) != 0) {
            for (am amVar : this.bLs) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bLs.clear();
        }
    }
}
