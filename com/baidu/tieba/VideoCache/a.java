package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> blb = new ArrayList();
    private long blc = 0;

    public List<d> PZ() {
        return this.blb;
    }

    public long Qa() {
        return this.blc;
    }

    public void a(d dVar) {
        if (this.blb != null) {
            this.blb.add(dVar);
            if (dVar != null) {
                this.blc += dVar.Qj();
            }
        }
    }

    public void b(d dVar) {
        if (this.blb != null) {
            this.blb.remove(dVar);
            if (dVar != null) {
                this.blc -= dVar.Qj();
            }
        }
    }

    public void remove(int i) {
        if (this.blb != null) {
            d dVar = this.blb.get(i);
            if (dVar != null) {
                this.blc -= dVar.Qj();
            }
            this.blb.remove(i);
        }
    }

    public int Qb() {
        if (this.blb != null) {
            return this.blb.size();
        }
        return 0;
    }

    public d go(int i) {
        if (this.blb != null) {
            return this.blb.get(i);
        }
        return null;
    }
}
