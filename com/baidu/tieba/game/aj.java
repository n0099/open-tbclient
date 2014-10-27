package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ GameWebViewActivity aIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(GameWebViewActivity gameWebViewActivity) {
        this.aIe = gameWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.aIe.aIb;
        if (dVar != null) {
            dVar2 = this.aIe.aIb;
            dVar2.dismiss();
            this.aIe.aIb = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.aIe, 23003, 2)));
    }
}
