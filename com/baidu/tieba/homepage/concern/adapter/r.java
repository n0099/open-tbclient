package com.baidu.tieba.homepage.concern.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class r extends c {
    private BdUniqueId jYb;
    private BdUniqueId jYc;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.jYb = bdUniqueId2;
        this.jYc = bdUniqueId3;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return this.jYb == null ? super.qn() : this.jYb;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return this.jYc == null ? super.qo() : this.jYc;
    }
}
