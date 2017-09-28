package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<d> aXo = new ArrayList();
    private long aXp = 0;

    public List<d> KM() {
        return this.aXo;
    }

    public long KN() {
        return this.aXp;
    }

    public void a(d dVar) {
        if (this.aXo != null) {
            this.aXo.add(dVar);
            if (dVar != null) {
                this.aXp += dVar.KU();
            }
        }
    }

    public void b(d dVar) {
        if (this.aXo != null) {
            this.aXo.remove(dVar);
            if (dVar != null) {
                this.aXp -= dVar.KU();
            }
        }
    }

    public void remove(int i) {
        if (this.aXo != null) {
            d dVar = this.aXo.get(i);
            if (dVar != null) {
                this.aXp -= dVar.KU();
            }
            this.aXo.remove(i);
        }
    }

    public int KO() {
        if (this.aXo != null) {
            return this.aXo.size();
        }
        return 0;
    }

    public d gd(int i) {
        if (this.aXo != null) {
            return this.aXo.get(i);
        }
        return null;
    }
}
