package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bw {
    private static bw aUN;
    private List<com.baidu.tbadk.core.util.ay> aUM;

    public static bw Lg() {
        if (aUN == null) {
            synchronized (bw.class) {
                if (aUN == null) {
                    aUN = new bw();
                }
            }
        }
        return aUN;
    }

    public void a(com.baidu.tbadk.core.util.ay ayVar) {
        if (ayVar != null) {
            if (this.aUM == null) {
                this.aUM = new ArrayList();
            }
            if (this.aUM != null) {
                this.aUM.add(ayVar);
            }
        }
    }

    public void he(String str) {
        if (str != null) {
            if (this.aUM == null) {
                this.aUM = new ArrayList();
            }
            if (this.aUM != null) {
                this.aUM.add(new com.baidu.tbadk.core.util.ay(str));
            }
        }
    }

    public void cj(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.aUM) != 0) {
            for (com.baidu.tbadk.core.util.ay ayVar : this.aUM) {
                if (ayVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    ayVar.s("obj_param2", i);
                    TiebaStatic.log(ayVar);
                }
            }
            this.aUM.clear();
        }
    }
}
