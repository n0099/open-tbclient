package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> baJ = new ArrayList();
    private long baK = 0;

    public List<d> Ly() {
        return this.baJ;
    }

    public long Lz() {
        return this.baK;
    }

    public void a(d dVar) {
        if (this.baJ != null) {
            this.baJ.add(dVar);
            if (dVar != null) {
                this.baK += dVar.LI();
            }
        }
    }

    public void b(d dVar) {
        if (this.baJ != null) {
            this.baJ.remove(dVar);
            if (dVar != null) {
                this.baK -= dVar.LI();
            }
        }
    }

    public void remove(int i) {
        if (this.baJ != null) {
            d dVar = this.baJ.get(i);
            if (dVar != null) {
                this.baK -= dVar.LI();
            }
            this.baJ.remove(i);
        }
    }

    public int LA() {
        if (this.baJ != null) {
            return this.baJ.size();
        }
        return 0;
    }

    public d gs(int i) {
        if (this.baJ != null) {
            return this.baJ.get(i);
        }
        return null;
    }
}
