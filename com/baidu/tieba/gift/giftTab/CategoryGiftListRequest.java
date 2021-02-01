package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetGiftListByCategoryId.DataReq;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdReqIdl;
/* loaded from: classes9.dex */
public class CategoryGiftListRequest extends NetMessage {
    private int categoryId;

    public CategoryGiftListRequest() {
        super(1003046, CmdConfigSocket.CMD_GIFT_LIST_BY_CATEGORY);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.category_id = Integer.valueOf(this.categoryId);
        if (z) {
            v.b(builder, true);
        }
        GetGiftListByCategoryIdReqIdl.Builder builder2 = new GetGiftListByCategoryIdReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }
}
