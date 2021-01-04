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

    public bz boO() {
        return this.gAx;
    }

    public aq aA(String str, boolean z) {
        bz boO = boO();
        if (boO == null) {
            return null;
        }
        String str2 = "";
        if (boO.brJ() != null && !StringUtils.isNull(boO.brJ().appId)) {
            str2 = boO.brJ().appId;
        }
        aq dX = new aq(str).w("obj_id", S(boO)).an("obj_type", bUl()).dX("obj_param1", boO.mRecomWeight).dX("obj_source", boO.mRecomSource).an("obj_locate", this.locate).dX("ab_tag", boO.mRecomAbTag).dX(TiebaInitialize.Params.OBJ_PARAM3, str2);
        if (z) {
            dX.dX(TiebaInitialize.Params.OBJ_PARAM2, boO.brE() > 0 ? "0" : "1");
        }
        return dX;
    }

    private long S(bz bzVar) {
        if (bzVar == null || bzVar.brJ() == null) {
            return -1L;
        }
        return bzVar.brJ().live_id;
    }

    private int bUl() {
        return 1;
    }
}
