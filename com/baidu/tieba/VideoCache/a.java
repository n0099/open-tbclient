package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bQI = new ArrayList();
    private long bQJ = 0;

    public List<d> Tw() {
        return this.bQI;
    }

    public long Tx() {
        return this.bQJ;
    }

    public void a(d dVar) {
        if (this.bQI != null) {
            this.bQI.add(dVar);
            if (dVar != null) {
                this.bQJ += dVar.TG();
            }
        }
    }

    public void b(d dVar) {
        if (this.bQI != null) {
            this.bQI.remove(dVar);
            if (dVar != null) {
                this.bQJ -= dVar.TG();
            }
        }
    }

    public void remove(int i) {
        if (this.bQI != null) {
            d dVar = this.bQI.get(i);
            if (dVar != null) {
                this.bQJ -= dVar.TG();
            }
            this.bQI.remove(i);
        }
    }

    public int Ty() {
        if (this.bQI != null) {
            return this.bQI.size();
        }
        return 0;
    }

    public d jj(int i) {
        if (this.bQI != null) {
            return this.bQI.get(i);
        }
        return null;
    }
}
