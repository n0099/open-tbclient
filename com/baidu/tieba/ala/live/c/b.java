package com.baidu.tieba.ala.live.c;

import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.tieba.ala.live.b.a;
/* loaded from: classes3.dex */
public class b extends a {
    public b(BaseActivity baseActivity) {
        super(baseActivity, PayChannelType.NUOMI);
    }

    @Override // com.baidu.tieba.ala.live.c.a
    protected com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0482a interfaceC0482a) {
        return new com.baidu.tieba.ala.live.b.b(getPageContext(), interfaceC0482a);
    }
}
