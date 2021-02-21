package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t iyY;
    private List<ar> gfV;

    public static t csB() {
        if (iyY == null) {
            synchronized (t.class) {
                if (iyY == null) {
                    iyY = new t();
                }
            }
        }
        return iyY;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfV == null) {
                this.gfV = new ArrayList();
            }
            this.gfV.add(arVar);
        }
    }

    public void mG(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.gfV) != 0) {
            int i2 = -1;
            for (ar arVar : this.gfV) {
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
            this.gfV.clear();
        }
    }

    public void pB(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.gfV) != 0) {
            for (ar arVar : this.gfV) {
                if (arVar != null) {
                    arVar.ap("obj_type", z ? 1 : 0);
                    TiebaStatic.log(arVar);
                }
            }
            this.gfV.clear();
        }
    }

    public void bOM() {
        if (com.baidu.tbadk.core.util.y.getCount(this.gfV) != 0) {
            for (ar arVar : this.gfV) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.gfV.clear();
        }
    }
}
