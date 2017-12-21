package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class HotSearchInfoData extends OrmObject {
    private String csX;
    private long csY;
    private long mId;
    private String mName;

    public String agP() {
        return this.csX;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.csX = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.csY = hotSearch.search_value.type.longValue();
        }
    }
}
