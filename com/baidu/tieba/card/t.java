package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ezt;
    private List<am> cUC;

    public static t aXM() {
        if (ezt == null) {
            synchronized (t.class) {
                if (ezt == null) {
                    ezt = new t();
                }
            }
        }
        return ezt;
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cUC == null) {
                this.cUC = new ArrayList();
            }
            this.cUC.add(amVar);
        }
    }

    public void gM(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.Z(this.cUC) != 0) {
            int i2 = -1;
            for (am amVar : this.cUC) {
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
            this.cUC.clear();
        }
    }

    public void iv(boolean z) {
        if (com.baidu.tbadk.core.util.v.Z(this.cUC) != 0) {
            for (am amVar : this.cUC) {
                if (amVar != null) {
                    amVar.P("obj_type", z ? 1 : 0);
                    TiebaStatic.log(amVar);
                }
            }
            this.cUC.clear();
        }
    }

    public void aGx() {
        if (com.baidu.tbadk.core.util.v.Z(this.cUC) != 0) {
            for (am amVar : this.cUC) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.cUC.clear();
        }
    }
}
