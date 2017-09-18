package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bNj;
    private List<ak> bbO;

    public static u Yj() {
        if (bNj == null) {
            synchronized (u.class) {
                if (bNj == null) {
                    bNj = new u();
                }
            }
        }
        return bNj;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.bbO == null) {
                this.bbO = new ArrayList();
            }
            if (this.bbO != null) {
                this.bbO.add(akVar);
            }
        }
    }

    public void jx(String str) {
        if (str != null) {
            if (this.bbO == null) {
                this.bbO = new ArrayList();
            }
            if (this.bbO != null) {
                this.bbO.add(new ak(str));
            }
        }
    }

    public void cC(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.bbO) != 0) {
            for (ak akVar : this.bbO) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bbO.clear();
        }
    }

    public void dJ(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.bbO) != 0) {
            for (ak akVar : this.bbO) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.bbO.clear();
        }
    }
}
