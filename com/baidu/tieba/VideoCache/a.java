package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> dWV = new ArrayList();
    private long dWW = 0;

    public List<d> aXa() {
        return this.dWV;
    }

    public long aXb() {
        return this.dWW;
    }

    public void a(d dVar) {
        if (this.dWV != null) {
            this.dWV.add(dVar);
            if (dVar != null) {
                this.dWW += dVar.getCurrentSize();
            }
        }
    }

    public void b(d dVar) {
        if (this.dWV != null) {
            this.dWV.remove(dVar);
            if (dVar != null) {
                this.dWW -= dVar.getCurrentSize();
            }
        }
    }

    public void remove(int i) {
        if (this.dWV != null) {
            d dVar = this.dWV.get(i);
            if (dVar != null) {
                this.dWW -= dVar.getCurrentSize();
            }
            this.dWV.remove(i);
        }
    }

    public int aXc() {
        if (this.dWV != null) {
            return this.dWV.size();
        }
        return 0;
    }

    public d nZ(int i) {
        if (this.dWV != null) {
            return this.dWV.get(i);
        }
        return null;
    }
}
