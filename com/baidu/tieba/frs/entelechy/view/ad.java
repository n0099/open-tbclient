package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ x chH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.chH = xVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bm bmVar;
        TbPageContext tbPageContext;
        bmVar = this.chH.aiu;
        com.baidu.tbadk.core.data.o sn = bmVar.sn();
        long cartoonId = sn.getCartoonId();
        int chapterId = sn.getChapterId();
        tbPageContext = this.chH.ajP;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
