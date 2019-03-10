package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cLe = new ArrayList();
    private long cLf = 0;

    public List<d> avx() {
        return this.cLe;
    }

    public long avy() {
        return this.cLf;
    }

    public void a(d dVar) {
        if (this.cLe != null) {
            this.cLe.add(dVar);
            if (dVar != null) {
                this.cLf += dVar.avH();
            }
        }
    }

    public void b(d dVar) {
        if (this.cLe != null) {
            this.cLe.remove(dVar);
            if (dVar != null) {
                this.cLf -= dVar.avH();
            }
        }
    }

    public void remove(int i) {
        if (this.cLe != null) {
            d dVar = this.cLe.get(i);
            if (dVar != null) {
                this.cLf -= dVar.avH();
            }
            this.cLe.remove(i);
        }
    }

    public int avz() {
        if (this.cLe != null) {
            return this.cLe.size();
        }
        return 0;
    }

    public d lo(int i) {
        if (this.cLe != null) {
            return this.cLe.get(i);
        }
        return null;
    }
}
