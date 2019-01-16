package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aXp = BdUniqueId.gen();
    public AlaLiveInfoCoreData aXq;
    public String aXs;
    public int aXr = 0;
    public int aXt = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aXp;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aXq == null) {
                this.aXq = new AlaLiveInfoCoreData();
            }
            this.aXq.parserProtoBuf(alaLiveInfo);
        }
    }
}
