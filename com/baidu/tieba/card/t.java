package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t eEy;
    private List<an> cWh;

    public static t aZP() {
        if (eEy == null) {
            synchronized (t.class) {
                if (eEy == null) {
                    eEy = new t();
                }
            }
        }
        return eEy;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.cWh == null) {
                this.cWh = new ArrayList();
            }
            this.cWh.add(anVar);
        }
    }

    public void gS(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.Z(this.cWh) != 0) {
            int i2 = -1;
            for (an anVar : this.cWh) {
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
            this.cWh.clear();
        }
    }

    public void iE(boolean z) {
        if (com.baidu.tbadk.core.util.v.Z(this.cWh) != 0) {
            for (an anVar : this.cWh) {
                if (anVar != null) {
                    anVar.P("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.cWh.clear();
        }
    }

    public void aHZ() {
        if (com.baidu.tbadk.core.util.v.Z(this.cWh) != 0) {
            for (an anVar : this.cWh) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.cWh.clear();
        }
    }
}
