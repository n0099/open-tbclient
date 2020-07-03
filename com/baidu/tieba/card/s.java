package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s gSU;
    private List<ao> eXh;

    public static s bOA() {
        if (gSU == null) {
            synchronized (s.class) {
                if (gSU == null) {
                    gSU = new s();
                }
            }
        }
        return gSU;
    }

    public void e(ao aoVar) {
        if (aoVar != null) {
            if (this.eXh == null) {
                this.eXh = new ArrayList();
            }
            this.eXh.add(aoVar);
        }
    }

    public void jI(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.w.getCount(this.eXh) != 0) {
            int i2 = -1;
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    if (i2 != aoVar.getPosition()) {
                        int position = aoVar.getPosition();
                        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(aoVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.eXh.clear();
        }
    }

    public void mc(boolean z) {
        if (com.baidu.tbadk.core.util.w.getCount(this.eXh) != 0) {
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    aoVar.ag("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aoVar);
                }
            }
            this.eXh.clear();
        }
    }

    public void brT() {
        if (com.baidu.tbadk.core.util.w.getCount(this.eXh) != 0) {
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    TiebaStatic.log(aoVar);
                }
            }
            this.eXh.clear();
        }
    }
}
