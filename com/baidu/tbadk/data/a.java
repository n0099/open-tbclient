package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aKz = BdUniqueId.gen();
    public AlaLiveInfoCoreData aKA;
    public String aKC;
    public int aKB = 0;
    public int aKD = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aKz;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aKA == null) {
                this.aKA = new AlaLiveInfoCoreData();
            }
            this.aKA.parserProtoBuf(alaLiveInfo);
        }
    }
}
