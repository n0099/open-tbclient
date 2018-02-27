package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bqB = BdUniqueId.gen();
    public AlaLiveInfoCoreData bqC;
    public String bqE;
    public int bqD = 0;
    public int bqF = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bqB;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.bqC == null) {
                this.bqC = new AlaLiveInfoCoreData();
            }
            this.bqC.parserProtoBuf(alaLiveInfo);
        }
    }
}
