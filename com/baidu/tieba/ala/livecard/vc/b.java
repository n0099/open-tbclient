package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bu;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int ehZ;
    private List<bu> eif;
    private List<bu> eig;
    private boolean eih;
    private boolean eii;
    private int eij = 2;
    private int eik = 1;

    public b(List<bu> list, boolean z, int i) {
        this.ehZ = 2;
        this.eii = z;
        this.ehZ = i;
        bN(list);
    }

    public void bN(List<bu> list) {
        if (list != null) {
            this.eif = list;
            if (list != null && list.size() >= this.eij && list.size() <= this.ehZ) {
                this.eih = true;
            } else if (list.size() > this.ehZ && this.eii) {
                this.eih = true;
            } else {
                this.eih = false;
            }
            this.eig = aZo();
        }
    }

    private List<bu> aZo() {
        ArrayList arrayList = new ArrayList();
        if (this.eif != null) {
            if (this.eih) {
                if (this.eif.size() > this.ehZ && this.eif.size() >= this.eik) {
                    arrayList.addAll(this.eif.subList(0, this.ehZ));
                    arrayList.addAll(0, this.eif.subList(this.ehZ - this.eik, this.ehZ));
                    arrayList.addAll(this.eif.subList(0, this.eik));
                } else {
                    arrayList.addAll(this.eif);
                    arrayList.addAll(0, this.eif.subList(this.eif.size() - this.eik, this.eif.size()));
                    arrayList.addAll(this.eif.subList(0, this.eik));
                }
            } else if (this.eif != null && this.eif.size() > 0 && this.eif.size() >= this.eik) {
                arrayList.addAll(this.eif.subList(0, this.eik));
            }
        }
        return arrayList;
    }

    public int mO(int i) {
        if (this.eih) {
            int size = this.eig.size();
            if (i == 0) {
                return (size - 1) - this.eik;
            }
            if (i == size - this.eik) {
                return this.eik;
            }
            return i;
        }
        return i;
    }

    public int mP(int i) {
        if (this.eih) {
            return i - this.eik;
        }
        return i;
    }

    public int aZp() {
        if (this.eif == null) {
            return 0;
        }
        return this.eif.size();
    }

    public int aZq() {
        if (this.eih) {
            return this.eik;
        }
        return 0;
    }

    public void mQ(int i) {
        this.ehZ = i;
        bN(this.eif);
    }

    public void mR(int i) {
        this.eij = i;
        bN(this.eif);
    }

    public List<bu> aZr() {
        return this.eig;
    }

    public void mS(int i) {
        this.eik = i;
        bN(this.eif);
    }
}
