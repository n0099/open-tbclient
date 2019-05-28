package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cTq = new ArrayList();
    private long cTr = 0;

    public List<d> aAC() {
        return this.cTq;
    }

    public long aAD() {
        return this.cTr;
    }

    public void a(d dVar) {
        if (this.cTq != null) {
            this.cTq.add(dVar);
            if (dVar != null) {
                this.cTr += dVar.aAM();
            }
        }
    }

    public void b(d dVar) {
        if (this.cTq != null) {
            this.cTq.remove(dVar);
            if (dVar != null) {
                this.cTr -= dVar.aAM();
            }
        }
    }

    public void remove(int i) {
        if (this.cTq != null) {
            d dVar = this.cTq.get(i);
            if (dVar != null) {
                this.cTr -= dVar.aAM();
            }
            this.cTq.remove(i);
        }
    }

    public int aAE() {
        if (this.cTq != null) {
            return this.cTq.size();
        }
        return 0;
    }

    public d mc(int i) {
        if (this.cTq != null) {
            return this.cTq.get(i);
        }
        return null;
    }
}
