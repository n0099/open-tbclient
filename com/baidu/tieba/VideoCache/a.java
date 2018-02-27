package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bQF = new ArrayList();
    private long bQG = 0;

    public List<d> Tv() {
        return this.bQF;
    }

    public long Tw() {
        return this.bQG;
    }

    public void a(d dVar) {
        if (this.bQF != null) {
            this.bQF.add(dVar);
            if (dVar != null) {
                this.bQG += dVar.TF();
            }
        }
    }

    public void b(d dVar) {
        if (this.bQF != null) {
            this.bQF.remove(dVar);
            if (dVar != null) {
                this.bQG -= dVar.TF();
            }
        }
    }

    public void remove(int i) {
        if (this.bQF != null) {
            d dVar = this.bQF.get(i);
            if (dVar != null) {
                this.bQG -= dVar.TF();
            }
            this.bQF.remove(i);
        }
    }

    public int Tx() {
        if (this.bQF != null) {
            return this.bQF.size();
        }
        return 0;
    }

    public d jj(int i) {
        if (this.bQF != null) {
            return this.bQF.get(i);
        }
        return null;
    }
}
