package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private int foV;
    private List<cb> fpb;
    private List<cb> fpc;
    private boolean fpd;
    private boolean fpe;
    private int fpf = 2;
    private int fpg = 1;

    public b(List<cb> list, boolean z, int i) {
        this.foV = 2;
        this.fpe = z;
        this.foV = i;
        cx(list);
    }

    public void cx(List<cb> list) {
        if (list != null) {
            this.fpb = list;
            if (list != null && list.size() >= this.fpf && list.size() <= this.foV) {
                this.fpd = true;
            } else if (list.size() > this.foV && this.fpe) {
                this.fpd = true;
            } else {
                this.fpd = false;
            }
            this.fpc = bvy();
        }
    }

    private List<cb> bvy() {
        ArrayList arrayList = new ArrayList();
        if (this.fpb != null) {
            if (this.fpd) {
                if (this.fpb.size() > this.foV && this.fpb.size() >= this.fpg) {
                    arrayList.addAll(this.fpb.subList(0, this.foV));
                    arrayList.addAll(0, this.fpb.subList(this.foV - this.fpg, this.foV));
                    arrayList.addAll(this.fpb.subList(0, this.fpg));
                } else {
                    arrayList.addAll(this.fpb);
                    arrayList.addAll(0, this.fpb.subList(this.fpb.size() - this.fpg, this.fpb.size()));
                    arrayList.addAll(this.fpb.subList(0, this.fpg));
                }
            } else if (this.fpb != null && this.fpb.size() > 0 && this.fpb.size() >= this.fpg) {
                arrayList.addAll(this.fpb.subList(0, this.fpg));
            }
        }
        return arrayList;
    }

    public int qf(int i) {
        if (this.fpd) {
            int size = this.fpc.size();
            if (i == 0) {
                return (size - 1) - this.fpg;
            }
            if (i == size - this.fpg) {
                return this.fpg;
            }
            return i;
        }
        return i;
    }

    public int qg(int i) {
        if (this.fpd) {
            return i - this.fpg;
        }
        return i;
    }

    public int bvz() {
        if (this.fpb == null) {
            return 0;
        }
        return this.fpb.size();
    }

    public int bvA() {
        if (this.fpd) {
            return this.fpg;
        }
        return 0;
    }

    public void qh(int i) {
        this.foV = i;
        cx(this.fpb);
    }

    public void qi(int i) {
        this.fpf = i;
        cx(this.fpb);
    }

    public List<cb> bvB() {
        return this.fpc;
    }

    public void qj(int i) {
        this.fpg = i;
        cx(this.fpb);
    }
}
