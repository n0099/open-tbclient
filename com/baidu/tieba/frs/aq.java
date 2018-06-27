package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
class aq implements af {
    @Override // com.baidu.tieba.frs.af
    public h<ICardInfo, ? extends q.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.d.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bc, ? extends q.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bc.ajE) {
            return new com.baidu.tieba.frs.entelechy.a.h(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bc, ? extends q.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.s.gLR) {
            return new com.baidu.tieba.frs.entelechy.a.c(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bc.ajw) {
            return new com.baidu.tieba.frs.entelechy.a.k(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }
}
