package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eJk;
    private List<an> eyd;

    public static c bjY() {
        if (eJk == null) {
            synchronized (c.class) {
                if (eJk == null) {
                    eJk = new c();
                }
            }
        }
        return eJk;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyd == null) {
                this.eyd = new ArrayList();
            }
            if (this.eyd != null) {
                this.eyd.add(anVar);
            }
        }
    }

    public void bjZ() {
        if (v.getCount(this.eyd) != 0) {
            for (an anVar : this.eyd) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eyd.clear();
        }
    }
}
