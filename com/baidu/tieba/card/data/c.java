package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.ap;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ai {
    public String Ty;
    private String bec;
    private int bed;
    private String bee;
    private String bef;
    public SparseArray<String> beg = null;
    private String mSource;

    public void setWeight(String str) {
        this.bec = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gj(int i) {
        this.bed = i;
    }

    public void hP(String str) {
        this.bee = str;
    }

    public int OJ() {
        return this.bed;
    }

    public String OK() {
        return String.valueOf(this.mSource) + "#" + this.bed + "#" + this.bee;
    }

    public String getWeight() {
        return this.bec;
    }

    public String getSource() {
        return this.mSource;
    }

    public String OL() {
        return this.bee;
    }

    public String OM() {
        return this.bef;
    }

    public void hQ(String str) {
        this.bef = str;
    }

    public bg IU() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public at hR(String str) {
        return x(str, false);
    }

    public at x(String str, boolean z) {
        bg IU = IU();
        if (IU == null) {
            return null;
        }
        at ab = new at(str).ab("fid", String.valueOf(IU.getFid())).ab("tid", String.valueOf(IU.getTid())).ab("obj_param1", getWeight()).ab("obj_source", getSource()).s("obj_locate", OJ()).ab("obj_name", OL()).ab("obj_param3", ap.OA());
        if (!z) {
            ab.s("obj_type", ON());
            return ab;
        }
        return ab;
    }

    private int ON() {
        int i;
        bg IU = IU();
        if (IU == null) {
            return 0;
        }
        ArrayList<MediaData> rP = IU.rP();
        if (rP == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rP.iterator();
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

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<ah> getImages() {
        bg IU = IU();
        if (IU != null) {
            return IU.getImages();
        }
        return null;
    }
}
