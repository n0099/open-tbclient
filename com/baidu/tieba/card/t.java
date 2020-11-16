package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t iao;
    private List<ar> fQs;

    public static t cnT() {
        if (iao == null) {
            synchronized (t.class) {
                if (iao == null) {
                    iao = new t();
                }
            }
        }
        return iao;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fQs == null) {
                this.fQs = new ArrayList();
            }
            this.fQs.add(arVar);
        }
    }

    public void lO(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fQs) != 0) {
            int i2 = -1;
            for (ar arVar : this.fQs) {
                if (arVar != null) {
                    if (i2 != arVar.getPosition()) {
                        int position = arVar.getPosition();
                        arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(arVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.fQs.clear();
        }
    }

    public void oB(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fQs) != 0) {
            for (ar arVar : this.fQs) {
                if (arVar != null) {
                    arVar.ak("obj_type", z ? 1 : 0);
                    TiebaStatic.log(arVar);
                }
            }
            this.fQs.clear();
        }
    }

    public void bLI() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fQs) != 0) {
            for (ar arVar : this.fQs) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fQs.clear();
        }
    }
}
