package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<e> aTW = new ArrayList();
    private long aTX = 0;

    public List<e> KS() {
        return this.aTW;
    }

    public long KT() {
        return this.aTX;
    }

    public void a(e eVar) {
        if (this.aTW != null) {
            this.aTW.add(eVar);
            if (eVar != null) {
                this.aTX += eVar.La();
            }
        }
    }

    public void b(e eVar) {
        if (this.aTW != null) {
            this.aTW.remove(eVar);
            if (eVar != null) {
                this.aTX -= eVar.La();
            }
        }
    }

    public void remove(int i) {
        if (this.aTW != null) {
            e eVar = this.aTW.get(i);
            if (eVar != null) {
                this.aTX -= eVar.La();
            }
            this.aTW.remove(i);
        }
    }

    public int KU() {
        if (this.aTW != null) {
            return this.aTW.size();
        }
        return 0;
    }

    public e fH(int i) {
        if (this.aTW != null) {
            return this.aTW.get(i);
        }
        return null;
    }
}
