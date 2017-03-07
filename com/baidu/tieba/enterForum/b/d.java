package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bEm;
    private long bEn;
    private long mId;
    private String mName;

    public String Vg() {
        return this.bEm;
    }

    public long Vh() {
        return this.bEn;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bEm = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bEn = hotSearch.search_value.type.longValue();
        }
    }
}
