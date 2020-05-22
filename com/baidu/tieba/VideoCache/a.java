package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<d> eLx = new ArrayList();
    private long eLy = 0;

    public List<d> blo() {
        return this.eLx;
    }

    public long blp() {
        return this.eLy;
    }

    public void a(d dVar) {
        if (this.eLx != null) {
            this.eLx.add(dVar);
            if (dVar != null) {
                this.eLy += dVar.bly();
            }
        }
    }

    public void b(d dVar) {
        if (this.eLx != null) {
            this.eLx.remove(dVar);
            if (dVar != null) {
                this.eLy -= dVar.bly();
            }
        }
    }

    public void remove(int i) {
        if (this.eLx != null) {
            d dVar = this.eLx.get(i);
            if (dVar != null) {
                this.eLy -= dVar.bly();
            }
            this.eLx.remove(i);
        }
    }

    public int blq() {
        if (this.eLx != null) {
            return this.eLx.size();
        }
        return 0;
    }

    public d oT(int i) {
        if (this.eLx != null) {
            return this.eLx.get(i);
        }
        return null;
    }
}
