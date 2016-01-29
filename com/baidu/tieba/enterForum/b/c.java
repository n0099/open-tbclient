package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String aWa;
    private long aWb;
    private long mId;
    private String mName;

    public String LL() {
        return this.aWa;
    }

    public long LM() {
        return this.aWb;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aWa = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aWb = hotSearch.search_value.type.longValue();
        }
    }
}
