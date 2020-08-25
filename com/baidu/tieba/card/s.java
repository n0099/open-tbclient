package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class s {
    private static s hls;
    private List<aq> fnc;

    public static s cbX() {
        if (hls == null) {
            synchronized (s.class) {
                if (hls == null) {
                    hls = new s();
                }
            }
        }
        return hls;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fnc == null) {
                this.fnc = new ArrayList();
            }
            this.fnc.add(aqVar);
        }
    }

    public void kK(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fnc) != 0) {
            int i2 = -1;
            for (aq aqVar : this.fnc) {
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
            this.fnc.clear();
        }
    }

    public void nk(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fnc) != 0) {
            for (aq aqVar : this.fnc) {
                if (aqVar != null) {
                    aqVar.ai("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.fnc.clear();
        }
    }

    public void bDV() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fnc) != 0) {
            for (aq aqVar : this.fnc) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fnc.clear();
        }
    }
}
