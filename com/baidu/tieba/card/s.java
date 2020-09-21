package com.baidu.tieba.card;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private static s hsz;
    private List<aq> fql;

    public static s cfn() {
        if (hsz == null) {
            synchronized (s.class) {
                if (hsz == null) {
                    hsz = new s();
                }
            }
        }
        return hsz;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fql == null) {
                this.fql = new ArrayList();
            }
            this.fql.add(aqVar);
        }
    }

    public void kO(boolean z) {
        int i;
        if (com.baidu.tbadk.core.util.y.getCount(this.fql) != 0) {
            int i2 = -1;
            for (aq aqVar : this.fql) {
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
            this.fql.clear();
        }
    }

    public void ns(boolean z) {
        if (com.baidu.tbadk.core.util.y.getCount(this.fql) != 0) {
            for (aq aqVar : this.fql) {
                if (aqVar != null) {
                    aqVar.ai("obj_type", z ? 1 : 0);
                    TiebaStatic.log(aqVar);
                }
            }
            this.fql.clear();
        }
    }

    public void bFm() {
        if (com.baidu.tbadk.core.util.y.getCount(this.fql) != 0) {
            for (aq aqVar : this.fql) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fql.clear();
        }
    }
}
