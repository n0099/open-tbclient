package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes22.dex */
public interface ao {
    com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z);

    k<ICardInfo, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
