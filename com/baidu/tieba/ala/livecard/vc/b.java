package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private int ctk;
    private List<bh> ctr;
    private List<bh> cts;
    private boolean ctt;
    private boolean ctu;
    private int ctv = 2;
    private int ctw = 1;

    public b(List<bh> list, boolean z, int i) {
        this.ctk = 2;
        this.ctu = z;
        this.ctk = i;
        aY(list);
    }

    public void aY(List<bh> list) {
        if (list != null) {
            this.ctr = list;
            if (list != null && list.size() >= this.ctv && list.size() <= this.ctk) {
                this.ctt = true;
            } else if (list.size() > this.ctk && this.ctu) {
                this.ctt = true;
            } else {
                this.ctt = false;
            }
            this.cts = aor();
        }
    }

    private List<bh> aor() {
        ArrayList arrayList = new ArrayList();
        if (this.ctr != null) {
            if (this.ctt) {
                if (this.ctr.size() > this.ctk && this.ctr.size() >= this.ctw) {
                    arrayList.addAll(this.ctr.subList(0, this.ctk));
                    arrayList.addAll(0, this.ctr.subList(this.ctk - this.ctw, this.ctk));
                    arrayList.addAll(this.ctr.subList(0, this.ctw));
                } else {
                    arrayList.addAll(this.ctr);
                    arrayList.addAll(0, this.ctr.subList(this.ctr.size() - this.ctw, this.ctr.size()));
                    arrayList.addAll(this.ctr.subList(0, this.ctw));
                }
            } else if (this.ctr != null && this.ctr.size() > 0 && this.ctr.size() >= this.ctw) {
                arrayList.addAll(this.ctr.subList(0, this.ctw));
            }
        }
        return arrayList;
    }

    public int iY(int i) {
        if (this.ctt) {
            int size = this.cts.size();
            if (i == 0) {
                return (size - 1) - this.ctw;
            }
            if (i == size - this.ctw) {
                return this.ctw;
            }
            return i;
        }
        return i;
    }

    public int iZ(int i) {
        if (this.ctt) {
            return i - this.ctw;
        }
        return i;
    }

    public int aos() {
        if (this.ctr == null) {
            return 0;
        }
        return this.ctr.size();
    }

    public int aot() {
        if (this.ctt) {
            return this.ctw;
        }
        return 0;
    }

    public void ja(int i) {
        this.ctk = i;
        aY(this.ctr);
    }

    public void jb(int i) {
        this.ctv = i;
        aY(this.ctr);
    }

    public List<bh> aou() {
        return this.cts;
    }

    public void jc(int i) {
        this.ctw = i;
        aY(this.ctr);
    }
}
