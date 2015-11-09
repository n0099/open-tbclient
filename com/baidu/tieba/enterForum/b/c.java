package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String aLC;
    private long aLD;
    private long mId;
    private String mName;

    public String Im() {
        return this.aLC;
    }

    public long getType() {
        return this.aLD;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aLC = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aLD = hotSearch.search_value.type.longValue();
        }
    }
}
