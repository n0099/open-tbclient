package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes2.dex */
class az implements al {
    @Override // com.baidu.tieba.frs.al
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new com.baidu.tieba.frs.lego.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.frs.al
    public com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == cb.eSx) {
            return new com.baidu.tieba.frs.entelechy.adapter.h(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.al
    public com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == com.baidu.tieba.tbadkCore.x.nvo) {
            return new com.baidu.tieba.frs.entelechy.adapter.e(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == cb.eSp) {
            return new com.baidu.tieba.frs.entelechy.adapter.ag(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // com.baidu.tieba.frs.al
    public com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new com.baidu.tieba.frs.entelechy.adapter.af(tbPageContext, cb.eSp, bdUniqueId, z);
    }
}
