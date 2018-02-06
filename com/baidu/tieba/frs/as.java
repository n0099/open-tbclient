package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
class as implements ah {
    @Override // com.baidu.tieba.frs.ah
    public g<ICardInfo, ? extends r.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.d.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.ah
    public com.baidu.adp.widget.ListView.a<? extends bd, ? extends r.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bd.aPP) {
            return new com.baidu.tieba.frs.entelechy.a.j(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ah
    public com.baidu.adp.widget.ListView.a<? extends bd, ? extends r.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.s.gZN) {
            return new com.baidu.tieba.frs.entelechy.a.e(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bd.aPI) {
            return new com.baidu.tieba.frs.entelechy.a.m(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }
}
