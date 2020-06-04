package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eVX;
    private List<an> eMV;

    public static c bps() {
        if (eVX == null) {
            synchronized (c.class) {
                if (eVX == null) {
                    eVX = new c();
                }
            }
        }
        return eVX;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMV == null) {
                this.eMV = new ArrayList();
            }
            if (this.eMV != null) {
                this.eMV.add(anVar);
            }
        }
    }

    public void bpt() {
        if (v.getCount(this.eMV) != 0) {
            for (an anVar : this.eMV) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eMV.clear();
        }
    }
}
