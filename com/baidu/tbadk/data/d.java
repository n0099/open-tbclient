package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aAg = BdUniqueId.gen();
    public static int aAk = 1;
    public AlaLiveInfoCoreData aAh;
    public boolean aAi = false;
    public long aAj = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAg;
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aAh == null) {
                this.aAh = new AlaLiveInfoCoreData();
            }
            this.aAh.parserProtoBuf(alaLiveInfo);
        }
    }
}
