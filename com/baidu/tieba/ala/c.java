package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c fwK;
    private List<aq> fng;

    public static c bDV() {
        if (fwK == null) {
            synchronized (c.class) {
                if (fwK == null) {
                    fwK = new c();
                }
            }
        }
        return fwK;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fng == null) {
                this.fng = new ArrayList();
            }
            if (this.fng != null) {
                this.fng.add(aqVar);
            }
        }
    }

    public void bDW() {
        if (y.getCount(this.fng) != 0) {
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fng.clear();
        }
    }
}
