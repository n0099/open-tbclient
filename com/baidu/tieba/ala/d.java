package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private static d gsC;
    private List<ar> ghy;

    public static d bOR() {
        if (gsC == null) {
            synchronized (d.class) {
                if (gsC == null) {
                    gsC = new d();
                }
            }
        }
        return gsC;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.ghy == null) {
                this.ghy = new ArrayList();
            }
            if (this.ghy != null) {
                this.ghy.add(arVar);
            }
        }
    }

    public void bOS() {
        if (y.getCount(this.ghy) != 0) {
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.ghy.clear();
        }
    }
}
