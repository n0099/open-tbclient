package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId azA = BdUniqueId.gen();
    public static int azE = 1;
    public AlaLiveInfoCoreData azB;
    public boolean azC = false;
    public long azD = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azA;
    }

    public void b(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.azB == null) {
                this.azB = new AlaLiveInfoCoreData();
            }
            this.azB.parserProtoBuf(alaLiveInfo);
        }
    }
}
