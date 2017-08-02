package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class f {
    private String bWV;
    private long bWW;
    private long mId;
    private String mName;

    public String abi() {
        return this.bWV;
    }

    public long abj() {
        return this.bWW;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.bWV = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bWW = hotSearch.search_value.type.longValue();
        }
    }
}
