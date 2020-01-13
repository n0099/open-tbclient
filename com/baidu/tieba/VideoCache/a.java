package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<d> dSm = new ArrayList();
    private long dSn = 0;

    public List<d> aUD() {
        return this.dSm;
    }

    public long aUE() {
        return this.dSn;
    }

    public void a(d dVar) {
        if (this.dSm != null) {
            this.dSm.add(dVar);
            if (dVar != null) {
                this.dSn += dVar.getCurrentSize();
            }
        }
    }

    public void b(d dVar) {
        if (this.dSm != null) {
            this.dSm.remove(dVar);
            if (dVar != null) {
                this.dSn -= dVar.getCurrentSize();
            }
        }
    }

    public void remove(int i) {
        if (this.dSm != null) {
            d dVar = this.dSm.get(i);
            if (dVar != null) {
                this.dSn -= dVar.getCurrentSize();
            }
            this.dSm.remove(i);
        }
    }

    public int aUF() {
        if (this.dSm != null) {
            return this.dSm.size();
        }
        return 0;
    }

    public d nG(int i) {
        if (this.dSm != null) {
            return this.dSm.get(i);
        }
        return null;
    }
}
