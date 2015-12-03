package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetGiftList.DataReq;
import tbclient.GetGiftList.GetGiftListReqIdl;
/* loaded from: classes.dex */
public class DefaultGiftListRequest extends NetMessage {
    private String from;
    private long toUserId;

    public DefaultGiftListRequest() {
        super(CmdConfigHttp.CMD_DEFAULT_GIFT_LIST, 309054);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scene_from = this.from;
        builder.benefit_userid = Long.valueOf(this.toUserId);
        if (z) {
            com.baidu.tbadk.util.i.a(builder, true);
        }
        GetGiftListReqIdl.Builder builder2 = new GetGiftListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public long getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(long j) {
        this.toUserId = j;
    }
}
