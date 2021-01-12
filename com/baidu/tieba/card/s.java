package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s ita;
    private List<aq> gdB;

    public static s crj() {
        if (ita == null) {
            synchronized (s.class) {
                if (ita == null) {
                    ita = new s();
                }
            }
        }
        return ita;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gdB == null) {
                this.gdB = new ArrayList();
            }
            this.gdB.add(aqVar);
        }
    }

    public void mC(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.x.getCount(this.gdB) != 0) {
            int i2 = -1;
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    if (i2 != aqVar.getPosition()) {
                        int position = aqVar.getPosition();
                        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(aqVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.gdB.clear();
        }
    }

    public void pr(boolean z) {
        if (com.baidu.tbadk.core.util.x.getCount(this.gdB) != 0) {
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    aqVar.an("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.gdB.clear();
        }
    }

    public void bOb() {
        if (com.baidu.tbadk.core.util.x.getCount(this.gdB) != 0) {
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.gdB.clear();
        }
    }
}
