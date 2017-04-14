package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bEf;
    private long bEg;
    private long mId;
    private String mName;

    public String VE() {
        return this.bEf;
    }

    public long VF() {
        return this.bEg;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bEf = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bEg = hotSearch.search_value.type.longValue();
        }
    }
}
