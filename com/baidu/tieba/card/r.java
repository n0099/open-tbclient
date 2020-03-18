package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r fMo;
    private List<an> dYi;

    public static r bvm() {
        if (fMo == null) {
            synchronized (r.class) {
                if (fMo == null) {
                    fMo = new r();
                }
            }
        }
        return fMo;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.dYi == null) {
                this.dYi = new ArrayList();
            }
            this.dYi.add(anVar);
        }
    }

    public void id(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.dYi) != 0) {
            int i2 = -1;
            for (an anVar : this.dYi) {
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
            this.dYi.clear();
        }
    }

    public void ku(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.dYi) != 0) {
            for (an anVar : this.dYi) {
                if (anVar != null) {
                    anVar.X("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.dYi.clear();
        }
    }

    public void bbW() {
        if (com.baidu.tbadk.core.util.v.getCount(this.dYi) != 0) {
            for (an anVar : this.dYi) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dYi.clear();
        }
    }
}
