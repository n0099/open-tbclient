package com.baidu.tieba.homepage.concern.adapter;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class r extends c {
    private BdUniqueId kbl;
    private BdUniqueId kbm;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.kbl = bdUniqueId2;
        this.kbm = bdUniqueId3;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId ql() {
        return this.kbl == null ? super.ql() : this.kbl;
    }

    @Override // com.baidu.tieba.homepage.concern.adapter.c, com.baidu.adp.widget.ListView.a
    public BdUniqueId qm() {
        return this.kbm == null ? super.qm() : this.kbm;
    }
}
