package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bOB = new ArrayList();
    private long bOC = 0;

    public List<d> SL() {
        return this.bOB;
    }

    public long SM() {
        return this.bOC;
    }

    public void a(d dVar) {
        if (this.bOB != null) {
            this.bOB.add(dVar);
            if (dVar != null) {
                this.bOC += dVar.SV();
            }
        }
    }

    public void b(d dVar) {
        if (this.bOB != null) {
            this.bOB.remove(dVar);
            if (dVar != null) {
                this.bOC -= dVar.SV();
            }
        }
    }

    public void remove(int i) {
        if (this.bOB != null) {
            d dVar = this.bOB.get(i);
            if (dVar != null) {
                this.bOC -= dVar.SV();
            }
            this.bOB.remove(i);
        }
    }

    public int SN() {
        if (this.bOB != null) {
            return this.bOB.size();
        }
        return 0;
    }

    public d jn(int i) {
        if (this.bOB != null) {
            return this.bOB.get(i);
        }
        return null;
    }
}
