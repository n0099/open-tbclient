package com.baidu.tieba.frs;

import java.io.Serializable;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes.dex */
public class SerializableItemInfo implements Serializable {
    private static final String ALL = "all";
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

    public SerializableItemInfo(ItemInfo itemInfo) {
        if (itemInfo != null) {
            this.id = itemInfo.id;
            this.name = itemInfo.name;
            this.icon_url = itemInfo.icon_url;
            this.brief = itemInfo.brief;
            this.tags = itemInfo.tags;
            this.icon_size = itemInfo.icon_size.doubleValue();
            this.score = new SerializableItemTableInfo(itemInfo.score);
            this.isSchool = itemInfo.is_school.intValue();
            if (itemInfo.score != null && itemInfo.score.item_point != null) {
                for (ItemPoint itemPoint : itemInfo.score.item_point) {
                    if (itemPoint.time_intval.equals("all")) {
                        this.averageScore = itemPoint.point.doubleValue();
                        return;
                    }
                }
            }
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public String getBrief() {
        return this.brief;
    }

    public void setBrief(String str) {
        this.brief = str;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public double getIconSize() {
        return this.icon_size;
    }

    public void setIconSize(double d) {
        this.icon_size = d;
    }

    public SerializableItemTableInfo getScore() {
        return this.score;
    }

    public void setScore(SerializableItemTableInfo serializableItemTableInfo) {
        this.score = serializableItemTableInfo;
    }

    public int getIsSchool() {
        return this.isSchool;
    }

    public void setIsSchool(int i) {
        this.isSchool = i;
    }

    public void setAverageScore(double d) {
        this.averageScore = d;
    }

    public double getAverageScore() {
        return this.averageScore;
    }
}
