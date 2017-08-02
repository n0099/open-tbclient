package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerUserStory;
import tbclient.UserStory;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId azf = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.f> azg;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azf;
    }

    public List<com.baidu.adp.widget.ListView.f> Cl() {
        return this.azg;
    }

    public void x(List<com.baidu.adp.widget.ListView.f> list) {
        this.azg = list;
    }

    public void a(BannerUserStory bannerUserStory, long j) {
        List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
        arrayList.add(new d());
        if (bannerUserStory == null || u.v(bannerUserStory.user_story)) {
            x(arrayList);
            return;
        }
        List<UserStory> list = bannerUserStory.user_story;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            UserStory userStory = list.get(i);
            if (userStory != null && userStory != null) {
                f fVar = new f();
                fVar.a(userStory);
                fVar.azk = String.valueOf(j);
                arrayList.add(fVar);
            }
        }
        x(arrayList);
    }
}
