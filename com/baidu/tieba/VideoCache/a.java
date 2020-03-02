package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> dWs = new ArrayList();
    private long dWt = 0;

    public List<d> aWV() {
        return this.dWs;
    }

    public long aWW() {
        return this.dWt;
    }

    public void a(d dVar) {
        if (this.dWs != null) {
            this.dWs.add(dVar);
            if (dVar != null) {
                this.dWt += dVar.getCurrentSize();
            }
        }
    }

    public void b(d dVar) {
        if (this.dWs != null) {
            this.dWs.remove(dVar);
            if (dVar != null) {
                this.dWt -= dVar.getCurrentSize();
            }
        }
    }

    public void remove(int i) {
        if (this.dWs != null) {
            d dVar = this.dWs.get(i);
            if (dVar != null) {
                this.dWt -= dVar.getCurrentSize();
            }
            this.dWs.remove(i);
        }
    }

    public int aWX() {
        if (this.dWs != null) {
            return this.dWs.size();
        }
        return 0;
    }

    public d nX(int i) {
        if (this.dWs != null) {
            return this.dWs.get(i);
        }
        return null;
    }
}
