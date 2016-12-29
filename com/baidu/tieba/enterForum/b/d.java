package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bpu;
    private long bpv;
    private long mId;
    private String mName;

    public String SN() {
        return this.bpu;
    }

    public long SO() {
        return this.bpv;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bpu = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bpv = hotSearch.search_value.type.longValue();
        }
    }
}
