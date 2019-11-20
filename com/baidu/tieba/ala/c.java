package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private static c dua;
    private List<an> dfF;

    public static c aII() {
        if (dua == null) {
            synchronized (c.class) {
                if (dua == null) {
                    dua = new c();
                }
            }
        }
        return dua;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dfF == null) {
                this.dfF = new ArrayList();
            }
            if (this.dfF != null) {
                this.dfF.add(anVar);
            }
        }
    }

    public void aIJ() {
        if (v.getCount(this.dfF) != 0) {
            for (an anVar : this.dfF) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dfF.clear();
        }
    }
}
