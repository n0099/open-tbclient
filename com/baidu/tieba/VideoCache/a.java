package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aUG = new ArrayList();
    private long aUH = 0;

    public List<d> Kf() {
        return this.aUG;
    }

    public long Kg() {
        return this.aUH;
    }

    public void a(d dVar) {
        if (this.aUG != null) {
            this.aUG.add(dVar);
            if (dVar != null) {
                this.aUH += dVar.Kn();
            }
        }
    }

    public void b(d dVar) {
        if (this.aUG != null) {
            this.aUG.remove(dVar);
            if (dVar != null) {
                this.aUH -= dVar.Kn();
            }
        }
    }

    public void remove(int i) {
        if (this.aUG != null) {
            d dVar = this.aUG.get(i);
            if (dVar != null) {
                this.aUH -= dVar.Kn();
            }
            this.aUG.remove(i);
        }
    }

    public int Kh() {
        if (this.aUG != null) {
            return this.aUG.size();
        }
        return 0;
    }

    public d fM(int i) {
        if (this.aUG != null) {
            return this.aUG.get(i);
        }
        return null;
    }
}
