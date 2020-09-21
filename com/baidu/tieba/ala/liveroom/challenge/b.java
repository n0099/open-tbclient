package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.challenge.f;
import com.baidu.live.challenge.j;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b implements f {
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.challenge.f
    public j BT() {
        return new com.baidu.tieba.ala.liveroom.challenge.panel.f(this.mPageContext);
    }
}
