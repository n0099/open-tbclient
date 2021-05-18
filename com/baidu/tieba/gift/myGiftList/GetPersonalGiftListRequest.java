package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.GetMyGift.DataReq;
import tbclient.GetMyGift.GetMyGiftReqIdl;
/* loaded from: classes4.dex */
public class GetPersonalGiftListRequest extends NetMessage {
    public int pageNumber;
    public String type;
    public long userId;
    public int userType;

    public GetPersonalGiftListRequest() {
        super(CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pageNumber);
        builder.uid = Long.valueOf(this.userId);
        builder.st_type = this.type;
        builder.account_type = Integer.valueOf(this.userType);
        if (z) {
            w.a(builder, true);
        }
        GetMyGiftReqIdl.Builder builder2 = new GetMyGiftReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public String getType() {
        return this.type;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setPageNumber(int i2) {
        this.pageNumber = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
