package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<e> aOj = new ArrayList();
    private long aOk = 0;

    public List<e> Kn() {
        return this.aOj;
    }

    public long Ko() {
        return this.aOk;
    }

    public void a(e eVar) {
        if (this.aOj != null) {
            this.aOj.add(eVar);
            if (eVar != null) {
                this.aOk += eVar.Kv();
            }
        }
    }

    public void b(e eVar) {
        if (this.aOj != null) {
            this.aOj.remove(eVar);
            if (eVar != null) {
                this.aOk -= eVar.Kv();
            }
        }
    }

    public void remove(int i) {
        if (this.aOj != null) {
            e eVar = this.aOj.get(i);
            if (eVar != null) {
                this.aOk -= eVar.Kv();
            }
            this.aOj.remove(i);
        }
    }

    public int Kp() {
        if (this.aOj != null) {
            return this.aOj.size();
        }
        return 0;
    }

    public e fN(int i) {
        if (this.aOj != null) {
            return this.aOj.get(i);
        }
        return null;
    }
}
