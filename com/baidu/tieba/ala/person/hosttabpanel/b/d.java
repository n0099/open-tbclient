package com.baidu.tieba.ala.person.hosttabpanel.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.AlaLiveInfoData;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.tieba.b.a.a implements IAdapterData {
    public static BdUniqueId gDw = BdUniqueId.gen();
    public AlaLiveInfoData gDg;
    public AlaLiveInfoData gDh;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return gDw;
    }
}
