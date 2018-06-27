package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cye;
    private List<an> bqQ;

    public static v aiz() {
        if (cye == null) {
            synchronized (v.class) {
                if (cye == null) {
                    cye = new v();
                }
            }
        }
        return cye;
    }

    public void a(an anVar) {
        if (anVar != null) {
            if (this.bqQ == null) {
                this.bqQ = new ArrayList();
            }
            if (this.bqQ != null) {
                this.bqQ.add(anVar);
            }
        }
    }

    public void cK(boolean z) {
        if (com.baidu.tbadk.core.util.w.z(this.bqQ) != 0) {
            for (an anVar : this.bqQ) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    anVar.r("obj_param2", i);
                    TiebaStatic.log(anVar);
                }
            }
            this.bqQ.clear();
        }
    }

    public void ex(boolean z) {
        if (com.baidu.tbadk.core.util.w.z(this.bqQ) != 0) {
            for (an anVar : this.bqQ) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    anVar.r("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            }
            this.bqQ.clear();
        }
    }

    public void Sp() {
        if (com.baidu.tbadk.core.util.w.z(this.bqQ) != 0) {
            for (an anVar : this.bqQ) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.bqQ.clear();
        }
    }
}
