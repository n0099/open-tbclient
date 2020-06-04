package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s gGb;
    private List<an> eMV;

    public static s bLs() {
        if (gGb == null) {
            synchronized (s.class) {
                if (gGb == null) {
                    gGb = new s();
                }
            }
        }
        return gGb;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMV == null) {
                this.eMV = new ArrayList();
            }
            this.eMV.add(anVar);
        }
    }

    public void jv(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.eMV) != 0) {
            int i2 = -1;
            for (an anVar : this.eMV) {
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
            this.eMV.clear();
        }
    }

    public void lT(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.eMV) != 0) {
            for (an anVar : this.eMV) {
                if (anVar != null) {
                    anVar.ag("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.eMV.clear();
        }
    }

    public void bpt() {
        if (com.baidu.tbadk.core.util.v.getCount(this.eMV) != 0) {
            for (an anVar : this.eMV) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eMV.clear();
        }
    }
}
