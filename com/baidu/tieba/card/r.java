package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r fLt;
    private List<an> dXF;

    public static r bvg() {
        if (fLt == null) {
            synchronized (r.class) {
                if (fLt == null) {
                    fLt = new r();
                }
            }
        }
        return fLt;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXF == null) {
                this.dXF = new ArrayList();
            }
            this.dXF.add(anVar);
        }
    }

    public void ib(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dXF) != 0) {
            int i2 = -1;
            for (an anVar : this.dXF) {
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
            this.dXF.clear();
        }
    }

    public void kp(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dXF) != 0) {
            for (an anVar : this.dXF) {
                if (anVar != null) {
                    anVar.X("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dXF.clear();
        }
    }

    public void bbR() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dXF) != 0) {
            for (an anVar : this.dXF) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXF.clear();
        }
    }
}
