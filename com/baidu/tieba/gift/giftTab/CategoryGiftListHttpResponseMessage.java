package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes9.dex */
public class CategoryGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    private int categoryId;
    private ArrayList<ai> giftList;

    public CategoryGiftListHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetGiftListByCategoryIdResIdl getGiftListByCategoryIdResIdl = (GetGiftListByCategoryIdResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListByCategoryIdResIdl.class);
        if (getGiftListByCategoryIdResIdl != null) {
            if (getGiftListByCategoryIdResIdl.error != null) {
                setError(getGiftListByCategoryIdResIdl.error.errorno.intValue());
                setErrorString(getGiftListByCategoryIdResIdl.error.usermsg);
            }
            if (getGiftListByCategoryIdResIdl.data != null && getGiftListByCategoryIdResIdl.data.gift_list != null && getGiftListByCategoryIdResIdl.data.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                for (PresentGiftListByCategoryId1 presentGiftListByCategoryId1 : getGiftListByCategoryIdResIdl.data.gift_list) {
                    if (presentGiftListByCategoryId1 != null) {
                        ai aiVar = new ai();
                        aiVar.id = presentGiftListByCategoryId1.gift_id.intValue();
                        aiVar.name = presentGiftListByCategoryId1.gift_name;
                        aiVar.price = presentGiftListByCategoryId1.price.intValue();
                        aiVar.thumbnailUrl = presentGiftListByCategoryId1.thumbnail_url;
                        aiVar.eNQ = presentGiftListByCategoryId1.ios_price.intValue();
                        aiVar.desc = presentGiftListByCategoryId1.gift_desc;
                        aiVar.aHS = presentGiftListByCategoryId1.activity_type.intValue();
                        aiVar.eNR = presentGiftListByCategoryId1.mark_url;
                        aiVar.beginTime = presentGiftListByCategoryId1.begin_time.intValue();
                        aiVar.endTime = presentGiftListByCategoryId1.end_time.intValue();
                        aiVar.eNS = presentGiftListByCategoryId1.discount.intValue();
                        aiVar.eNT = presentGiftListByCategoryId1.ios_discount.intValue();
                        aiVar.eNU = presentGiftListByCategoryId1.proportion.intValue();
                        aiVar.eNV = presentGiftListByCategoryId1.pitch_on.intValue();
                        aiVar.aXz = presentGiftListByCategoryId1.gift_count.intValue();
                        aiVar.eNW = presentGiftListByCategoryId1.currency_unit.intValue();
                        this.giftList.add(aiVar);
                    }
                }
            }
            if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof CategoryGiftListRequest)) {
                this.categoryId = ((CategoryGiftListRequest) getOrginalMessage().getExtra()).getCategoryId();
            }
        }
    }

    public ArrayList<ai> getGiftList() {
        return this.giftList;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
}
