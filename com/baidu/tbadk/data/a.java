package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cgM = BdUniqueId.gen();
    public AlaLiveInfoCoreData cgN;
    public String cgP;
    public int cgO = 0;
    public int cgQ = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cgM;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cgN == null) {
                this.cgN = new AlaLiveInfoCoreData();
            }
            this.cgN.parserProtoBuf(alaLiveInfo);
        }
    }
}
