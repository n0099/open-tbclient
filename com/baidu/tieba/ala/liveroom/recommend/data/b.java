package com.baidu.tieba.ala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes3.dex */
public class b implements IAdapterData {
    public static BdUniqueId gdD = BdUniqueId.gen();
    public int count;
    public int type;

    public b(int i) {
        this.type = i;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return gdD;
    }
}
