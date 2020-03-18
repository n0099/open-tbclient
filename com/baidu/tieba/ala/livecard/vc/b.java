package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bj;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private int dla;
    private List<bj> dlg;
    private List<bj> dlh;
    private boolean dli;
    private boolean dlj;
    private int dlk = 2;
    private int dll = 1;

    public b(List<bj> list, boolean z, int i) {
        this.dla = 2;
        this.dlj = z;
        this.dla = i;
        ac(list);
    }

    public void ac(List<bj> list) {
        if (list != null) {
            this.dlg = list;
            if (list != null && list.size() >= this.dlk && list.size() <= this.dla) {
                this.dli = true;
            } else if (list.size() > this.dla && this.dlj) {
                this.dli = true;
            } else {
                this.dli = false;
            }
            this.dlh = aIH();
        }
    }

    private List<bj> aIH() {
        ArrayList arrayList = new ArrayList();
        if (this.dlg != null) {
            if (this.dli) {
                if (this.dlg.size() > this.dla && this.dlg.size() >= this.dll) {
                    arrayList.addAll(this.dlg.subList(0, this.dla));
                    arrayList.addAll(0, this.dlg.subList(this.dla - this.dll, this.dla));
                    arrayList.addAll(this.dlg.subList(0, this.dll));
                } else {
                    arrayList.addAll(this.dlg);
                    arrayList.addAll(0, this.dlg.subList(this.dlg.size() - this.dll, this.dlg.size()));
                    arrayList.addAll(this.dlg.subList(0, this.dll));
                }
            } else if (this.dlg != null && this.dlg.size() > 0 && this.dlg.size() >= this.dll) {
                arrayList.addAll(this.dlg.subList(0, this.dll));
            }
        }
        return arrayList;
    }

    public int lD(int i) {
        if (this.dli) {
            int size = this.dlh.size();
            if (i == 0) {
                return (size - 1) - this.dll;
            }
            if (i == size - this.dll) {
                return this.dll;
            }
            return i;
        }
        return i;
    }

    public int lE(int i) {
        if (this.dli) {
            return i - this.dll;
        }
        return i;
    }

    public int aII() {
        if (this.dlg == null) {
            return 0;
        }
        return this.dlg.size();
    }

    public int aIJ() {
        if (this.dli) {
            return this.dll;
        }
        return 0;
    }

    public void lF(int i) {
        this.dla = i;
        ac(this.dlg);
    }

    public void lG(int i) {
        this.dlk = i;
        ac(this.dlg);
    }

    public List<bj> aIK() {
        return this.dlh;
    }

    public void lH(int i) {
        this.dll = i;
        ac(this.dlg);
    }
}
