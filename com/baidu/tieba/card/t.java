package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t eOO;
    private List<an> dgw;

    public static t baw() {
        if (eOO == null) {
            synchronized (t.class) {
                if (eOO == null) {
                    eOO = new t();
                }
            }
        }
        return eOO;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dgw == null) {
                this.dgw = new ArrayList();
            }
            this.dgw.add(anVar);
        }
    }

    public void gF(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dgw) != 0) {
            int i2 = -1;
            for (an anVar : this.dgw) {
                if (anVar != null) {
                    if (i2 != anVar.getPosition()) {
                        int position = anVar.getPosition();
                        anVar.O(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(anVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.dgw.clear();
        }
    }

    public void iK(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dgw) != 0) {
            for (an anVar : this.dgw) {
                if (anVar != null) {
                    anVar.O("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dgw.clear();
        }
    }

    public void aIL() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dgw) != 0) {
            for (an anVar : this.dgw) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dgw.clear();
        }
    }
}
