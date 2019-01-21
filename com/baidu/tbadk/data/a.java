package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aXq = BdUniqueId.gen();
    public AlaLiveInfoCoreData aXr;
    public String aXt;
    public int aXs = 0;
    public int aXu = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aXq;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aXr == null) {
                this.aXr = new AlaLiveInfoCoreData();
            }
            this.aXr.parserProtoBuf(alaLiveInfo);
        }
    }
}
