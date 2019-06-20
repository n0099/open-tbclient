package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cTr = new ArrayList();
    private long cTs = 0;

    public List<d> aAC() {
        return this.cTr;
    }

    public long aAD() {
        return this.cTs;
    }

    public void a(d dVar) {
        if (this.cTr != null) {
            this.cTr.add(dVar);
            if (dVar != null) {
                this.cTs += dVar.aAM();
            }
        }
    }

    public void b(d dVar) {
        if (this.cTr != null) {
            this.cTr.remove(dVar);
            if (dVar != null) {
                this.cTs -= dVar.aAM();
            }
        }
    }

    public void remove(int i) {
        if (this.cTr != null) {
            d dVar = this.cTr.get(i);
            if (dVar != null) {
                this.cTs -= dVar.aAM();
            }
            this.cTr.remove(i);
        }
    }

    public int aAE() {
        if (this.cTr != null) {
            return this.cTr.size();
        }
        return 0;
    }

    public d mc(int i) {
        if (this.cTr != null) {
            return this.cTr.get(i);
        }
        return null;
    }
}
