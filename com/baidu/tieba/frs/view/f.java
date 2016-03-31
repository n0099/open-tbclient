package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ b bwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.bwr = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int rI;
        if (this.bwr.bvU != null && this.bwr.bvU.aRZ() != null && (rI = this.bwr.bvU.aRZ().rI()) != 0 && rI == 1 && this.bwr.blH != null) {
            MangaCoverActivityConfig mangaCoverActivityConfig = new MangaCoverActivityConfig(this.bwr.MX.getPageActivity(), com.baidu.adp.lib.h.b.c(this.bwr.blH.getForumId(), 0L));
            mangaCoverActivityConfig.setFrom(4);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, mangaCoverActivityConfig));
        }
    }
}
