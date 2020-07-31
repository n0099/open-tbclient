package com.baidu.tieba.ala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class a implements IAdapterData {
    public static BdUniqueId gvU = BdUniqueId.gen();
    public AlaRecommendLiveData gvV;
    public AlaRecommendLiveData gvW;
    public int type;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return gvU;
    }
}
