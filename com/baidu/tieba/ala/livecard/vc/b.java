package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.by;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private int fhC;
    private List<by> fhI;
    private List<by> fhJ;
    private boolean fhK;
    private boolean fhL;
    private int fhM = 2;
    private int fhN = 1;

    public b(List<by> list, boolean z, int i) {
        this.fhC = 2;
        this.fhL = z;
        this.fhC = i;
        cv(list);
    }

    public void cv(List<by> list) {
        if (list != null) {
            this.fhI = list;
            if (list != null && list.size() >= this.fhM && list.size() <= this.fhC) {
                this.fhK = true;
            } else if (list.size() > this.fhC && this.fhL) {
                this.fhK = true;
            } else {
                this.fhK = false;
            }
            this.fhJ = bwE();
        }
    }

    private List<by> bwE() {
        ArrayList arrayList = new ArrayList();
        if (this.fhI != null) {
            if (this.fhK) {
                if (this.fhI.size() > this.fhC && this.fhI.size() >= this.fhN) {
                    arrayList.addAll(this.fhI.subList(0, this.fhC));
                    arrayList.addAll(0, this.fhI.subList(this.fhC - this.fhN, this.fhC));
                    arrayList.addAll(this.fhI.subList(0, this.fhN));
                } else {
                    arrayList.addAll(this.fhI);
                    arrayList.addAll(0, this.fhI.subList(this.fhI.size() - this.fhN, this.fhI.size()));
                    arrayList.addAll(this.fhI.subList(0, this.fhN));
                }
            } else if (this.fhI != null && this.fhI.size() > 0 && this.fhI.size() >= this.fhN) {
                arrayList.addAll(this.fhI.subList(0, this.fhN));
            }
        }
        return arrayList;
    }

    public int ru(int i) {
        if (this.fhK) {
            int size = this.fhJ.size();
            if (i == 0) {
                return (size - 1) - this.fhN;
            }
            if (i == size - this.fhN) {
                return this.fhN;
            }
            return i;
        }
        return i;
    }

    public int rv(int i) {
        if (this.fhK) {
            return i - this.fhN;
        }
        return i;
    }

    public int bwF() {
        if (this.fhI == null) {
            return 0;
        }
        return this.fhI.size();
    }

    public int bwG() {
        if (this.fhK) {
            return this.fhN;
        }
        return 0;
    }

    public void rw(int i) {
        this.fhC = i;
        cv(this.fhI);
    }

    public void rx(int i) {
        this.fhM = i;
        cv(this.fhI);
    }

    public List<by> bwH() {
        return this.fhJ;
    }

    public void ry(int i) {
        this.fhN = i;
        cv(this.fhI);
    }
}
