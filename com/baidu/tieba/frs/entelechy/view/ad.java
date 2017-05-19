package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ x bTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.bTG = xVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bk bkVar;
        TbPageContext tbPageContext;
        bkVar = this.bTG.ahV;
        com.baidu.tbadk.core.data.n su = bkVar.su();
        long cartoonId = su.getCartoonId();
        int chapterId = su.getChapterId();
        tbPageContext = this.bTG.ajr;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
