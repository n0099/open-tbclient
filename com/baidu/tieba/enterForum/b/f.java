package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String bGr;
    private long bGs;
    private long mId;
    private String mName;

    public String VW() {
        return this.bGr;
    }

    public long VX() {
        return this.bGs;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bGr = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bGs = hotSearch.search_value.type.longValue();
        }
    }
}
