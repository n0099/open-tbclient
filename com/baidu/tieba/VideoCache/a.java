package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bkW = new ArrayList();
    private long bkX = 0;

    public List<d> PT() {
        return this.bkW;
    }

    public long PU() {
        return this.bkX;
    }

    public void a(d dVar) {
        if (this.bkW != null) {
            this.bkW.add(dVar);
            if (dVar != null) {
                this.bkX += dVar.Qd();
            }
        }
    }

    public void b(d dVar) {
        if (this.bkW != null) {
            this.bkW.remove(dVar);
            if (dVar != null) {
                this.bkX -= dVar.Qd();
            }
        }
    }

    public void remove(int i) {
        if (this.bkW != null) {
            d dVar = this.bkW.get(i);
            if (dVar != null) {
                this.bkX -= dVar.Qd();
            }
            this.bkW.remove(i);
        }
    }

    public int PV() {
        if (this.bkW != null) {
            return this.bkW.size();
        }
        return 0;
    }

    public d gp(int i) {
        if (this.bkW != null) {
            return this.bkW.get(i);
        }
        return null;
    }
}
