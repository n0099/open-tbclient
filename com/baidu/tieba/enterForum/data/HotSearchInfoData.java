package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class HotSearchInfoData extends OrmObject {
    private String cjR;
    private long cjS;
    private long mId;
    private String mName;

    public String aeK() {
        return this.cjR;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.cjR = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.cjS = hotSearch.search_value.type.longValue();
        }
    }
}
