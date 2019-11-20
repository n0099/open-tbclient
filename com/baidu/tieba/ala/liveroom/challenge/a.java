package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class a implements com.baidu.live.challenge.f {
    public a() {
        d.aPW();
    }

    @Override // com.baidu.live.challenge.f
    public j a(TbPageContext tbPageContext) {
        return new c(tbPageContext);
    }

    @Override // com.baidu.live.challenge.f
    public i b(TbPageContext tbPageContext) {
        return new com.baidu.tieba.ala.liveroom.challenge.view.c(tbPageContext);
    }
}
