package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId coU = BdUniqueId.gen();
    public AlaLiveInfoCoreData coV;
    public String coX;
    public int coW = 0;
    public int coY = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return coU;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.coV == null) {
                this.coV = new AlaLiveInfoCoreData();
            }
            this.coV.parserProtoBuf(alaLiveInfo);
        }
    }
}
