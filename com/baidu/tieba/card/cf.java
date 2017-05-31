package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cf {
    private static cf bCC;
    private List<com.baidu.tbadk.core.util.as> aXV;

    public static cf Uw() {
        if (bCC == null) {
            synchronized (cf.class) {
                if (bCC == null) {
                    bCC = new cf();
                }
            }
        }
        return bCC;
    }

    public void a(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (this.aXV == null) {
                this.aXV = new ArrayList();
            }
            if (this.aXV != null) {
                this.aXV.add(asVar);
            }
        }
    }

    public void ie(String str) {
        if (str != null) {
            if (this.aXV == null) {
                this.aXV = new ArrayList();
            }
            if (this.aXV != null) {
                this.aXV.add(new com.baidu.tbadk.core.util.as(str));
            }
        }
    }

    public void ds(boolean z) {
        if (com.baidu.tbadk.core.util.x.q(this.aXV) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.aXV) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.r("obj_param2", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.aXV.clear();
        }
    }

    public void dt(boolean z) {
        if (com.baidu.tbadk.core.util.x.q(this.aXV) != 0) {
            for (com.baidu.tbadk.core.util.as asVar : this.aXV) {
                if (asVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    asVar.r("obj_type", i);
                    TiebaStatic.log(asVar);
                }
            }
            this.aXV.clear();
        }
    }
}
