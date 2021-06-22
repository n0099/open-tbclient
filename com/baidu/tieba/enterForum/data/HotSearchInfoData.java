package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
import tbclient.ForumRecommend.SearchValue;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f14525e;

    public String w() {
        return this.f14525e;
    }

    public void x(HotSearch hotSearch) {
        SearchValue searchValue;
        if (hotSearch == null || (searchValue = hotSearch.search_value) == null) {
            return;
        }
        this.f14525e = hotSearch.search_title;
        searchValue.id.longValue();
        SearchValue searchValue2 = hotSearch.search_value;
        String str = searchValue2.name;
        searchValue2.type.longValue();
    }
}
