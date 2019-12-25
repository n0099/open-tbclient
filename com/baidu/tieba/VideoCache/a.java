package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> dSd = new ArrayList();
    private long dSe = 0;

    public List<d> aUj() {
        return this.dSd;
    }

    public long aUk() {
        return this.dSe;
    }

    public void a(d dVar) {
        if (this.dSd != null) {
            this.dSd.add(dVar);
            if (dVar != null) {
                this.dSe += dVar.getCurrentSize();
            }
        }
    }

    public void b(d dVar) {
        if (this.dSd != null) {
            this.dSd.remove(dVar);
            if (dVar != null) {
                this.dSe -= dVar.getCurrentSize();
            }
        }
    }

    public void remove(int i) {
        if (this.dSd != null) {
            d dVar = this.dSd.get(i);
            if (dVar != null) {
                this.dSe -= dVar.getCurrentSize();
            }
            this.dSd.remove(i);
        }
    }

    public int aUl() {
        if (this.dSd != null) {
            return this.dSd.size();
        }
        return 0;
    }

    public d nG(int i) {
        if (this.dSd != null) {
            return this.dSd.get(i);
        }
        return null;
    }
}
