package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r gqV;
    private List<an> eyd;

    public static r bEY() {
        if (gqV == null) {
            synchronized (r.class) {
                if (gqV == null) {
                    gqV = new r();
                }
            }
        }
        return gqV;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyd == null) {
                this.eyd = new ArrayList();
            }
            this.eyd.add(anVar);
        }
    }

    public void jd(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.v.getCount(this.eyd) != 0) {
            int i2 = -1;
            for (an anVar : this.eyd) {
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
            this.eyd.clear();
        }
    }

    public void lx(boolean z) {
        if (com.baidu.tbadk.core.util.v.getCount(this.eyd) != 0) {
            for (an anVar : this.eyd) {
                if (anVar != null) {
                    anVar.af("obj_type", z ? 1 : 0);
                    TiebaStatic.log(anVar);
                }
            }
            this.eyd.clear();
        }
    }

    public void bjZ() {
        if (com.baidu.tbadk.core.util.v.getCount(this.eyd) != 0) {
            for (an anVar : this.eyd) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eyd.clear();
        }
    }
}
