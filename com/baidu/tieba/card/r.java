package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r grb;
    private List<an> eyj;

    public static r bEW() {
        if (grb == null) {
            synchronized (r.class) {
                if (grb == null) {
                    grb = new r();
                }
            }
        }
        return grb;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyj == null) {
                this.eyj = new ArrayList();
            }
            this.eyj.add(anVar);
        }
    }

    public void jd(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.eyj) != 0) {
            int i2 = -1;
            for (an anVar : this.eyj) {
                if (anVar != null) {
                    if (i2 != anVar.getPosition()) {
                        int position = anVar.getPosition();
                        anVar.af(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(anVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.eyj.clear();
        }
    }

    public void lx(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.eyj) != 0) {
            for (an anVar : this.eyj) {
                if (anVar != null) {
                    anVar.af("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.eyj.clear();
        }
    }

    public void bjX() {
        if (com.baidu.tbadk.core.util.v.getCount(this.eyj) != 0) {
            for (an anVar : this.eyj) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eyj.clear();
        }
    }
}
