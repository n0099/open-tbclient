package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String bYN;
    private long bYO;
    private long mId;
    private String mName;

    public String abI() {
        return this.bYN;
    }

    public long abJ() {
        return this.bYO;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bYN = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bYO = hotSearch.search_value.type.longValue();
        }
    }
}
