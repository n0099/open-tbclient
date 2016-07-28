package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bw {
    private static bw aVJ;
    private List<com.baidu.tbadk.core.util.ay> aVI;

    public static bw Lf() {
        if (aVJ == null) {
            synchronized (bw.class) {
                if (aVJ == null) {
                    aVJ = new bw();
                }
            }
        }
        return aVJ;
    }

    public void b(com.baidu.tbadk.core.util.ay ayVar) {
        if (ayVar != null) {
            if (this.aVI == null) {
                this.aVI = new ArrayList();
            }
            if (this.aVI != null) {
                this.aVI.add(ayVar);
            }
        }
    }

    public void he(String str) {
        if (str != null) {
            if (this.aVI == null) {
                this.aVI = new ArrayList();
            }
            if (this.aVI != null) {
                this.aVI.add(new com.baidu.tbadk.core.util.ay(str));
            }
        }
    }

    public void cl(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.aVI) != 0) {
            for (com.baidu.tbadk.core.util.ay ayVar : this.aVI) {
                if (ayVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ayVar.s("obj_param2", i);
                    TiebaStatic.log(ayVar);
                }
            }
            this.aVI.clear();
        }
    }

    public void cm(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.aVI) != 0) {
            for (com.baidu.tbadk.core.util.ay ayVar : this.aVI) {
                if (ayVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ayVar.s("obj_type", i);
                    TiebaStatic.log(ayVar);
                }
            }
            this.aVI.clear();
        }
    }
}
