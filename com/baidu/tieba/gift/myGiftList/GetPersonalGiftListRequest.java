package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetMyGift.DataReq;
import tbclient.GetMyGift.GetMyGiftReqIdl;
/* loaded from: classes9.dex */
public class GetPersonalGiftListRequest extends NetMessage {
    private int pageNumber;
    private String type;
    private long userId;
    public int userType;

    public GetPersonalGiftListRequest() {
        super(1003051, CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pageNumber);
        builder.uid = Long.valueOf(this.userId);
        builder.st_type = this.type;
        builder.account_type = Integer.valueOf(this.userType);
        if (z) {
            t.b(builder, true);
        }
        GetMyGiftReqIdl.Builder builder2 = new GetMyGiftReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
