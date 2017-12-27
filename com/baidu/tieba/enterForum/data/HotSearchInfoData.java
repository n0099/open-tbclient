package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes2.dex */
public class HotSearchInfoData extends OrmObject {
    private String dhv;
    private long dhw;
    private long mId;
    private String mName;

    public String aoq() {
        return this.dhv;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.dhv = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.dhw = hotSearch.search_value.type.longValue();
        }
    }
}
