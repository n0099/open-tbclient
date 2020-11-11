package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c gal;
    private List<aq> fQJ;

    public static c bMo() {
        if (gal == null) {
            synchronized (c.class) {
                if (gal == null) {
                    gal = new c();
                }
            }
        }
        return gal;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fQJ == null) {
                this.fQJ = new ArrayList();
            }
            if (this.fQJ != null) {
                this.fQJ.add(aqVar);
            }
        }
    }

    public void bMp() {
        if (y.getCount(this.fQJ) != 0) {
            for (aq aqVar : this.fQJ) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fQJ.clear();
        }
    }
}
