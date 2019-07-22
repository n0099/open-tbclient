package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cqi = BdUniqueId.gen();
    public AlaLiveInfoCoreData cqj;
    public String cql;
    public int cqk = 0;
    public int cqm = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cqi;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cqj == null) {
                this.cqj = new AlaLiveInfoCoreData();
            }
            this.cqj.parserProtoBuf(alaLiveInfo);
        }
    }
}
