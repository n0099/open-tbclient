package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eVM;
    private List<an> eMK;

    public static c bpq() {
        if (eVM == null) {
            synchronized (c.class) {
                if (eVM == null) {
                    eVM = new c();
                }
            }
        }
        return eVM;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMK == null) {
                this.eMK = new ArrayList();
            }
            if (this.eMK != null) {
                this.eMK.add(anVar);
            }
        }
    }

    public void bpr() {
        if (v.getCount(this.eMK) != 0) {
            for (an anVar : this.eMK) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eMK.clear();
        }
    }
}
