package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<e> aUn = new ArrayList();
    private long aUo = 0;

    public List<e> Ls() {
        return this.aUn;
    }

    public long Lt() {
        return this.aUo;
    }

    public void a(e eVar) {
        if (this.aUn != null) {
            this.aUn.add(eVar);
            if (eVar != null) {
                this.aUo += eVar.LA();
            }
        }
    }

    public void b(e eVar) {
        if (this.aUn != null) {
            this.aUn.remove(eVar);
            if (eVar != null) {
                this.aUo -= eVar.LA();
            }
        }
    }

    public void remove(int i) {
        if (this.aUn != null) {
            e eVar = this.aUn.get(i);
            if (eVar != null) {
                this.aUo -= eVar.LA();
            }
            this.aUn.remove(i);
        }
    }

    public int Lu() {
        if (this.aUn != null) {
            return this.aUn.size();
        }
        return 0;
    }

    public e fK(int i) {
        if (this.aUn != null) {
            return this.aUn.get(i);
        }
        return null;
    }
}
