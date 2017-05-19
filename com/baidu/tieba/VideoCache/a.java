package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<e> aUI = new ArrayList();
    private long aUJ = 0;

    public List<e> KG() {
        return this.aUI;
    }

    public long KH() {
        return this.aUJ;
    }

    public void a(e eVar) {
        if (this.aUI != null) {
            this.aUI.add(eVar);
            if (eVar != null) {
                this.aUJ += eVar.KO();
            }
        }
    }

    public void b(e eVar) {
        if (this.aUI != null) {
            this.aUI.remove(eVar);
            if (eVar != null) {
                this.aUJ -= eVar.KO();
            }
        }
    }

    public void remove(int i) {
        if (this.aUI != null) {
            e eVar = this.aUI.get(i);
            if (eVar != null) {
                this.aUJ -= eVar.KO();
            }
            this.aUI.remove(i);
        }
    }

    public int KI() {
        if (this.aUI != null) {
            return this.aUI.size();
        }
        return 0;
    }

    public e fH(int i) {
        if (this.aUI != null) {
            return this.aUI.get(i);
        }
        return null;
    }
}
