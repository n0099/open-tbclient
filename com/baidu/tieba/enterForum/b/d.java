package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bJr;
    private long bJs;
    private long mId;
    private String mName;

    public String YC() {
        return this.bJr;
    }

    public long YD() {
        return this.bJs;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bJr = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bJs = hotSearch.search_value.type.longValue();
        }
    }
}
