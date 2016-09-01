package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements de {
    public static final AtomicReference<de> bOR = new AtomicReference<>(null);
    private static final de bOS = new c();

    private c() {
    }

    public static de aau() {
        de deVar = bOR.get();
        return deVar == null ? bOS : deVar;
    }

    @Override // com.baidu.tieba.frs.de
    public bf<ICardInfo, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.de
    public a<? extends com.baidu.tbadk.core.data.bg, ? extends y.a> b(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.de
    public a<? extends com.baidu.tbadk.core.data.bg, ? extends y.a> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
