package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cTp = new ArrayList();
    private long cTq = 0;

    public List<d> aAz() {
        return this.cTp;
    }

    public long aAA() {
        return this.cTq;
    }

    public void a(d dVar) {
        if (this.cTp != null) {
            this.cTp.add(dVar);
            if (dVar != null) {
                this.cTq += dVar.aAJ();
            }
        }
    }

    public void b(d dVar) {
        if (this.cTp != null) {
            this.cTp.remove(dVar);
            if (dVar != null) {
                this.cTq -= dVar.aAJ();
            }
        }
    }

    public void remove(int i) {
        if (this.cTp != null) {
            d dVar = this.cTp.get(i);
            if (dVar != null) {
                this.cTq -= dVar.aAJ();
            }
            this.cTp.remove(i);
        }
    }

    public int aAB() {
        if (this.cTp != null) {
            return this.cTp.size();
        }
        return 0;
    }

    public d mc(int i) {
        if (this.cTp != null) {
            return this.cTp.get(i);
        }
        return null;
    }
}
