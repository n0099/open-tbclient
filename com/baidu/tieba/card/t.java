package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t hZN;
    private List<aq> fQJ;

    public static t cor() {
        if (hZN == null) {
            synchronized (t.class) {
                if (hZN == null) {
                    hZN = new t();
                }
            }
        }
        return hZN;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fQJ == null) {
                this.fQJ = new ArrayList();
            }
            this.fQJ.add(aqVar);
        }
    }

    public void lN(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fQJ) != 0) {
            int i2 = -1;
            for (aq aqVar : this.fQJ) {
                if (aqVar != null) {
                    if (i2 != aqVar.getPosition()) {
                        int position = aqVar.getPosition();
                        aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(aqVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.fQJ.clear();
        }
    }

    public void oy(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fQJ) != 0) {
            for (aq aqVar : this.fQJ) {
                if (aqVar != null) {
                    aqVar.al("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.fQJ.clear();
        }
    }

    public void bMp() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fQJ) != 0) {
            for (aq aqVar : this.fQJ) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fQJ.clear();
        }
    }
}
