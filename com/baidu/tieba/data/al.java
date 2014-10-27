package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.widget.n {
    final /* synthetic */ ak aml;
    private final /* synthetic */ IconData amm;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, IconData iconData, Context context) {
        this.aml = akVar;
        this.amm = iconData;
        this.val$context = context;
    }

    @Override // com.baidu.tbadk.widget.n
    public Drawable a(com.baidu.tbadk.widget.m mVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.amm.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            am amVar = new am(this, mVar, this.val$context);
            if (this.val$context instanceof com.baidu.adp.base.i) {
                com.baidu.adp.lib.f.d.ef().a(this.amm.getIcon(), 21, amVar, ((com.baidu.adp.base.i) this.val$context).getUniqueId());
            }
        }
        return this.aml.e(aVar);
    }
}
