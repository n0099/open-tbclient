package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aVT = new ArrayList();
    private long aVU = 0;

    public List<d> Kl() {
        return this.aVT;
    }

    public long Km() {
        return this.aVU;
    }

    public void a(d dVar) {
        if (this.aVT != null) {
            this.aVT.add(dVar);
            if (dVar != null) {
                this.aVU += dVar.Kt();
            }
        }
    }

    public void b(d dVar) {
        if (this.aVT != null) {
            this.aVT.remove(dVar);
            if (dVar != null) {
                this.aVU -= dVar.Kt();
            }
        }
    }

    public void remove(int i) {
        if (this.aVT != null) {
            d dVar = this.aVT.get(i);
            if (dVar != null) {
                this.aVU -= dVar.Kt();
            }
            this.aVT.remove(i);
        }
    }

    public int Kn() {
        if (this.aVT != null) {
            return this.aVT.size();
        }
        return 0;
    }

    public d fO(int i) {
        if (this.aVT != null) {
            return this.aVT.get(i);
        }
        return null;
    }
}
