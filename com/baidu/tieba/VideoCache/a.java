package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<e> aTD = new ArrayList();
    private long aTE = 0;

    public List<e> JZ() {
        return this.aTD;
    }

    public long Ka() {
        return this.aTE;
    }

    public void a(e eVar) {
        if (this.aTD != null) {
            this.aTD.add(eVar);
            if (eVar != null) {
                this.aTE += eVar.Kh();
            }
        }
    }

    public void b(e eVar) {
        if (this.aTD != null) {
            this.aTD.remove(eVar);
            if (eVar != null) {
                this.aTE -= eVar.Kh();
            }
        }
    }

    public void remove(int i) {
        if (this.aTD != null) {
            e eVar = this.aTD.get(i);
            if (eVar != null) {
                this.aTE -= eVar.Kh();
            }
            this.aTD.remove(i);
        }
    }

    public int Kb() {
        if (this.aTD != null) {
            return this.aTD.size();
        }
        return 0;
    }

    public e fJ(int i) {
        if (this.aTD != null) {
            return this.aTD.get(i);
        }
        return null;
    }
}
