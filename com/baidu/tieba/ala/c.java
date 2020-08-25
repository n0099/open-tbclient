package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c fwG;
    private List<aq> fnc;

    public static c bDU() {
        if (fwG == null) {
            synchronized (c.class) {
                if (fwG == null) {
                    fwG = new c();
                }
            }
        }
        return fwG;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fnc == null) {
                this.fnc = new ArrayList();
            }
            if (this.fnc != null) {
                this.fnc.add(aqVar);
            }
        }
    }

    public void bDV() {
        if (y.getCount(this.fnc) != 0) {
            for (aq aqVar : this.fnc) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fnc.clear();
        }
    }
}
