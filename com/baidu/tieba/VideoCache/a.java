package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aXr = new ArrayList();
    private long aXs = 0;

    public List<d> KP() {
        return this.aXr;
    }

    public long KQ() {
        return this.aXs;
    }

    public void a(d dVar) {
        if (this.aXr != null) {
            this.aXr.add(dVar);
            if (dVar != null) {
                this.aXs += dVar.KX();
            }
        }
    }

    public void b(d dVar) {
        if (this.aXr != null) {
            this.aXr.remove(dVar);
            if (dVar != null) {
                this.aXs -= dVar.KX();
            }
        }
    }

    public void remove(int i) {
        if (this.aXr != null) {
            d dVar = this.aXr.get(i);
            if (dVar != null) {
                this.aXs -= dVar.KX();
            }
            this.aXr.remove(i);
        }
    }

    public int KR() {
        if (this.aXr != null) {
            return this.aXr.size();
        }
        return 0;
    }

    public d gl(int i) {
        if (this.aXr != null) {
            return this.aXr.get(i);
        }
        return null;
    }
}
