package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public bb bIj;
    public static final BdUniqueId cQu = BdUniqueId.gen();
    public static final BdUniqueId cQv = BdUniqueId.gen();
    public static String cQw = "";
    public static String cQx = "";
    public static String cQy = "";
    public static String cQz = "";
    public static String cQA = "";
    public static String cQB = "";
    public boolean cQt = false;
    public boolean cQC = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.bIj = bbVar;
    }

    public static boolean S(bb bbVar) {
        return (bbVar == null || bbVar.yN() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bIj == null) {
            return cQu;
        }
        if (this.bIj.yy() || this.bIj.yz()) {
            return cQv;
        }
        return cQu;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb YB() {
        if (this.bIj == null) {
            return this.bIj;
        }
        if (this.bIj.yk() == 5) {
            return this.bIj;
        }
        this.bIj.setResource(1);
        return this.bIj;
    }

    public am mk(String str) {
        am amVar = new am(str);
        if (this.bIj != null) {
            amVar.h(ImageViewerConfig.FORUM_ID, this.bIj.getFid());
            amVar.ax("tid", this.bIj.getTid());
            amVar.x("obj_type", 2);
            amVar.x("obj_param1", aoF() ? 2 : 1);
            if (this.bIj.yv() != null) {
                amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.bIj.yv().getUserId());
            }
        }
        return amVar;
    }

    public am aoK() {
        am w = w(cQy, true);
        if (w != null && YB() != null) {
            bb YB = YB();
            w.x("obj_name", YB.zM() != null && (YB.zM().bCd() != null || YB.zM().QS() != null) ? 1 : 0);
            if (YB.yv() != null) {
                w.x("ab_type", YB.yv().hadConcerned() ? 1 : 0);
            }
        }
        return w;
    }

    public am T(bb bbVar) {
        return (bbVar.zy() == null || bbVar.zy().channelId <= 0) ? w(cQz, true) : w(cQA, true);
    }

    public am aoM() {
        return w(cQx, true);
    }

    public am U(bb bbVar) {
        return (bbVar.zy() == null || bbVar.zy().channelId <= 0) ? w(cQw, true) : w(cQB, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bIj == null || this.bIj.yN() == null || this.bIj.yN().video_url == null) {
            return null;
        }
        return this.bIj.yN().video_url;
    }
}
