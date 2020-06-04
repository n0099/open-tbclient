package com.baidu.tieba.ala.person.hosttabpanel.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.q;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.tieba.b.a.a implements IAdapterData {
    public static BdUniqueId glc = BdUniqueId.gen();
    public q gld;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return glc;
    }
}
