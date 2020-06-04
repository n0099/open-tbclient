package com.baidu.tieba.frs;

import java.io.Serializable;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes.dex */
public class SerializableItemInfo implements Serializable {
    public String brief;
    public String icon_url;
    public Integer id;
    public String name;
    public List<String> tags;

    public SerializableItemInfo(ItemInfo itemInfo) {
        this.id = itemInfo.id;
        this.name = itemInfo.name;
        this.icon_url = itemInfo.icon_url;
        this.brief = itemInfo.brief;
        this.tags = itemInfo.tags;
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
}
