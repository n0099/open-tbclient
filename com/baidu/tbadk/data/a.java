package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bqO = BdUniqueId.gen();
    public AlaLiveInfoCoreData bqP;
    public String bqR;
    public int bqQ = 0;
    public int bqS = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bqO;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.bqP == null) {
                this.bqP = new AlaLiveInfoCoreData();
            }
            this.bqP.parserProtoBuf(alaLiveInfo);
        }
    }
}
