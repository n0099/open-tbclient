package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> deq = new ArrayList();
    private long der = 0;

    public List<d> aCo() {
        return this.deq;
    }

    public long aCp() {
        return this.der;
    }

    public void a(d dVar) {
        if (this.deq != null) {
            this.deq.add(dVar);
            if (dVar != null) {
                this.der += dVar.aCy();
            }
        }
    }

    public void b(d dVar) {
        if (this.deq != null) {
            this.deq.remove(dVar);
            if (dVar != null) {
                this.der -= dVar.aCy();
            }
        }
    }

    public void remove(int i) {
        if (this.deq != null) {
            d dVar = this.deq.get(i);
            if (dVar != null) {
                this.der -= dVar.aCy();
            }
            this.deq.remove(i);
        }
    }

    public int aCq() {
        if (this.deq != null) {
            return this.deq.size();
        }
        return 0;
    }

    public d ls(int i) {
        if (this.deq != null) {
            return this.deq.get(i);
        }
        return null;
    }
}
