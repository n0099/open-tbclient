package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cUU = new ArrayList();
    private long cUV = 0;

    public List<d> aBT() {
        return this.cUU;
    }

    public long aBU() {
        return this.cUV;
    }

    public void a(d dVar) {
        if (this.cUU != null) {
            this.cUU.add(dVar);
            if (dVar != null) {
                this.cUV += dVar.aCd();
            }
        }
    }

    public void b(d dVar) {
        if (this.cUU != null) {
            this.cUU.remove(dVar);
            if (dVar != null) {
                this.cUV -= dVar.aCd();
            }
        }
    }

    public void remove(int i) {
        if (this.cUU != null) {
            d dVar = this.cUU.get(i);
            if (dVar != null) {
                this.cUV -= dVar.aCd();
            }
            this.cUU.remove(i);
        }
    }

    public int aBV() {
        if (this.cUU != null) {
            return this.cUU.size();
        }
        return 0;
    }

    public d mk(int i) {
        if (this.cUU != null) {
            return this.cUU.get(i);
        }
        return null;
    }
}
