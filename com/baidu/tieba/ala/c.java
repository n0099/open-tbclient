package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private static c eeR;
    private List<an> dTz;

    public static c aZz() {
        if (eeR == null) {
            synchronized (c.class) {
                if (eeR == null) {
                    eeR = new c();
                }
            }
        }
        return eeR;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTz == null) {
                this.dTz = new ArrayList();
            }
            if (this.dTz != null) {
                this.dTz.add(anVar);
            }
        }
    }

    public void aZA() {
        if (v.getCount(this.dTz) != 0) {
            for (an anVar : this.dTz) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dTz.clear();
        }
    }
}
