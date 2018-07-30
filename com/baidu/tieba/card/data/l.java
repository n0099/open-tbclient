package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes2.dex */
public class l extends c {
    public static final BdUniqueId cCn = BdUniqueId.gen();
    public static final BdUniqueId cCo = BdUniqueId.gen();
    public static String cCp = "";
    public static String cCq = "";
    public static String cCr = "";
    public static String cCs = "";
    public static String cCt = "";
    public static String cCu = "";
    public bb btJ;
    public boolean cCm = false;
    public boolean cCv = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.btJ = bbVar;
    }

    public static boolean R(bb bbVar) {
        return (bbVar == null || bbVar.vC() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.btJ == null) {
            return cCn;
        }
        if (this.btJ.vn() || this.btJ.vo()) {
            return cCo;
        }
        return cCn;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb Td() {
        if (this.btJ == null) {
            return this.btJ;
        }
        if (this.btJ.uZ() == 5) {
            return this.btJ;
        }
        this.btJ.setResource(1);
        return this.btJ;
    }

    public an le(String str) {
        an anVar = new an(str);
        if (this.btJ != null) {
            anVar.f(ImageViewerConfig.FORUM_ID, this.btJ.getFid());
            anVar.af("tid", this.btJ.getTid());
            anVar.r("obj_type", 2);
            anVar.r("obj_param1", ajo() ? 2 : 1);
            if (this.btJ.vk() != null) {
                anVar.af(VideoPlayActivityConfig.OBJ_ID, this.btJ.vk().getUserId());
            }
        }
        return anVar;
    }

    public an ajt() {
        an o = o(cCr, true);
        if (o != null && Td() != null) {
            bb Td = Td();
            o.r("obj_name", Td.wx() != null && (Td.wx().bwh() != null || Td.wx().NF() != null) ? 1 : 0);
            if (Td.vk() != null) {
                o.r("ab_type", Td.vk().hadConcerned() ? 1 : 0);
            }
        }
        return o;
    }

    public an S(bb bbVar) {
        return (bbVar.wl() == null || bbVar.wl().channelId <= 0) ? o(cCs, true) : o(cCt, true);
    }

    public an ajv() {
        return o(cCq, true);
    }

    public an T(bb bbVar) {
        return (bbVar.wl() == null || bbVar.wl().channelId <= 0) ? o(cCp, true) : o(cCu, true);
    }
}
