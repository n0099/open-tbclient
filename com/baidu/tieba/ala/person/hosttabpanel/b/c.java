package com.baidu.tieba.ala.person.hosttabpanel.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes3.dex */
public class c extends com.baidu.live.tieba.b.a.a implements IAdapterData {
    public static BdUniqueId fWa = BdUniqueId.gen();

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return fWa;
    }
}
