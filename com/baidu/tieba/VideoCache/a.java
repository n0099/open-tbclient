package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aXb = new ArrayList();
    private long aXc = 0;

    public List<d> KG() {
        return this.aXb;
    }

    public long KH() {
        return this.aXc;
    }

    public void a(d dVar) {
        if (this.aXb != null) {
            this.aXb.add(dVar);
            if (dVar != null) {
                this.aXc += dVar.KO();
            }
        }
    }

    public void b(d dVar) {
        if (this.aXb != null) {
            this.aXb.remove(dVar);
            if (dVar != null) {
                this.aXc -= dVar.KO();
            }
        }
    }

    public void remove(int i) {
        if (this.aXb != null) {
            d dVar = this.aXb.get(i);
            if (dVar != null) {
                this.aXc -= dVar.KO();
            }
            this.aXb.remove(i);
        }
    }

    public int KI() {
        if (this.aXb != null) {
            return this.aXb.size();
        }
        return 0;
    }

    public d gc(int i) {
        if (this.aXb != null) {
            return this.aXb.get(i);
        }
        return null;
    }
}
