package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eiV;
    private List<an> dXF;

    public static c bbQ() {
        if (eiV == null) {
            synchronized (c.class) {
                if (eiV == null) {
                    eiV = new c();
                }
            }
        }
        return eiV;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXF == null) {
                this.dXF = new ArrayList();
            }
            if (this.dXF != null) {
                this.dXF.add(anVar);
            }
        }
    }

    public void bbR() {
        if (v.getCount(this.dXF) != 0) {
            for (an anVar : this.dXF) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXF.clear();
        }
    }
}
