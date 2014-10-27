package com.baidu.tbadk.gift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
import tbclient.GetGiftCommonList.GiftList;
import tbclient.GetGiftCommonList.Item;
/* loaded from: classes.dex */
public class GiftCommonList implements Serializable {
    private static final long serialVersionUID = 1719387618953489739L;
    private String errmsg;
    private int errorno;
    private GiftInfo gift_info;
    private String usermsg;

    public void setErrorNo(int i) {
        this.errorno = i;
    }

    public int getErrorNo() {
        return this.errorno;
    }

    public void setErrMsg(String str) {
        this.errmsg = str;
    }

    public String getErrMsg() {
        return this.errmsg;
    }

    public void setUserMsg(String str) {
        this.usermsg = str;
    }

    public String getUserMsg() {
        return this.usermsg;
    }

    public void setGiftInfo(GiftInfo giftInfo) {
        this.gift_info = giftInfo;
    }

    public GiftInfo getGiftInfo() {
        return this.gift_info;
    }

    public void parseProto(GetGiftCommonListResIdl getGiftCommonListResIdl) {
        tbclient.GetGiftCommonList.GiftInfo giftInfo;
        if (getGiftCommonListResIdl != null) {
            if (getGiftCommonListResIdl.error != null) {
                this.errmsg = getGiftCommonListResIdl.error.errmsg;
                this.errorno = getGiftCommonListResIdl.error.errorno.intValue();
                this.usermsg = getGiftCommonListResIdl.error.usermsg;
            }
            if (this.errorno == 0 && getGiftCommonListResIdl.data != null && (giftInfo = getGiftCommonListResIdl.data.gift_info) != null) {
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
        }
    }

    /* loaded from: classes.dex */
    public class GiftInfo implements Serializable {
        private static final long serialVersionUID = 4908690864725277352L;
        private List<TypeInfo> list;
        private List<NumInfo> num_info;
        private int version;

        public void setVersion(int i) {
            this.version = i;
        }

        public int getVersion() {
            return this.version;
        }

        public void setTypeInfo(List<TypeInfo> list) {
            this.list = list;
        }

        public List<TypeInfo> getTypeInfo() {
            if (this.list == null) {
                this.list = new ArrayList();
            }
            return this.list;
        }

        public void setNumInfo(List<NumInfo> list) {
            this.num_info = list;
        }

        public List<NumInfo> getNumInfo() {
            if (this.num_info == null) {
                this.num_info = new ArrayList();
            }
            return this.num_info;
        }
    }

    /* loaded from: classes.dex */
    public class TypeInfo implements Serializable {
        private static final long serialVersionUID = -8689340701873734582L;
        private List<GiftItem> item;
        private int type_id;
        private String type_name;

        public void setTypeId(int i) {
            this.type_id = i;
        }

        public int getTypeId() {
            return this.type_id;
        }

        public void setTypeName(String str) {
            this.type_name = str;
        }

        public String getTypeName() {
            return this.type_name;
        }

        public void setGiftItems(List<GiftItem> list) {
            this.item = list;
        }

        public List<GiftItem> getGiftItems() {
            if (this.item == null) {
                this.item = new ArrayList();
            }
            return this.item;
        }
    }

    /* loaded from: classes.dex */
    public class NumInfo implements Serializable {
        private static final long serialVersionUID = 6308284942592196517L;
        private String name;
        private int num;

        public void setNum(int i) {
            this.num = i;
        }

        public int getNum() {
            return this.num;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    /* loaded from: classes.dex */
    public class GiftItem implements Serializable {
        private static final long serialVersionUID = -628875343878681499L;
        private int gift_id;
        private String name;
        private String play_url;
        private int price;
        private String thumbnail_url;

        public void setName(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public void setGiftId(int i) {
            this.gift_id = i;
        }

        public int getGiftId() {
            return this.gift_id;
        }

        public void setPrice(int i) {
            this.price = i;
        }

        public int getPrice() {
            return this.price;
        }

        public void setThumbnailUrl(String str) {
            this.thumbnail_url = str;
        }

        public String getThumbnailUrl() {
            return this.thumbnail_url;
        }

        public void setPlayUrl(String str) {
            this.play_url = str;
        }

        public String getPlayUrl() {
            return this.play_url;
        }
    }
}
