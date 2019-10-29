package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cDI = BdUniqueId.gen();
    public AlaLiveInfoCoreData cDJ;
    public String cDL;
    public int cDK = 0;
    public int cDM = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cDI;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cDJ == null) {
                this.cDJ = new AlaLiveInfoCoreData();
            }
            this.cDJ.parserProtoBuf(alaLiveInfo);
        }
    }
}
