package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cCR = BdUniqueId.gen();
    public AlaLiveInfoCoreData cCS;
    public String cCU;
    public int cCT = 0;
    public int cCV = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cCR;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cCS == null) {
                this.cCS = new AlaLiveInfoCoreData();
            }
            this.cCS.parserProtoBuf(alaLiveInfo);
        }
    }
}
