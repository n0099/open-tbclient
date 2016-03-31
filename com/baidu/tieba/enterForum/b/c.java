package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String baJ;
    private long baK;
    private long mId;
    private String mName;

    public String Nz() {
        return this.baJ;
    }

    public long NA() {
        return this.baK;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.baJ = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.baK = hotSearch.search_value.type.longValue();
        }
    }
}
