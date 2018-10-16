package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aSr = BdUniqueId.gen();
    public AlaLiveInfoCoreData aSs;
    public String aSu;
    public int aSt = 0;
    public int aSv = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aSr;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aSs == null) {
                this.aSs = new AlaLiveInfoCoreData();
            }
            this.aSs.parserProtoBuf(alaLiveInfo);
        }
    }
}
