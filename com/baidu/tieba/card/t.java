package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t hTQ;
    private List<aq> fKT;

    public static t clQ() {
        if (hTQ == null) {
            synchronized (t.class) {
                if (hTQ == null) {
                    hTQ = new t();
                }
            }
        }
        return hTQ;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fKT == null) {
                this.fKT = new ArrayList();
            }
            this.fKT.add(aqVar);
        }
    }

    public void lE(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fKT) != 0) {
            int i2 = -1;
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    if (i2 != aqVar.getPosition()) {
                        int position = aqVar.getPosition();
                        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(aqVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.fKT.clear();
        }
    }

    public void op(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fKT) != 0) {
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    aqVar.aj("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.fKT.clear();
        }
    }

    public void bJQ() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fKT) != 0) {
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fKT.clear();
        }
    }
}
