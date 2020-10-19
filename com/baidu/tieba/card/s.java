package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s hHt;
    private List<aq> fCy;

    public static s ciJ() {
        if (hHt == null) {
            synchronized (s.class) {
                if (hHt == null) {
                    hHt = new s();
                }
            }
        }
        return hHt;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fCy == null) {
                this.fCy = new ArrayList();
            }
            this.fCy.add(aqVar);
        }
    }

    public void lm(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fCy) != 0) {
            int i2 = -1;
            for (aq aqVar : this.fCy) {
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
            this.fCy.clear();
        }
    }

    public void nX(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fCy) != 0) {
            for (aq aqVar : this.fCy) {
                if (aqVar != null) {
                    aqVar.aj("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.fCy.clear();
        }
    }

    public void bHY() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fCy) != 0) {
            for (aq aqVar : this.fCy) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fCy.clear();
        }
    }
}
