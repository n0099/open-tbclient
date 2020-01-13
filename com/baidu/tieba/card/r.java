package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r fIU;
    private List<an> dTz;

    public static r btA() {
        if (fIU == null) {
            synchronized (r.class) {
                if (fIU == null) {
                    fIU = new r();
                }
            }
        }
        return fIU;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTz == null) {
                this.dTz = new ArrayList();
            }
            this.dTz.add(anVar);
        }
    }

    public void hU(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dTz) != 0) {
            int i2 = -1;
            for (an anVar : this.dTz) {
                if (anVar != null) {
                    if (i2 != anVar.getPosition()) {
                        int position = anVar.getPosition();
                        anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(anVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.dTz.clear();
        }
    }

    public void kn(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dTz) != 0) {
            for (an anVar : this.dTz) {
                if (anVar != null) {
                    anVar.Z("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dTz.clear();
        }
    }

    public void aZA() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dTz) != 0) {
            for (an anVar : this.dTz) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dTz.clear();
        }
    }
}
