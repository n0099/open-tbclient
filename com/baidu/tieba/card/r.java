package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r fLG;
    private List<an> dXS;

    public static r bvh() {
        if (fLG == null) {
            synchronized (r.class) {
                if (fLG == null) {
                    fLG = new r();
                }
            }
        }
        return fLG;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXS == null) {
                this.dXS = new ArrayList();
            }
            this.dXS.add(anVar);
        }
    }

    public void ib(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dXS) != 0) {
            int i2 = -1;
            for (an anVar : this.dXS) {
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
            this.dXS.clear();
        }
    }

    public void kp(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dXS) != 0) {
            for (an anVar : this.dXS) {
                if (anVar != null) {
                    anVar.X("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dXS.clear();
        }
    }

    public void bbS() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dXS) != 0) {
            for (an anVar : this.dXS) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXS.clear();
        }
    }
}
