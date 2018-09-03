package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes2.dex */
public class l extends c {
    public static final BdUniqueId cCk = BdUniqueId.gen();
    public static final BdUniqueId cCl = BdUniqueId.gen();
    public static String cCm = "";
    public static String cCn = "";
    public static String cCo = "";
    public static String cCp = "";
    public static String cCq = "";
    public static String cCr = "";
    public bb btL;
    public boolean cCj = false;
    public boolean cCs = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.btL = bbVar;
    }

    public static boolean R(bb bbVar) {
        return (bbVar == null || bbVar.vB() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.btL == null) {
            return cCk;
        }
        if (this.btL.vm() || this.btL.vn()) {
            return cCl;
        }
        return cCk;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb Tg() {
        if (this.btL == null) {
            return this.btL;
        }
        if (this.btL.uY() == 5) {
            return this.btL;
        }
        this.btL.setResource(1);
        return this.btL;
    }

    public an lg(String str) {
        an anVar = new an(str);
        if (this.btL != null) {
            anVar.f(ImageViewerConfig.FORUM_ID, this.btL.getFid());
            anVar.ae("tid", this.btL.getTid());
            anVar.r("obj_type", 2);
            anVar.r("obj_param1", ajr() ? 2 : 1);
            if (this.btL.vj() != null) {
                anVar.ae(VideoPlayActivityConfig.OBJ_ID, this.btL.vj().getUserId());
            }
        }
        return anVar;
    }

    public an ajw() {
        an o = o(cCo, true);
        if (o != null && Tg() != null) {
            bb Tg = Tg();
            o.r("obj_name", Tg.ww() != null && (Tg.ww().bwi() != null || Tg.ww().NE() != null) ? 1 : 0);
            if (Tg.vj() != null) {
                o.r("ab_type", Tg.vj().hadConcerned() ? 1 : 0);
            }
        }
        return o;
    }

    public an S(bb bbVar) {
        return (bbVar.wk() == null || bbVar.wk().channelId <= 0) ? o(cCp, true) : o(cCq, true);
    }

    public an ajy() {
        return o(cCn, true);
    }

    public an T(bb bbVar) {
        return (bbVar.wk() == null || bbVar.wk().channelId <= 0) ? o(cCm, true) : o(cCr, true);
    }
}
