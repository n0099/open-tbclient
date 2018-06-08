package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> biR = new ArrayList();
    private long biS = 0;

    public List<d> Pq() {
        return this.biR;
    }

    public long Pr() {
        return this.biS;
    }

    public void a(d dVar) {
        if (this.biR != null) {
            this.biR.add(dVar);
            if (dVar != null) {
                this.biS += dVar.Pz();
            }
        }
    }

    public void b(d dVar) {
        if (this.biR != null) {
            this.biR.remove(dVar);
            if (dVar != null) {
                this.biS -= dVar.Pz();
            }
        }
    }

    public void remove(int i) {
        if (this.biR != null) {
            d dVar = this.biR.get(i);
            if (dVar != null) {
                this.biS -= dVar.Pz();
            }
            this.biR.remove(i);
        }
    }

    public int Ps() {
        if (this.biR != null) {
            return this.biR.size();
        }
        return 0;
    }

    public d gj(int i) {
        if (this.biR != null) {
            return this.biR.get(i);
        }
        return null;
    }
}
