package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bk;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int dZp;
    private List<bk> dZv;
    private List<bk> dZw;
    private boolean dZx;
    private boolean dZy;
    private int dZz = 2;
    private int dZA = 1;

    public b(List<bk> list, boolean z, int i) {
        this.dZp = 2;
        this.dZy = z;
        this.dZp = i;
        bE(list);
    }

    public void bE(List<bk> list) {
        if (list != null) {
            this.dZv = list;
            if (list != null && list.size() >= this.dZz && list.size() <= this.dZp) {
                this.dZx = true;
            } else if (list.size() > this.dZp && this.dZy) {
                this.dZx = true;
            } else {
                this.dZx = false;
            }
            this.dZw = aXh();
        }
    }

    private List<bk> aXh() {
        ArrayList arrayList = new ArrayList();
        if (this.dZv != null) {
            if (this.dZx) {
                if (this.dZv.size() > this.dZp && this.dZv.size() >= this.dZA) {
                    arrayList.addAll(this.dZv.subList(0, this.dZp));
                    arrayList.addAll(0, this.dZv.subList(this.dZp - this.dZA, this.dZp));
                    arrayList.addAll(this.dZv.subList(0, this.dZA));
                } else {
                    arrayList.addAll(this.dZv);
                    arrayList.addAll(0, this.dZv.subList(this.dZv.size() - this.dZA, this.dZv.size()));
                    arrayList.addAll(this.dZv.subList(0, this.dZA));
                }
            } else if (this.dZv != null && this.dZv.size() > 0 && this.dZv.size() >= this.dZA) {
                arrayList.addAll(this.dZv.subList(0, this.dZA));
            }
        }
        return arrayList;
    }

    public int ms(int i) {
        if (this.dZx) {
            int size = this.dZw.size();
            if (i == 0) {
                return (size - 1) - this.dZA;
            }
            if (i == size - this.dZA) {
                return this.dZA;
            }
            return i;
        }
        return i;
    }

    public int mt(int i) {
        if (this.dZx) {
            return i - this.dZA;
        }
        return i;
    }

    public int aXi() {
        if (this.dZv == null) {
            return 0;
        }
        return this.dZv.size();
    }

    public int aXj() {
        if (this.dZx) {
            return this.dZA;
        }
        return 0;
    }

    public void mu(int i) {
        this.dZp = i;
        bE(this.dZv);
    }

    public void mv(int i) {
        this.dZz = i;
        bE(this.dZv);
    }

    public List<bk> aXk() {
        return this.dZw;
    }

    public void mw(int i) {
        this.dZA = i;
        bE(this.dZv);
    }
}
