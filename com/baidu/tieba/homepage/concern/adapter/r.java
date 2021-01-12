package com.baidu.tieba.homepage.concern.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class r extends c {
    private BdUniqueId jTw;
    private BdUniqueId jTx;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.jTw = bdUniqueId2;
        this.jTx = bdUniqueId3;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return this.jTw == null ? super.qn() : this.jTw;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return this.jTx == null ? super.qo() : this.jTx;
    }
}
