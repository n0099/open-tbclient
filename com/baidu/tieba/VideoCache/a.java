package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> eVU = new ArrayList();
    private long eVV = 0;

    public List<d> bnQ() {
        return this.eVU;
    }

    public long bnR() {
        return this.eVV;
    }

    public void a(d dVar) {
        if (this.eVU != null) {
            this.eVU.add(dVar);
            if (dVar != null) {
                this.eVV += dVar.boa();
            }
        }
    }

    public void b(d dVar) {
        if (this.eVU != null) {
            this.eVU.remove(dVar);
            if (dVar != null) {
                this.eVV -= dVar.boa();
            }
        }
    }

    public void remove(int i) {
        if (this.eVU != null) {
            d dVar = this.eVU.get(i);
            if (dVar != null) {
                this.eVV -= dVar.boa();
            }
            this.eVU.remove(i);
        }
    }

    public int bnS() {
        if (this.eVU != null) {
            return this.eVU.size();
        }
        return 0;
    }

    public d pu(int i) {
        if (this.eVU != null) {
            return this.eVU.get(i);
        }
        return null;
    }
}
