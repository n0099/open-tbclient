package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetGiftList.DataReq;
import tbclient.GetGiftList.GetGiftListReqIdl;
/* loaded from: classes8.dex */
public class DefaultGiftListRequest extends NetMessage {
    private String from;
    private long toUserId;

    public DefaultGiftListRequest() {
        super(1003045, CmdConfigSocket.CMD_DEFAULT_GIFT_LIST);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scene_from = this.from;
        builder.benefit_userid = Long.valueOf(this.toUserId);
        if (z) {
            v.b(builder, true);
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
