package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cLb = new ArrayList();
    private long cLc = 0;

    public List<d> avw() {
        return this.cLb;
    }

    public long avx() {
        return this.cLc;
    }

    public void a(d dVar) {
        if (this.cLb != null) {
            this.cLb.add(dVar);
            if (dVar != null) {
                this.cLc += dVar.avG();
            }
        }
    }

    public void b(d dVar) {
        if (this.cLb != null) {
            this.cLb.remove(dVar);
            if (dVar != null) {
                this.cLc -= dVar.avG();
            }
        }
    }

    public void remove(int i) {
        if (this.cLb != null) {
            d dVar = this.cLb.get(i);
            if (dVar != null) {
                this.cLc -= dVar.avG();
            }
            this.cLb.remove(i);
        }
    }

    public int avy() {
        if (this.cLb != null) {
            return this.cLb.size();
        }
        return 0;
    }

    public d lo(int i) {
        if (this.cLb != null) {
            return this.cLb.get(i);
        }
        return null;
    }
}
