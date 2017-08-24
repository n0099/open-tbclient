package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String bYO;
    private long bYP;
    private long mId;
    private String mName;

    public String abF() {
        return this.bYO;
    }

    public long abG() {
        return this.bYP;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bYO = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bYP = hotSearch.search_value.type.longValue();
        }
    }
}
