package com.baidu.tieba.homepage.concern.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class r extends c {
    private BdUniqueId jKK;
    private BdUniqueId jKL;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.jKK = bdUniqueId2;
        this.jKL = bdUniqueId3;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qL() {
        return this.jKK == null ? super.qL() : this.jKK;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qM() {
        return this.jKL == null ? super.qM() : this.jKL;
    }
}
