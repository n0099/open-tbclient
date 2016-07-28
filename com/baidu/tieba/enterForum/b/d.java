package com.baidu.tieba.enterForum.b;

import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class d {
    private String buZ;
    private long bva;
    private long mId;
    private String mName;

    public String Sv() {
        return this.buZ;
    }

    public long Sw() {
        return this.bva;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.buZ = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.bva = hotSearch.search_value.type.longValue();
        }
    }
}
