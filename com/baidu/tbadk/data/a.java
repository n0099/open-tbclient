package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aNP = BdUniqueId.gen();
    public AlaLiveInfoCoreData aNQ;
    public String aNS;
    public int aNR = 0;
    public int aNT = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aNP;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aNQ == null) {
                this.aNQ = new AlaLiveInfoCoreData();
            }
            this.aNQ.parserProtoBuf(alaLiveInfo);
        }
    }
}
