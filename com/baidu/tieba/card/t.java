package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ilk;
    private List<ar> fYB;

    public static t csg() {
        if (ilk == null) {
            synchronized (t.class) {
                if (ilk == null) {
                    ilk = new t();
                }
            }
        }
        return ilk;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYB == null) {
                this.fYB = new ArrayList();
            }
            this.fYB.add(arVar);
        }
    }

    public void mj(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fYB) != 0) {
            int i2 = -1;
            for (ar arVar : this.fYB) {
                if (arVar != null) {
                    if (i2 != arVar.getPosition()) {
                        int position = arVar.getPosition();
                        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(arVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.fYB.clear();
        }
    }

    public void oX(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fYB) != 0) {
            for (ar arVar : this.fYB) {
                if (arVar != null) {
                    arVar.al("obj_type", z ? 1 : 0);
                    TiebaStatic.log(arVar);
                }
            }
            this.fYB.clear();
        }
    }

    public void bPr() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fYB) != 0) {
            for (ar arVar : this.fYB) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fYB.clear();
        }
    }
}
