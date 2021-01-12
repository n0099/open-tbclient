package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId gvX = BdUniqueId.gen();
    public String entryName;
    public bz gvQ;
    public boolean gvY;
    public boolean gvZ;
    public String labelName;
    public int locate;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gvO = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gvX;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.gvQ == null) {
            this.gvQ = new bz();
        }
        this.gvQ.a(threadInfo);
    }

    public bz bkV() {
        return this.gvQ;
    }

    public aq aA(String str, boolean z) {
        bz bkV = bkV();
        if (bkV == null) {
            return null;
        }
        String str2 = "";
        if (bkV.bnQ() != null && !StringUtils.isNull(bkV.bnQ().appId)) {
            str2 = bkV.bnQ().appId;
        }
        aq dW = new aq(str).w("obj_id", S(bkV)).an("obj_type", bQu()).dW("obj_param1", bkV.mRecomWeight).dW("obj_source", bkV.mRecomSource).an("obj_locate", this.locate).dW("ab_tag", bkV.mRecomAbTag).dW(TiebaInitialize.Params.OBJ_PARAM3, str2);
        if (z) {
            dW.dW(TiebaInitialize.Params.OBJ_PARAM2, bkV.bnL() > 0 ? "0" : "1");
        }
        return dW;
    }

    private long S(bz bzVar) {
        if (bzVar == null || bzVar.bnQ() == null) {
            return -1L;
        }
        return bzVar.bnQ().live_id;
    }

    private int bQu() {
        return 1;
    }
}
