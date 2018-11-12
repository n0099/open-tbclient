package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aTh = BdUniqueId.gen();
    public AlaLiveInfoCoreData aTi;
    public String aTk;
    public int aTj = 0;
    public int aTl = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aTh;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aTi == null) {
                this.aTi = new AlaLiveInfoCoreData();
            }
            this.aTi.parserProtoBuf(alaLiveInfo);
        }
    }
}
