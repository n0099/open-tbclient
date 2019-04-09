package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cgN = BdUniqueId.gen();
    public AlaLiveInfoCoreData cgO;
    public String cgQ;
    public int cgP = 0;
    public int cgR = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cgN;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cgO == null) {
                this.cgO = new AlaLiveInfoCoreData();
            }
            this.cgO.parserProtoBuf(alaLiveInfo);
        }
    }
}
