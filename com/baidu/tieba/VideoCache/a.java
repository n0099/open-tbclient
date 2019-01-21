package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> bzY = new ArrayList();
    private long bzZ = 0;

    public List<d> Vw() {
        return this.bzY;
    }

    public long Vx() {
        return this.bzZ;
    }

    public void a(d dVar) {
        if (this.bzY != null) {
            this.bzY.add(dVar);
            if (dVar != null) {
                this.bzZ += dVar.VG();
            }
        }
    }

    public void b(d dVar) {
        if (this.bzY != null) {
            this.bzY.remove(dVar);
            if (dVar != null) {
                this.bzZ -= dVar.VG();
            }
        }
    }

    public void remove(int i) {
        if (this.bzY != null) {
            d dVar = this.bzY.get(i);
            if (dVar != null) {
                this.bzZ -= dVar.VG();
            }
            this.bzY.remove(i);
        }
    }

    public int Vy() {
        if (this.bzY != null) {
            return this.bzY.size();
        }
        return 0;
    }

    public d hy(int i) {
        if (this.bzY != null) {
            return this.bzY.get(i);
        }
        return null;
    }
}
