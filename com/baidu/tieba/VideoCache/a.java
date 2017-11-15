package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aXA = new ArrayList();
    private long aXB = 0;

    public List<d> La() {
        return this.aXA;
    }

    public long Lb() {
        return this.aXB;
    }

    public void a(d dVar) {
        if (this.aXA != null) {
            this.aXA.add(dVar);
            if (dVar != null) {
                this.aXB += dVar.Li();
            }
        }
    }

    public void b(d dVar) {
        if (this.aXA != null) {
            this.aXA.remove(dVar);
            if (dVar != null) {
                this.aXB -= dVar.Li();
            }
        }
    }

    public void remove(int i) {
        if (this.aXA != null) {
            d dVar = this.aXA.get(i);
            if (dVar != null) {
                this.aXB -= dVar.Li();
            }
            this.aXA.remove(i);
        }
    }

    public int Lc() {
        if (this.aXA != null) {
            return this.aXA.size();
        }
        return 0;
    }

    public d gk(int i) {
        if (this.aXA != null) {
            return this.aXA.get(i);
        }
        return null;
    }
}
