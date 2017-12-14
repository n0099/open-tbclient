package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> baF = new ArrayList();
    private long baG = 0;

    public List<d> Ly() {
        return this.baF;
    }

    public long Lz() {
        return this.baG;
    }

    public void a(d dVar) {
        if (this.baF != null) {
            this.baF.add(dVar);
            if (dVar != null) {
                this.baG += dVar.LI();
            }
        }
    }

    public void b(d dVar) {
        if (this.baF != null) {
            this.baF.remove(dVar);
            if (dVar != null) {
                this.baG -= dVar.LI();
            }
        }
    }

    public void remove(int i) {
        if (this.baF != null) {
            d dVar = this.baF.get(i);
            if (dVar != null) {
                this.baG -= dVar.LI();
            }
            this.baF.remove(i);
        }
    }

    public int LA() {
        if (this.baF != null) {
            return this.baF.size();
        }
        return 0;
    }

    public d gs(int i) {
        if (this.baF != null) {
            return this.baF.get(i);
        }
        return null;
    }
}
