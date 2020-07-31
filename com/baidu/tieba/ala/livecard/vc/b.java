package com.baidu.tieba.ala.livecard.vc;

import com.baidu.tbadk.core.data.bv;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private int eol;
    private List<bv> eor;
    private List<bv> eos;
    private boolean eot;
    private boolean eou;
    private int eov = 2;
    private int eow = 1;

    public b(List<bv> list, boolean z, int i) {
        this.eol = 2;
        this.eou = z;
        this.eol = i;
        bR(list);
    }

    public void bR(List<bv> list) {
        if (list != null) {
            this.eor = list;
            if (list != null && list.size() >= this.eov && list.size() <= this.eol) {
                this.eot = true;
            } else if (list.size() > this.eol && this.eou) {
                this.eot = true;
            } else {
                this.eot = false;
            }
            this.eos = bdl();
        }
    }

    private List<bv> bdl() {
        ArrayList arrayList = new ArrayList();
        if (this.eor != null) {
            if (this.eot) {
                if (this.eor.size() > this.eol && this.eor.size() >= this.eow) {
                    arrayList.addAll(this.eor.subList(0, this.eol));
                    arrayList.addAll(0, this.eor.subList(this.eol - this.eow, this.eol));
                    arrayList.addAll(this.eor.subList(0, this.eow));
                } else {
                    arrayList.addAll(this.eor);
                    arrayList.addAll(0, this.eor.subList(this.eor.size() - this.eow, this.eor.size()));
                    arrayList.addAll(this.eor.subList(0, this.eow));
                }
            } else if (this.eor != null && this.eor.size() > 0 && this.eor.size() >= this.eow) {
                arrayList.addAll(this.eor.subList(0, this.eow));
            }
        }
        return arrayList;
    }

    public int ng(int i) {
        if (this.eot) {
            int size = this.eos.size();
            if (i == 0) {
                return (size - 1) - this.eow;
            }
            if (i == size - this.eow) {
                return this.eow;
            }
            return i;
        }
        return i;
    }

    public int nh(int i) {
        if (this.eot) {
            return i - this.eow;
        }
        return i;
    }

    public int bdm() {
        if (this.eor == null) {
            return 0;
        }
        return this.eor.size();
    }

    public int bdn() {
        if (this.eot) {
            return this.eow;
        }
        return 0;
    }

    public void ni(int i) {
        this.eol = i;
        bR(this.eor);
    }

    public void nj(int i) {
        this.eov = i;
        bR(this.eor);
    }

    public List<bv> bdo() {
        return this.eos;
    }

    public void nk(int i) {
        this.eow = i;
        bR(this.eor);
    }
}
