package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements al {
    public String TB;
    private String bbN;
    private int bbO;
    private String bbP;
    private String bbQ;
    public SparseArray<String> bbR = null;
    private String mSource;

    public void setWeight(String str) {
        this.bbN = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gj(int i) {
        this.bbO = i;
    }

    public void hR(String str) {
        this.bbP = str;
    }

    public int Ok() {
        return this.bbO;
    }

    public String Ol() {
        return String.valueOf(this.mSource) + "#" + this.bbO + "#" + this.bbP;
    }

    public String getWeight() {
        return this.bbN;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Om() {
        return this.bbP;
    }

    public String On() {
        return this.bbQ;
    }

    public void hS(String str) {
        this.bbQ = str;
    }

    public bi Jv() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ax hT(String str) {
        return x(str, false);
    }

    public ax x(String str, boolean z) {
        bi Jv = Jv();
        if (Jv == null) {
            return null;
        }
        ax ab = new ax(str).ab("fid", String.valueOf(Jv.getFid())).ab("tid", String.valueOf(Jv.getTid())).ab("obj_param1", getWeight()).ab("obj_source", getSource()).s("obj_locate", Ok()).ab("obj_param3", an.Oc());
        if (!z) {
            ab.s("obj_type", Oo());
            return ab;
        }
        return ab;
    }

    private int Oo() {
        int i;
        bi Jv = Jv();
        if (Jv == null) {
            return 0;
        }
        ArrayList<MediaData> rW = Jv.rW();
        if (rW == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rW.iterator();
            i = 0;
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i++;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<ak> getImages() {
        bi Jv = Jv();
        if (Jv != null) {
            return Jv.getImages();
        }
        return null;
    }
}
