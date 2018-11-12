package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {
    private String dhp;
    private long dhq;
    private long mId;
    private String mName;

    public String atg() {
        return this.dhp;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dhp = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dhq = hotSearch.search_value.type.longValue();
        }
    }
}
