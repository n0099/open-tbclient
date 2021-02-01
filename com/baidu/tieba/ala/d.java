package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static d gqF;
    private List<ar> gfQ;

    public static d bOE() {
        if (gqF == null) {
            synchronized (d.class) {
                if (gqF == null) {
                    gqF = new d();
                }
            }
        }
        return gqF;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfQ == null) {
                this.gfQ = new ArrayList();
            }
            if (this.gfQ != null) {
                this.gfQ.add(arVar);
            }
        }
    }

    public void bOF() {
        if (y.getCount(this.gfQ) != 0) {
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.gfQ.clear();
        }
    }
}
