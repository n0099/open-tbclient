package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> bQS = new ArrayList();
    private long bQT = 0;

    public List<d> Tw() {
        return this.bQS;
    }

    public long Tx() {
        return this.bQT;
    }

    public void a(d dVar) {
        if (this.bQS != null) {
            this.bQS.add(dVar);
            if (dVar != null) {
                this.bQT += dVar.TG();
            }
        }
    }

    public void b(d dVar) {
        if (this.bQS != null) {
            this.bQS.remove(dVar);
            if (dVar != null) {
                this.bQT -= dVar.TG();
            }
        }
    }

    public void remove(int i) {
        if (this.bQS != null) {
            d dVar = this.bQS.get(i);
            if (dVar != null) {
                this.bQT -= dVar.TG();
            }
            this.bQS.remove(i);
        }
    }

    public int Ty() {
        if (this.bQS != null) {
            return this.bQS.size();
        }
        return 0;
    }

    public d jj(int i) {
        if (this.bQS != null) {
            return this.bQS.get(i);
        }
        return null;
    }
}
