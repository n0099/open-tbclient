package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u bUr;
    private List<ak> ber;

    public static u aaj() {
        if (bUr == null) {
            synchronized (u.class) {
                if (bUr == null) {
                    bUr = new u();
                }
            }
        }
        return bUr;
    }

    public void a(ak akVar) {
        if (akVar != null) {
            if (this.ber == null) {
                this.ber = new ArrayList();
            }
            if (this.ber != null) {
                this.ber.add(akVar);
            }
        }
    }

    public void cw(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.ber) != 0) {
            for (ak akVar : this.ber) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_param2", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.ber.clear();
        }
    }

    public void dF(boolean z) {
        if (com.baidu.tbadk.core.util.v.u(this.ber) != 0) {
            for (ak akVar : this.ber) {
                if (akVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    akVar.r("obj_type", i);
                    TiebaStatic.log(akVar);
                }
            }
            this.ber.clear();
        }
    }

    public void Nm() {
        if (com.baidu.tbadk.core.util.v.u(this.ber) != 0) {
            for (ak akVar : this.ber) {
                if (akVar != null) {
                    TiebaStatic.log(akVar);
                }
            }
            this.ber.clear();
        }
    }
}
