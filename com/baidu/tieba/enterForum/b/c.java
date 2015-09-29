package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String aLj;
    private long aLk;
    private long mId;
    private String mName;

    public String Ia() {
        return this.aLj;
    }

    public long getType() {
        return this.aLk;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aLj = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aLk = hotSearch.search_value.type.longValue();
        }
    }
}
