package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes.dex */
public class CategoryGiftListSocketResponseMessage extends SocketResponsedMessage {
    private int categoryId;
    private ArrayList<com.baidu.tbadk.core.data.l> giftList;

    public CategoryGiftListSocketResponseMessage() {
        super(309055);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
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
                        com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                        lVar.setId(presentGiftListByCategoryId1.gift_id.intValue());
                        lVar.setName(presentGiftListByCategoryId1.gift_name);
                        lVar.k(presentGiftListByCategoryId1.price.intValue());
                        lVar.setThumbnailUrl(presentGiftListByCategoryId1.thumbnail_url);
                        lVar.l(presentGiftListByCategoryId1.ios_price.intValue());
                        lVar.setDesc(presentGiftListByCategoryId1.gift_desc);
                        lVar.bw(presentGiftListByCategoryId1.activity_type.intValue());
                        lVar.co(presentGiftListByCategoryId1.mark_url);
                        lVar.m(presentGiftListByCategoryId1.begin_time.intValue());
                        lVar.setEndTime(presentGiftListByCategoryId1.end_time.intValue());
                        lVar.n(presentGiftListByCategoryId1.discount.intValue());
                        lVar.l(presentGiftListByCategoryId1.ios_discount.intValue());
                        lVar.by(presentGiftListByCategoryId1.proportion.intValue());
                        lVar.bx(presentGiftListByCategoryId1.pitch_on.intValue());
                        lVar.bz(presentGiftListByCategoryId1.gift_count.intValue());
                        this.giftList.add(lVar);
                    }
                }
            }
            if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof CategoryGiftListRequest)) {
                this.categoryId = ((CategoryGiftListRequest) getOrginalMessage().getExtra()).getCategoryId();
            }
        }
    }

    public ArrayList<com.baidu.tbadk.core.data.l> getGiftList() {
        return this.giftList;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
}
