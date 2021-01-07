package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bz;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private int frn;
    private List<bz> fru;
    private List<bz> frv;
    private boolean frw;
    private boolean frx;
    private int fry = 2;
    private int frz = 1;

    public b(List<bz> list, boolean z, int i) {
        this.frn = 2;
        this.frx = z;
        this.frn = i;
        cC(list);
    }

    public void cC(List<bz> list) {
        if (list != null) {
            this.fru = list;
            if (list != null && list.size() >= this.fry && list.size() <= this.frn) {
                this.frw = true;
            } else if (list.size() > this.frn && this.frx) {
                this.frw = true;
            } else {
                this.frw = false;
            }
            this.frv = byY();
        }
    }

    private List<bz> byY() {
        ArrayList arrayList = new ArrayList();
        if (this.fru != null) {
            if (this.frw) {
                if (this.fru.size() > this.frn && this.fru.size() >= this.frz) {
                    arrayList.addAll(this.fru.subList(0, this.frn));
                    arrayList.addAll(0, this.fru.subList(this.frn - this.frz, this.frn));
                    arrayList.addAll(this.fru.subList(0, this.frz));
                } else {
                    arrayList.addAll(this.fru);
                    arrayList.addAll(0, this.fru.subList(this.fru.size() - this.frz, this.fru.size()));
                    arrayList.addAll(this.fru.subList(0, this.frz));
                }
            } else if (this.fru != null && this.fru.size() > 0 && this.fru.size() >= this.frz) {
                arrayList.addAll(this.fru.subList(0, this.frz));
            }
        }
        return arrayList;
    }

    public int rG(int i) {
        if (this.frw) {
            int size = this.frv.size();
            if (i == 0) {
                return (size - 1) - this.frz;
            }
            if (i == size - this.frz) {
                return this.frz;
            }
            return i;
        }
        return i;
    }

    public int rH(int i) {
        if (this.frw) {
            return i - this.frz;
        }
        return i;
    }

    public int byZ() {
        if (this.fru == null) {
            return 0;
        }
        return this.fru.size();
    }

    public int bza() {
        if (this.frw) {
            return this.frz;
        }
        return 0;
    }

    public void rI(int i) {
        this.frn = i;
        cC(this.fru);
    }

    public void rJ(int i) {
        this.fry = i;
        cC(this.fru);
    }

    public List<bz> bzb() {
        return this.frv;
    }

    public void rK(int i) {
        this.frz = i;
        cC(this.fru);
    }
}
