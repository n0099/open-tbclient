package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> baF = new ArrayList();
    private long baG = 0;

    public List<d> LT() {
        return this.baF;
    }

    public long LU() {
        return this.baG;
    }

    public void a(d dVar) {
        if (this.baF != null) {
            this.baF.add(dVar);
            if (dVar != null) {
                this.baG += dVar.Mc();
            }
        }
    }

    public void b(d dVar) {
        if (this.baF != null) {
            this.baF.remove(dVar);
            if (dVar != null) {
                this.baG -= dVar.Mc();
            }
        }
    }

    public void remove(int i) {
        if (this.baF != null) {
            d dVar = this.baF.get(i);
            if (dVar != null) {
                this.baG -= dVar.Mc();
            }
            this.baF.remove(i);
        }
    }

    public int LV() {
        if (this.baF != null) {
            return this.baF.size();
        }
        return 0;
    }

    public d gi(int i) {
        if (this.baF != null) {
            return this.baF.get(i);
        }
        return null;
    }
}
