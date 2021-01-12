package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static d gnW;
    private List<aq> gdB;

    public static d bOa() {
        if (gnW == null) {
            synchronized (d.class) {
                if (gnW == null) {
                    gnW = new d();
                }
            }
        }
        return gnW;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gdB == null) {
                this.gdB = new ArrayList();
            }
            if (this.gdB != null) {
                this.gdB.add(aqVar);
            }
        }
    }

    public void bOb() {
        if (x.getCount(this.gdB) != 0) {
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.gdB.clear();
        }
    }
}
