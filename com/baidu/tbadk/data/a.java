package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bor = BdUniqueId.gen();
    public AlaLiveInfoCoreData bos;
    public String bou;
    public int bot = 0;
    public int bov = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bor;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.bos == null) {
                this.bos = new AlaLiveInfoCoreData();
            }
            this.bos.parserProtoBuf(alaLiveInfo);
        }
    }
}
