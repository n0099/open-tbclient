package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements aj {
    public String TY;
    private String beL;
    private int beM;
    private String beN;
    private String beO;
    public SparseArray<String> beP = null;
    private String mSource;

    public void setWeight(String str) {
        this.beL = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gk(int i) {
        this.beM = i;
    }

    public void hV(String str) {
        this.beN = str;
    }

    public int Pn() {
        return this.beM;
    }

    public String Po() {
        return String.valueOf(this.mSource) + "#" + this.beM + "#" + this.beN;
    }

    public String getWeight() {
        return this.beL;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Pp() {
        return this.beN;
    }

    public String Pq() {
        return this.beO;
    }

    public void hW(String str) {
        this.beO = str;
    }

    public bk Jz() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public av hX(String str) {
        return x(str, false);
    }

    public av x(String str, boolean z) {
        bk Jz = Jz();
        if (Jz == null) {
            return null;
        }
        av ab = new av(str).ab("fid", String.valueOf(Jz.getFid())).ab("tid", String.valueOf(Jz.getTid())).ab("obj_param1", getWeight()).ab("obj_source", getSource()).s("obj_locate", Pn()).ab("obj_name", Pp()).ab("obj_param3", an.Pe());
        if (!z) {
            ab.s("obj_type", Pr());
            return ab;
        }
        return ab;
    }

    private int Pr() {
        int i;
        bk Jz = Jz();
        if (Jz == null) {
            return 0;
        }
        ArrayList<MediaData> rY = Jz.rY();
        if (rY == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rY.iterator();
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

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        bk Jz = Jz();
        if (Jz != null) {
            return Jz.getImages();
        }
        return null;
    }
}
