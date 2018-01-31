package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bOK = new ArrayList();
    private long bOL = 0;

    public List<d> SN() {
        return this.bOK;
    }

    public long SO() {
        return this.bOL;
    }

    public void a(d dVar) {
        if (this.bOK != null) {
            this.bOK.add(dVar);
            if (dVar != null) {
                this.bOL += dVar.SX();
            }
        }
    }

    public void b(d dVar) {
        if (this.bOK != null) {
            this.bOK.remove(dVar);
            if (dVar != null) {
                this.bOL -= dVar.SX();
            }
        }
    }

    public void remove(int i) {
        if (this.bOK != null) {
            d dVar = this.bOK.get(i);
            if (dVar != null) {
                this.bOL -= dVar.SX();
            }
            this.bOK.remove(i);
        }
    }

    public int SP() {
        if (this.bOK != null) {
            return this.bOK.size();
        }
        return 0;
    }

    public d jn(int i) {
        if (this.bOK != null) {
            return this.bOK.get(i);
        }
        return null;
    }
}
