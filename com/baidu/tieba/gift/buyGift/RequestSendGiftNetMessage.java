package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.SendGiftAndroid.DataReq;
import tbclient.SendGiftAndroid.SendGiftAndroidReqIdl;
/* loaded from: classes.dex */
public class RequestSendGiftNetMessage extends NetMessage {
    public static final int FROM_PERSON_CENTER = 1;
    public static final int FROM_PERSON_CHAT = 2;
    public static final int FROM_PHOTO_LIVE = 3;
    private long mFrom;
    private int mGiftId;
    private int mNum;
    private String mPassword;
    private int mPrice;
    private long mReceiverId;

    public RequestSendGiftNetMessage() {
        super(CmdConfigHttp.SEND_GIFT, 308007);
    }

    public void setParams(long j, int i, int i2, int i3, long j2, String str) {
        this.mReceiverId = j;
        this.mGiftId = i;
        this.mPrice = i2;
        this.mNum = i3;
        this.mFrom = j2;
        this.mPassword = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.gift_from = Long.valueOf(this.mFrom);
        builder.gift_id = Integer.valueOf(this.mGiftId);
        builder.num = Integer.valueOf(this.mNum);
        builder.price = Integer.valueOf(this.mPrice);
        builder.receiver_id = Long.valueOf(this.mReceiverId);
        builder.password = this.mPassword;
        SendGiftAndroidReqIdl.Builder builder2 = new SendGiftAndroidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
