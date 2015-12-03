package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetGiftList.GetGiftListResIdl;
import tbclient.GetGiftList.PresentCategoryList;
import tbclient.GetGiftList.PresentGiftList1;
import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes.dex */
public class DefaultGiftListSocketResponseMessage extends SocketResponsedMessage {
    private String addFreeUrl;
    private ArrayList<c> categoryList;
    private int freeChance;
    private ArrayList<com.baidu.tbadk.core.data.l> giftList;
    private ArrayList<k> numberList;
    private long sceneId;

    public DefaultGiftListSocketResponseMessage() {
        super(309054);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetGiftListResIdl getGiftListResIdl = (GetGiftListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListResIdl.class);
        if (getGiftListResIdl != null) {
            if (getGiftListResIdl.error != null) {
                setError(getGiftListResIdl.error.errorno.intValue());
                setErrorString(getGiftListResIdl.error.usermsg);
            }
            if (getGiftListResIdl.data != null) {
                this.addFreeUrl = getGiftListResIdl.data.addfree_url;
                this.freeChance = getGiftListResIdl.data.free_chance.intValue();
                this.sceneId = getGiftListResIdl.data.scene_id.intValue();
                if (getGiftListResIdl.data.gift_list != null && getGiftListResIdl.data.gift_list.size() > 0) {
                    this.giftList = new ArrayList<>();
                    for (PresentGiftList1 presentGiftList1 : getGiftListResIdl.data.gift_list) {
                        if (presentGiftList1 != null) {
                            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                            lVar.setId(presentGiftList1.gift_id.intValue());
                            lVar.setName(presentGiftList1.gift_name);
                            lVar.k(presentGiftList1.price.intValue());
                            lVar.setThumbnailUrl(presentGiftList1.thumbnail_url);
                            lVar.l(presentGiftList1.ios_price.intValue());
                            lVar.setDesc(presentGiftList1.gift_desc);
                            lVar.bw(presentGiftList1.activity_type.intValue());
                            lVar.co(presentGiftList1.mark_url);
                            lVar.m(presentGiftList1.begin_time.intValue());
                            lVar.setEndTime(presentGiftList1.end_time.intValue());
                            lVar.n(presentGiftList1.discount.intValue());
                            lVar.o(presentGiftList1.ios_discount.intValue());
                            lVar.by(presentGiftList1.proportion.intValue());
                            lVar.bx(presentGiftList1.pitch_on.intValue());
                            lVar.bz(presentGiftList1.gift_count.intValue());
                            this.giftList.add(lVar);
                        }
                    }
                }
                if (getGiftListResIdl.data.list != null && getGiftListResIdl.data.list.size() > 0) {
                    this.categoryList = new ArrayList<>();
                    for (PresentCategoryList presentCategoryList : getGiftListResIdl.data.list) {
                        if (presentCategoryList != null) {
                            c cVar = new c();
                            cVar.a(presentCategoryList);
                            this.categoryList.add(cVar);
                        }
                    }
                }
                if (getGiftListResIdl.data.num_info != null && getGiftListResIdl.data.num_info.size() > 0) {
                    this.numberList = new ArrayList<>();
                    for (PresentNumInfo presentNumInfo : getGiftListResIdl.data.num_info) {
                        if (presentNumInfo != null) {
                            k kVar = new k();
                            kVar.a(presentNumInfo);
                            this.numberList.add(kVar);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<c> getCategoryList() {
        return this.categoryList;
    }

    public ArrayList<com.baidu.tbadk.core.data.l> getGiftList() {
        return this.giftList;
    }

    public ArrayList<k> getGiftNumberList() {
        return this.numberList;
    }

    public String getAddFreeUrl() {
        return this.addFreeUrl;
    }

    public int getFreeChance() {
        return this.freeChance;
    }

    public long getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(long j) {
        this.sceneId = j;
    }
}
