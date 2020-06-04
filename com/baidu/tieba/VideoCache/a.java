package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> eLI = new ArrayList();
    private long eLJ = 0;

    public List<d> blq() {
        return this.eLI;
    }

    public long blr() {
        return this.eLJ;
    }

    public void a(d dVar) {
        if (this.eLI != null) {
            this.eLI.add(dVar);
            if (dVar != null) {
                this.eLJ += dVar.blA();
            }
        }
    }

    public void b(d dVar) {
        if (this.eLI != null) {
            this.eLI.remove(dVar);
            if (dVar != null) {
                this.eLJ -= dVar.blA();
            }
        }
    }

    public void remove(int i) {
        if (this.eLI != null) {
            d dVar = this.eLI.get(i);
            if (dVar != null) {
                this.eLJ -= dVar.blA();
            }
            this.eLI.remove(i);
        }
    }

    public int bls() {
        if (this.eLI != null) {
            return this.eLI.size();
        }
        return 0;
    }

    public d oV(int i) {
        if (this.eLI != null) {
            return this.eLI.get(i);
        }
        return null;
    }
}
