package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aJz = BdUniqueId.gen();
    public AlaLiveInfoCoreData aJA;
    public String aJC;
    public int aJB = 0;
    public int aJD = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aJz;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aJA == null) {
                this.aJA = new AlaLiveInfoCoreData();
            }
            this.aJA.parserProtoBuf(alaLiveInfo);
        }
    }
}
