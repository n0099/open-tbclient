package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.BannerFollowLive;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId bqT = BdUniqueId.gen();
    private List<com.baidu.adp.widget.ListView.i> mList;

    public List<com.baidu.adp.widget.ListView.i> getList() {
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
            if (!v.E(list)) {
                for (AlaLiveInfo alaLiveInfo : list) {
                    if (alaLiveInfo != null) {
                        a aVar = new a();
                        aVar.parserProtoBuf(alaLiveInfo);
                        this.mList.add(aVar);
                    }
                }
                Kt();
            }
        }
    }

    private void Kt() {
        a aVar = new a();
        aVar.bqQ = -100;
        aVar.bqR = TbadkCoreApplication.getInst().getResources().getString(d.j.ala_follow_live_enter_live_square_txt);
        aVar.bqS = d.f.icon_follow_live_recommend;
        this.mList.add(aVar);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bqT;
    }
}
