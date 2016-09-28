package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<f> aNJ = new ArrayList();
    private long aNK = 0;

    public List<f> Kb() {
        return this.aNJ;
    }

    public long Kc() {
        return this.aNK;
    }

    public void a(f fVar) {
        if (this.aNJ != null) {
            this.aNJ.add(fVar);
            if (fVar != null) {
                this.aNK += fVar.Kj();
            }
        }
    }

    public void b(f fVar) {
        if (this.aNJ != null) {
            this.aNJ.remove(fVar);
            if (fVar != null) {
                this.aNK -= fVar.Kj();
            }
        }
    }

    public void remove(int i) {
        if (this.aNJ != null) {
            f fVar = this.aNJ.get(i);
            if (fVar != null) {
                this.aNK -= fVar.Kj();
            }
            this.aNJ.remove(i);
        }
    }

    public int Kd() {
        if (this.aNJ != null) {
            return this.aNJ.size();
        }
        return 0;
    }

    public f fK(int i) {
        if (this.aNJ != null) {
            return this.aNJ.get(i);
        }
        return null;
    }
}
