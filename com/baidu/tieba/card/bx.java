package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bx {
    private static bx beJ;
    private List<com.baidu.tbadk.core.util.av> beI;

    public static bx Pl() {
        if (beJ == null) {
            synchronized (bx.class) {
                if (beJ == null) {
                    beJ = new bx();
                }
            }
        }
        return beJ;
    }

    public void a(com.baidu.tbadk.core.util.av avVar) {
        if (avVar != null) {
            if (this.beI == null) {
                this.beI = new ArrayList();
            }
            if (this.beI != null) {
                this.beI.add(avVar);
            }
        }
    }

    public void hU(String str) {
        if (str != null) {
            if (this.beI == null) {
                this.beI = new ArrayList();
            }
            if (this.beI != null) {
                this.beI.add(new com.baidu.tbadk.core.util.av(str));
            }
        }
    }

    public void cw(boolean z) {
        if (com.baidu.tbadk.core.util.x.s(this.beI) != 0) {
            for (com.baidu.tbadk.core.util.av avVar : this.beI) {
                if (avVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    avVar.s("obj_param2", i);
                    TiebaStatic.log(avVar);
                }
            }
            this.beI.clear();
        }
    }

    public void cx(boolean z) {
        if (com.baidu.tbadk.core.util.x.s(this.beI) != 0) {
            for (com.baidu.tbadk.core.util.av avVar : this.beI) {
                if (avVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    avVar.s("obj_type", i);
                    TiebaStatic.log(avVar);
                }
            }
            this.beI.clear();
        }
    }

    public void Pm() {
        if (com.baidu.tbadk.core.util.x.s(this.beI) != 0) {
            for (com.baidu.tbadk.core.util.av avVar : this.beI) {
                if (avVar != null) {
                    TiebaStatic.log(avVar);
                }
            }
            this.beI.clear();
        }
    }
}
