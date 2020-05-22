package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes9.dex */
public interface ai {
    com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    com.baidu.adp.widget.ListView.a<? extends bj, ? extends aa.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z);

    h<ICardInfo, ? extends aa.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
