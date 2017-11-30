package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> baE = new ArrayList();
    private long baF = 0;

    public List<d> Ly() {
        return this.baE;
    }

    public long Lz() {
        return this.baF;
    }

    public void a(d dVar) {
        if (this.baE != null) {
            this.baE.add(dVar);
            if (dVar != null) {
                this.baF += dVar.LI();
            }
        }
    }

    public void b(d dVar) {
        if (this.baE != null) {
            this.baE.remove(dVar);
            if (dVar != null) {
                this.baF -= dVar.LI();
            }
        }
    }

    public void remove(int i) {
        if (this.baE != null) {
            d dVar = this.baE.get(i);
            if (dVar != null) {
                this.baF -= dVar.LI();
            }
            this.baE.remove(i);
        }
    }

    public int LA() {
        if (this.baE != null) {
            return this.baE.size();
        }
        return 0;
    }

    public d gs(int i) {
        if (this.baE != null) {
            return this.baE.get(i);
        }
        return null;
    }
}
