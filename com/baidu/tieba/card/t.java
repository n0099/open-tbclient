package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t eNX;
    private List<an> dfF;

    public static t bau() {
        if (eNX == null) {
            synchronized (t.class) {
                if (eNX == null) {
                    eNX = new t();
                }
            }
        }
        return eNX;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dfF == null) {
                this.dfF = new ArrayList();
            }
            this.dfF.add(anVar);
        }
    }

    public void gF(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dfF) != 0) {
            int i2 = -1;
            for (an anVar : this.dfF) {
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
            this.dfF.clear();
        }
    }

    public void iK(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dfF) != 0) {
            for (an anVar : this.dfF) {
                if (anVar != null) {
                    anVar.O("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dfF.clear();
        }
    }

    public void aIJ() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dfF) != 0) {
            for (an anVar : this.dfF) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dfF.clear();
        }
    }
}
