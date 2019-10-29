package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private static c duR;
    private List<an> dgw;

    public static c aIK() {
        if (duR == null) {
            synchronized (c.class) {
                if (duR == null) {
                    duR = new c();
                }
            }
        }
        return duR;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dgw == null) {
                this.dgw = new ArrayList();
            }
            if (this.dgw != null) {
                this.dgw.add(anVar);
            }
        }
    }

    public void aIL() {
        if (v.getCount(this.dgw) != 0) {
            for (an anVar : this.dgw) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dgw.clear();
        }
    }
}
