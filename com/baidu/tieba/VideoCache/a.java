package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cUN = new ArrayList();
    private long cUO = 0;

    public List<d> aBR() {
        return this.cUN;
    }

    public long aBS() {
        return this.cUO;
    }

    public void a(d dVar) {
        if (this.cUN != null) {
            this.cUN.add(dVar);
            if (dVar != null) {
                this.cUO += dVar.aCb();
            }
        }
    }

    public void b(d dVar) {
        if (this.cUN != null) {
            this.cUN.remove(dVar);
            if (dVar != null) {
                this.cUO -= dVar.aCb();
            }
        }
    }

    public void remove(int i) {
        if (this.cUN != null) {
            d dVar = this.cUN.get(i);
            if (dVar != null) {
                this.cUO -= dVar.aCb();
            }
            this.cUN.remove(i);
        }
    }

    public int aBT() {
        if (this.cUN != null) {
            return this.cUN.size();
        }
        return 0;
    }

    public d mj(int i) {
        if (this.cUN != null) {
            return this.cUN.get(i);
        }
        return null;
    }
}
