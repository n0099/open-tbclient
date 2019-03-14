package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ejS;
    private List<am> cMo;

    public static t aQF() {
        if (ejS == null) {
            synchronized (t.class) {
                if (ejS == null) {
                    ejS = new t();
                }
            }
        }
        return ejS;
    }

    public void b(am amVar) {
        if (amVar != null) {
            if (this.cMo == null) {
                this.cMo = new ArrayList();
            }
            this.cMo.add(amVar);
        }
    }

    public void go(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.S(this.cMo) != 0) {
            int i2 = -1;
            for (am amVar : this.cMo) {
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
            this.cMo.clear();
        }
    }

    public void hQ(boolean z) {
        if (com.baidu.tbadk.core.util.v.S(this.cMo) != 0) {
            for (am amVar : this.cMo) {
                if (amVar != null) {
                    amVar.T("obj_type", z ? 1 : 0);
                    TiebaStatic.log(amVar);
                }
            }
            this.cMo.clear();
        }
    }

    public void aAo() {
        if (com.baidu.tbadk.core.util.v.S(this.cMo) != 0) {
            for (am amVar : this.cMo) {
                if (amVar != null) {
                    TiebaStatic.log(amVar);
                }
            }
            this.cMo.clear();
        }
    }
}
