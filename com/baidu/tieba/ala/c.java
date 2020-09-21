package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c fzV;
    private List<aq> fql;

    public static c bFl() {
        if (fzV == null) {
            synchronized (c.class) {
                if (fzV == null) {
                    fzV = new c();
                }
            }
        }
        return fzV;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fql == null) {
                this.fql = new ArrayList();
            }
            if (this.fql != null) {
                this.fql.add(aqVar);
            }
        }
    }

    public void bFm() {
        if (y.getCount(this.fql) != 0) {
            for (aq aqVar : this.fql) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fql.clear();
        }
    }
}
