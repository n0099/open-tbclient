package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private int eAF;
    private List<bw> eAL;
    private List<bw> eAM;
    private boolean eAN;
    private boolean eAO;
    private int eAP = 2;
    private int eAQ = 1;

    public b(List<bw> list, boolean z, int i) {
        this.eAF = 2;
        this.eAO = z;
        this.eAF = i;
        bX(list);
    }

    public void bX(List<bw> list) {
        if (list != null) {
            this.eAL = list;
            if (list != null && list.size() >= this.eAP && list.size() <= this.eAF) {
                this.eAN = true;
            } else if (list.size() > this.eAF && this.eAO) {
                this.eAN = true;
            } else {
                this.eAN = false;
            }
            this.eAM = bmL();
        }
    }

    private List<bw> bmL() {
        ArrayList arrayList = new ArrayList();
        if (this.eAL != null) {
            if (this.eAN) {
                if (this.eAL.size() > this.eAF && this.eAL.size() >= this.eAQ) {
                    arrayList.addAll(this.eAL.subList(0, this.eAF));
                    arrayList.addAll(0, this.eAL.subList(this.eAF - this.eAQ, this.eAF));
                    arrayList.addAll(this.eAL.subList(0, this.eAQ));
                } else {
                    arrayList.addAll(this.eAL);
                    arrayList.addAll(0, this.eAL.subList(this.eAL.size() - this.eAQ, this.eAL.size()));
                    arrayList.addAll(this.eAL.subList(0, this.eAQ));
                }
            } else if (this.eAL != null && this.eAL.size() > 0 && this.eAL.size() >= this.eAQ) {
                arrayList.addAll(this.eAL.subList(0, this.eAQ));
            }
        }
        return arrayList;
    }

    public int pC(int i) {
        if (this.eAN) {
            int size = this.eAM.size();
            if (i == 0) {
                return (size - 1) - this.eAQ;
            }
            if (i == size - this.eAQ) {
                return this.eAQ;
            }
            return i;
        }
        return i;
    }

    public int pD(int i) {
        if (this.eAN) {
            return i - this.eAQ;
        }
        return i;
    }

    public int bmM() {
        if (this.eAL == null) {
            return 0;
        }
        return this.eAL.size();
    }

    public int bmN() {
        if (this.eAN) {
            return this.eAQ;
        }
        return 0;
    }

    public void pE(int i) {
        this.eAF = i;
        bX(this.eAL);
    }

    public void pF(int i) {
        this.eAP = i;
        bX(this.eAL);
    }

    public List<bw> bmO() {
        return this.eAM;
    }

    public void pG(int i) {
        this.eAQ = i;
        bX(this.eAL);
    }
}
