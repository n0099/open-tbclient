package com.baidu.tieba.card.a;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements al {
    private String aUU;
    private int aUV;
    private String aUW;
    private String aUX;
    private String mSource;
    public String tid;

    public void setWeight(String str) {
        this.aUU = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void fI(int i) {
        this.aUV = i;
    }

    public void hf(String str) {
        this.aUW = str;
    }

    public int Lh() {
        return this.aUV;
    }

    public String Li() {
        return String.valueOf(this.mSource) + "#" + this.aUV + "#" + this.aUW;
    }

    public String getWeight() {
        return this.aUU;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Lj() {
        return this.aUW;
    }

    public String Lk() {
        return this.aUX;
    }

    public void hg(String str) {
        this.aUX = str;
    }

    public az Ix() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ay hh(String str) {
        return v(str, false);
    }

    public ay v(String str, boolean z) {
        az Ix = Ix();
        if (Ix == null) {
            return null;
        }
        ay ab = new ay(str).ab("fid", String.valueOf(Ix.getFid())).ab("tid", String.valueOf(Ix.getTid())).ab("obj_param1", getWeight()).ab("obj_source", getSource()).s("obj_locate", Lh()).ab("obj_param3", at.La());
        if (!z) {
            ab.s("obj_type", Ll());
            return ab;
        }
        return ab;
    }

    private int Ll() {
        int i;
        az Ix = Ix();
        if (Ix == null) {
            return 0;
        }
        ArrayList<MediaData> medias = Ix.getMedias();
        if (medias == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = medias.iterator();
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
        az Ix = Ix();
        if (Ix != null) {
            return Ix.getImages();
        }
        return null;
    }
}
