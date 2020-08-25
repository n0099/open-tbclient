package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private List<bw> eyD;
    private List<bw> eyE;
    private boolean eyF;
    private boolean eyG;
    private int eyH = 2;
    private int eyI = 1;
    private int eyx;

    public b(List<bw> list, boolean z, int i) {
        this.eyx = 2;
        this.eyG = z;
        this.eyx = i;
        bS(list);
    }

    public void bS(List<bw> list) {
        if (list != null) {
            this.eyD = list;
            if (list != null && list.size() >= this.eyH && list.size() <= this.eyx) {
                this.eyF = true;
            } else if (list.size() > this.eyx && this.eyG) {
                this.eyF = true;
            } else {
                this.eyF = false;
            }
            this.eyE = blR();
        }
    }

    private List<bw> blR() {
        ArrayList arrayList = new ArrayList();
        if (this.eyD != null) {
            if (this.eyF) {
                if (this.eyD.size() > this.eyx && this.eyD.size() >= this.eyI) {
                    arrayList.addAll(this.eyD.subList(0, this.eyx));
                    arrayList.addAll(0, this.eyD.subList(this.eyx - this.eyI, this.eyx));
                    arrayList.addAll(this.eyD.subList(0, this.eyI));
                } else {
                    arrayList.addAll(this.eyD);
                    arrayList.addAll(0, this.eyD.subList(this.eyD.size() - this.eyI, this.eyD.size()));
                    arrayList.addAll(this.eyD.subList(0, this.eyI));
                }
            } else if (this.eyD != null && this.eyD.size() > 0 && this.eyD.size() >= this.eyI) {
                arrayList.addAll(this.eyD.subList(0, this.eyI));
            }
        }
        return arrayList;
    }

    public int pp(int i) {
        if (this.eyF) {
            int size = this.eyE.size();
            if (i == 0) {
                return (size - 1) - this.eyI;
            }
            if (i == size - this.eyI) {
                return this.eyI;
            }
            return i;
        }
        return i;
    }

    public int pq(int i) {
        if (this.eyF) {
            return i - this.eyI;
        }
        return i;
    }

    public int blS() {
        if (this.eyD == null) {
            return 0;
        }
        return this.eyD.size();
    }

    public int blT() {
        if (this.eyF) {
            return this.eyI;
        }
        return 0;
    }

    public void pr(int i) {
        this.eyx = i;
        bS(this.eyD);
    }

    public void ps(int i) {
        this.eyH = i;
        bS(this.eyD);
    }

    public List<bw> blU() {
        return this.eyE;
    }

    public void pt(int i) {
        this.eyI = i;
        bS(this.eyD);
    }
}
