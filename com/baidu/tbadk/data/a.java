package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import tbclient.AlaLiveInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId crk = BdUniqueId.gen();
    public AlaLiveInfoCoreData crl;
    public String crn;
    public int crm = 0;
    public int cro = -1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return crk;
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        if (alaLiveInfo != null) {
            if (this.crl == null) {
                this.crl = new AlaLiveInfoCoreData();
            }
            this.crl.parserProtoBuf(alaLiveInfo);
        }
    }
}
