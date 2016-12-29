package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class g implements cb {
    public static final AtomicReference<cb> bxP = new AtomicReference<>(null);
    private static final cb bxQ = new g();

    private g() {
    }

    public static cb VZ() {
        cb cbVar = bxP.get();
        return cbVar == null ? bxQ : cbVar;
    }

    @Override // com.baidu.tieba.frs.cb
    public au<ICardInfo, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.cb
    public com.baidu.adp.widget.ListView.a<? extends com.baidu.tbadk.core.data.bg, ? extends y.a> b(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.cb
    public com.baidu.adp.widget.ListView.a<? extends com.baidu.tbadk.core.data.bg, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
