package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aVS = new ArrayList();
    private long aVT = 0;

    public List<d> Kl() {
        return this.aVS;
    }

    public long Km() {
        return this.aVT;
    }

    public void a(d dVar) {
        if (this.aVS != null) {
            this.aVS.add(dVar);
            if (dVar != null) {
                this.aVT += dVar.Kt();
            }
        }
    }

    public void b(d dVar) {
        if (this.aVS != null) {
            this.aVS.remove(dVar);
            if (dVar != null) {
                this.aVT -= dVar.Kt();
            }
        }
    }

    public void remove(int i) {
        if (this.aVS != null) {
            d dVar = this.aVS.get(i);
            if (dVar != null) {
                this.aVT -= dVar.Kt();
            }
            this.aVS.remove(i);
        }
    }

    public int Kn() {
        if (this.aVS != null) {
            return this.aVS.size();
        }
        return 0;
    }

    public d fO(int i) {
        if (this.aVS != null) {
            return this.aVS.get(i);
        }
        return null;
    }
}
