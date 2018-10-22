package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {
    private String dgk;
    private long dgl;
    private long mId;
    private String mName;

    public String atH() {
        return this.dgk;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dgk = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dgl = hotSearch.search_value.type.longValue();
        }
    }
}
