package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s ixH;
    private List<aq> gik;

    public static s cvb() {
        if (ixH == null) {
            synchronized (s.class) {
                if (ixH == null) {
                    ixH = new s();
                }
            }
        }
        return ixH;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gik == null) {
                this.gik = new ArrayList();
            }
            this.gik.add(aqVar);
        }
    }

    public void mG(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.x.getCount(this.gik) != 0) {
            int i2 = -1;
            for (aq aqVar : this.gik) {
                if (aqVar != null) {
                    if (i2 != aqVar.getPosition()) {
                        int position = aqVar.getPosition();
                        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(aqVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.gik.clear();
        }
    }

    public void pv(boolean z) {
        if (com.baidu.tbadk.core.util.x.getCount(this.gik) != 0) {
            for (aq aqVar : this.gik) {
                if (aqVar != null) {
                    aqVar.an("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.gik.clear();
        }
    }

    public void bRT() {
        if (com.baidu.tbadk.core.util.x.getCount(this.gik) != 0) {
            for (aq aqVar : this.gik) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.gik.clear();
        }
    }
}
