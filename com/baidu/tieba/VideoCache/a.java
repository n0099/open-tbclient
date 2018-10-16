package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> buZ = new ArrayList();
    private long bva = 0;

    public List<d> TJ() {
        return this.buZ;
    }

    public long TK() {
        return this.bva;
    }

    public void a(d dVar) {
        if (this.buZ != null) {
            this.buZ.add(dVar);
            if (dVar != null) {
                this.bva += dVar.TT();
            }
        }
    }

    public void b(d dVar) {
        if (this.buZ != null) {
            this.buZ.remove(dVar);
            if (dVar != null) {
                this.bva -= dVar.TT();
            }
        }
    }

    public void remove(int i) {
        if (this.buZ != null) {
            d dVar = this.buZ.get(i);
            if (dVar != null) {
                this.bva -= dVar.TT();
            }
            this.buZ.remove(i);
        }
    }

    public int TL() {
        if (this.buZ != null) {
            return this.buZ.size();
        }
        return 0;
    }

    public d gW(int i) {
        if (this.buZ != null) {
            return this.buZ.get(i);
        }
        return null;
    }
}
