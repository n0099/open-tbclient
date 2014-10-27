package com.baidu.tbadk.gift;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.SendGift.DataReq;
import tbclient.SendGift.SendGiftReqIdl;
/* loaded from: classes.dex */
public class RequestSendGiftSocketMessage extends TbSocketMessage {
    public static final int FROM_PERSON_CENTER = 1;
    public static final int FROM_PERSON_CHAT = 2;
    private int mFrom;
    private int mGiftId;
    private int mNum;
    private String mPassword;
    private int mPrice;
    private long mReceiverId;

    public RequestSendGiftSocketMessage() {
        super(308003);
    }

    public void setParams(long j, int i, int i2, int i3, int i4, String str) {
        this.mReceiverId = j;
        this.mGiftId = i;
        this.mPrice = i2;
        this.mNum = i3;
        this.mFrom = i4;
        this.mPassword = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.gift_from = Integer.valueOf(this.mFrom);
        builder.gift_id = Integer.valueOf(this.mGiftId);
        builder.num = Integer.valueOf(this.mNum);
        builder.price = Integer.valueOf(this.mPrice);
        builder.receiver_id = Long.valueOf(this.mReceiverId);
        builder.password = this.mPassword;
        SendGiftReqIdl.Builder builder2 = new SendGiftReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
