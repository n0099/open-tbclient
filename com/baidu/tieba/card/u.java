package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bHG;
    private List<aj> baO;

    public static u Ww() {
        if (bHG == null) {
            synchronized (u.class) {
                if (bHG == null) {
                    bHG = new u();
                }
            }
        }
        return bHG;
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            if (this.baO == null) {
                this.baO = new ArrayList();
            }
            if (this.baO != null) {
                this.baO.add(ajVar);
            }
        }
    }

    public void jb(String str) {
        if (str != null) {
            if (this.baO == null) {
                this.baO = new ArrayList();
            }
            if (this.baO != null) {
                this.baO.add(new aj(str));
            }
        }
    }

    public void cA(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.baO) != 0) {
            for (aj ajVar : this.baO) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_param2", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.baO.clear();
        }
    }

    public void dE(boolean z) {
        if (com.baidu.tbadk.core.util.u.u(this.baO) != 0) {
            for (aj ajVar : this.baO) {
                if (ajVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ajVar.r("obj_type", i);
                    TiebaStatic.log(ajVar);
                }
            }
            this.baO.clear();
        }
    }
}
