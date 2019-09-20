package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cVN = new ArrayList();
    private long cVO = 0;

    public List<d> aCh() {
        return this.cVN;
    }

    public long aCi() {
        return this.cVO;
    }

    public void a(d dVar) {
        if (this.cVN != null) {
            this.cVN.add(dVar);
            if (dVar != null) {
                this.cVO += dVar.aCr();
            }
        }
    }

    public void b(d dVar) {
        if (this.cVN != null) {
            this.cVN.remove(dVar);
            if (dVar != null) {
                this.cVO -= dVar.aCr();
            }
        }
    }

    public void remove(int i) {
        if (this.cVN != null) {
            d dVar = this.cVN.get(i);
            if (dVar != null) {
                this.cVO -= dVar.aCr();
            }
            this.cVN.remove(i);
        }
    }

    public int aCj() {
        if (this.cVN != null) {
            return this.cVN.size();
        }
        return 0;
    }

    public d mo(int i) {
        if (this.cVN != null) {
            return this.cVN.get(i);
        }
        return null;
    }
}
