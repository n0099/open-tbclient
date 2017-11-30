package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aAb = BdUniqueId.gen();
    public static int aAf = 1;
    public AlaLiveInfoCoreData aAc;
    public boolean aAd = false;
    public long aAe = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAb;
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aAc == null) {
                this.aAc = new AlaLiveInfoCoreData();
            }
            this.aAc.parserProtoBuf(alaLiveInfo);
        }
    }
}
