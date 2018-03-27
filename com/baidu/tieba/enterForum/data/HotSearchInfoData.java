package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes2.dex */
public class HotSearchInfoData extends OrmObject {
    private String doZ;
    private long dpa;
    private long mId;
    private String mName;

    public String aqn() {
        return this.doZ;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.doZ = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dpa = hotSearch.search_value.type.longValue();
        }
    }
}
