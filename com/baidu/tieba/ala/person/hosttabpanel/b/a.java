package com.baidu.tieba.ala.person.hosttabpanel.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.data.i;
/* loaded from: classes6.dex */
public class a extends com.baidu.live.tieba.b.a.a implements IAdapterData {
    public static BdUniqueId ety = BdUniqueId.gen();
    public i etz;

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return ety;
    }
}
