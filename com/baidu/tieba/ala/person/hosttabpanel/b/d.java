package com.baidu.tieba.ala.person.hosttabpanel.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.AlaLiveInfoData;
/* loaded from: classes10.dex */
public class d extends com.baidu.live.tieba.b.a.a implements IAdapterData {
    public static BdUniqueId hRr = BdUniqueId.gen();
    public AlaLiveInfoData hRb;
    public AlaLiveInfoData hRc;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return hRr;
    }
}
