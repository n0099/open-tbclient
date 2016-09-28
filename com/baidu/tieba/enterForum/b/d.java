package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bGx;
    private long bGy;
    private long mId;
    private String mName;

    public String XA() {
        return this.bGx;
    }

    public long XB() {
        return this.bGy;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bGx = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bGy = hotSearch.search_value.type.longValue();
        }
    }
}
