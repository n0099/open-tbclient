package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static d gsD;
    private List<aq> gik;

    public static d bRR() {
        if (gsD == null) {
            synchronized (d.class) {
                if (gsD == null) {
                    gsD = new d();
                }
            }
        }
        return gsD;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gik == null) {
                this.gik = new ArrayList();
            }
            if (this.gik != null) {
                this.gik.add(aqVar);
            }
        }
    }

    public void bRS() {
        if (x.getCount(this.gik) != 0) {
            for (aq aqVar : this.gik) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.gik.clear();
        }
    }
}
