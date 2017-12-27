package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class a implements ah {
    public static final AtomicReference<ah> dvX = new AtomicReference<>(null);
    private static final ah dvY = new a();

    private a() {
    }

    public static ah asx() {
        ah ahVar = dvX.get();
        return ahVar == null ? dvY : ahVar;
    }

    @Override // com.baidu.tieba.frs.ah
    public g<ICardInfo, ? extends r.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ah
    public com.baidu.adp.widget.ListView.a<? extends be, ? extends r.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ah
    public com.baidu.adp.widget.ListView.a<? extends be, ? extends r.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
