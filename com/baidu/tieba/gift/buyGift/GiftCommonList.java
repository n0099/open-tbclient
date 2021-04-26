package com.baidu.tieba.gift.buyGift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetGiftCommonList.DataRes;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
import tbclient.GetGiftCommonList.GiftList;
import tbclient.GetGiftCommonList.Item;
@Deprecated
/* loaded from: classes4.dex */
public class GiftCommonList implements Serializable {
    public static final long serialVersionUID = 1719387618953489739L;
    public String errmsg;
    public int errorno;
    public GiftInfo gift_info;
    public String usermsg;

    /* loaded from: classes4.dex */
    public static class GiftInfo implements Serializable {
        public static final long serialVersionUID = 4908690864725277352L;
        public List<TypeInfo> list;
        public List<NumInfo> num_info;
        public int version;

        public List<NumInfo> getNumInfo() {
            if (this.num_info == null) {
                this.num_info = new ArrayList();
            }
            return this.num_info;
        }

        public List<TypeInfo> getTypeInfo() {
            if (this.list == null) {
                this.list = new ArrayList();
            }
            return this.list;
        }

        public int getVersion() {
            return this.version;
        }

        public void setNumInfo(List<NumInfo> list) {
            this.num_info = list;
        }

        public void setTypeInfo(List<TypeInfo> list) {
            this.list = list;
        }

        public void setVersion(int i2) {
            this.version = i2;
        }
    }

    /* loaded from: classes4.dex */
    public static class GiftItem implements Serializable {
        public static final long serialVersionUID = -628875343878681499L;
        public int gift_id;
        public String name;
        public String play_url;
        public int price;
        public String thumbnail_url;

        public int getGiftId() {
            return this.gift_id;
        }

        public String getName() {
            return this.name;
        }

        public String getPlayUrl() {
            return this.play_url;
        }

        public int getPrice() {
            return this.price;
        }

        public String getThumbnailUrl() {
            return this.thumbnail_url;
        }

        public void setGiftId(int i2) {
            this.gift_id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPlayUrl(String str) {
            this.play_url = str;
        }

        public void setPrice(int i2) {
            this.price = i2;
        }

        public void setThumbnailUrl(String str) {
            this.thumbnail_url = str;
        }
    }

    /* loaded from: classes4.dex */
    public static class NumInfo implements Serializable {
        public static final long serialVersionUID = 6308284942592196517L;
        public String name;
        public int num;

        public String getName() {
            return this.name;
        }

        public int getNum() {
            return this.num;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNum(int i2) {
            this.num = i2;
        }
    }

    /* loaded from: classes4.dex */
    public static class TypeInfo implements Serializable {
        public static final long serialVersionUID = -8689340701873734582L;
        public List<GiftItem> item;
        public int type_id;
        public String type_name;

        public List<GiftItem> getGiftItems() {
            if (this.item == null) {
                this.item = new ArrayList();
            }
            return this.item;
        }

        public int getTypeId() {
            return this.type_id;
        }

        public String getTypeName() {
            return this.type_name;
        }

        public void setGiftItems(List<GiftItem> list) {
            this.item = list;
        }

        public void setTypeId(int i2) {
            this.type_id = i2;
        }

        public void setTypeName(String str) {
            this.type_name = str;
        }
    }

    public String getErrMsg() {
        return this.errmsg;
    }

    public int getErrorNo() {
        return this.errorno;
    }

    public GiftInfo getGiftInfo() {
        return this.gift_info;
    }

    public String getUserMsg() {
        return this.usermsg;
    }

    public void parseProto(GetGiftCommonListResIdl getGiftCommonListResIdl) {
        DataRes dataRes;
        tbclient.GetGiftCommonList.GiftInfo giftInfo;
        if (getGiftCommonListResIdl == null) {
            return;
        }
        Error error = getGiftCommonListResIdl.error;
        if (error != null) {
            this.errmsg = error.errmsg;
            this.errorno = error.errorno.intValue();
            this.usermsg = getGiftCommonListResIdl.error.usermsg;
        }
        if (this.errorno != 0 || (dataRes = getGiftCommonListResIdl.data) == null || (giftInfo = dataRes.gift_info) == null) {
            return;
        }
        this.gift_info = new GiftInfo();
        List<GiftList> list = giftInfo.list;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (GiftList giftList : list) {
                TypeInfo typeInfo = new TypeInfo();
                typeInfo.setTypeId(giftList.type_id.intValue());
                typeInfo.setTypeName(giftList.type_name);
                if (giftList.item != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Item item : giftList.item) {
                        GiftItem giftItem = new GiftItem();
                        giftItem.setName(item.name);
                        giftItem.setPrice(item.price.intValue());
                        giftItem.setGiftId(item.gift_id.intValue());
                        giftItem.setPlayUrl(item.play_url);
                        giftItem.setThumbnailUrl(item.thumbnail_url);
                        arrayList2.add(giftItem);
                    }
                    typeInfo.setGiftItems(arrayList2);
                }
                arrayList.add(typeInfo);
            }
            this.gift_info.setTypeInfo(arrayList);
        }
        List<tbclient.GetGiftCommonList.NumInfo> list2 = giftInfo.num_info;
        if (list2 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (tbclient.GetGiftCommonList.NumInfo numInfo : list2) {
                NumInfo numInfo2 = new NumInfo();
                numInfo2.setName(numInfo.name);
                numInfo2.setNum(numInfo.num.intValue());
                arrayList3.add(numInfo2);
            }
            this.gift_info.setNumInfo(arrayList3);
        }
    }

    public void setErrMsg(String str) {
        this.errmsg = str;
    }

    public void setErrorNo(int i2) {
        this.errorno = i2;
    }

    public void setGiftInfo(GiftInfo giftInfo) {
        this.gift_info = giftInfo;
    }

    public void setUserMsg(String str) {
        this.usermsg = str;
    }
}
