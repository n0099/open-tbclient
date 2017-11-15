package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
/* loaded from: classes.dex */
public class HotSearchInfoData extends OrmObject {
    private String cke;
    private long ckf;
    private long mId;
    private String mName;

    public String aeW() {
        return this.cke;
    }

    public void a(HotSearch hotSearch) {
        if (hotSearch != null && hotSearch.search_value != null) {
            this.cke = hotSearch.search_title;
            this.mId = hotSearch.search_value.id.longValue();
            this.mName = hotSearch.search_value.name;
            this.ckf = hotSearch.search_value.type.longValue();
        }
    }
}
