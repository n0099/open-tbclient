package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aVA = new ArrayList();
    private long aVB = 0;

    public List<d> Ku() {
        return this.aVA;
    }

    public long Kv() {
        return this.aVB;
    }

    public void a(d dVar) {
        if (this.aVA != null) {
            this.aVA.add(dVar);
            if (dVar != null) {
                this.aVB += dVar.KC();
            }
        }
    }

    public void b(d dVar) {
        if (this.aVA != null) {
            this.aVA.remove(dVar);
            if (dVar != null) {
                this.aVB -= dVar.KC();
            }
        }
    }

    public void remove(int i) {
        if (this.aVA != null) {
            d dVar = this.aVA.get(i);
            if (dVar != null) {
                this.aVB -= dVar.KC();
            }
            this.aVA.remove(i);
        }
    }

    public int Kw() {
        if (this.aVA != null) {
            return this.aVA.size();
        }
        return 0;
    }

    public d fP(int i) {
        if (this.aVA != null) {
            return this.aVA.get(i);
        }
        return null;
    }
}
