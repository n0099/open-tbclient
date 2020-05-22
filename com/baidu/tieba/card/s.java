package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s gFQ;
    private List<an> eMK;

    public static s bLq() {
        if (gFQ == null) {
            synchronized (s.class) {
                if (gFQ == null) {
                    gFQ = new s();
                }
            }
        }
        return gFQ;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMK == null) {
                this.eMK = new ArrayList();
            }
            this.eMK.add(anVar);
        }
    }

    public void jv(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.eMK) != 0) {
            int i2 = -1;
            for (an anVar : this.eMK) {
                if (anVar != null) {
                    if (i2 != anVar.getPosition()) {
                        int position = anVar.getPosition();
                        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(anVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.eMK.clear();
        }
    }

    public void lT(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.eMK) != 0) {
            for (an anVar : this.eMK) {
                if (anVar != null) {
                    anVar.ag("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.eMK.clear();
        }
    }

    public void bpr() {
        if (com.baidu.tbadk.core.util.v.getCount(this.eMK) != 0) {
            for (an anVar : this.eMK) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eMK.clear();
        }
    }
}
