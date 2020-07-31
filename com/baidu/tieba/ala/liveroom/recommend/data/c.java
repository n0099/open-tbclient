package com.baidu.tieba.ala.liveroom.recommend.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class c implements IAdapterData {
    public static BdUniqueId gvY = BdUniqueId.gen();
    public int count;
    public int type;

    public c(int i) {
        this.type = i;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return gvY;
    }
}
