package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes10.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId gyV = BdUniqueId.gen();
    public String entryName;
    public cb gyO;
    public boolean gyW;
    public boolean gyX;
    public String labelName;
    public int locate;
    public int tabId;
    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean gyM = false;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gyV;
    }

    @Deprecated
    public void a(ThreadInfo threadInfo) {
        if (this.gyO == null) {
            this.gyO = new cb();
        }
        this.gyO.a(threadInfo);
    }

    public cb bln() {
        return this.gyO;
    }

    public ar az(String str, boolean z) {
        cb bln = bln();
        if (bln == null) {
            return null;
        }
        String str2 = "";
        if (bln.boj() != null && !StringUtils.isNull(bln.boj().appId)) {
            str2 = bln.boj().appId;
        }
        ar dR = new ar(str).v("obj_id", T(bln)).ap("obj_type", bRf()).dR("obj_param1", bln.mRecomWeight).dR("obj_source", bln.mRecomSource).ap("obj_locate", this.locate).dR("ab_tag", bln.mRecomAbTag).dR(TiebaInitialize.Params.OBJ_PARAM3, str2);
        if (z) {
            dR.dR(TiebaInitialize.Params.OBJ_PARAM2, bln.boe() > 0 ? "0" : "1");
        }
        return dR;
    }

    private long T(cb cbVar) {
        if (cbVar == null || cbVar.boj() == null) {
            return -1L;
        }
        return cbVar.boj().live_id;
    }

    private int bRf() {
        return 1;
    }
}
