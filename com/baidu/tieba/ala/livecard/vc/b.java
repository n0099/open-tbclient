package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private int faX;
    private List<bw> fbd;
    private List<bw> fbe;
    private boolean fbf;
    private boolean fbg;
    private int fbh = 2;
    private int fbi = 1;

    public b(List<bw> list, boolean z, int i) {
        this.faX = 2;
        this.fbg = z;
        this.faX = i;
        cr(list);
    }

    public void cr(List<bw> list) {
        if (list != null) {
            this.fbd = list;
            if (list != null && list.size() >= this.fbh && list.size() <= this.faX) {
                this.fbf = true;
            } else if (list.size() > this.faX && this.fbg) {
                this.fbf = true;
            } else {
                this.fbf = false;
            }
            this.fbe = btO();
        }
    }

    private List<bw> btO() {
        ArrayList arrayList = new ArrayList();
        if (this.fbd != null) {
            if (this.fbf) {
                if (this.fbd.size() > this.faX && this.fbd.size() >= this.fbi) {
                    arrayList.addAll(this.fbd.subList(0, this.faX));
                    arrayList.addAll(0, this.fbd.subList(this.faX - this.fbi, this.faX));
                    arrayList.addAll(this.fbd.subList(0, this.fbi));
                } else {
                    arrayList.addAll(this.fbd);
                    arrayList.addAll(0, this.fbd.subList(this.fbd.size() - this.fbi, this.fbd.size()));
                    arrayList.addAll(this.fbd.subList(0, this.fbi));
                }
            } else if (this.fbd != null && this.fbd.size() > 0 && this.fbd.size() >= this.fbi) {
                arrayList.addAll(this.fbd.subList(0, this.fbi));
            }
        }
        return arrayList;
    }

    public int qv(int i) {
        if (this.fbf) {
            int size = this.fbe.size();
            if (i == 0) {
                return (size - 1) - this.fbi;
            }
            if (i == size - this.fbi) {
                return this.fbi;
            }
            return i;
        }
        return i;
    }

    public int qw(int i) {
        if (this.fbf) {
            return i - this.fbi;
        }
        return i;
    }

    public int btP() {
        if (this.fbd == null) {
            return 0;
        }
        return this.fbd.size();
    }

    public int btQ() {
        if (this.fbf) {
            return this.fbi;
        }
        return 0;
    }

    public void qx(int i) {
        this.faX = i;
        cr(this.fbd);
    }

    public void qy(int i) {
        this.fbh = i;
        cr(this.fbd);
    }

    public List<bw> btR() {
        return this.fbe;
    }

    public void qz(int i) {
        this.fbi = i;
        cr(this.fbd);
    }
}
