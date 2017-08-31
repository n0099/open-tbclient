package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aVD = new ArrayList();
    private long aVE = 0;

    public List<d> Ku() {
        return this.aVD;
    }

    public long Kv() {
        return this.aVE;
    }

    public void a(d dVar) {
        if (this.aVD != null) {
            this.aVD.add(dVar);
            if (dVar != null) {
                this.aVE += dVar.KC();
            }
        }
    }

    public void b(d dVar) {
        if (this.aVD != null) {
            this.aVD.remove(dVar);
            if (dVar != null) {
                this.aVE -= dVar.KC();
            }
        }
    }

    public void remove(int i) {
        if (this.aVD != null) {
            d dVar = this.aVD.get(i);
            if (dVar != null) {
                this.aVE -= dVar.KC();
            }
            this.aVD.remove(i);
        }
    }

    public int Kw() {
        if (this.aVD != null) {
            return this.aVD.size();
        }
        return 0;
    }

    public d fP(int i) {
        if (this.aVD != null) {
            return this.aVD.get(i);
        }
        return null;
    }
}
