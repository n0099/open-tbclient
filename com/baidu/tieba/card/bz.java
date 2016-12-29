package com.baidu.tieba.card;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bz {
    private static bz bea;
    private List<com.baidu.tbadk.core.util.at> bdZ;

    public static bz OH() {
        if (bea == null) {
            synchronized (bz.class) {
                if (bea == null) {
                    bea = new bz();
                }
            }
        }
        return bea;
    }

    public void a(com.baidu.tbadk.core.util.at atVar) {
        if (atVar != null) {
            if (this.bdZ == null) {
                this.bdZ = new ArrayList();
            }
            if (this.bdZ != null) {
                this.bdZ.add(atVar);
            }
        }
    }

    public void hO(String str) {
        if (str != null) {
            if (this.bdZ == null) {
                this.bdZ = new ArrayList();
            }
            if (this.bdZ != null) {
                this.bdZ.add(new com.baidu.tbadk.core.util.at(str));
            }
        }
    }

    public void cy(boolean z) {
        if (com.baidu.tbadk.core.util.x.s(this.bdZ) != 0) {
            for (com.baidu.tbadk.core.util.at atVar : this.bdZ) {
                if (atVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    atVar.s("obj_param2", i);
                    TiebaStatic.log(atVar);
                }
            }
            this.bdZ.clear();
        }
    }

    public void cz(boolean z) {
        if (com.baidu.tbadk.core.util.x.s(this.bdZ) != 0) {
            for (com.baidu.tbadk.core.util.at atVar : this.bdZ) {
                if (atVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    atVar.s("obj_type", i);
                    TiebaStatic.log(atVar);
                }
            }
            this.bdZ.clear();
        }
    }

    public void OI() {
        if (com.baidu.tbadk.core.util.x.s(this.bdZ) != 0) {
            for (com.baidu.tbadk.core.util.at atVar : this.bdZ) {
                if (atVar != null) {
                    TiebaStatic.log(atVar);
                }
            }
            this.bdZ.clear();
        }
    }
}
