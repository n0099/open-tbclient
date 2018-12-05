package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> bzh = new ArrayList();
    private long bzi = 0;

    public List<d> UY() {
        return this.bzh;
    }

    public long UZ() {
        return this.bzi;
    }

    public void a(d dVar) {
        if (this.bzh != null) {
            this.bzh.add(dVar);
            if (dVar != null) {
                this.bzi += dVar.Vi();
            }
        }
    }

    public void b(d dVar) {
        if (this.bzh != null) {
            this.bzh.remove(dVar);
            if (dVar != null) {
                this.bzi -= dVar.Vi();
            }
        }
    }

    public void remove(int i) {
        if (this.bzh != null) {
            d dVar = this.bzh.get(i);
            if (dVar != null) {
                this.bzi -= dVar.Vi();
            }
            this.bzh.remove(i);
        }
    }

    public int Va() {
        if (this.bzh != null) {
            return this.bzh.size();
        }
        return 0;
    }

    public d hx(int i) {
        if (this.bzh != null) {
            return this.bzh.get(i);
        }
        return null;
    }
}
