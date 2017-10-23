package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String ccr;
    private long ccs;
    private long mId;
    private String mName;

    public String acB() {
        return this.ccr;
    }

    public long acC() {
        return this.ccs;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.ccr = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.ccs = hotSearch.search_value.type.longValue();
        }
    }
}
