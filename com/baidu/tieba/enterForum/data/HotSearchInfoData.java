package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes2.dex */
public class HotSearchInfoData extends OrmObject {
    private String cRA;
    private long cRB;
    private long mId;
    private String mName;

    public String aoC() {
        return this.cRA;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.cRA = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.cRB = hotSearch.search_value.type.longValue();
        }
    }
}
