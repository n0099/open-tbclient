package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c flk;
    private List<ap> fbI;

    public static c buZ() {
        if (flk == null) {
            synchronized (c.class) {
                if (flk == null) {
                    flk = new c();
                }
            }
        }
        return flk;
    }

    public void e(ap apVar) {
        if (apVar != null) {
            if (this.fbI == null) {
                this.fbI = new ArrayList();
            }
            if (this.fbI != null) {
                this.fbI.add(apVar);
            }
        }
    }

    public void bva() {
        if (x.getCount(this.fbI) != 0) {
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    TiebaStatic.log(apVar);
                }
            }
            this.fbI.clear();
        }
    }
}
