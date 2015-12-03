package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetGiftListByCategoryId.DataReq;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdReqIdl;
/* loaded from: classes.dex */
public class CategoryGiftListRequest extends NetMessage {
    private int categoryId;

    public CategoryGiftListRequest() {
        super(CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.category_id = Integer.valueOf(this.categoryId);
        if (z) {
            com.baidu.tbadk.util.i.a(builder, true);
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
