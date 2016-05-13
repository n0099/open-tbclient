package com.baidu.tieba.card.a;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.au;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ak {
    private String aRA;
    private String aRB;
    private String aRy;
    private int aRz;
    private String mSource;

    public void setWeight(String str) {
        this.aRy = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void fw(int i) {
        this.aRz = i;
    }

    public void hf(String str) {
        this.aRA = str;
    }

    public int Kj() {
        return this.aRz;
    }

    public String Kk() {
        return String.valueOf(this.mSource) + "#" + this.aRz + "#" + this.aRA;
    }

    public String getWeight() {
        return this.aRy;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Kl() {
        return this.aRA;
    }

    public String Km() {
        return this.aRB;
    }

    public void hg(String str) {
        this.aRB = str;
    }

    public ax Kn() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public aw hh(String str) {
        ax Kn = Kn();
        if (Kn == null) {
            return null;
        }
        return new aw(str).ac("fid", String.valueOf(Kn.getFid())).ac("tid", String.valueOf(Kn.getTid())).ac("obj_param1", getWeight()).ac("obj_source", getSource()).s("obj_locate", Kj()).ac("obj_param3", au.Kc()).s("obj_type", Ko());
    }

    private int Ko() {
        int i;
        ax Kn = Kn();
        if (Kn == null) {
            return 0;
        }
        ArrayList<MediaData> medias = Kn.getMedias();
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
        ax Kn = Kn();
        if (Kn != null) {
            return Kn.getImages();
        }
        return null;
    }
}
