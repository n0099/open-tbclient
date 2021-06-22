package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetGiftList.DataReq;
import tbclient.GetGiftList.GetGiftListReqIdl;
/* loaded from: classes4.dex */
public class DefaultGiftListRequest extends NetMessage {
    public String from;
    public long toUserId;

    public DefaultGiftListRequest() {
        super(CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scene_from = this.from;
        builder.benefit_userid = Long.valueOf(this.toUserId);
        if (z) {
            w.a(builder, true);
        }
        GetGiftListReqIdl.Builder builder2 = new GetGiftListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getFrom() {
        return this.from;
    }

    public long getToUserId() {
        return this.toUserId;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setToUserId(long j) {
        this.toUserId = j;
    }
}
