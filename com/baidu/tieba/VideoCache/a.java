package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> bzX = new ArrayList();
    private long bzY = 0;

    public List<d> Vw() {
        return this.bzX;
    }

    public long Vx() {
        return this.bzY;
    }

    public void a(d dVar) {
        if (this.bzX != null) {
            this.bzX.add(dVar);
            if (dVar != null) {
                this.bzY += dVar.VG();
            }
        }
    }

    public void b(d dVar) {
        if (this.bzX != null) {
            this.bzX.remove(dVar);
            if (dVar != null) {
                this.bzY -= dVar.VG();
            }
        }
    }

    public void remove(int i) {
        if (this.bzX != null) {
            d dVar = this.bzX.get(i);
            if (dVar != null) {
                this.bzY -= dVar.VG();
            }
            this.bzX.remove(i);
        }
    }

    public int Vy() {
        if (this.bzX != null) {
            return this.bzX.size();
        }
        return 0;
    }

    public d hy(int i) {
        if (this.bzX != null) {
            return this.bzX.get(i);
        }
        return null;
    }
}
