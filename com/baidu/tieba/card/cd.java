package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cd {
    private static cd bbm;
    private List<com.baidu.tbadk.core.util.ay> bbl;

    public static cd NI() {
        if (bbm == null) {
            synchronized (cd.class) {
                if (bbm == null) {
                    bbm = new cd();
                }
            }
        }
        return bbm;
    }

    public void b(com.baidu.tbadk.core.util.ay ayVar) {
        if (ayVar != null) {
            if (this.bbl == null) {
                this.bbl = new ArrayList();
            }
            if (this.bbl != null) {
                this.bbl.add(ayVar);
            }
        }
    }

    public void hJ(String str) {
        if (str != null) {
            if (this.bbl == null) {
                this.bbl = new ArrayList();
            }
            if (this.bbl != null) {
                this.bbl.add(new com.baidu.tbadk.core.util.ay(str));
            }
        }
    }

    public void cr(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.bbl) != 0) {
            for (com.baidu.tbadk.core.util.ay ayVar : this.bbl) {
                if (ayVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ayVar.s("obj_param2", i);
                    TiebaStatic.log(ayVar);
                }
            }
            this.bbl.clear();
        }
    }

    public void cs(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.bbl) != 0) {
            for (com.baidu.tbadk.core.util.ay ayVar : this.bbl) {
                if (ayVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ayVar.s("obj_type", i);
                    TiebaStatic.log(ayVar);
                }
            }
            this.bbl.clear();
        }
    }
}
