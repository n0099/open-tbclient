package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String aQb;
    private long aQc;
    private long mId;
    private String mName;

    public String JE() {
        return this.aQb;
    }

    public long getType() {
        return this.aQc;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aQb = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aQc = hotSearch.search_value.type.longValue();
        }
    }
}
