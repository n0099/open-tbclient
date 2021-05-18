package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.GetGiftListByCategoryId.DataReq;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdReqIdl;
/* loaded from: classes4.dex */
public class CategoryGiftListRequest extends NetMessage {
    public int categoryId;

    public CategoryGiftListRequest() {
        super(CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.category_id = Integer.valueOf(this.categoryId);
        if (z) {
            w.a(builder, true);
        }
        GetGiftListByCategoryIdReqIdl.Builder builder2 = new GetGiftListByCategoryIdReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i2) {
        this.categoryId = i2;
    }
}
