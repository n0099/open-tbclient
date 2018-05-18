package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v {
    private static v crJ;
    private List<al> bhk;

    public static v afy() {
        if (crJ == null) {
            synchronized (v.class) {
                if (crJ == null) {
                    crJ = new v();
                }
            }
        }
        return crJ;
    }

    public void a(al alVar) {
        if (alVar != null) {
            if (this.bhk == null) {
                this.bhk = new ArrayList();
            }
            if (this.bhk != null) {
                this.bhk.add(alVar);
            }
        }
    }

    public void cB(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhk) != 0) {
            for (al alVar : this.bhk) {
                if (alVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    alVar.r("obj_param2", i);
                    TiebaStatic.log(alVar);
                }
            }
            this.bhk.clear();
        }
    }

    public void eu(boolean z) {
        if (com.baidu.tbadk.core.util.v.v(this.bhk) != 0) {
            for (al alVar : this.bhk) {
                if (alVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    alVar.r("obj_type", i);
                    TiebaStatic.log(alVar);
                }
            }
            this.bhk.clear();
        }
    }

    public void Ov() {
        if (com.baidu.tbadk.core.util.v.v(this.bhk) != 0) {
            for (al alVar : this.bhk) {
                if (alVar != null) {
                    TiebaStatic.log(alVar);
                }
            }
            this.bhk.clear();
        }
    }
}
