package com.baidu.tieba.bubble;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ Activity Ft;
    final /* synthetic */ k ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Activity activity) {
        this.ajj = kVar;
        this.Ft = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = h.ajf;
        if (dVar != null) {
            dVar2 = h.ajf;
            dVar2.dismiss();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.Ft, true, 23004, "expiring")));
    }
}
