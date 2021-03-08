package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.cb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<cb> fqB;
    private List<cb> fqC;
    private boolean fqD;
    private boolean fqE;
    private int fqF = 2;
    private int fqG = 1;
    private int fqv;

    public b(List<cb> list, boolean z, int i) {
        this.fqv = 2;
        this.fqE = z;
        this.fqv = i;
        cx(list);
    }

    public void cx(List<cb> list) {
        if (list != null) {
            this.fqB = list;
            if (list != null && list.size() >= this.fqF && list.size() <= this.fqv) {
                this.fqD = true;
            } else if (list.size() > this.fqv && this.fqE) {
                this.fqD = true;
            } else {
                this.fqD = false;
            }
            this.fqC = bvB();
        }
    }

    private List<cb> bvB() {
        ArrayList arrayList = new ArrayList();
        if (this.fqB != null) {
            if (this.fqD) {
                if (this.fqB.size() > this.fqv && this.fqB.size() >= this.fqG) {
                    arrayList.addAll(this.fqB.subList(0, this.fqv));
                    arrayList.addAll(0, this.fqB.subList(this.fqv - this.fqG, this.fqv));
                    arrayList.addAll(this.fqB.subList(0, this.fqG));
                } else {
                    arrayList.addAll(this.fqB);
                    arrayList.addAll(0, this.fqB.subList(this.fqB.size() - this.fqG, this.fqB.size()));
                    arrayList.addAll(this.fqB.subList(0, this.fqG));
                }
            } else if (this.fqB != null && this.fqB.size() > 0 && this.fqB.size() >= this.fqG) {
                arrayList.addAll(this.fqB.subList(0, this.fqG));
            }
        }
        return arrayList;
    }

    public int qg(int i) {
        if (this.fqD) {
            int size = this.fqC.size();
            if (i == 0) {
                return (size - 1) - this.fqG;
            }
            if (i == size - this.fqG) {
                return this.fqG;
            }
            return i;
        }
        return i;
    }

    public int qh(int i) {
        if (this.fqD) {
            return i - this.fqG;
        }
        return i;
    }

    public int bvC() {
        if (this.fqB == null) {
            return 0;
        }
        return this.fqB.size();
    }

    public int bvD() {
        if (this.fqD) {
            return this.fqG;
        }
        return 0;
    }

    public void qi(int i) {
        this.fqv = i;
        cx(this.fqB);
    }

    public void qj(int i) {
        this.fqF = i;
        cx(this.fqB);
    }

    public List<cb> bvE() {
        return this.fqC;
    }

    public void qk(int i) {
        this.fqG = i;
        cx(this.fqB);
    }
}
