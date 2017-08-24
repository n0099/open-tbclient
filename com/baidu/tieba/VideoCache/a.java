package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aVU = new ArrayList();
    private long aVV = 0;

    public List<d> Kl() {
        return this.aVU;
    }

    public long Km() {
        return this.aVV;
    }

    public void a(d dVar) {
        if (this.aVU != null) {
            this.aVU.add(dVar);
            if (dVar != null) {
                this.aVV += dVar.Kt();
            }
        }
    }

    public void b(d dVar) {
        if (this.aVU != null) {
            this.aVU.remove(dVar);
            if (dVar != null) {
                this.aVV -= dVar.Kt();
            }
        }
    }

    public void remove(int i) {
        if (this.aVU != null) {
            d dVar = this.aVU.get(i);
            if (dVar != null) {
                this.aVV -= dVar.Kt();
            }
            this.aVU.remove(i);
        }
    }

    public int Kn() {
        if (this.aVU != null) {
            return this.aVU.size();
        }
        return 0;
    }

    public d fO(int i) {
        if (this.aVU != null) {
            return this.aVU.get(i);
        }
        return null;
    }
}
