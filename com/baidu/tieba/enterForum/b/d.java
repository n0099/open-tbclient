package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bsK;
    private long bsL;
    private long mId;
    private String mName;

    public String RO() {
        return this.bsK;
    }

    public long RP() {
        return this.bsL;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bsK = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bsL = hotSearch.search_value.type.longValue();
        }
    }
}
