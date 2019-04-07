package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<d> cLd = new ArrayList();
    private long cLe = 0;

    public List<d> avt() {
        return this.cLd;
    }

    public long avu() {
        return this.cLe;
    }

    public void a(d dVar) {
        if (this.cLd != null) {
            this.cLd.add(dVar);
            if (dVar != null) {
                this.cLe += dVar.avD();
            }
        }
    }

    public void b(d dVar) {
        if (this.cLd != null) {
            this.cLd.remove(dVar);
            if (dVar != null) {
                this.cLe -= dVar.avD();
            }
        }
    }

    public void remove(int i) {
        if (this.cLd != null) {
            d dVar = this.cLd.get(i);
            if (dVar != null) {
                this.cLe -= dVar.avD();
            }
            this.cLd.remove(i);
        }
    }

    public int avv() {
        if (this.cLd != null) {
            return this.cLd.size();
        }
        return 0;
    }

    public d ln(int i) {
        if (this.cLd != null) {
            return this.cLd.get(i);
        }
        return null;
    }
}
