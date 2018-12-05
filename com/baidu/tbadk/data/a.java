package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aWE = BdUniqueId.gen();
    public AlaLiveInfoCoreData aWF;
    public String aWH;
    public int aWG = 0;
    public int aWI = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aWE;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aWF == null) {
                this.aWF = new AlaLiveInfoCoreData();
            }
            this.aWF.parserProtoBuf(alaLiveInfo);
        }
    }
}
