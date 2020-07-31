package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s gYz;
    private List<ap> fbI;

    public static s bRL() {
        if (gYz == null) {
            synchronized (s.class) {
                if (gYz == null) {
                    gYz = new s();
                }
            }
        }
        return gYz;
    }

    public void e(ap apVar) {
        if (apVar != null) {
            if (this.fbI == null) {
                this.fbI = new ArrayList();
            }
            this.fbI.add(apVar);
        }
    }

    public void km(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.x.getCount(this.fbI) != 0) {
            int i2 = -1;
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    if (i2 != apVar.getPosition()) {
                        int position = apVar.getPosition();
                        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(apVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.fbI.clear();
        }
    }

    public void mH(boolean z) {
        if (com.baidu.tbadk.core.util.x.getCount(this.fbI) != 0) {
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    apVar.ah("obj_type", z ? 1 : 0);
                    TiebaStatic.log(apVar);
                }
            }
            this.fbI.clear();
        }
    }

    public void bva() {
        if (com.baidu.tbadk.core.util.x.getCount(this.fbI) != 0) {
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    TiebaStatic.log(apVar);
                }
            }
            this.fbI.clear();
        }
    }
}
