package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerUserStory;
import tbclient.UserStory;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId azG = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.f> azH;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azG;
    }

    public List<com.baidu.adp.widget.ListView.f> Co() {
        return this.azH;
    }

    public void x(List<com.baidu.adp.widget.ListView.f> list) {
        this.azH = list;
    }

    public void a(BannerUserStory bannerUserStory, long j) {
        List<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
        arrayList.add(new d());
        if (bannerUserStory == null || v.v(bannerUserStory.user_story)) {
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
                fVar.azL = String.valueOf(j);
                arrayList.add(fVar);
            }
        }
        x(arrayList);
    }
}
