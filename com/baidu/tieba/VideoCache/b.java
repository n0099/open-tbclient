package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<f> aMz = new ArrayList();
    private long aMA = 0;

    public List<f> Jp() {
        return this.aMz;
    }

    public long Jq() {
        return this.aMA;
    }

    public void a(f fVar) {
        if (this.aMz != null) {
            this.aMz.add(fVar);
            if (fVar != null) {
                this.aMA += fVar.Jx();
            }
        }
    }

    public void b(f fVar) {
        if (this.aMz != null) {
            this.aMz.remove(fVar);
            if (fVar != null) {
                this.aMA -= fVar.Jx();
            }
        }
    }

    public void remove(int i) {
        if (this.aMz != null) {
            f fVar = this.aMz.get(i);
            if (fVar != null) {
                this.aMA -= fVar.Jx();
            }
            this.aMz.remove(i);
        }
    }

    public int Jr() {
        if (this.aMz != null) {
            return this.aMz.size();
        }
        return 0;
    }

    public f fG(int i) {
        if (this.aMz != null) {
            return this.aMz.get(i);
        }
        return null;
    }
}
