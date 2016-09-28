package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cb {
    private static cb bbD;
    private List<com.baidu.tbadk.core.util.ax> bbC;

    public static cb Oj() {
        if (bbD == null) {
            synchronized (cb.class) {
                if (bbD == null) {
                    bbD = new cb();
                }
            }
        }
        return bbD;
    }

    public void a(com.baidu.tbadk.core.util.ax axVar) {
        if (axVar != null) {
            if (this.bbC == null) {
                this.bbC = new ArrayList();
            }
            if (this.bbC != null) {
                this.bbC.add(axVar);
            }
        }
    }

    public void hQ(String str) {
        if (str != null) {
            if (this.bbC == null) {
                this.bbC = new ArrayList();
            }
            if (this.bbC != null) {
                this.bbC.add(new com.baidu.tbadk.core.util.ax(str));
            }
        }
    }

    public void cr(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.bbC) != 0) {
            for (com.baidu.tbadk.core.util.ax axVar : this.bbC) {
                if (axVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    axVar.s("obj_param2", i);
                    TiebaStatic.log(axVar);
                }
            }
            this.bbC.clear();
        }
    }

    public void cs(boolean z) {
        if (com.baidu.tbadk.core.util.y.s(this.bbC) != 0) {
            for (com.baidu.tbadk.core.util.ax axVar : this.bbC) {
                if (axVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    axVar.s("obj_type", i);
                    TiebaStatic.log(axVar);
                }
            }
            this.bbC.clear();
        }
    }
}
