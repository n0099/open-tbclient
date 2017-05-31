package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<e> aSk = new ArrayList();
    private long aSl = 0;

    public List<e> JB() {
        return this.aSk;
    }

    public long JC() {
        return this.aSl;
    }

    public void a(e eVar) {
        if (this.aSk != null) {
            this.aSk.add(eVar);
            if (eVar != null) {
                this.aSl += eVar.JJ();
            }
        }
    }

    public void b(e eVar) {
        if (this.aSk != null) {
            this.aSk.remove(eVar);
            if (eVar != null) {
                this.aSl -= eVar.JJ();
            }
        }
    }

    public void remove(int i) {
        if (this.aSk != null) {
            e eVar = this.aSk.get(i);
            if (eVar != null) {
                this.aSl -= eVar.JJ();
            }
            this.aSk.remove(i);
        }
    }

    public int JD() {
        if (this.aSk != null) {
            return this.aSk.size();
        }
        return 0;
    }

    public e fH(int i) {
        if (this.aSk != null) {
            return this.aSk.get(i);
        }
        return null;
    }
}
