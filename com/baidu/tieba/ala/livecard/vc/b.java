package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int dkN;
    private List<bj> dkT;
    private List<bj> dkU;
    private boolean dkV;
    private boolean dkW;
    private int dkX = 2;
    private int dkY = 1;

    public b(List<bj> list, boolean z, int i) {
        this.dkN = 2;
        this.dkW = z;
        this.dkN = i;
        ac(list);
    }

    public void ac(List<bj> list) {
        if (list != null) {
            this.dkT = list;
            if (list != null && list.size() >= this.dkX && list.size() <= this.dkN) {
                this.dkV = true;
            } else if (list.size() > this.dkN && this.dkW) {
                this.dkV = true;
            } else {
                this.dkV = false;
            }
            this.dkU = aID();
        }
    }

    private List<bj> aID() {
        ArrayList arrayList = new ArrayList();
        if (this.dkT != null) {
            if (this.dkV) {
                if (this.dkT.size() > this.dkN && this.dkT.size() >= this.dkY) {
                    arrayList.addAll(this.dkT.subList(0, this.dkN));
                    arrayList.addAll(0, this.dkT.subList(this.dkN - this.dkY, this.dkN));
                    arrayList.addAll(this.dkT.subList(0, this.dkY));
                } else {
                    arrayList.addAll(this.dkT);
                    arrayList.addAll(0, this.dkT.subList(this.dkT.size() - this.dkY, this.dkT.size()));
                    arrayList.addAll(this.dkT.subList(0, this.dkY));
                }
            } else if (this.dkT != null && this.dkT.size() > 0 && this.dkT.size() >= this.dkY) {
                arrayList.addAll(this.dkT.subList(0, this.dkY));
            }
        }
        return arrayList;
    }

    public int lB(int i) {
        if (this.dkV) {
            int size = this.dkU.size();
            if (i == 0) {
                return (size - 1) - this.dkY;
            }
            if (i == size - this.dkY) {
                return this.dkY;
            }
            return i;
        }
        return i;
    }

    public int lC(int i) {
        if (this.dkV) {
            return i - this.dkY;
        }
        return i;
    }

    public int aIE() {
        if (this.dkT == null) {
            return 0;
        }
        return this.dkT.size();
    }

    public int aIF() {
        if (this.dkV) {
            return this.dkY;
        }
        return 0;
    }

    public void lD(int i) {
        this.dkN = i;
        ac(this.dkT);
    }

    public void lE(int i) {
        this.dkX = i;
        ac(this.dkT);
    }

    public List<bj> aIG() {
        return this.dkU;
    }

    public void lF(int i) {
        this.dkY = i;
        ac(this.dkT);
    }
}
