package com.baidu.tieba.ala.person.hosttabpanel.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes3.dex */
public class b extends com.baidu.live.tieba.b.a.a implements IAdapterData {
    public static BdUniqueId fVZ = BdUniqueId.gen();
    public long fVY;
    public int liveType = 2;
    public String portrait;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return fVZ;
    }
}
