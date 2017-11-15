package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bVq = BdUniqueId.gen();
    public static final BdUniqueId bVr = BdUniqueId.gen();
    public static String bVs = "";
    public static String bVt = "";
    public static String bVu = "";
    public static String bVv = "";
    public static String bVw = "";
    public static String bVx = "";
    public static String bVy = "";
    public bh bff;
    public boolean bVl = false;
    public boolean bVz = true;
    public int sourceType = 0;

    public n(bh bhVar) {
        this.bff = bhVar;
    }

    public static boolean A(bh bhVar) {
        return (bhVar == null || bhVar.rL() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bff == null) {
            return bVq;
        }
        if (this.bff.rx() || this.bff.ry()) {
            return bVr;
        }
        return bVq;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh NA() {
        return this.bff;
    }

    public ak jS(String str) {
        ak akVar = new ak(str);
        if (this.bff != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bff.getFid());
            akVar.ac("tid", this.bff.getTid());
            akVar.r("obj_type", 2);
            if (this.bff.rt() != null) {
                akVar.ac("obj_id", this.bff.rt().getUserId());
            }
        }
        return akVar;
    }

    public ak aav() {
        ak s = s(bVv, true);
        if (s != null && NA() != null) {
            bh NA = NA();
            s.r("obj_name", NA.sL() != null && (NA.sL().aEx() != null || NA.sL().Jb() != null) ? 1 : 0);
        }
        return s;
    }

    public ak B(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? s(bVw, true) : s(bVx, true);
    }

    public ak aax() {
        return s(bVt, true);
    }

    public ak C(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? s(bVs, true) : s(bVy, true);
    }
}
