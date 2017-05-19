package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements bu {
    public static final AtomicReference<bu> bNI = new AtomicReference<>(null);
    private static final bu bNJ = new c();

    private c() {
    }

    public static bu YE() {
        bu buVar = bNI.get();
        return buVar == null ? bNJ : buVar;
    }

    @Override // com.baidu.tieba.frs.bu
    public p<ICardInfo, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bu
    public a<? extends com.baidu.tbadk.core.data.bk, ? extends y.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bu
    public a<? extends com.baidu.tbadk.core.data.bk, ? extends y.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
