package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int dKY;
    private List<bj> dLe;
    private List<bj> dLf;
    private boolean dLg;
    private boolean dLh;
    private int dLi = 2;
    private int dLj = 1;

    public b(List<bj> list, boolean z, int i) {
        this.dKY = 2;
        this.dLh = z;
        this.dKY = i;
        ak(list);
    }

    public void ak(List<bj> list) {
        if (list != null) {
            this.dLe = list;
            if (list != null && list.size() >= this.dLi && list.size() <= this.dKY) {
                this.dLg = true;
            } else if (list.size() > this.dKY && this.dLh) {
                this.dLg = true;
            } else {
                this.dLg = false;
            }
            this.dLf = aRa();
        }
    }

    private List<bj> aRa() {
        ArrayList arrayList = new ArrayList();
        if (this.dLe != null) {
            if (this.dLg) {
                if (this.dLe.size() > this.dKY && this.dLe.size() >= this.dLj) {
                    arrayList.addAll(this.dLe.subList(0, this.dKY));
                    arrayList.addAll(0, this.dLe.subList(this.dKY - this.dLj, this.dKY));
                    arrayList.addAll(this.dLe.subList(0, this.dLj));
                } else {
                    arrayList.addAll(this.dLe);
                    arrayList.addAll(0, this.dLe.subList(this.dLe.size() - this.dLj, this.dLe.size()));
                    arrayList.addAll(this.dLe.subList(0, this.dLj));
                }
            } else if (this.dLe != null && this.dLe.size() > 0 && this.dLe.size() >= this.dLj) {
                arrayList.addAll(this.dLe.subList(0, this.dLj));
            }
        }
        return arrayList;
    }

    public int lP(int i) {
        if (this.dLg) {
            int size = this.dLf.size();
            if (i == 0) {
                return (size - 1) - this.dLj;
            }
            if (i == size - this.dLj) {
                return this.dLj;
            }
            return i;
        }
        return i;
    }

    public int lQ(int i) {
        if (this.dLg) {
            return i - this.dLj;
        }
        return i;
    }

    public int aRb() {
        if (this.dLe == null) {
            return 0;
        }
        return this.dLe.size();
    }

    public int aRc() {
        if (this.dLg) {
            return this.dLj;
        }
        return 0;
    }

    public void lR(int i) {
        this.dKY = i;
        ak(this.dLe);
    }

    public void lS(int i) {
        this.dLi = i;
        ak(this.dLe);
    }

    public List<bj> aRd() {
        return this.dLf;
    }

    public void lT(int i) {
        this.dLj = i;
        ak(this.dLe);
    }
}
