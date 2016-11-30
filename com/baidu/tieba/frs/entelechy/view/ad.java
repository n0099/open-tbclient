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
public class ad implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ w caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(w wVar) {
        this.caE = wVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bk bkVar;
        TbPageContext tbPageContext;
        bkVar = this.caE.aeu;
        com.baidu.tbadk.core.data.n sK = bkVar.sK();
        long cartoonId = sK.getCartoonId();
        int chapterId = sK.getChapterId();
        tbPageContext = this.caE.GO;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
