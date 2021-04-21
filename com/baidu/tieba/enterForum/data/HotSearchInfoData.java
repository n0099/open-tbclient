package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ForumRecommend.HotSearch;
import tbclient.ForumRecommend.SearchValue;
/* loaded from: classes4.dex */
public class HotSearchInfoData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public String f15047e;

    public String s() {
        return this.f15047e;
    }

    public void t(HotSearch hotSearch) {
        SearchValue searchValue;
        if (hotSearch == null || (searchValue = hotSearch.search_value) == null) {
            return;
        }
        this.f15047e = hotSearch.search_title;
        searchValue.id.longValue();
        SearchValue searchValue2 = hotSearch.search_value;
        String str = searchValue2.name;
        searchValue2.type.longValue();
    }
}
