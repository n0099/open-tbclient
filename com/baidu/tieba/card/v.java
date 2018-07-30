package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cAH;
    private List<an> bry;

    public static v aiY() {
        if (cAH == null) {
            synchronized (v.class) {
                if (cAH == null) {
                    cAH = new v();
                }
            }
        }
        return cAH;
    }

    public void a(an anVar) {
        if (anVar != null) {
            if (this.bry == null) {
                this.bry = new ArrayList();
            }
            if (this.bry != null) {
                this.bry.add(anVar);
            }
        }
    }

    public void cK(boolean z) {
        if (com.baidu.tbadk.core.util.w.y(this.bry) != 0) {
            for (an anVar : this.bry) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    anVar.r("obj_param2", i);
                    TiebaStatic.log(anVar);
                }
            }
            this.bry.clear();
        }
    }

    public void ey(boolean z) {
        if (com.baidu.tbadk.core.util.w.y(this.bry) != 0) {
            for (an anVar : this.bry) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    anVar.r("obj_type", i);
                    TiebaStatic.log(anVar);
                }
            }
            this.bry.clear();
        }
    }

    public void Sy() {
        if (com.baidu.tbadk.core.util.w.y(this.bry) != 0) {
            for (an anVar : this.bry) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.bry.clear();
        }
    }
}
