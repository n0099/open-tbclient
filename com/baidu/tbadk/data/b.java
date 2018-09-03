package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.BannerFollowLive;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId aKE = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.h> mList;

    public List<com.baidu.adp.widget.ListView.h> getList() {
        return this.mList;
    }

    public void a(BannerFollowLive bannerFollowLive) {
        if (bannerFollowLive != null) {
            if (this.mList == null) {
                this.mList = new ArrayList();
            } else {
                this.mList.clear();
            }
            List<AlaLiveInfo> list = bannerFollowLive.ala_live_list;
            if (!w.z(list)) {
                GO();
                for (AlaLiveInfo alaLiveInfo : list) {
                    if (alaLiveInfo != null) {
                        a aVar = new a();
                        aVar.parserProtoBuf(alaLiveInfo);
                        this.mList.add(aVar);
                    }
                }
            }
        }
    }

    private void GO() {
        a aVar = new a();
        aVar.aKB = -100;
        aVar.aKC = TbadkCoreApplication.getInst().getResources().getString(f.j.ala_follow_live_enter_live_square_txt);
        aVar.aKD = f.C0146f.icon_follow_live_recommend;
        this.mList.add(aVar);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aKE;
    }
}
