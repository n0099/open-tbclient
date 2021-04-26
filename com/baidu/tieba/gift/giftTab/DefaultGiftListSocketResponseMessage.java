package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.i0.r.q.i0;
import d.a.i0.r.q.j0;
import d.a.j0.u0.b.a;
import d.a.j0.u0.b.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftList.DataRes;
import tbclient.GetGiftList.GetGiftListResIdl;
import tbclient.GetGiftList.PresentCategoryList;
import tbclient.GetGiftList.PresentGiftList1;
import tbclient.GetGiftList.PresentNumInfo;
import tbclient.GetGiftList.UrlTitle;
/* loaded from: classes4.dex */
public class DefaultGiftListSocketResponseMessage extends SocketResponsedMessage {
    public String addFreeUrl;
    public ArrayList<a> categoryList;
    public int currencyType;
    public int freeChance;
    public ArrayList<i0> giftList;
    public ArrayList<e> numberList;
    public long sceneId;
    public j0 urlTitleData;

    public DefaultGiftListSocketResponseMessage() {
        super(309054);
    }

    public String getAddFreeUrl() {
        return this.addFreeUrl;
    }

    public ArrayList<a> getCategoryList() {
        return this.categoryList;
    }

    public int getFreeChance() {
        return this.freeChance;
    }

    public ArrayList<i0> getGiftList() {
        return this.giftList;
    }

    public ArrayList<e> getGiftNumberList() {
        return this.numberList;
    }

    public long getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(long j) {
        this.sceneId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetGiftListResIdl getGiftListResIdl = (GetGiftListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftListResIdl.class);
        if (getGiftListResIdl == null) {
            return;
        }
        Error error = getGiftListResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getGiftListResIdl.error.usermsg);
        }
        DataRes dataRes = getGiftListResIdl.data;
        if (dataRes != null) {
            this.addFreeUrl = dataRes.addfree_url;
            this.freeChance = dataRes.free_chance.intValue();
            this.sceneId = getGiftListResIdl.data.scene_id.intValue();
            this.currencyType = getGiftListResIdl.data.currency_type.intValue();
            j0 j0Var = new j0();
            this.urlTitleData = j0Var;
            DataRes dataRes2 = getGiftListResIdl.data;
            UrlTitle urlTitle = dataRes2.currency_txt;
            j0Var.f49193a = urlTitle.name;
            j0Var.f49194b = urlTitle.url;
            List<PresentGiftList1> list = dataRes2.gift_list;
            if (list != null && list.size() > 0) {
                this.giftList = new ArrayList<>();
                for (PresentGiftList1 presentGiftList1 : getGiftListResIdl.data.gift_list) {
                    if (presentGiftList1 != null) {
                        i0 i0Var = new i0();
                        i0Var.f49180a = presentGiftList1.gift_id.intValue();
                        i0Var.f49181b = presentGiftList1.gift_name;
                        i0Var.f49182c = presentGiftList1.price.intValue();
                        i0Var.f49183d = presentGiftList1.thumbnail_url;
                        presentGiftList1.ios_price.intValue();
                        i0Var.f49184e = presentGiftList1.gift_desc;
                        i0Var.f49185f = presentGiftList1.activity_type.intValue();
                        i0Var.f49186g = presentGiftList1.mark_url;
                        i0Var.f49187h = presentGiftList1.begin_time.intValue();
                        i0Var.f49188i = presentGiftList1.end_time.intValue();
                        i0Var.j = presentGiftList1.discount.intValue();
                        presentGiftList1.ios_discount.intValue();
                        presentGiftList1.proportion.intValue();
                        presentGiftList1.pitch_on.intValue();
                        i0Var.k = presentGiftList1.gift_count.intValue();
                        i0Var.q = presentGiftList1.currency_unit.intValue();
                        i0Var.s = presentGiftList1.currency.intValue();
                        this.giftList.add(i0Var);
                    }
                }
            }
            List<PresentCategoryList> list2 = getGiftListResIdl.data.list;
            if (list2 != null && list2.size() > 0) {
                this.categoryList = new ArrayList<>();
                for (PresentCategoryList presentCategoryList : getGiftListResIdl.data.list) {
                    if (presentCategoryList != null) {
                        a aVar = new a();
                        aVar.d(presentCategoryList);
                        this.categoryList.add(aVar);
                    }
                }
            }
            List<PresentNumInfo> list3 = getGiftListResIdl.data.num_info;
            if (list3 == null || list3.size() <= 0) {
                return;
            }
            this.numberList = new ArrayList<>();
            for (PresentNumInfo presentNumInfo : getGiftListResIdl.data.num_info) {
                if (presentNumInfo != null) {
                    e eVar = new e();
                    eVar.c(presentNumInfo);
                    this.numberList.add(eVar);
                }
            }
        }
    }
}
