package com.baidu.tieba.VideoCache;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<d> bzk = new ArrayList();
    private long bzl = 0;

    public List<d> Va() {
        return this.bzk;
    }

    public long Vb() {
        return this.bzl;
    }

    public void a(d dVar) {
        if (this.bzk != null) {
            this.bzk.add(dVar);
            if (dVar != null) {
                this.bzl += dVar.Vk();
            }
        }
    }

    public void b(d dVar) {
        if (this.bzk != null) {
            this.bzk.remove(dVar);
            if (dVar != null) {
                this.bzl -= dVar.Vk();
            }
        }
    }

    public void remove(int i) {
        if (this.bzk != null) {
            d dVar = this.bzk.get(i);
            if (dVar != null) {
                this.bzl -= dVar.Vk();
            }
            this.bzk.remove(i);
        }
    }

    public int Vc() {
        if (this.bzk != null) {
            return this.bzk.size();
        }
        return 0;
    }

    public d hy(int i) {
        if (this.bzk != null) {
            return this.bzk.get(i);
        }
        return null;
    }
}
