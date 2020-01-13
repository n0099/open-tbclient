package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes7.dex */
public class HotSearchInfoData extends OrmObject {
    private String fRM;
    private long mId;
    private String mName;
    private long mType;

    public String bwj() {
        return this.fRM;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.fRM = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.mType = hotSearch.search_value.type.longValue();
        }
    }
}
