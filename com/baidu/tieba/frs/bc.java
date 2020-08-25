package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes16.dex */
class bc implements ap {
    @Override // com.baidu.tieba.frs.ap
    public k<ICardInfo, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.c.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.ap
    public com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bw.ecZ) {
            return new com.baidu.tieba.frs.entelechy.a.g(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ap
    public com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.w.mdI) {
            return new com.baidu.tieba.frs.entelechy.a.f(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bw.ecR) {
            return new com.baidu.tieba.frs.entelechy.a.ae(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ap
    public com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.ad(tbPageContext, bw.ecR, bdUniqueId, z);
    }
}
