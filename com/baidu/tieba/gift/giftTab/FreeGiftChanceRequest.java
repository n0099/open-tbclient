package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetUserFreeChance.DataReq;
import tbclient.GetUserFreeChance.GetUserFreeChanceReqIdl;
/* loaded from: classes4.dex */
public class FreeGiftChanceRequest extends NetMessage {
    public String from;

    public FreeGiftChanceRequest() {
        super(CmdConfigHttp.CMD_USER_FREE_CHANCE, 309060);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scene_from = this.from;
        if (z) {
            w.a(builder, true);
        }
        GetUserFreeChanceReqIdl.Builder builder2 = new GetUserFreeChanceReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }
}
