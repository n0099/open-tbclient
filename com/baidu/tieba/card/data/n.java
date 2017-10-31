package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bVd = BdUniqueId.gen();
    public static final BdUniqueId bVe = BdUniqueId.gen();
    public static String bVf = "";
    public static String bVg = "";
    public static String bVh = "";
    public static String bVi = "";
    public static String bVj = "";
    public static String bVk = "";
    public static String bVl = "";
    public bh beV;
    public boolean bUY = false;
    public boolean bVm = true;
    public int sourceType = 0;

    public n(bh bhVar) {
        this.beV = bhVar;
    }

    public static boolean A(bh bhVar) {
        return (bhVar == null || bhVar.rL() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.beV == null) {
            return bVd;
        }
        if (this.beV.rx() || this.beV.ry()) {
            return bVe;
        }
        return bVd;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Np() {
        return this.beV;
    }

    public ak jR(String str) {
        ak akVar = new ak(str);
        if (this.beV != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.beV.getFid());
            akVar.ac("tid", this.beV.getTid());
            akVar.r("obj_type", 2);
            if (this.beV.rt() != null) {
                akVar.ac("obj_id", this.beV.rt().getUserId());
            }
        }
        return akVar;
    }

    public ak aaj() {
        ak s = s(bVi, true);
        if (s != null && Np() != null) {
            bh Np = Np();
            s.r("obj_name", Np.sL() != null && (Np.sL().aEt() != null || Np.sL().IQ() != null) ? 1 : 0);
        }
        return s;
    }

    public ak B(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? s(bVj, true) : s(bVk, true);
    }

    public ak aal() {
        return s(bVg, true);
    }

    public ak C(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? s(bVf, true) : s(bVl, true);
    }
}
