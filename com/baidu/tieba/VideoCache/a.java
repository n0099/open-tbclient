package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<e> aUl = new ArrayList();
    private long aUm = 0;

    public List<e> Ls() {
        return this.aUl;
    }

    public long Lt() {
        return this.aUm;
    }

    public void a(e eVar) {
        if (this.aUl != null) {
            this.aUl.add(eVar);
            if (eVar != null) {
                this.aUm += eVar.LA();
            }
        }
    }

    public void b(e eVar) {
        if (this.aUl != null) {
            this.aUl.remove(eVar);
            if (eVar != null) {
                this.aUm -= eVar.LA();
            }
        }
    }

    public void remove(int i) {
        if (this.aUl != null) {
            e eVar = this.aUl.get(i);
            if (eVar != null) {
                this.aUm -= eVar.LA();
            }
            this.aUl.remove(i);
        }
    }

    public int Lu() {
        if (this.aUl != null) {
            return this.aUl.size();
        }
        return 0;
    }

    public e fK(int i) {
        if (this.aUl != null) {
            return this.aUl.get(i);
        }
        return null;
    }
}
