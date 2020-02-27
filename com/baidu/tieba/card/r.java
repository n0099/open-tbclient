package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r fLr;
    private List<an> dXE;

    public static r bve() {
        if (fLr == null) {
            synchronized (r.class) {
                if (fLr == null) {
                    fLr = new r();
                }
            }
        }
        return fLr;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXE == null) {
                this.dXE = new ArrayList();
            }
            this.dXE.add(anVar);
        }
    }

    public void ib(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dXE) != 0) {
            int i2 = -1;
            for (an anVar : this.dXE) {
                if (anVar != null) {
                    if (i2 != anVar.getPosition()) {
                        int position = anVar.getPosition();
                        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(anVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.dXE.clear();
        }
    }

    public void kp(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dXE) != 0) {
            for (an anVar : this.dXE) {
                if (anVar != null) {
                    anVar.X("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dXE.clear();
        }
    }

    public void bbP() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dXE) != 0) {
            for (an anVar : this.dXE) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXE.clear();
        }
    }
}
