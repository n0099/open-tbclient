package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> ewU = new ArrayList();
    private long ewV = 0;

    public List<d> bfc() {
        return this.ewU;
    }

    public long bfd() {
        return this.ewV;
    }

    public void a(d dVar) {
        if (this.ewU != null) {
            this.ewU.add(dVar);
            if (dVar != null) {
                this.ewV += dVar.bfm();
            }
        }
    }

    public void b(d dVar) {
        if (this.ewU != null) {
            this.ewU.remove(dVar);
            if (dVar != null) {
                this.ewV -= dVar.bfm();
            }
        }
    }

    public void remove(int i) {
        if (this.ewU != null) {
            d dVar = this.ewU.get(i);
            if (dVar != null) {
                this.ewV -= dVar.bfm();
            }
            this.ewU.remove(i);
        }
    }

    public int bfe() {
        if (this.ewU != null) {
            return this.ewU.size();
        }
        return 0;
    }

    public d om(int i) {
        if (this.ewU != null) {
            return this.ewU.get(i);
        }
        return null;
    }
}
