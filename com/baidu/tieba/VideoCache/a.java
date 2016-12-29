package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<e> aPg = new ArrayList();
    private long aPh = 0;

    public List<e> JY() {
        return this.aPg;
    }

    public long JZ() {
        return this.aPh;
    }

    public void a(e eVar) {
        if (this.aPg != null) {
            this.aPg.add(eVar);
            if (eVar != null) {
                this.aPh += eVar.Kg();
            }
        }
    }

    public void b(e eVar) {
        if (this.aPg != null) {
            this.aPg.remove(eVar);
            if (eVar != null) {
                this.aPh -= eVar.Kg();
            }
        }
    }

    public void remove(int i) {
        if (this.aPg != null) {
            e eVar = this.aPg.get(i);
            if (eVar != null) {
                this.aPh -= eVar.Kg();
            }
            this.aPg.remove(i);
        }
    }

    public int Ka() {
        if (this.aPg != null) {
            return this.aPg.size();
        }
        return 0;
    }

    public e fJ(int i) {
        if (this.aPg != null) {
            return this.aPg.get(i);
        }
        return null;
    }
}
