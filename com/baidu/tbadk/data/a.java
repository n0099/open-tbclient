package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cqp = BdUniqueId.gen();
    public AlaLiveInfoCoreData cqq;
    public String cqs;
    public int cqr = 0;
    public int cqt = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cqp;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cqq == null) {
                this.cqq = new AlaLiveInfoCoreData();
            }
            this.cqq.parserProtoBuf(alaLiveInfo);
        }
    }
}
