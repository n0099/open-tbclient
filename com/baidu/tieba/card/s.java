package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s hlw;
    private List<aq> fng;

    public static s cbY() {
        if (hlw == null) {
            synchronized (s.class) {
                if (hlw == null) {
                    hlw = new s();
                }
            }
        }
        return hlw;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fng == null) {
                this.fng = new ArrayList();
            }
            this.fng.add(aqVar);
        }
    }

    public void kM(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fng) != 0) {
            int i2 = -1;
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    if (i2 != aqVar.getPosition()) {
                        int position = aqVar.getPosition();
                        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, z ? 1 : 0);
                        TiebaStatic.log(aqVar);
                        i = position;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            }
            this.fng.clear();
        }
    }

    public void nm(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fng) != 0) {
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    aqVar.ai("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.fng.clear();
        }
    }

    public void bDW() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fng) != 0) {
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fng.clear();
        }
    }
}
