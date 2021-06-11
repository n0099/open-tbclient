package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.m0.r.q.i0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftListByCategoryId.DataRes;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes4.dex */
public class CategoryGiftListSocketResponseMessage extends SocketResponsedMessage {
    public int categoryId;
    public ArrayList<i0> giftList;

    public CategoryGiftListSocketResponseMessage() {
        super(309055);
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<i0> getGiftList() {
        return this.giftList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
                    i0Var.f53719a = presentGiftListByCategoryId1.gift_id.intValue();
                    i0Var.f53720b = presentGiftListByCategoryId1.gift_name;
                    i0Var.f53721c = presentGiftListByCategoryId1.price.intValue();
                    i0Var.f53722d = presentGiftListByCategoryId1.thumbnail_url;
                    presentGiftListByCategoryId1.ios_price.intValue();
                    i0Var.f53723e = presentGiftListByCategoryId1.gift_desc;
                    i0Var.f53724f = presentGiftListByCategoryId1.activity_type.intValue();
                    i0Var.f53725g = presentGiftListByCategoryId1.mark_url;
                    i0Var.f53726h = presentGiftListByCategoryId1.begin_time.intValue();
                    i0Var.f53727i = presentGiftListByCategoryId1.end_time.intValue();
                    i0Var.j = presentGiftListByCategoryId1.discount.intValue();
                    presentGiftListByCategoryId1.ios_discount.intValue();
                    presentGiftListByCategoryId1.proportion.intValue();
                    presentGiftListByCategoryId1.pitch_on.intValue();
                    i0Var.k = presentGiftListByCategoryId1.gift_count.intValue();
                    i0Var.q = presentGiftListByCategoryId1.currency_unit.intValue();
                    i0Var.s = presentGiftListByCategoryId1.currency.intValue();
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
