package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t iAH;
    private List<ar> ghy;

    public static t csH() {
        if (iAH == null) {
            synchronized (t.class) {
                if (iAH == null) {
                    iAH = new t();
                }
            }
        }
        return iAH;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.ghy == null) {
                this.ghy = new ArrayList();
            }
            this.ghy.add(arVar);
        }
    }

    public void mG(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.ghy) != 0) {
            int i2 = -1;
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    if (i2 != arVar.getPosition()) {
                        int position = arVar.getPosition();
                        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(arVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.ghy.clear();
        }
    }

    public void pB(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.ghy) != 0) {
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    arVar.aq("obj_type", z ? 1 : 0);
                    TiebaStatic.log(arVar);
                }
            }
            this.ghy.clear();
        }
    }

    public void bOS() {
        if (com.baidu.tbadk.core.util.y.getCount(this.ghy) != 0) {
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.ghy.clear();
        }
    }
}
