package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId azs = BdUniqueId.gen();
    public static int azw = 1;
    public AlaLiveInfoCoreData azt;
    public boolean azu = false;
    public long azv = 0;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azs;
    }

    public void b(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.azt == null) {
                this.azt = new AlaLiveInfoCoreData();
            }
            this.azt.parserProtoBuf(alaLiveInfo);
        }
    }
}
