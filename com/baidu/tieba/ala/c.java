package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c ejy;
    private List<an> dYi;

    public static c bbV() {
        if (ejy == null) {
            synchronized (c.class) {
                if (ejy == null) {
                    ejy = new c();
                }
            }
        }
        return ejy;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.dYi == null) {
                this.dYi = new ArrayList();
            }
            if (this.dYi != null) {
                this.dYi.add(anVar);
            }
        }
    }

    public void bbW() {
        if (v.getCount(this.dYi) != 0) {
            for (an anVar : this.dYi) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dYi.clear();
        }
    }
}
