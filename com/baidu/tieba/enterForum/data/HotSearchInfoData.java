package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {
    private String eYb;
    private long eYc;
    private long mId;
    private String mName;

    public String bfT() {
        return this.eYb;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.eYb = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.eYc = hotSearch.search_value.type.longValue();
        }
    }
}
