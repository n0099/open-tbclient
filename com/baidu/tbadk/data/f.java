package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.BannerUserStory;
import tbclient.UserStory;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId azy = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.f> azA;
    private List<com.baidu.adp.widget.ListView.f> azz;
    private List<com.baidu.adp.widget.ListView.f> mList;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azy;
    }

    public List<com.baidu.adp.widget.ListView.f> getList() {
        return this.mList;
    }

    public void a(BannerUserStory bannerUserStory, long j, long j2, String str, boolean z) {
        if (bannerUserStory != null && !v.v(bannerUserStory.user_story)) {
            if (this.azz == null) {
                this.azz = new ArrayList();
            } else {
                this.azz.clear();
            }
            List<UserStory> list = bannerUserStory.user_story;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                UserStory userStory = list.get(i);
                if (userStory != null && userStory != null) {
                    g gVar = new g();
                    gVar.a(userStory);
                    gVar.azE = String.valueOf(j);
                    this.azz.add(gVar);
                }
            }
            List<AlaLiveInfo> list2 = bannerUserStory.ala_live_list;
            if (!v.v(list2)) {
                if (this.azA == null) {
                    this.azA = new ArrayList();
                } else {
                    this.azA.clear();
                }
                if (z) {
                    e eVar = new e();
                    eVar.x(list2);
                    eVar.setFid(String.valueOf(j2));
                    eVar.setForumName(str);
                    this.azA.add(eVar);
                    TiebaStatic.log(new ak("c12547"));
                } else {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        AlaLiveInfo alaLiveInfo = list2.get(i2);
                        if (alaLiveInfo != null && alaLiveInfo != null) {
                            if (alaLiveInfo.user_info != null) {
                                TiebaStatic.log(new ak("c12545").ac("obj_param1", alaLiveInfo.user_info.user_name));
                            }
                            d dVar = new d();
                            dVar.b(alaLiveInfo);
                            this.azA.add(dVar);
                        }
                    }
                }
            }
            Ca();
        }
    }

    private void Ca() {
        if (this.mList == null) {
            this.mList = new ArrayList();
        }
        this.mList.add(new c());
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        d.azw = 1;
        if (!v.v(this.azz)) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.azz);
            for (com.baidu.adp.widget.ListView.f fVar : this.azz) {
                if (fVar instanceof g) {
                    g gVar = (g) fVar;
                    if (gVar.user_id == 963275198 || gVar.user_id == currentAccountId) {
                        this.mList.add(gVar);
                        arrayList.remove(gVar);
                    }
                }
            }
            if (!v.v(this.azA)) {
                if (this.azA.get(0) instanceof d) {
                    d.azw = this.mList.size();
                }
                this.mList.addAll(this.azA);
            }
            if (!v.v(this.azz)) {
                this.mList.addAll(arrayList);
            }
        } else if (!v.v(this.azA)) {
            this.mList.addAll(this.azA);
        }
    }
}
