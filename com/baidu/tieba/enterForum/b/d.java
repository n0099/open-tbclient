package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String bxg;
    private long bxh;
    private long mId;
    private String mName;

    public String Ui() {
        return this.bxg;
    }

    public long Uj() {
        return this.bxh;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bxg = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bxh = hotSearch.search_value.type.longValue();
        }
    }
}
