package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes8.dex */
public class CategoryGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    private int categoryId;
    private ArrayList<ah> giftList;

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
                        ah ahVar = new ah();
                        ahVar.id = presentGiftListByCategoryId1.gift_id.intValue();
                        ahVar.name = presentGiftListByCategoryId1.gift_name;
                        ahVar.price = presentGiftListByCategoryId1.price.intValue();
                        ahVar.thumbnailUrl = presentGiftListByCategoryId1.thumbnail_url;
                        ahVar.eLE = presentGiftListByCategoryId1.ios_price.intValue();
                        ahVar.desc = presentGiftListByCategoryId1.gift_desc;
                        ahVar.aFw = presentGiftListByCategoryId1.activity_type.intValue();
                        ahVar.eLF = presentGiftListByCategoryId1.mark_url;
                        ahVar.beginTime = presentGiftListByCategoryId1.begin_time.intValue();
                        ahVar.endTime = presentGiftListByCategoryId1.end_time.intValue();
                        ahVar.eLG = presentGiftListByCategoryId1.discount.intValue();
                        ahVar.eLH = presentGiftListByCategoryId1.ios_discount.intValue();
                        ahVar.eLI = presentGiftListByCategoryId1.proportion.intValue();
                        ahVar.eLJ = presentGiftListByCategoryId1.pitch_on.intValue();
                        ahVar.aUu = presentGiftListByCategoryId1.gift_count.intValue();
                        ahVar.eLK = presentGiftListByCategoryId1.currency_unit.intValue();
                        this.giftList.add(ahVar);
                    }
                }
            }
            if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof CategoryGiftListRequest)) {
                this.categoryId = ((CategoryGiftListRequest) getOrginalMessage().getExtra()).getCategoryId();
            }
        }
    }

    public ArrayList<ah> getGiftList() {
        return this.giftList;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
}
