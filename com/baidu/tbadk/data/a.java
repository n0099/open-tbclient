package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aKw = BdUniqueId.gen();
    public AlaLiveInfoCoreData aKx;
    public String aKz;
    public int aKy = 0;
    public int aKA = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aKw;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aKx == null) {
                this.aKx = new AlaLiveInfoCoreData();
            }
            this.aKx.parserProtoBuf(alaLiveInfo);
        }
    }
}
