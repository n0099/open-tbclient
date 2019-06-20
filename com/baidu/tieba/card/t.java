package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ezu;
    private List<am> cUE;

    public static t aXP() {
        if (ezu == null) {
            synchronized (t.class) {
                if (ezu == null) {
                    ezu = new t();
                }
            }
        }
        return ezu;
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cUE == null) {
                this.cUE = new ArrayList();
            }
            this.cUE.add(amVar);
        }
    }

    public void gM(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.Z(this.cUE) != 0) {
            int i2 = -1;
            for (am amVar : this.cUE) {
                if (amVar != null) {
                    if (i2 != amVar.getPosition()) {
                        int position = amVar.getPosition();
                        amVar.P("obj_param2", z ? 1 : 0);
                        TiebaStatic.log(amVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.cUE.clear();
        }
    }

    public void iv(boolean z) {
        if (com.baidu.tbadk.core.util.v.Z(this.cUE) != 0) {
            for (am amVar : this.cUE) {
                if (amVar != null) {
                    amVar.P("obj_type", z ? 1 : 0);
                    TiebaStatic.log(amVar);
                }
            }
            this.cUE.clear();
        }
    }

    public void aGA() {
        if (com.baidu.tbadk.core.util.v.Z(this.cUE) != 0) {
            for (am amVar : this.cUE) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.cUE.clear();
        }
    }
}
