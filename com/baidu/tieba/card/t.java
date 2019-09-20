package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t eGh;
    private List<an> cXa;

    public static t bat() {
        if (eGh == null) {
            synchronized (t.class) {
                if (eGh == null) {
                    eGh = new t();
                }
            }
        }
        return eGh;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.cXa == null) {
                this.cXa = new ArrayList();
            }
            this.cXa.add(anVar);
        }
    }

    public void gV(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.Z(this.cXa) != 0) {
            int i2 = -1;
            for (an anVar : this.cXa) {
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
            this.cXa.clear();
        }
    }

    public void iH(boolean z) {
        if (com.baidu.tbadk.core.util.v.Z(this.cXa) != 0) {
            for (an anVar : this.cXa) {
                if (anVar != null) {
                    anVar.P("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.cXa.clear();
        }
    }

    public void aID() {
        if (com.baidu.tbadk.core.util.v.Z(this.cXa) != 0) {
            for (an anVar : this.cXa) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.cXa.clear();
        }
    }
}
