package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r fFK;
    private List<an> dTq;

    public static r bsy() {
        if (fFK == null) {
            synchronized (r.class) {
                if (fFK == null) {
                    fFK = new r();
                }
            }
        }
        return fFK;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTq == null) {
                this.dTq = new ArrayList();
            }
            this.dTq.add(anVar);
        }
    }

    public void hK(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dTq) != 0) {
            int i2 = -1;
            for (an anVar : this.dTq) {
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
            this.dTq.clear();
        }
    }

    public void kc(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dTq) != 0) {
            for (an anVar : this.dTq) {
                if (anVar != null) {
                    anVar.Z("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dTq.clear();
        }
    }

    public void aZg() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dTq) != 0) {
            for (an anVar : this.dTq) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dTq.clear();
        }
    }
}
