package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int dKU;
    private List<bj> dLa;
    private List<bj> dLb;
    private boolean dLc;
    private boolean dLd;
    private int dLe = 2;
    private int dLf = 1;

    public b(List<bj> list, boolean z, int i) {
        this.dKU = 2;
        this.dLd = z;
        this.dKU = i;
        ak(list);
    }

    public void ak(List<bj> list) {
        if (list != null) {
            this.dLa = list;
            if (list != null && list.size() >= this.dLe && list.size() <= this.dKU) {
                this.dLc = true;
            } else if (list.size() > this.dKU && this.dLd) {
                this.dLc = true;
            } else {
                this.dLc = false;
            }
            this.dLb = aRd();
        }
    }

    private List<bj> aRd() {
        ArrayList arrayList = new ArrayList();
        if (this.dLa != null) {
            if (this.dLc) {
                if (this.dLa.size() > this.dKU && this.dLa.size() >= this.dLf) {
                    arrayList.addAll(this.dLa.subList(0, this.dKU));
                    arrayList.addAll(0, this.dLa.subList(this.dKU - this.dLf, this.dKU));
                    arrayList.addAll(this.dLa.subList(0, this.dLf));
                } else {
                    arrayList.addAll(this.dLa);
                    arrayList.addAll(0, this.dLa.subList(this.dLa.size() - this.dLf, this.dLa.size()));
                    arrayList.addAll(this.dLa.subList(0, this.dLf));
                }
            } else if (this.dLa != null && this.dLa.size() > 0 && this.dLa.size() >= this.dLf) {
                arrayList.addAll(this.dLa.subList(0, this.dLf));
            }
        }
        return arrayList;
    }

    public int lP(int i) {
        if (this.dLc) {
            int size = this.dLb.size();
            if (i == 0) {
                return (size - 1) - this.dLf;
            }
            if (i == size - this.dLf) {
                return this.dLf;
            }
            return i;
        }
        return i;
    }

    public int lQ(int i) {
        if (this.dLc) {
            return i - this.dLf;
        }
        return i;
    }

    public int aRe() {
        if (this.dLa == null) {
            return 0;
        }
        return this.dLa.size();
    }

    public int aRf() {
        if (this.dLc) {
            return this.dLf;
        }
        return 0;
    }

    public void lR(int i) {
        this.dKU = i;
        ak(this.dLa);
    }

    public void lS(int i) {
        this.dLe = i;
        ak(this.dLa);
    }

    public List<bj> aRg() {
        return this.dLb;
    }

    public void lT(int i) {
        this.dLf = i;
        ak(this.dLa);
    }
}
