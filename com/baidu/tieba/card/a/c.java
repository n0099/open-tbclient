package com.baidu.tieba.card.a;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bc;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ak {
    private String aVt;
    private int aVu;
    private String aVv;
    private String aVw;
    private String mSource;

    public void setWeight(String str) {
        this.aVt = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void fP(int i) {
        this.aVu = i;
    }

    public void hf(String str) {
        this.aVv = str;
    }

    public int Ly() {
        return this.aVu;
    }

    public String Lz() {
        return String.valueOf(this.mSource) + "#" + this.aVu + "#" + this.aVv;
    }

    public String getWeight() {
        return this.aVt;
    }

    public String getSource() {
        return this.mSource;
    }

    public String LA() {
        return this.aVv;
    }

    public String LB() {
        return this.aVw;
    }

    public void hg(String str) {
        this.aVw = str;
    }

    public as LC() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public aw hh(String str) {
        as LC = LC();
        if (LC == null) {
            return null;
        }
        return new aw(str).ac("fid", String.valueOf(LC.getFid())).ac("tid", String.valueOf(LC.getTid())).ac("obj_param1", getWeight()).ac("obj_source", getSource()).r("obj_locate", Ly()).ac("obj_param3", bc.Lr()).r("obj_type", LD());
    }

    private int LD() {
        int i;
        as LC = LC();
        if (LC == null) {
            return 0;
        }
        ArrayList<MediaData> medias = LC.getMedias();
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

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<aj> getImages() {
        as LC = LC();
        if (LC != null) {
            return LC.getImages();
        }
        return null;
    }
}
