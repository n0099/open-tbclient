package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class HotSearchInfoData extends OrmObject {
    private String csT;
    private long csU;
    private long mId;
    private String mName;

    public String agQ() {
        return this.csT;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.csT = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.csU = hotSearch.search_value.type.longValue();
        }
    }
}
