package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.r.q.i0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftListByCategoryId.DataRes;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes4.dex */
public class CategoryGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    public int categoryId;
    public ArrayList<i0> giftList;

    public CategoryGiftListHttpResponseMessage(int i) {
        super(i);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<i0> getGiftList() {
        return this.giftList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        List<PresentGiftListByCategoryId1> list;
        GetGiftListByCategoryIdResIdl getGiftListByCategoryIdResIdl = (GetGiftListByCategoryIdResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListByCategoryIdResIdl.class);
        if (getGiftListByCategoryIdResIdl == null) {
            return;
        }
        Error error = getGiftListByCategoryIdResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getGiftListByCategoryIdResIdl.error.usermsg);
        }
        DataRes dataRes = getGiftListByCategoryIdResIdl.data;
        if (dataRes != null && (list = dataRes.gift_list) != null && list.size() > 0) {
            this.giftList = new ArrayList<>();
            for (PresentGiftListByCategoryId1 presentGiftListByCategoryId1 : getGiftListByCategoryIdResIdl.data.gift_list) {
                if (presentGiftListByCategoryId1 != null) {
                    i0 i0Var = new i0();
                    i0Var.f51552a = presentGiftListByCategoryId1.gift_id.intValue();
                    i0Var.f51553b = presentGiftListByCategoryId1.gift_name;
                    i0Var.f51554c = presentGiftListByCategoryId1.price.intValue();
                    i0Var.f51555d = presentGiftListByCategoryId1.thumbnail_url;
                    presentGiftListByCategoryId1.ios_price.intValue();
                    i0Var.f51556e = presentGiftListByCategoryId1.gift_desc;
                    i0Var.f51557f = presentGiftListByCategoryId1.activity_type.intValue();
                    i0Var.f51558g = presentGiftListByCategoryId1.mark_url;
                    i0Var.f51559h = presentGiftListByCategoryId1.begin_time.intValue();
                    i0Var.i = presentGiftListByCategoryId1.end_time.intValue();
                    i0Var.j = presentGiftListByCategoryId1.discount.intValue();
                    presentGiftListByCategoryId1.ios_discount.intValue();
                    presentGiftListByCategoryId1.proportion.intValue();
                    presentGiftListByCategoryId1.pitch_on.intValue();
                    i0Var.k = presentGiftListByCategoryId1.gift_count.intValue();
                    i0Var.q = presentGiftListByCategoryId1.currency_unit.intValue();
                    this.giftList.add(i0Var);
                }
            }
        }
        if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof CategoryGiftListRequest)) {
            return;
        }
        this.categoryId = ((CategoryGiftListRequest) getOrginalMessage().getExtra()).getCategoryId();
    }
}
