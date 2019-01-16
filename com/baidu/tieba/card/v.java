package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v dae;
    private List<am> bLr;

    public static v aqP() {
        if (dae == null) {
            synchronized (v.class) {
                if (dae == null) {
                    dae = new v();
                }
            }
        }
        return dae;
    }

    public void a(am amVar) {
        if (amVar != null) {
            if (this.bLr == null) {
                this.bLr = new ArrayList();
            }
            if (this.bLr != null) {
                this.bLr.add(amVar);
            }
        }
    }

    public void dT(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bLr) != 0) {
            for (am amVar : this.bLr) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.y("obj_param2", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bLr.clear();
        }
    }

    public void fy(boolean z) {
        if (com.baidu.tbadk.core.util.v.H(this.bLr) != 0) {
            for (am amVar : this.bLr) {
                if (amVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    amVar.y("obj_type", i);
                    TiebaStatic.log(amVar);
                }
            }
            this.bLr.clear();
        }
    }

    public void ZM() {
        if (com.baidu.tbadk.core.util.v.H(this.bLr) != 0) {
            for (am amVar : this.bLr) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.bLr.clear();
        }
    }
}
