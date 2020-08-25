package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes16.dex */
public class HotSearchInfoData extends OrmObject {
    private String hug;
    private long mId;
    private String mName;
    private long mType;

    public String ceG() {
        return this.hug;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.hug = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.mType = hotSearch.search_value.type.longValue();
        }
    }
}
