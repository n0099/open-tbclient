package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId gAE = BdUniqueId.gen();
    public String entryName;
    public boolean gAF;
    public boolean gAG;
    public cb gAx;
    public String labelName;
    public int locate;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gAv = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gAE;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.gAx == null) {
            this.gAx = new cb();
        }
        this.gAx.a(threadInfo);
    }

    public cb blp() {
        return this.gAx;
    }

    public ar az(String str, boolean z) {
        cb blp = blp();
        if (blp == null) {
            return null;
        }
        String str2 = "";
        if (blp.bol() != null && !StringUtils.isNull(blp.bol().appId)) {
            str2 = blp.bol().appId;
        }
        ar dR = new ar(str).v("obj_id", T(blp)).aq("obj_type", bRl()).dR("obj_param1", blp.mRecomWeight).dR("obj_source", blp.mRecomSource).aq("obj_locate", this.locate).dR("ab_tag", blp.mRecomAbTag).dR(TiebaInitialize.Params.OBJ_PARAM3, str2);
        if (z) {
            dR.dR(TiebaInitialize.Params.OBJ_PARAM2, blp.bog() > 0 ? "0" : "1");
        }
        return dR;
    }

    private long T(cb cbVar) {
        if (cbVar == null || cbVar.bol() == null) {
            return -1L;
        }
        return cbVar.bol().live_id;
    }

    private int bRl() {
        return 1;
    }
}
