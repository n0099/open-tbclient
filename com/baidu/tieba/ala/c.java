package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static c fMe;
    private List<aq> fCy;

    public static c bHX() {
        if (fMe == null) {
            synchronized (c.class) {
                if (fMe == null) {
                    fMe = new c();
                }
            }
        }
        return fMe;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fCy == null) {
                this.fCy = new ArrayList();
            }
            if (this.fCy != null) {
                this.fCy.add(aqVar);
            }
        }
    }

    public void bHY() {
        if (y.getCount(this.fCy) != 0) {
            for (aq aqVar : this.fCy) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fCy.clear();
        }
    }
}
