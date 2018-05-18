package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> baG = new ArrayList();
    private long baH = 0;

    public List<d> LR() {
        return this.baG;
    }

    public long LS() {
        return this.baH;
    }

    public void a(d dVar) {
        if (this.baG != null) {
            this.baG.add(dVar);
            if (dVar != null) {
                this.baH += dVar.Ma();
            }
        }
    }

    public void b(d dVar) {
        if (this.baG != null) {
            this.baG.remove(dVar);
            if (dVar != null) {
                this.baH -= dVar.Ma();
            }
        }
    }

    public void remove(int i) {
        if (this.baG != null) {
            d dVar = this.baG.get(i);
            if (dVar != null) {
                this.baH -= dVar.Ma();
            }
            this.baG.remove(i);
        }
    }

    public int LT() {
        if (this.baG != null) {
            return this.baG.size();
        }
        return 0;
    }

    public d gi(int i) {
        if (this.baG != null) {
            return this.baG.get(i);
        }
        return null;
    }
}
