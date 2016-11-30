package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<f> aPP = new ArrayList();
    private long aPQ = 0;

    public List<f> KF() {
        return this.aPP;
    }

    public long KG() {
        return this.aPQ;
    }

    public void a(f fVar) {
        if (this.aPP != null) {
            this.aPP.add(fVar);
            if (fVar != null) {
                this.aPQ += fVar.KN();
            }
        }
    }

    public void b(f fVar) {
        if (this.aPP != null) {
            this.aPP.remove(fVar);
            if (fVar != null) {
                this.aPQ -= fVar.KN();
            }
        }
    }

    public void remove(int i) {
        if (this.aPP != null) {
            f fVar = this.aPP.get(i);
            if (fVar != null) {
                this.aPQ -= fVar.KN();
            }
            this.aPP.remove(i);
        }
    }

    public int KH() {
        if (this.aPP != null) {
            return this.aPP.size();
        }
        return 0;
    }

    public f fK(int i) {
        if (this.aPP != null) {
            return this.aPP.get(i);
        }
        return null;
    }
}
