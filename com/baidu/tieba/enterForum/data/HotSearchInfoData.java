package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {
    private String dqO;
    private long dqP;
    private long mId;
    private String mName;

    public String avH() {
        return this.dqO;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dqO = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dqP = hotSearch.search_value.type.longValue();
        }
    }
}
