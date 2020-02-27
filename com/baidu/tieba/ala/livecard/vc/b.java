package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private List<bj> dkF;
    private List<bj> dkG;
    private boolean dkH;
    private boolean dkI;
    private int dkJ = 2;
    private int dkK = 1;
    private int dkz;

    public b(List<bj> list, boolean z, int i) {
        this.dkz = 2;
        this.dkI = z;
        this.dkz = i;
        ac(list);
    }

    public void ac(List<bj> list) {
        if (list != null) {
            this.dkF = list;
            if (list != null && list.size() >= this.dkJ && list.size() <= this.dkz) {
                this.dkH = true;
            } else if (list.size() > this.dkz && this.dkI) {
                this.dkH = true;
            } else {
                this.dkH = false;
            }
            this.dkG = aIA();
        }
    }

    private List<bj> aIA() {
        ArrayList arrayList = new ArrayList();
        if (this.dkF != null) {
            if (this.dkH) {
                if (this.dkF.size() > this.dkz && this.dkF.size() >= this.dkK) {
                    arrayList.addAll(this.dkF.subList(0, this.dkz));
                    arrayList.addAll(0, this.dkF.subList(this.dkz - this.dkK, this.dkz));
                    arrayList.addAll(this.dkF.subList(0, this.dkK));
                } else {
                    arrayList.addAll(this.dkF);
                    arrayList.addAll(0, this.dkF.subList(this.dkF.size() - this.dkK, this.dkF.size()));
                    arrayList.addAll(this.dkF.subList(0, this.dkK));
                }
            } else if (this.dkF != null && this.dkF.size() > 0 && this.dkF.size() >= this.dkK) {
                arrayList.addAll(this.dkF.subList(0, this.dkK));
            }
        }
        return arrayList;
    }

    public int lB(int i) {
        if (this.dkH) {
            int size = this.dkG.size();
            if (i == 0) {
                return (size - 1) - this.dkK;
            }
            if (i == size - this.dkK) {
                return this.dkK;
            }
            return i;
        }
        return i;
    }

    public int lC(int i) {
        if (this.dkH) {
            return i - this.dkK;
        }
        return i;
    }

    public int aIB() {
        if (this.dkF == null) {
            return 0;
        }
        return this.dkF.size();
    }

    public int aIC() {
        if (this.dkH) {
            return this.dkK;
        }
        return 0;
    }

    public void lD(int i) {
        this.dkz = i;
        ac(this.dkF);
    }

    public void lE(int i) {
        this.dkJ = i;
        ac(this.dkF);
    }

    public List<bj> aID() {
        return this.dkG;
    }

    public void lF(int i) {
        this.dkK = i;
        ac(this.dkF);
    }
}
