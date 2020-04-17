package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> ewP = new ArrayList();
    private long ewQ = 0;

    public List<d> bfe() {
        return this.ewP;
    }

    public long bff() {
        return this.ewQ;
    }

    public void a(d dVar) {
        if (this.ewP != null) {
            this.ewP.add(dVar);
            if (dVar != null) {
                this.ewQ += dVar.bfo();
            }
        }
    }

    public void b(d dVar) {
        if (this.ewP != null) {
            this.ewP.remove(dVar);
            if (dVar != null) {
                this.ewQ -= dVar.bfo();
            }
        }
    }

    public void remove(int i) {
        if (this.ewP != null) {
            d dVar = this.ewP.get(i);
            if (dVar != null) {
                this.ewQ -= dVar.bfo();
            }
            this.ewP.remove(i);
        }
    }

    public int bfg() {
        if (this.ewP != null) {
            return this.ewP.size();
        }
        return 0;
    }

    public d om(int i) {
        if (this.ewP != null) {
            return this.ewP.get(i);
        }
        return null;
    }
}
