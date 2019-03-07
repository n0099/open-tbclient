package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cgK = BdUniqueId.gen();
    public AlaLiveInfoCoreData cgL;
    public String cgN;
    public int cgM = 0;
    public int cgO = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cgK;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.cgL == null) {
                this.cgL = new AlaLiveInfoCoreData();
            }
            this.cgL.parserProtoBuf(alaLiveInfo);
        }
    }
}
