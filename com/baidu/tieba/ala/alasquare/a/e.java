package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes10.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId gAE = BdUniqueId.gen();
    public String entryName;
    public boolean gAF;
    public boolean gAG;
    public bz gAx;
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
            this.gAx = new bz();
        }
        this.gAx.a(threadInfo);
    }

    public bz boP() {
        return this.gAx;
    }

    public aq aA(String str, boolean z) {
        bz boP = boP();
        if (boP == null) {
            return null;
        }
        String str2 = "";
        if (boP.brK() != null && !StringUtils.isNull(boP.brK().appId)) {
            str2 = boP.brK().appId;
        }
        aq dX = new aq(str).w("obj_id", S(boP)).an("obj_type", bUm()).dX("obj_param1", boP.mRecomWeight).dX("obj_source", boP.mRecomSource).an("obj_locate", this.locate).dX("ab_tag", boP.mRecomAbTag).dX(TiebaInitialize.Params.OBJ_PARAM3, str2);
        if (z) {
            dX.dX(TiebaInitialize.Params.OBJ_PARAM2, boP.brF() > 0 ? "0" : "1");
        }
        return dX;
    }

    private long S(bz bzVar) {
        if (bzVar == null || bzVar.brK() == null) {
            return -1L;
        }
        return bzVar.brK().live_id;
    }

    private int bUm() {
        return 1;
    }
}
