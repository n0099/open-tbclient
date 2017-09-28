package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String ccD;
    private long ccE;
    private long mId;
    private String mName;

    public String acF() {
        return this.ccD;
    }

    public long acG() {
        return this.ccE;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.ccD = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.ccE = hotSearch.search_value.type.longValue();
        }
    }
}
