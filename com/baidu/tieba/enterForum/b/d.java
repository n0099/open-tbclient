package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bGm;
    private long bGn;
    private long mId;
    private String mName;

    public String Xh() {
        return this.bGm;
    }

    public long Xi() {
        return this.bGn;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bGm = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bGn = hotSearch.search_value.type.longValue();
        }
    }
}
