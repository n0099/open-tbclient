package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aBd = BdUniqueId.gen();
    public AlaLiveInfoCoreData aBe;
    public String aBg;
    public int aBf = 0;
    public int aBh = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aBd;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aBe == null) {
                this.aBe = new AlaLiveInfoCoreData();
            }
            this.aBe.parserProtoBuf(alaLiveInfo);
        }
    }
}
