package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ x bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar) {
        this.bXo = xVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bi biVar;
        TbPageContext tbPageContext;
        biVar = this.bXo.adW;
        com.baidu.tbadk.core.data.m sI = biVar.sI();
        long cartoonId = sI.getCartoonId();
        int chapterId = sI.getChapterId();
        tbPageContext = this.bXo.GM;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(tbPageContext.getPageActivity(), cartoonId, chapterId, 2)));
    }
}
