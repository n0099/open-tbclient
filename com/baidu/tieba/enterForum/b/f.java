package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String cbL;
    private long cbM;
    private long mId;
    private String mName;

    public String acH() {
        return this.cbL;
    }

    public long acI() {
        return this.cbM;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.cbL = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.cbM = hotSearch.search_value.type.longValue();
        }
    }
}
