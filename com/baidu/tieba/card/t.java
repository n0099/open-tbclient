package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private static t ilm;
    private List<ar> fYD;

    public static t csh() {
        if (ilm == null) {
            synchronized (t.class) {
                if (ilm == null) {
                    ilm = new t();
                }
            }
        }
        return ilm;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYD == null) {
                this.fYD = new ArrayList();
            }
            this.fYD.add(arVar);
        }
    }

    public void mj(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fYD) != 0) {
            int i2 = -1;
            for (ar arVar : this.fYD) {
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
            this.fYD.clear();
        }
    }

    public void oX(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fYD) != 0) {
            for (ar arVar : this.fYD) {
                if (arVar != null) {
                    arVar.al("obj_type", z ? 1 : 0);
                    TiebaStatic.log(arVar);
                }
            }
            this.fYD.clear();
        }
    }

    public void bPs() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fYD) != 0) {
            for (ar arVar : this.fYD) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fYD.clear();
        }
    }
}
