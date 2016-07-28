package com.baidu.tieba.card.a;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements al {
    public String QK;
    private String aVS;
    private int aVT;
    private String aVU;
    private String aVV;
    private String mSource;

    public void setWeight(String str) {
        this.aVS = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void fH(int i) {
        this.aVT = i;
    }

    public void hf(String str) {
        this.aVU = str;
    }

    public int Lg() {
        return this.aVT;
    }

    public String Lh() {
        return String.valueOf(this.mSource) + "#" + this.aVT + "#" + this.aVU;
    }

    public String getWeight() {
        return this.aVS;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Li() {
        return this.aVU;
    }

    public String Lj() {
        return this.aVV;
    }

    public void hg(String str) {
        this.aVV = str;
    }

    public be Iw() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ay hh(String str) {
        return v(str, false);
    }

    public ay v(String str, boolean z) {
        be Iw = Iw();
        if (Iw == null) {
            return null;
        }
        ay ab = new ay(str).ab("fid", String.valueOf(Iw.getFid())).ab("tid", String.valueOf(Iw.getTid())).ab("obj_param1", getWeight()).ab("obj_source", getSource()).s("obj_locate", Lg()).ab("obj_param3", at.KZ());
        if (!z) {
            ab.s("obj_type", Lk());
            return ab;
        }
        return ab;
    }

    private int Lk() {
        int i;
        be Iw = Iw();
        if (Iw == null) {
            return 0;
        }
        ArrayList<MediaData> qF = Iw.qF();
        if (qF == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = qF.iterator();
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
        be Iw = Iw();
        if (Iw != null) {
            return Iw.getImages();
        }
        return null;
    }
}
