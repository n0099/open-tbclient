package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bGw;
    private long bGx;
    private long mId;
    private String mName;

    public String WF() {
        return this.bGw;
    }

    public long WG() {
        return this.bGx;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bGw = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bGx = hotSearch.search_value.type.longValue();
        }
    }
}
