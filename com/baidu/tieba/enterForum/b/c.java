package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class c {
    private String aLu;
    private long aLv;
    private long mId;
    private String mName;

    public String Ia() {
        return this.aLu;
    }

    public long getType() {
        return this.aLv;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.aLu = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.aLv = hotSearch.search_value.type.longValue();
        }
    }
}
