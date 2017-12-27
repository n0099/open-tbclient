package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bOt = new ArrayList();
    private long bOu = 0;

    public List<d> SX() {
        return this.bOt;
    }

    public long SY() {
        return this.bOu;
    }

    public void a(d dVar) {
        if (this.bOt != null) {
            this.bOt.add(dVar);
            if (dVar != null) {
                this.bOu += dVar.Th();
            }
        }
    }

    public void b(d dVar) {
        if (this.bOt != null) {
            this.bOt.remove(dVar);
            if (dVar != null) {
                this.bOu -= dVar.Th();
            }
        }
    }

    public void remove(int i) {
        if (this.bOt != null) {
            d dVar = this.bOt.get(i);
            if (dVar != null) {
                this.bOu -= dVar.Th();
            }
            this.bOt.remove(i);
        }
    }

    public int SZ() {
        if (this.bOt != null) {
            return this.bOt.size();
        }
        return 0;
    }

    public d jr(int i) {
        if (this.bOt != null) {
            return this.bOt.get(i);
        }
        return null;
    }
}
