package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aBe = BdUniqueId.gen();
    public AlaLiveInfoCoreData aBf;
    public String aBh;
    public int aBg = 0;
    public int aBi = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aBe;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.aBf == null) {
                this.aBf = new AlaLiveInfoCoreData();
            }
            this.aBf.parserProtoBuf(alaLiveInfo);
        }
    }
}
