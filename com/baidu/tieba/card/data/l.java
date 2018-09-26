package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes2.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId cIb = BdUniqueId.gen();
    public static final BdUniqueId cIc = BdUniqueId.gen();
    public static String cId = "";
    public static String cIe = "";
    public static String cIf = "";
    public static String cIg = "";
    public static String cIh = "";
    public static String cIi = "";
    public bb bzB;
    public boolean cIa = false;
    public boolean cIj = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.bzB = bbVar;
    }

    public static boolean S(bb bbVar) {
        return (bbVar == null || bbVar.wE() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bzB == null) {
            return cIb;
        }
        if (this.bzB.wp() || this.bzB.wq()) {
            return cIc;
        }
        return cIb;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb UT() {
        if (this.bzB == null) {
            return this.bzB;
        }
        if (this.bzB.wb() == 5) {
            return this.bzB;
        }
        this.bzB.setResource(1);
        return this.bzB;
    }

    public am lI(String str) {
        am amVar = new am(str);
        if (this.bzB != null) {
            amVar.g(ImageViewerConfig.FORUM_ID, this.bzB.getFid());
            amVar.al("tid", this.bzB.getTid());
            amVar.w("obj_type", 2);
            amVar.w("obj_param1", alc() ? 2 : 1);
            if (this.bzB.wm() != null) {
                amVar.al(VideoPlayActivityConfig.OBJ_ID, this.bzB.wm().getUserId());
            }
        }
        return amVar;
    }

    public am alh() {
        am p = p(cIf, true);
        if (p != null && UT() != null) {
            bb UT = UT();
            p.w("obj_name", UT.xD() != null && (UT.xD().byO() != null || UT.xD().OX() != null) ? 1 : 0);
            if (UT.wm() != null) {
                p.w("ab_type", UT.wm().hadConcerned() ? 1 : 0);
            }
        }
        return p;
    }

    public am T(bb bbVar) {
        return (bbVar.xp() == null || bbVar.xp().channelId <= 0) ? p(cIg, true) : p(cIh, true);
    }

    public am alj() {
        return p(cIe, true);
    }

    public am U(bb bbVar) {
        return (bbVar.xp() == null || bbVar.xp().channelId <= 0) ? p(cId, true) : p(cIi, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bzB == null || this.bzB.wE() == null || this.bzB.wE().video_url == null) {
            return null;
        }
        return this.bzB.wE().video_url;
    }
}
