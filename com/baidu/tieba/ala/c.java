package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c eJp;
    private List<an> eyj;

    public static c bjW() {
        if (eJp == null) {
            synchronized (c.class) {
                if (eJp == null) {
                    eJp = new c();
                }
            }
        }
        return eJp;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyj == null) {
                this.eyj = new ArrayList();
            }
            if (this.eyj != null) {
                this.eyj.add(anVar);
            }
        }
    }

    public void bjX() {
        if (v.getCount(this.eyj) != 0) {
            for (an anVar : this.eyj) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eyj.clear();
        }
    }
}
