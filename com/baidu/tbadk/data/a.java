package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId boi = BdUniqueId.gen();
    public AlaLiveInfoCoreData boj;
    public String bol;
    public int bok = 0;
    public int bom = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return boi;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.boj == null) {
                this.boj = new AlaLiveInfoCoreData();
            }
            this.boj.parserProtoBuf(alaLiveInfo);
        }
    }
}
