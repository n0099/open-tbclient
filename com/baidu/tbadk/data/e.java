package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId azx = BdUniqueId.gen();
    private String fid;
    private String forumName;
    private List<AlaLiveInfoCoreData> list;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azx;
    }

    public List<AlaLiveInfoCoreData> getList() {
        return this.list;
    }

    public void x(List<AlaLiveInfo> list) {
        if (list != null && !v.v(list)) {
            if (this.list == null || !v.v(this.list)) {
                this.list = new ArrayList();
            }
            for (AlaLiveInfo alaLiveInfo : list) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
                this.list.add(alaLiveInfoCoreData);
            }
        }
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
