package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static d gqT;
    private List<ar> gfV;

    public static d bOL() {
        if (gqT == null) {
            synchronized (d.class) {
                if (gqT == null) {
                    gqT = new d();
                }
            }
        }
        return gqT;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfV == null) {
                this.gfV = new ArrayList();
            }
            if (this.gfV != null) {
                this.gfV.add(arVar);
            }
        }
    }

    public void bOM() {
        if (y.getCount(this.gfV) != 0) {
            for (ar arVar : this.gfV) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.gfV.clear();
        }
    }
}
