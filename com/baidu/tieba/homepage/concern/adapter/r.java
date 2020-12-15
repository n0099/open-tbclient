package com.baidu.tieba.homepage.concern.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class r extends c {
    private BdUniqueId jKM;
    private BdUniqueId jKN;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.jKM = bdUniqueId2;
        this.jKN = bdUniqueId3;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qL() {
        return this.jKM == null ? super.qL() : this.jKM;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qM() {
        return this.jKN == null ? super.qM() : this.jKN;
    }
}
