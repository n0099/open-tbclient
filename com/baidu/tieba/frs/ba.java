package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes16.dex */
class ba implements an {
    @Override // com.baidu.tieba.frs.an
    public j<ICardInfo, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.c.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.an
    public com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bv.dTD) {
            return new com.baidu.tieba.frs.entelechy.a.g(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.an
    public com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.v.lLW) {
            return new com.baidu.tieba.frs.entelechy.a.f(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bv.dTv) {
            return new com.baidu.tieba.frs.entelechy.a.ae(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.an
    public com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.ad(tbPageContext, bv.dTv, bdUniqueId, z);
    }
}
