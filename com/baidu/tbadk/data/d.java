package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aAj = BdUniqueId.gen();
    public static int aAn = 1;
    public AlaLiveInfoCoreData aAk;
    public boolean aAl = false;
    public long aAm = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAj;
    }

    public void a(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aAk == null) {
                this.aAk = new AlaLiveInfoCoreData();
            }
            this.aAk.parserProtoBuf(alaLiveInfo);
        }
    }
}
