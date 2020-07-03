package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.challenge.e {
    @Override // com.baidu.live.challenge.e
    public i a(TbPageContext tbPageContext) {
        return new c(tbPageContext);
    }

    @Override // com.baidu.live.challenge.e
    public h b(TbPageContext tbPageContext) {
        return new com.baidu.tieba.ala.liveroom.challenge.view.d(tbPageContext);
    }
}
