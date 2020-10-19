package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private int eMM;
    private List<bw> eMS;
    private List<bw> eMT;
    private boolean eMU;
    private boolean eMV;
    private int eMW = 2;
    private int eMX = 1;

    public b(List<bw> list, boolean z, int i) {
        this.eMM = 2;
        this.eMV = z;
        this.eMM = i;
        ca(list);
    }

    public void ca(List<bw> list) {
        if (list != null) {
            this.eMS = list;
            if (list != null && list.size() >= this.eMW && list.size() <= this.eMM) {
                this.eMU = true;
            } else if (list.size() > this.eMM && this.eMV) {
                this.eMU = true;
            } else {
                this.eMU = false;
            }
            this.eMT = bpv();
        }
    }

    private List<bw> bpv() {
        ArrayList arrayList = new ArrayList();
        if (this.eMS != null) {
            if (this.eMU) {
                if (this.eMS.size() > this.eMM && this.eMS.size() >= this.eMX) {
                    arrayList.addAll(this.eMS.subList(0, this.eMM));
                    arrayList.addAll(0, this.eMS.subList(this.eMM - this.eMX, this.eMM));
                    arrayList.addAll(this.eMS.subList(0, this.eMX));
                } else {
                    arrayList.addAll(this.eMS);
                    arrayList.addAll(0, this.eMS.subList(this.eMS.size() - this.eMX, this.eMS.size()));
                    arrayList.addAll(this.eMS.subList(0, this.eMX));
                }
            } else if (this.eMS != null && this.eMS.size() > 0 && this.eMS.size() >= this.eMX) {
                arrayList.addAll(this.eMS.subList(0, this.eMX));
            }
        }
        return arrayList;
    }

    public int qa(int i) {
        if (this.eMU) {
            int size = this.eMT.size();
            if (i == 0) {
                return (size - 1) - this.eMX;
            }
            if (i == size - this.eMX) {
                return this.eMX;
            }
            return i;
        }
        return i;
    }

    public int qb(int i) {
        if (this.eMU) {
            return i - this.eMX;
        }
        return i;
    }

    public int bpw() {
        if (this.eMS == null) {
            return 0;
        }
        return this.eMS.size();
    }

    public int bpx() {
        if (this.eMU) {
            return this.eMX;
        }
        return 0;
    }

    public void qc(int i) {
        this.eMM = i;
        ca(this.eMS);
    }

    public void qd(int i) {
        this.eMW = i;
        ca(this.eMS);
    }

    public List<bw> bpy() {
        return this.eMT;
    }

    public void qe(int i) {
        this.eMX = i;
        ca(this.eMS);
    }
}
