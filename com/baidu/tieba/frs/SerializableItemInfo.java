package com.baidu.tieba.frs;

import java.io.Serializable;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes4.dex */
public class SerializableItemInfo implements Serializable {
    public static final String ALL = "all";
    public double averageScore;
    public String brief;
    public double icon_size;
    public String icon_url;
    public Integer id;
    public int isSchool;
    public String name;
    public SerializableItemTableInfo score;
    public List<String> tags;

    public SerializableItemInfo() {
    }

    public double getAverageScore() {
        return this.averageScore;
    }

    public String getBrief() {
        return this.brief;
    }

    public double getIconSize() {
        return this.icon_size;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public Integer getId() {
        return this.id;
    }

    public int getIsSchool() {
        return this.isSchool;
    }

    public String getName() {
        return this.name;
    }

    public SerializableItemTableInfo getScore() {
        return this.score;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setAverageScore(double d2) {
        this.averageScore = d2;
    }

    public void setBrief(String str) {
        this.brief = str;
    }

    public void setIconSize(double d2) {
        this.icon_size = d2;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setIsSchool(int i2) {
        this.isSchool = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setScore(SerializableItemTableInfo serializableItemTableInfo) {
        this.score = serializableItemTableInfo;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public SerializableItemInfo(ItemInfo itemInfo) {
        List<ItemPoint> list;
        if (itemInfo == null) {
            return;
        }
        this.id = itemInfo.id;
        this.name = itemInfo.name;
        this.icon_url = itemInfo.icon_url;
        this.brief = itemInfo.brief;
        this.tags = itemInfo.tags;
        this.icon_size = itemInfo.icon_size.doubleValue();
        this.score = new SerializableItemTableInfo(itemInfo.score);
        this.isSchool = itemInfo.is_school.intValue();
        ItemTable itemTable = itemInfo.score;
        if (itemTable == null || (list = itemTable.item_point) == null) {
            return;
        }
        for (ItemPoint itemPoint : list) {
            if (itemPoint.time_intval.equals("all")) {
                this.averageScore = itemPoint.point.doubleValue();
                return;
            }
        }
    }
}
