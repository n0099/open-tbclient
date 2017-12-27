package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes2.dex */
public interface ah {
    com.baidu.adp.widget.ListView.a<? extends be, ? extends r.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    g<ICardInfo, ? extends r.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    com.baidu.adp.widget.ListView.a<? extends be, ? extends r.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
