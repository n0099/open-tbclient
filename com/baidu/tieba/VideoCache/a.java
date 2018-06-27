package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bkr = new ArrayList();
    private long bks = 0;

    public List<d> PN() {
        return this.bkr;
    }

    public long PO() {
        return this.bks;
    }

    public void a(d dVar) {
        if (this.bkr != null) {
            this.bkr.add(dVar);
            if (dVar != null) {
                this.bks += dVar.PW();
            }
        }
    }

    public void b(d dVar) {
        if (this.bkr != null) {
            this.bkr.remove(dVar);
            if (dVar != null) {
                this.bks -= dVar.PW();
            }
        }
    }

    public void remove(int i) {
        if (this.bkr != null) {
            d dVar = this.bkr.get(i);
            if (dVar != null) {
                this.bks -= dVar.PW();
            }
            this.bkr.remove(i);
        }
    }

    public int PP() {
        if (this.bkr != null) {
            return this.bkr.size();
        }
        return 0;
    }

    public d gk(int i) {
        if (this.bkr != null) {
            return this.bkr.get(i);
        }
        return null;
    }
}
