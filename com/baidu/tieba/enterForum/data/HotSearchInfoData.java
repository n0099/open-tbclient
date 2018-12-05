package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {
    private String dnX;
    private long dnY;
    private long mId;
    private String mName;

    public String auS() {
        return this.dnX;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dnX = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dnY = hotSearch.search_value.type.longValue();
        }
    }
}
