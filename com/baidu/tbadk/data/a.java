package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aWH = BdUniqueId.gen();
    public AlaLiveInfoCoreData aWI;
    public String aWK;
    public int aWJ = 0;
    public int aWL = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aWH;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aWI == null) {
                this.aWI = new AlaLiveInfoCoreData();
            }
            this.aWI.parserProtoBuf(alaLiveInfo);
        }
    }
}
