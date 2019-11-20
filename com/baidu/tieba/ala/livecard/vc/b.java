package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private List<bh> csA;
    private List<bh> csB;
    private boolean csC;
    private boolean csD;
    private int csE = 2;
    private int csF = 1;
    private int cst;

    public b(List<bh> list, boolean z, int i) {
        this.cst = 2;
        this.csD = z;
        this.cst = i;
        aY(list);
    }

    public void aY(List<bh> list) {
        if (list != null) {
            this.csA = list;
            if (list != null && list.size() >= this.csE && list.size() <= this.cst) {
                this.csC = true;
            } else if (list.size() > this.cst && this.csD) {
                this.csC = true;
            } else {
                this.csC = false;
            }
            this.csB = aop();
        }
    }

    private List<bh> aop() {
        ArrayList arrayList = new ArrayList();
        if (this.csA != null) {
            if (this.csC) {
                if (this.csA.size() > this.cst && this.csA.size() >= this.csF) {
                    arrayList.addAll(this.csA.subList(0, this.cst));
                    arrayList.addAll(0, this.csA.subList(this.cst - this.csF, this.cst));
                    arrayList.addAll(this.csA.subList(0, this.csF));
                } else {
                    arrayList.addAll(this.csA);
                    arrayList.addAll(0, this.csA.subList(this.csA.size() - this.csF, this.csA.size()));
                    arrayList.addAll(this.csA.subList(0, this.csF));
                }
            } else if (this.csA != null && this.csA.size() > 0 && this.csA.size() >= this.csF) {
                arrayList.addAll(this.csA.subList(0, this.csF));
            }
        }
        return arrayList;
    }

    public int iX(int i) {
        if (this.csC) {
            int size = this.csB.size();
            if (i == 0) {
                return (size - 1) - this.csF;
            }
            if (i == size - this.csF) {
                return this.csF;
            }
            return i;
        }
        return i;
    }

    public int iY(int i) {
        if (this.csC) {
            return i - this.csF;
        }
        return i;
    }

    public int aoq() {
        if (this.csA == null) {
            return 0;
        }
        return this.csA.size();
    }

    public int aor() {
        if (this.csC) {
            return this.csF;
        }
        return 0;
    }

    public void iZ(int i) {
        this.cst = i;
        aY(this.csA);
    }

    public void ja(int i) {
        this.csE = i;
        aY(this.csA);
    }

    public List<bh> aos() {
        return this.csB;
    }

    public void jb(int i) {
        this.csF = i;
        aY(this.csA);
    }
}
