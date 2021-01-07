package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetGiftList.GetGiftListResIdl;
import tbclient.GetGiftList.PresentCategoryList;
import tbclient.GetGiftList.PresentGiftList1;
import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes9.dex */
public class DefaultGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    private String addFreeUrl;
    private ArrayList<a> categoryList;
    public int currencyType;
    private int freeChance;
    private ArrayList<ah> giftList;
    private ArrayList<e> numberList;
    private long sceneId;
    public ai urlTitleData;

    public DefaultGiftListHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
                this.currencyType = getGiftListResIdl.data.currency_type.intValue();
                this.urlTitleData = new ai();
                this.urlTitleData.eQw = getGiftListResIdl.data.currency_txt.name;
                this.urlTitleData.eQx = getGiftListResIdl.data.currency_txt.url;
                if (getGiftListResIdl.data.gift_list != null && getGiftListResIdl.data.gift_list.size() > 0) {
                    this.giftList = new ArrayList<>();
                    for (PresentGiftList1 presentGiftList1 : getGiftListResIdl.data.gift_list) {
                        if (presentGiftList1 != null) {
                            ah ahVar = new ah();
                            ahVar.id = presentGiftList1.gift_id.intValue();
                            ahVar.name = presentGiftList1.gift_name;
                            ahVar.price = presentGiftList1.price.intValue();
                            ahVar.thumbnailUrl = presentGiftList1.thumbnail_url;
                            ahVar.eQp = presentGiftList1.ios_price.intValue();
                            ahVar.desc = presentGiftList1.gift_desc;
                            ahVar.aKj = presentGiftList1.activity_type.intValue();
                            ahVar.eQq = presentGiftList1.mark_url;
                            ahVar.beginTime = presentGiftList1.begin_time.intValue();
                            ahVar.endTime = presentGiftList1.end_time.intValue();
                            ahVar.eQr = presentGiftList1.discount.intValue();
                            ahVar.eQs = presentGiftList1.ios_discount.intValue();
                            ahVar.eQt = presentGiftList1.proportion.intValue();
                            ahVar.eQu = presentGiftList1.pitch_on.intValue();
                            ahVar.aZh = presentGiftList1.gift_count.intValue();
                            ahVar.eQv = presentGiftList1.currency_unit.intValue();
                            this.giftList.add(ahVar);
                        }
                    }
                }
                if (getGiftListResIdl.data.list != null && getGiftListResIdl.data.list.size() > 0) {
                    this.categoryList = new ArrayList<>();
                    for (PresentCategoryList presentCategoryList : getGiftListResIdl.data.list) {
                        if (presentCategoryList != null) {
                            a aVar = new a();
                            aVar.a(presentCategoryList);
                            this.categoryList.add(aVar);
                        }
                    }
                }
                if (getGiftListResIdl.data.num_info != null && getGiftListResIdl.data.num_info.size() > 0) {
                    this.numberList = new ArrayList<>();
                    for (PresentNumInfo presentNumInfo : getGiftListResIdl.data.num_info) {
                        if (presentNumInfo != null) {
                            e eVar = new e();
                            eVar.a(presentNumInfo);
                            this.numberList.add(eVar);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<a> getCategoryList() {
        return this.categoryList;
    }

    public ArrayList<ah> getGiftList() {
        return this.giftList;
    }

    public ArrayList<e> getGiftNumberList() {
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
