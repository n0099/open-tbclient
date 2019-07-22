package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t eEr;
    private List<an> cWa;

    public static t aZN() {
        if (eEr == null) {
            synchronized (t.class) {
                if (eEr == null) {
                    eEr = new t();
                }
            }
        }
        return eEr;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.cWa == null) {
                this.cWa = new ArrayList();
            }
            this.cWa.add(anVar);
        }
    }

    public void gS(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.Z(this.cWa) != 0) {
            int i2 = -1;
            for (an anVar : this.cWa) {
                if (anVar != null) {
                    if (i2 != anVar.getPosition()) {
                        int position = anVar.getPosition();
                        anVar.P("obj_param2", z ? 1 : 0);
                        TiebaStatic.log(anVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.cWa.clear();
        }
    }

    public void iE(boolean z) {
        if (com.baidu.tbadk.core.util.v.Z(this.cWa) != 0) {
            for (an anVar : this.cWa) {
                if (anVar != null) {
                    anVar.P("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.cWa.clear();
        }
    }

    public void aHX() {
        if (com.baidu.tbadk.core.util.v.Z(this.cWa) != 0) {
            for (an anVar : this.cWa) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.cWa.clear();
        }
    }
}
