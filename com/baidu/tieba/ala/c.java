package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private static c gig;
    private List<ar> fYD;

    public static c bPr() {
        if (gig == null) {
            synchronized (c.class) {
                if (gig == null) {
                    gig = new c();
                }
            }
        }
        return gig;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYD == null) {
                this.fYD = new ArrayList();
            }
            if (this.fYD != null) {
                this.fYD.add(arVar);
            }
        }
    }

    public void bPs() {
        if (y.getCount(this.fYD) != 0) {
            for (ar arVar : this.fYD) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fYD.clear();
        }
    }
}
