package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bqQ = new ArrayList();
    private long bqR = 0;

    public List<d> RN() {
        return this.bqQ;
    }

    public long RO() {
        return this.bqR;
    }

    public void a(d dVar) {
        if (this.bqQ != null) {
            this.bqQ.add(dVar);
            if (dVar != null) {
                this.bqR += dVar.RX();
            }
        }
    }

    public void b(d dVar) {
        if (this.bqQ != null) {
            this.bqQ.remove(dVar);
            if (dVar != null) {
                this.bqR -= dVar.RX();
            }
        }
    }

    public void remove(int i) {
        if (this.bqQ != null) {
            d dVar = this.bqQ.get(i);
            if (dVar != null) {
                this.bqR -= dVar.RX();
            }
            this.bqQ.remove(i);
        }
    }

    public int RP() {
        if (this.bqQ != null) {
            return this.bqQ.size();
        }
        return 0;
    }

    public d gO(int i) {
        if (this.bqQ != null) {
            return this.bqQ.get(i);
        }
        return null;
    }
}
