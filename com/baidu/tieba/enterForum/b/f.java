package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String bMg;
    private long bMh;
    private long mId;
    private String mName;

    public String WZ() {
        return this.bMg;
    }

    public long Xa() {
        return this.bMh;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bMg = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bMh = hotSearch.search_value.type.longValue();
        }
    }
}
