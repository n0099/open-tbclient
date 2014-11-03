package com.baidu.tieba.bubble;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    private final /* synthetic */ Activity Fu;
    final /* synthetic */ k ajs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Activity activity) {
        this.ajs = kVar;
        this.Fu = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = h.ajo;
        if (dVar != null) {
            dVar2 = h.ajo;
            dVar2.dismiss();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.Fu, true, 23004, "expiring")));
    }
}
