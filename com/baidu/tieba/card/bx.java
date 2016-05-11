package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bx {
    private static bx aRr;
    private List<com.baidu.tbadk.core.util.aw> aRq;

    public static bx Kg() {
        if (aRr == null) {
            synchronized (bx.class) {
                if (aRr == null) {
                    aRr = new bx();
                }
            }
        }
        return aRr;
    }

    public void a(com.baidu.tbadk.core.util.aw awVar) {
        if (awVar != null) {
            if (this.aRq == null) {
                this.aRq = new ArrayList();
            }
            if (this.aRq != null) {
                this.aRq.add(awVar);
            }
        }
    }

    public void he(String str) {
        if (str != null) {
            if (this.aRq == null) {
                this.aRq = new ArrayList();
            }
            if (this.aRq != null) {
                this.aRq.add(new com.baidu.tbadk.core.util.aw(str));
            }
        }
    }

    public void ci(boolean z) {
        if (com.baidu.tbadk.core.util.y.r(this.aRq) != 0) {
            for (com.baidu.tbadk.core.util.aw awVar : this.aRq) {
                if (awVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    awVar.s("obj_param2", i);
                    TiebaStatic.log(awVar);
                }
            }
            this.aRq.clear();
        }
    }
}
