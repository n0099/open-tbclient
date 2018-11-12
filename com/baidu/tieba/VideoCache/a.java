package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> bvK = new ArrayList();
    private long bvL = 0;

    public List<d> TS() {
        return this.bvK;
    }

    public long TT() {
        return this.bvL;
    }

    public void a(d dVar) {
        if (this.bvK != null) {
            this.bvK.add(dVar);
            if (dVar != null) {
                this.bvL += dVar.Uc();
            }
        }
    }

    public void b(d dVar) {
        if (this.bvK != null) {
            this.bvK.remove(dVar);
            if (dVar != null) {
                this.bvL -= dVar.Uc();
            }
        }
    }

    public void remove(int i) {
        if (this.bvK != null) {
            d dVar = this.bvK.get(i);
            if (dVar != null) {
                this.bvL -= dVar.Uc();
            }
            this.bvK.remove(i);
        }
    }

    public int TU() {
        if (this.bvK != null) {
            return this.bvK.size();
        }
        return 0;
    }

    public d hj(int i) {
        if (this.bvK != null) {
            return this.bvK.get(i);
        }
        return null;
    }
}
