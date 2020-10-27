package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c fUv;
    private List<aq> fKT;

    public static c bJP() {
        if (fUv == null) {
            synchronized (c.class) {
                if (fUv == null) {
                    fUv = new c();
                }
            }
        }
        return fUv;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fKT == null) {
                this.fKT = new ArrayList();
            }
            if (this.fKT != null) {
                this.fKT.add(aqVar);
            }
        }
    }

    public void bJQ() {
        if (y.getCount(this.fKT) != 0) {
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fKT.clear();
        }
    }
}
