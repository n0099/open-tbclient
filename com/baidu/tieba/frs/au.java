package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes9.dex */
class au implements ai {
    @Override // com.baidu.tieba.frs.ai
    public h<ICardInfo, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.c.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bj.dsJ) {
            return new com.baidu.tieba.frs.entelechy.a.g(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.v.kRk) {
            return new com.baidu.tieba.frs.entelechy.a.f(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bj.dsB) {
            return new com.baidu.tieba.frs.entelechy.a.ab(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.aa(tbPageContext, bj.dsB, bdUniqueId, z);
    }
}
