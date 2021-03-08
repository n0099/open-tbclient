package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.ai;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetGiftListByCategoryId.GetGiftListByCategoryIdResIdl;
import tbclient.GetGiftListByCategoryId.PresentGiftListByCategoryId1;
/* loaded from: classes8.dex */
public class CategoryGiftListSocketResponseMessage extends SocketResponsedMessage {
    private int categoryId;
    private ArrayList<ai> giftList;

    public CategoryGiftListSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GIFT_LIST_BY_CATEGORY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
                        aiVar.ePr = presentGiftListByCategoryId1.ios_price.intValue();
                        aiVar.desc = presentGiftListByCategoryId1.gift_desc;
                        aiVar.aJs = presentGiftListByCategoryId1.activity_type.intValue();
                        aiVar.ePs = presentGiftListByCategoryId1.mark_url;
                        aiVar.beginTime = presentGiftListByCategoryId1.begin_time.intValue();
                        aiVar.endTime = presentGiftListByCategoryId1.end_time.intValue();
                        aiVar.ePt = presentGiftListByCategoryId1.discount.intValue();
                        aiVar.ePu = presentGiftListByCategoryId1.ios_discount.intValue();
                        aiVar.ePv = presentGiftListByCategoryId1.proportion.intValue();
                        aiVar.ePw = presentGiftListByCategoryId1.pitch_on.intValue();
                        aiVar.aYZ = presentGiftListByCategoryId1.gift_count.intValue();
                        aiVar.ePx = presentGiftListByCategoryId1.currency_unit.intValue();
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
