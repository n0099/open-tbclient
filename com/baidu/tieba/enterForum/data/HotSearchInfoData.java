package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class HotSearchInfoData extends OrmObject {
    private String csK;
    private long csL;
    private long mId;
    private String mName;

    public String agI() {
        return this.csK;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.csK = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.csL = hotSearch.search_value.type.longValue();
        }
    }
}
