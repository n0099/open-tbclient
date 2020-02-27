package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> dWr = new ArrayList();
    private long dWs = 0;

    public List<d> aWT() {
        return this.dWr;
    }

    public long aWU() {
        return this.dWs;
    }

    public void a(d dVar) {
        if (this.dWr != null) {
            this.dWr.add(dVar);
            if (dVar != null) {
                this.dWs += dVar.getCurrentSize();
            }
        }
    }

    public void b(d dVar) {
        if (this.dWr != null) {
            this.dWr.remove(dVar);
            if (dVar != null) {
                this.dWs -= dVar.getCurrentSize();
            }
        }
    }

    public void remove(int i) {
        if (this.dWr != null) {
            d dVar = this.dWr.get(i);
            if (dVar != null) {
                this.dWs -= dVar.getCurrentSize();
            }
            this.dWr.remove(i);
        }
    }

    public int aWV() {
        if (this.dWr != null) {
            return this.dWr.size();
        }
        return 0;
    }

    public d nX(int i) {
        if (this.dWr != null) {
            return this.dWr.get(i);
        }
        return null;
    }
}
