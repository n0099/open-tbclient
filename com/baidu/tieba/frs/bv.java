package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface bv {
    a<? extends com.baidu.tbadk.core.data.bl, ? extends z.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    p<ICardInfo, ? extends z.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    a<? extends com.baidu.tbadk.core.data.bl, ? extends z.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
