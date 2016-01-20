package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private static am aPt;
    private List<av> aPs;

    public static am Iq() {
        if (aPt == null) {
            synchronized (am.class) {
                if (aPt == null) {
                    aPt = new am();
                }
            }
        }
        return aPt;
    }

    public void a(av avVar) {
        if (avVar != null) {
            if (this.aPs == null) {
                this.aPs = new ArrayList();
            }
            if (this.aPs != null) {
                this.aPs.add(avVar);
            }
        }
    }

    public void gK(String str) {
        if (str != null) {
            if (this.aPs == null) {
                this.aPs = new ArrayList();
            }
            if (this.aPs != null) {
                this.aPs.add(new av(str));
            }
        }
    }

    public void Ir() {
        if (com.baidu.tbadk.core.util.y.l(this.aPs) != 0) {
            for (av avVar : this.aPs) {
                if (avVar != null) {
                    TiebaStatic.log(avVar);
                }
            }
            this.aPs.clear();
        }
    }
}
