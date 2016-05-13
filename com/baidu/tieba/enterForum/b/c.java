package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String aWM;
    private long aWN;
    private long mId;
    private String mName;

    public String Mk() {
        return this.aWM;
    }

    public long Ml() {
        return this.aWN;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aWM = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aWN = hotSearch.search_value.type.longValue();
        }
    }
}
