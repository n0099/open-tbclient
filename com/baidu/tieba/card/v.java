package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v cqz;
    private List<al> bhf;

    public static v afy() {
        if (cqz == null) {
            synchronized (v.class) {
                if (cqz == null) {
                    cqz = new v();
                }
            }
        }
        return cqz;
    }

    public void a(al alVar) {
        if (alVar != null) {
            if (this.bhf == null) {
                this.bhf = new ArrayList();
            }
            if (this.bhf != null) {
                this.bhf.add(alVar);
            }
        }
    }

    public void cB(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhf) != 0) {
            for (al alVar : this.bhf) {
                if (alVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    alVar.r("obj_param2", i);
                    TiebaStatic.log(alVar);
                }
            }
            this.bhf.clear();
        }
    }

    public void et(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhf) != 0) {
            for (al alVar : this.bhf) {
                if (alVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    alVar.r("obj_type", i);
                    TiebaStatic.log(alVar);
                }
            }
            this.bhf.clear();
        }
    }

    public void Ox() {
        if (com.baidu.tbadk.core.util.v.v(this.bhf) != 0) {
            for (al alVar : this.bhf) {
                if (alVar != null) {
                    TiebaStatic.log(alVar);
                }
            }
            this.bhf.clear();
        }
    }
}
