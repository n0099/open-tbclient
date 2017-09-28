package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerUserStory;
import tbclient.UserStory;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aza = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.f> azb;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aza;
    }

    public List<com.baidu.adp.widget.ListView.f> BR() {
        return this.azb;
    }

    public void w(List<com.baidu.adp.widget.ListView.f> list) {
        this.azb = list;
    }

    public void a(BannerUserStory bannerUserStory, long j) {
        List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
        arrayList.add(new c());
        if (bannerUserStory == null || v.u(bannerUserStory.user_story)) {
            w(arrayList);
            return;
        }
        List<UserStory> list = bannerUserStory.user_story;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            UserStory userStory = list.get(i);
            if (userStory != null && userStory != null) {
                e eVar = new e();
                eVar.a(userStory);
                eVar.azf = String.valueOf(j);
                arrayList.add(eVar);
            }
        }
        w(arrayList);
    }
}
