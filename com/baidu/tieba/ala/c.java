package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eji;
    private List<an> dXS;

    public static c bbR() {
        if (eji == null) {
            synchronized (c.class) {
                if (eji == null) {
                    eji = new c();
                }
            }
        }
        return eji;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXS == null) {
                this.dXS = new ArrayList();
            }
            if (this.dXS != null) {
                this.dXS.add(anVar);
            }
        }
    }

    public void bbS() {
        if (v.getCount(this.dXS) != 0) {
            for (an anVar : this.dXS) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXS.clear();
        }
    }
}
