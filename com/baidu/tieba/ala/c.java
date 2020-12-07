package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private static c gie;
    private List<ar> fYB;

    public static c bPq() {
        if (gie == null) {
            synchronized (c.class) {
                if (gie == null) {
                    gie = new c();
                }
            }
        }
        return gie;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYB == null) {
                this.fYB = new ArrayList();
            }
            if (this.fYB != null) {
                this.fYB.add(arVar);
            }
        }
    }

    public void bPr() {
        if (y.getCount(this.fYB) != 0) {
            for (ar arVar : this.fYB) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fYB.clear();
        }
    }
}
