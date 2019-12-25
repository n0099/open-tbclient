package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes6.dex */
class ap implements ae {
    @Override // com.baidu.tieba.frs.ae
    public h<ICardInfo, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.c.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.ae
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == bj.cOY) {
            return new com.baidu.tieba.frs.entelechy.a.f(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ae
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.u.kaH) {
            return new com.baidu.tieba.frs.entelechy.a.e(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == bj.cOQ) {
            return new com.baidu.tieba.frs.entelechy.a.z(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.ae
    public com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.a.y(tbPageContext, bj.cOQ, bdUniqueId, z);
    }
}
