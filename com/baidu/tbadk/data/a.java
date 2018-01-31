package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId boA = BdUniqueId.gen();
    public AlaLiveInfoCoreData boB;
    public String boD;
    public int boC = 0;
    public int boE = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return boA;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.boB == null) {
                this.boB = new AlaLiveInfoCoreData();
            }
            this.boB.parserProtoBuf(alaLiveInfo);
        }
    }
}
