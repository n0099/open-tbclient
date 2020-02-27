package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eiU;
    private List<an> dXE;

    public static c bbO() {
        if (eiU == null) {
            synchronized (c.class) {
                if (eiU == null) {
                    eiU = new c();
                }
            }
        }
        return eiU;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXE == null) {
                this.dXE = new ArrayList();
            }
            if (this.dXE != null) {
                this.dXE.add(anVar);
            }
        }
    }

    public void bbP() {
        if (v.getCount(this.dXE) != 0) {
            for (an anVar : this.dXE) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXE.clear();
        }
    }
}
