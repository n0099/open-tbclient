package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId coV = BdUniqueId.gen();
    public AlaLiveInfoCoreData coW;
    public String coY;
    public int coX = 0;
    public int coZ = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return coV;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.coW == null) {
                this.coW = new AlaLiveInfoCoreData();
            }
            this.coW.parserProtoBuf(alaLiveInfo);
        }
    }
}
