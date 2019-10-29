package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> dfi = new ArrayList();
    private long dfj = 0;

    public List<d> aCq() {
        return this.dfi;
    }

    public long aCr() {
        return this.dfj;
    }

    public void a(d dVar) {
        if (this.dfi != null) {
            this.dfi.add(dVar);
            if (dVar != null) {
                this.dfj += dVar.aCA();
            }
        }
    }

    public void b(d dVar) {
        if (this.dfi != null) {
            this.dfi.remove(dVar);
            if (dVar != null) {
                this.dfj -= dVar.aCA();
            }
        }
    }

    public void remove(int i) {
        if (this.dfi != null) {
            d dVar = this.dfi.get(i);
            if (dVar != null) {
                this.dfj -= dVar.aCA();
            }
            this.dfi.remove(i);
        }
    }

    public int aCs() {
        if (this.dfi != null) {
            return this.dfi.size();
        }
        return 0;
    }

    public d lt(int i) {
        if (this.dfi != null) {
            return this.dfi.get(i);
        }
        return null;
    }
}
