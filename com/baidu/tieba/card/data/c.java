package com.baidu.tieba.card.data;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ap;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements al {
    public String Tt;
    private String bbv;
    private int bbw;
    private String bbx;
    private String bby;
    private String mSource;

    public void setWeight(String str) {
        this.bbv = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gf(int i) {
        this.bbw = i;
    }

    public void hK(String str) {
        this.bbx = str;
    }

    public int NJ() {
        return this.bbw;
    }

    public String NK() {
        return String.valueOf(this.mSource) + "#" + this.bbw + "#" + this.bbx;
    }

    public String getWeight() {
        return this.bbv;
    }

    public String getSource() {
        return this.mSource;
    }

    public String NL() {
        return this.bbx;
    }

    public String NM() {
        return this.bby;
    }

    public void hL(String str) {
        this.bby = str;
    }

    public bg Kw() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ay hM(String str) {
        return w(str, false);
    }

    public ay w(String str, boolean z) {
        bg Kw = Kw();
        if (Kw == null) {
            return null;
        }
        ay ab = new ay(str).ab("fid", String.valueOf(Kw.getFid())).ab("tid", String.valueOf(Kw.getTid())).ab("obj_param1", getWeight()).ab("obj_source", getSource()).s("obj_locate", NJ()).ab("obj_param3", ap.NC());
        if (!z) {
            ab.s("obj_type", NN());
            return ab;
        }
        return ab;
    }

    private int NN() {
        int i;
        bg Kw = Kw();
        if (Kw == null) {
            return 0;
        }
        ArrayList<MediaData> rK = Kw.rK();
        if (rK == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rK.iterator();
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
        bg Kw = Kw();
        if (Kw != null) {
            return Kw.getImages();
        }
        return null;
    }
}
