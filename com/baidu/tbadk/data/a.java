package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bqE = BdUniqueId.gen();
    public AlaLiveInfoCoreData bqF;
    public String bqH;
    public int bqG = 0;
    public int bqI = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bqE;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.bqF == null) {
                this.bqF = new AlaLiveInfoCoreData();
            }
            this.bqF.parserProtoBuf(alaLiveInfo);
        }
    }
}
