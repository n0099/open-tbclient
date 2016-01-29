package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ax {
    private static ax aRq;
    private List<com.baidu.tbadk.core.util.au> aRp;

    public static ax Kc() {
        if (aRq == null) {
            synchronized (ax.class) {
                if (aRq == null) {
                    aRq = new ax();
                }
            }
        }
        return aRq;
    }

    public void a(com.baidu.tbadk.core.util.au auVar) {
        if (auVar != null) {
            if (this.aRp == null) {
                this.aRp = new ArrayList();
            }
            if (this.aRp != null) {
                this.aRp.add(auVar);
            }
        }
    }

    public void gQ(String str) {
        if (str != null) {
            if (this.aRp == null) {
                this.aRp = new ArrayList();
            }
            if (this.aRp != null) {
                this.aRp.add(new com.baidu.tbadk.core.util.au(str));
            }
        }
    }

    public void Kd() {
        if (com.baidu.tbadk.core.util.x.o(this.aRp) != 0) {
            for (com.baidu.tbadk.core.util.au auVar : this.aRp) {
                if (auVar != null) {
                    TiebaStatic.log(auVar);
                }
            }
            this.aRp.clear();
        }
    }
}
