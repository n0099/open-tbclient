package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ejW;
    private List<am> cMr;

    public static t aQF() {
        if (ejW == null) {
            synchronized (t.class) {
                if (ejW == null) {
                    ejW = new t();
                }
            }
        }
        return ejW;
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cMr == null) {
                this.cMr = new ArrayList();
            }
            this.cMr.add(amVar);
        }
    }

    public void go(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.S(this.cMr) != 0) {
            int i2 = -1;
            for (am amVar : this.cMr) {
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
            this.cMr.clear();
        }
    }

    public void hQ(boolean z) {
        if (com.baidu.tbadk.core.util.v.S(this.cMr) != 0) {
            for (am amVar : this.cMr) {
                if (amVar != null) {
                    amVar.T("obj_type", z ? 1 : 0);
                    TiebaStatic.log(amVar);
                }
            }
            this.cMr.clear();
        }
    }

    public void aAo() {
        if (com.baidu.tbadk.core.util.v.S(this.cMr) != 0) {
            for (am amVar : this.cMr) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.cMr.clear();
        }
    }
}
