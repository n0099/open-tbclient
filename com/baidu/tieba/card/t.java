package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t iyK;
    private List<ar> gfQ;

    public static t csu() {
        if (iyK == null) {
            synchronized (t.class) {
                if (iyK == null) {
                    iyK = new t();
                }
            }
        }
        return iyK;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfQ == null) {
                this.gfQ = new ArrayList();
            }
            this.gfQ.add(arVar);
        }
    }

    public void mG(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.gfQ) != 0) {
            int i2 = -1;
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    if (i2 != arVar.getPosition()) {
                        int position = arVar.getPosition();
                        arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(arVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.gfQ.clear();
        }
    }

    public void pB(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.gfQ) != 0) {
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    arVar.ap("obj_type", z ? 1 : 0);
                    TiebaStatic.log(arVar);
                }
            }
            this.gfQ.clear();
        }
    }

    public void bOF() {
        if (com.baidu.tbadk.core.util.y.getCount(this.gfQ) != 0) {
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.gfQ.clear();
        }
    }
}
