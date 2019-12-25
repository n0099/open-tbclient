package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private static c eeJ;
    private List<an> dTq;

    public static c aZf() {
        if (eeJ == null) {
            synchronized (c.class) {
                if (eeJ == null) {
                    eeJ = new c();
                }
            }
        }
        return eeJ;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTq == null) {
                this.dTq = new ArrayList();
            }
            if (this.dTq != null) {
                this.dTq.add(anVar);
            }
        }
    }

    public void aZg() {
        if (v.getCount(this.dTq) != 0) {
            for (an anVar : this.dTq) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dTq.clear();
        }
    }
}
