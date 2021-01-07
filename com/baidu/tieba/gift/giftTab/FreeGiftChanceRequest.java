package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetUserFreeChance.DataReq;
import tbclient.GetUserFreeChance.GetUserFreeChanceReqIdl;
/* loaded from: classes9.dex */
public class FreeGiftChanceRequest extends NetMessage {
    private String from;

    public FreeGiftChanceRequest() {
        super(1003047, CmdConfigSocket.CMD_USER_FREE_CHANCE);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scene_from = this.from;
        if (z) {
            t.b(builder, true);
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
