package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c fZS;
    private List<ar> fQs;

    public static c bLH() {
        if (fZS == null) {
            synchronized (c.class) {
                if (fZS == null) {
                    fZS = new c();
                }
            }
        }
        return fZS;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fQs == null) {
                this.fQs = new ArrayList();
            }
            if (this.fQs != null) {
                this.fQs.add(arVar);
            }
        }
    }

    public void bLI() {
        if (y.getCount(this.fQs) != 0) {
            for (ar arVar : this.fQs) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fQs.clear();
        }
    }
}
