package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> dWF = new ArrayList();
    private long dWG = 0;

    public List<d> aWW() {
        return this.dWF;
    }

    public long aWX() {
        return this.dWG;
    }

    public void a(d dVar) {
        if (this.dWF != null) {
            this.dWF.add(dVar);
            if (dVar != null) {
                this.dWG += dVar.getCurrentSize();
            }
        }
    }

    public void b(d dVar) {
        if (this.dWF != null) {
            this.dWF.remove(dVar);
            if (dVar != null) {
                this.dWG -= dVar.getCurrentSize();
            }
        }
    }

    public void remove(int i) {
        if (this.dWF != null) {
            d dVar = this.dWF.get(i);
            if (dVar != null) {
                this.dWG -= dVar.getCurrentSize();
            }
            this.dWF.remove(i);
        }
    }

    public int aWY() {
        if (this.dWF != null) {
            return this.dWF.size();
        }
        return 0;
    }

    public d nX(int i) {
        if (this.dWF != null) {
            return this.dWF.get(i);
        }
        return null;
    }
}
