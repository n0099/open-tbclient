package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ejE;
    private List<am> cMq;

    public static t aQD() {
        if (ejE == null) {
            synchronized (t.class) {
                if (ejE == null) {
                    ejE = new t();
                }
            }
        }
        return ejE;
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cMq == null) {
                this.cMq = new ArrayList();
            }
            this.cMq.add(amVar);
        }
    }

    public void go(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.S(this.cMq) != 0) {
            int i2 = -1;
            for (am amVar : this.cMq) {
                if (amVar != null) {
                    if (amVar.getPosition() == 0) {
                        amVar.T("obj_param2", z ? 1 : 0);
                        TiebaStatic.log(amVar);
                        i = i2;
                    } else if (i2 != amVar.getPosition()) {
                        int position = amVar.getPosition();
                        amVar.T("obj_param2", z ? 1 : 0);
                        TiebaStatic.log(amVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.cMq.clear();
        }
    }

    public void hQ(boolean z) {
        if (com.baidu.tbadk.core.util.v.S(this.cMq) != 0) {
            for (am amVar : this.cMq) {
                if (amVar != null) {
                    amVar.T("obj_type", z ? 1 : 0);
                    TiebaStatic.log(amVar);
                }
            }
            this.cMq.clear();
        }
    }

    public void aAl() {
        if (com.baidu.tbadk.core.util.v.S(this.cMq) != 0) {
            for (am amVar : this.cMq) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.cMq.clear();
        }
    }
}
