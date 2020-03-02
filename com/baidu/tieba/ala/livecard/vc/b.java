package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int dkA;
    private List<bj> dkG;
    private List<bj> dkH;
    private boolean dkI;
    private boolean dkJ;
    private int dkK = 2;
    private int dkL = 1;

    public b(List<bj> list, boolean z, int i) {
        this.dkA = 2;
        this.dkJ = z;
        this.dkA = i;
        ac(list);
    }

    public void ac(List<bj> list) {
        if (list != null) {
            this.dkG = list;
            if (list != null && list.size() >= this.dkK && list.size() <= this.dkA) {
                this.dkI = true;
            } else if (list.size() > this.dkA && this.dkJ) {
                this.dkI = true;
            } else {
                this.dkI = false;
            }
            this.dkH = aIC();
        }
    }

    private List<bj> aIC() {
        ArrayList arrayList = new ArrayList();
        if (this.dkG != null) {
            if (this.dkI) {
                if (this.dkG.size() > this.dkA && this.dkG.size() >= this.dkL) {
                    arrayList.addAll(this.dkG.subList(0, this.dkA));
                    arrayList.addAll(0, this.dkG.subList(this.dkA - this.dkL, this.dkA));
                    arrayList.addAll(this.dkG.subList(0, this.dkL));
                } else {
                    arrayList.addAll(this.dkG);
                    arrayList.addAll(0, this.dkG.subList(this.dkG.size() - this.dkL, this.dkG.size()));
                    arrayList.addAll(this.dkG.subList(0, this.dkL));
                }
            } else if (this.dkG != null && this.dkG.size() > 0 && this.dkG.size() >= this.dkL) {
                arrayList.addAll(this.dkG.subList(0, this.dkL));
            }
        }
        return arrayList;
    }

    public int lB(int i) {
        if (this.dkI) {
            int size = this.dkH.size();
            if (i == 0) {
                return (size - 1) - this.dkL;
            }
            if (i == size - this.dkL) {
                return this.dkL;
            }
            return i;
        }
        return i;
    }

    public int lC(int i) {
        if (this.dkI) {
            return i - this.dkL;
        }
        return i;
    }

    public int aID() {
        if (this.dkG == null) {
            return 0;
        }
        return this.dkG.size();
    }

    public int aIE() {
        if (this.dkI) {
            return this.dkL;
        }
        return 0;
    }

    public void lD(int i) {
        this.dkA = i;
        ac(this.dkG);
    }

    public void lE(int i) {
        this.dkK = i;
        ac(this.dkG);
    }

    public List<bj> aIF() {
        return this.dkH;
    }

    public void lF(int i) {
        this.dkL = i;
        ac(this.dkG);
    }
}
