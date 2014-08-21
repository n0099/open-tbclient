package com.baidu.tieba.bubble;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.au;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ k a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Activity activity) {
        this.a = kVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = h.a;
        if (dVar != null) {
            dVar2 = h.a;
            dVar2.a();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new au(this.b, true, 23004, "expiring")));
    }
}
